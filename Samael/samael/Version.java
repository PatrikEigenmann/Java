/* ------------------------------------------------------------------------------------------------------
 * Version.java - The Version class encapsulates the concept of versioning for a given class. It
 * maintains a major and minor version number, which are essential for tracking the evolution and
 * updates of the class over time. The class name is also stored to provide context to the version
 * information.
 * 
 * The constructor initializes the class with a specific name and version numbers, ensuring that each
 * instance of Version is uniquely identifiable by its class name and version combination. The
 * toString method provides a formatted string representation of the version, making it easy to
 * display and interpret the version information in a human-readable format.
 * ------------------------------------------------------------------------------------------------------
 * Author : Patrik Eigenmann
 * eMail  : p.eigenmann@gmx.net
 * ------------------------------------------------------------------------------------------------------
 * Change log
 * Wed 2024-08-21	File created														 	Version 00.01
 * Sun 2024-09-01	Add the words Component & Version in method toString()				 	Version 00.02
 * Wed 2024-09-25	Rearrange the class so it is the same like in the C# Samael library.	Version 00.03
 * Fri 2024-09-27	Implemantation of IVersionable.											Version 00.04
 * ------------------------------------------------------------------------------------------------------
 * To Do:
 * - Make it the same as in the C# library Samael. So that the difference is minimal.			-> Done.
 * ------------------------------------------------------------------------------------------------------*/
package samael;

/**
 * The Version class encapsulates the concept of versioning for a given class. It
 * maintains a major and minor version number, which are essential for tracking the evolution and
 * updates of the class over time. The class name is also stored to provide context to the version
 * information.
 */
public class Version implements IVersionable {
	
	/**
	 * 
	 * @return
	 */
	public static String getVersion() {
		return VersionManager.getInstance(Version.class.getName(), 0, 4).toString();
	}
	
	/**
	 * The major number in versions typically signifies significant changes or milestones in the
	 * development of a component of the software. It is incremented when there are substantial
	 * updates that may include new features, architectural changes, or other modifications that
	 * could potentially break compatibility with previous versions. Essentially, the major number
	 * reflects the overall progress and evolution of the software in a way that users and developers
	 * can easily recognize the importance of the changes made.
	 */
	private int iMajor = 0;
	
	/**
	 * The minor number in versions represents smaller, incremental updates or improvements to a
	 * class or software. These updates typically include bug fixes, performance enhancements, or
	 * minor feature additions that do not significantly alter the overall functionality or
	 * architecture. The minor number is incremented to indicate these less impactful changes,
	 * ensuring that users and developers can track and understand the progression of the software
	 * without expecting major shifts or compatibility issues.
	 */
	private int iMinor = 0;
	
	/**
	 * The component in the Version class represents the specific name of the component that the version
	 * information is associated with. It provides context to the version numbers, making it clear which
	 * component the version applies to. This is particularly useful in larger projects where multiple
	 * classes or components may have their own versions.
	 */
	private String component = "";
	
	/**
	 * The constructor initializes the class with a specific name and version numbers, ensuring that each
	 * instance of Version is uniquely identifiable by its class name and version combination. The
	 * toString method provides a formatted string representation of the version, making it easy to
	 * display and interpret the version information in a human-readable format.
	 * @param classNameIn
	 * @param iMajorIn
	 * @param iMinorIn
	 */
	public Version(String componentIn, int iMajorIn, int iMinorIn) {
		
		component = componentIn;
		iMajor = iMajorIn;
		iMinor = iMinorIn;
	}
	
	/**
	 * The toString method in the Version class provides a human-readable string representation of the
	 * version information. It combines the component name with the major and minor version numbers,
	 * formatting the version numbers to always display two digits. This method ensures that the version
	 * information is easily interpretable and can be conveniently displayed or logged.
	 * 
	 * For example, if the component name is “ExampleComponent” with a major version of 1 and a minor
	 * version of 5, the toString method would return the string “Component ExampleComponent: Version 01.05”.
	 * 
	 * @return "Component" component: "Version" Major#.Minor#
	 */
	public String toString() {
		return "Component: " + component + ", Version: " + String.format("%02d", iMajor) + "." + String.format("%02d", iMinor);
	}
}