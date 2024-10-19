/* ------------------------------------------------------------------------------------------------------
 * The VersionManager class is designed to manage and track different versions of software components. It
 * maintains a centralized list of versions, ensuring that each component’s version is easily accessible.
 * When a version is requested, the class checks if it already exists; if not, it creates and stores a
 * new version. This approach ensures consistency and reliability in version management, making it easier
 * to maintain and update software systems. Additionally, the class includes error handling to manage any
 * issues that might arise during version retrieval.
 * ------------------------------------------------------------------------------------------------------
 * Author : Patrik Eigenmann
 * eMail  : p.eigenmann@gmx.net
 * ------------------------------------------------------------------------------------------------------
 * Change log:
 * 
 * Thu 2024-09-26 File created.																Version 00.01
 * Fri 2024-09-27 IVersionable implemented.													Version 00.02
 * Sat 2024-09-28 Implementation of the Version String for the whole framework.				Version 00.03
 * Wed 2024-10-02 Handling some deprecation classes/methode.								Version 00.04	
 * ------------------------------------------------------------------------------------------------------
 * To Do:
 * 
 * ------------------------------------------------------------------------------------------------------ */
package samael;

import java.util.*;

/**
* The VersionManager class is designed to manage and track different versions of software components. It
* maintains a centralized list of versions, ensuring that each component’s version is easily accessible.
* When a version is requested, the class checks if it already exists; if not, it creates and stores a
* new version. This approach ensures consistency and reliability in version management, making it easier
* to maintain and update software systems. Additionally, the class includes error handling to manage any
* issues that might arise during version retrieval.
*/
public class VersionManager implements IVersionable {
	
	/**
	 * This is the general Version # of the Samael Framework. Framework versioning works the following:
	 * Framework Samael vMajor #. Minor # -> the Major # are releases. After the Framework went under
	 * main bugfixes and the collection of classes/components are generally useful, a release (Major)
	 * number will increased.
	 * Increase of the Minor # represents minor bugfixes, adding new methods and properties in the
	 * Frameworks components.
	 * 
	 * This String is hard programmed and not changeable with a config file.
	 */
	private static final String frameworkVersion = "Framework Samael v00.03";
	
	/**
	 * Override this method from the implemented VersionControl interface.
	 * The getVersion method in the Utility class retrieves version information. When called, it internally
	 * invokes VersionControl.getVersion(String component, Major #, Minor #) to obtain the version
	 * string. This method ensures that no data type faces the abyss of conversion alone.
	 * 
	 * @return A formatted String: Component: component name, Version Major #.Minor #.
	 */
	public static String getVersion() {
		
		/* */
		LogManager.writeMessage("Version String created.", LogManager.INFO, VersionManager.class, VersionManager.class);
		
		/** Return a formatted String: Component: component name, Version Major #, Minor # */
		return VersionManager.getInstance(VersionManager.class.getName(), 0, 4).toString();
	}
	
	/**
	 * A centralized dictionary that stores versions of different components, 
	 * ensuring easy access and management of component versions.
	 */
	private static HashMap<String, Version> versionList = new HashMap<>();
	

	/**
	 * Retrieves the version of a specified component. If the version does not exist,
	 * it creates and stores a new version.
	 * 
	 * @param componentIn Class/Interface name of the component.
	 * @param majorIn Major # of the Version number.
	 * @param minorIn Minor # of the Version number.
	 * @return An Instance of Version object of the specified component.
	 */
	public static Version getInstance(String componentIn, int majorIn, int minorIn) {
		
		Version version;
		
		version = versionList.get(componentIn);
		if(version == null) {
			version = new Version(componentIn, majorIn, minorIn);	
			versionList.put(componentIn, version);
		}
		return version;
	}
	
	/**
	 * Creating a formatted String about the Versions of the Samael Framework components.
	 * @return Formatted String of all Framework's components Versions.
	 */
	public static String addFramework() {
		
		String message = VersionManager.frameworkVersion + "\n---------------------------------------\n";
		//message += Config.getVersion() + "\n";
		message += ConfigManager.getVersion() + "\n";
		//message += IConfigurable.getVersion() + "\n";
		message += IVersionable.GetIVersion() + "\n";
		message += LogManager.getVersion() + "\n";
		//message += MessageHandler.getVersion() + "\n";
		message += Utility.getVersion() + "\n";
		message += Version.getVersion() + "\n";
		message += VersionManager.getVersion() + "\n";
		
		return message;
	}
}
