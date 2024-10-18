/* -------------------------------------------------------------------------------------------------------
 * Within the heart of your code lies the LogManager class, a vigilant guardian of warnings and errors.
 * This class, with its constants WARNING and ERROR, communicates through the showMessage method,
 * presenting messages in a clear dialog box.
 *
 * Its strength, however, lies in the writeMessage methods, recording messages into a centralized log file,
 * each entry stamped with a precise timestamp. Depending on the log type, messages are tagged as WRN for
 * warnings, ERR for errors, and INF for informational entries. Handle these messages carefully to avoid a
 * trail of lingering issues in your logs.
 * -------------------------------------------------------------------------------------------------------
 * Author:	Patrik Eigenmann
 * eMail:	p.eigenmann@gmx.net
 * -------------------------------------------------------------------------------------------------------
 * Change Log:
 * 
 * Thu 2024-10-10 Class created and basic functionality implemented.						Version: 00.01
 * Thu 2024-10-10 Changed file extension from .log to .csv.									Version: 00.02
 * Thu 2024-10-10 Changed APP_NAME from ConfigManager.getParameter("appName")				Version: 00.03
 * 					to retrieving the name of the running process.
 * Thu 2024-10-10 Added Object name to verify which component caused the message.			Version: 00.04
 * Fri 2024-10-11 Corrected the LogManager, process name and class name is now dynamically.	Version: 00.05
 * Wed 2024-10-16 Logging flags implemented. Add
 * -------------------------------------------------------------------------------------------------------
 * To Do:
 * A flag system which allows to specifically write the log for only the flagged messages.		-> Done.
 * -------------------------------------------------------------------------------------------------------
 */

package samael;

import java.io.*;
import java.util.*;
import java.text.*;

/**
 * Within the heart of your code lies the LogManager class, a vigilant guardian of warnings and errors.
 * This class, with its constants WARNING and ERROR, communicates through the showMessage method,
 * presenting messages in a clear dialog box.
 *
 * Its strength, however, lies in the writeMessage methods, recording messages into a centralized log file,
 * each entry stamped with a precise timestamp. Depending on the log type, messages are tagged as WRN for
 * warnings, ERR for errors, and INF for informational entries. Handle these messages carefully to avoid a
 * trail of lingering issues in your logs.
 */
public class LogManager implements IVersionable {

	/**
	 * Override this method from the implemented VersionControl interface.
	 * The getVersion method in the Utility class retrieves version information. When called, it internally
	 * invokes VersionControl.getVersion(String component, Major #, Minor #) to obtain the version
	 * string. This method ensures that no data type faces the abyss of conversion alone.
	 * 
	 * @return "Component" component: "Version" Major#.Minor#
	 */
    public static String getVersion() {
        return VersionManager.getInstance(LogManager.class.getName(), 0, 5).toString();
    }
	
	/**
	 * Log levels:
	 * Bit flags are cool, so off course you simply can tell the internal_flag you want;
	 * just INFO or WARNING or ERROR or ALL messages written in the log file.
	 * But you can also combine only two types. With INFO | WARNING all info and all warnings
	 * are written, but not ERROR. Or with WARNING | ERROR all warnings and all errors will be
	 * logged, but not the info. So, the developer can actually decide if the logs are filled
	 * with what type of messages.
	 */
    public final static int INFO = 1;		// 001
    public final static int WARNING = 2;	// 010
    public final static int ERROR = 4;		// 100
    public final static int ALL = 7;		// 111
    
    /** Log directory based on OS */
    private static final String LOG_DIR;
    
    
    /** Flag for INFO, WARNING, and ERROR */
    private static int internal_flag = 0;
    
    /**
     * Setting the flag system allows the programmer to exactly define which messages
     * will be logged. Let me make an example. If you want to log all warnings and errors,
     * the parameter should be setFlag(LogManager.WARNING | LogManager.ERROR)
     * @param flag One for the three, LogManager.INFO, WARNING, and ERROR or a combination of it.
     */
    public static void setFlag(int flag) {
    	internal_flag = flag;
    }

    /**
     * Static construction will be called the first time when the static class is referenced.
     */
    static {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            LOG_DIR = System.getenv("LOCALAPPDATA") + "/samael/logs";
        } else if (os.contains("mac")){
        	LOG_DIR = "/Library/Logs/samael";
        }
        else {
            LOG_DIR = "/usr/local/samael/logs";
        }
        new File(LOG_DIR).mkdirs(); // Ensure directory exists
    }
    
    /**
     * Logs a message with a specified type, process, and component class.
     * This method ensures comprehensive logging across both application and framework components,
     * enabling precise tracking and troubleshooting. By capturing the process and component details,
     * it provides a robust mechanism for monitoring and maintaining the health of your system.
     * This approach ensures transparency and consistency, ultimately supporting informed decision-making
     * and seamless operations.
     *
     * @param message        The log message to be recorded.
     * @param type           The type of log message (e.g., INFO, WARNING, ERROR).
     * @param process        The class representing the process generating the log.
     * @param componentClass The class from which the log message originated.
     */
    public static void writeMessage(String message, int type, Class<?> process, Class<?> componentClass) {
        if((internal_flag & type) == type) {	

            PrintWriter out = null;
        	try {

	        	String logFile = LOG_DIR + "/samael.csv";
	            out = new PrintWriter(new BufferedWriter(new FileWriter(logFile, true)));
	            
	            String sDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	            String logType;
	            switch (type) {
	                case WARNING:
	                    logType = "WRN";
	                    break;
	                case ERROR:
	                    logType = "ERR";
	                    break;
	                default:
	                    logType = "INF";
	                    break;
	            }
	            String processName = process.getPackageName().isEmpty() ? process.getName() : process.getPackageName();
	            String componentName = componentClass.getName();
	            String logEntry = String.join(",", sDate, processName, componentName, logType, message);
	            out.append(logEntry).append("\n");
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (out != null) {
	                out.close();
	            }
	        }
        }
    }
}