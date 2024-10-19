/* -------------------------------------------------------------------------------------------------------
 * The java class IVersionableTest creates a test program that displays the functionality of the interface
 * IVersionable. It showcases the method getVersion() and it's functionality.
 * 
 * Please call these java test programs with: java <name of the test class>
 * -------------------------------------------------------------------------------------------------------
 * Author:	Patrik Eigenmann
 * eMail:	p.eigenmann@gmx.net
 * -------------------------------------------------------------------------------------------------------
 * Change Log:
 * Sat 2024-10-19 Class file created.														Version 00.01
 * -------------------------------------------------------------------------------------------------------*/
import samael.*;

/**
 * IVersionableTest is showcasing the funtionality of IVersionable.
 */
public class IVersionableTest implements IVersionable {

	/**
	 * Override this method from the implemented VersionControl interface.
	 * The getVersion method in the Utility class retrieves version information. When called, it internally
	 * invokes VersionControl.getVersion(String component, Major #, Minor #) to obtain the version
	 * string. This method ensures that no data type faces the abyss of conversion alone.
	 * 
	 * @return A formatted String: Component: component name, Version Major #.Minor #.
	 */
	public static String getVersion() {
		
		/** Return a formatted String: Component: component name, Version Major #, Minor # */
		return VersionManager.getInstance(IVersionableTest.class.getName(), 0, 3).toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(IVersionableTest.getVersion());
	}

}
