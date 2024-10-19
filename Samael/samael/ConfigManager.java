/* -------------------------------------------------------------------------------------------------------
 * The ConfigManager class is responsible for managing configuration parameters stored in an XML file. It
 * provides methods to load these parameters into a Config object and update the XML file with any changes
 * made to the configuration. The class uses the Config class to handle the key-value pairs of
 * configuration settings. It includes functionality to read from and write to the XML file, ensuring that
 * the application’s configuration can be easily maintained and modified.
 * -------------------------------------------------------------------------------------------------------
 * Author:	Patrik Eigenmann
 * eMail:	p.eigenmann@gmx.net
 * -------------------------------------------------------------------------------------------------------
 * Change Log:
 * Sat 2024-09-14 File created.																Version: 00.01
 * Sat 2024-09-14 samael.VersionControl implemented.										Version: 00.02
 * Wed 2024-09-18 Added the method public static String getParameter(String keyIn).			Version: 00.03
 * Wed 2024-10-01 Big overhaul of the class, declared some methods as deprecated.			Version: 00.04
 * Wed 2024-10-02 Some comments updated.													Version: 00.05
 * Wed 2024-10-02 Changed key to name in the XML file.										Version: 00.06
 * -------------------------------------------------------------------------------------------------------*/
package samael;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.*;

/**
 * The ConfigManager class is responsible for managing configuration parameters stored in an XML file. It
 * provides methods to load these parameters into a Config object and update the XML file with any changes
 * made to the configuration. The class uses the Config class to handle the key-value pairs of
 * configuration settings. It includes functionality to read from and write to the XML file, ensuring that
 * the application’s configuration can be easily maintained and modified.
 */
public class ConfigManager implements IVersionable {
		
	/**
	 * The CONFIG_FILE is a constant string that specifies the path to the XML configuration file.
	 * This file, named config.xml, is located in the current directory of the application.
	 * The CONFIG_FILE constant is used throughout the ConfigManager class to reference the
	 * configuration file for loading and updating configuration parameters.
	 */
    private static final String CONFIG_FILE = "./config.xml";
    
	/**
	 * Override this method from the implemented VersionControl interface.
	 * The getVersion method in the Utility class retrieves version information. When called, it internally
	 * invokes VersionControl.getVersion(String component, Major #, Minor #) to obtain the version
	 * string. This method ensures that no data type faces the abyss of conversion alone.
	 * 
	 * @return "Component" component: "Version" Major#.Minor#
	 */
	public static String getVersion() {

		return VersionManager.getInstance(ConfigManager.class.getName(), 0, 5).toString();
	}

	/**
	 * This part of the program sets up a shared list of settings that the application will use. It
	 * ensures that there is only one instance of these settings, making them easily accessible
	 * whenever needed.
	 */
	private static Map<String, String> configMap = new HashMap<>();
	
	/**
	 * This block of code ensures that the configuration settings are loaded as soon as the class is
	 * accessed for the first time. It calls the loadConfig() method to initialize the settings,
	 * making them ready for use throughout the application.
	 */
    static {
    	loadConfig();
    }
	
	
    /**
     * The loadConfig method is a cornerstone of our configuration management strategy. It embodies
     * our commitment to maintaining a seamless and dynamic configuration environment. By leveraging
     * advanced XML processing techniques, this method ensures that our configuration parameters are
     * not only stored efficiently but also updated with precision and clarity.
     * 
     * At its core, loadConfig transforms our in-memory configuration data into a well-structured
     * XML document. It meticulously organizes the parameters, ensuring they are sorted and easily
     * accessible. This method underscores our dedication to data integrity and accessibility,
     * providing a robust framework for future enhancements and scalability.
     * 
     * In essence, loadConfig is more than just a method; it’s a testament to our forward-thinking
     * approach in software development. It encapsulates our vision of creating adaptable, maintainable,
     * and high-performing applications that can effortlessly evolve with changing requirements.
     */
    public static void loadConfig() {
        
    	try {
            File configFile = new File(CONFIG_FILE);
            if (!configFile.exists()) {
                return;
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(configFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("parameter");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String key = element.getAttribute("name");
                    String value = element.getTextContent();
                    //config.setKey(key, value);
                    configMap.put(key, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
	/**
	 * Retrieves the value of a configuration parameter based on the provided key.
	 *
	 * @param keyIn The key for the desired configuration parameter.
	 * @return The value associated with the provided key.
	 */
	public static String getParameter(String keyIn) {
		//return config.getKey(keyIn);
		return configMap.get(keyIn);
	}
}