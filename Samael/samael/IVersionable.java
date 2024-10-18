/* ------------------------------------------------------------------------------------------------------------------
 * IVersionable.java - The purpose of the IVersionable interface is to provide a contract for retrieving version
 * information related to a specific software component. By defining a single static method, it allows developers to
 * dynamically obtain a version string based on the component’s name, major version, and minor version. This interface
 * doesn’t handle the actual implementation of version control; rather, it serves as an abstraction layer for version-
 * related operations. Developers can use it to retrieve version details during runtime, facilitating consistent
 * version reporting across different components within a project. 😊
 * ------------------------------------------------------------------------------------------------------------------
 * Author : Patrik Eigenmann
 * eMail  : p.eigenmann@gmx.net
 * ------------------------------------------------------------------------------------------------------------------
 * Change log
 * Wed 2024-08-21	File created														 				Version 00.01
 * Wed 2024-08-21	public static getVersion() implemented. Must be overwritten in implementing class.	Version 00.02
 * Wed 2024-08-21	public static getVersion(String componentIn, int iMajorIn, int iMinorIn)			Version 00.03
 * Wed 2024-08-21	final static int iMajor & final static int iMinor implemented.						Version 00.04
 * Mon 2024-09-23	Renamed the interface into IVersionable.											Version 00.05
 * Wed 2024-09-25	Rearranged the class to make it similar like the Samael Library in C#.				Version 00.06
 * ------------------------------------------------------------------------------------------------------------------
 * To Do:
 * 
 * - Rename the Interface to IVersionable to be consistent with the C# framework Samael.					-> Done
 * - Rearrange the interface so the difference to the existing C# Samael framework is minimal.				-> Done
 * ------------------------------------------------------------------------------------------------------------------*/
package samael;

/**
 * The purpose of the IVersionable interface is to provide a contract for
 * retrieving version information related to a specific software component. By defining a single
 * static method, it allows developers to dynamically obtain a version string based on the component’s
 * name, major version, and minor version. This interface doesn’t handle the actual implementation of
 * version control; rather, it serves as an abstraction layer for version-related operations.
 * Developers can use it to retrieve version details during runtime, facilitating consistent version
 * reporting across different components within a project. 😊
 */
public interface IVersionable {

	/**
	 * The major # indicates significant changes or milestones, and stable builds in software packages. When
	 * the major # is incremented, it usually means that there are substantial updates, such as new features
	 * major improvements, or changes that might be not backward compatible. For example, moving from version
	 * 01.?? to 02.00 suggests a major overhaul or significant new functionality.
	 */
	final static int iMajor = 0;
	
	/**
	 * The minor # represents smaller updates or improvements that are backwards compatible. Incrementing the
	 * the minor # typically means bug fixes, minor enhancements, or incremental improvements. For instance
	 * going from version 01.02 to 01.03 indicating a minor update that enhances the existing version without
	 * breaking the compatibility.
	 */
	final static int iMinor = 5;
	
	/**
	 * The GetIVersion method is a vital feature for IVersionable interface. It provides a
	 * standardized way to retrieve version information, ensuring that every component can clearly
	 * communicate its version. This method is essential for maintaining consistency and reliability
	 * across the system, making it easier to manage updates and track changes. By implementing
	 * GetIVersion, we ensure that our software remains robust, up-to-date, and easy to maintain,
	 * ultimately enhancing the overall user experience.
	 * 
	 * @return A formatted string where the name of the component is the class or object name,
	 * and the version number consists of a major and a minor number, each formatted to two digits.
	 */
	public static String GetIVersion()
	{
	    return VersionManager.getInstance(IVersionable.class.getName(), IVersionable.iMajor, IVersionable.iMinor).toString();
	}
	
	/**
	 * The GetVersion method is a vital feature for any class implementing the IVersionable interface.
	 * It provides a standardized way to retrieve version information, ensuring that every component
	 * can clearly communicate its version. This method is essential for maintaining consistency and
	 * reliability across the system, making it easier to manage updates and track changes. By
	 * implementing GetVersion, we ensure that our software remains robust, up-to-date, and easy to
	 * maintain, ultimately enhancing the overall user experience.
	 * 
	 * @return A formatted string where the name of the component is the class or object name,
	 * and the version number consists of a major and a minor number, each formatted to two digits.
	 */
	public static String GetVersion()
    {
    	return "Please overwrite this method in the implementing class!";
    }
}