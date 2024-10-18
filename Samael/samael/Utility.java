/* ---------------------------------------------------------------------------------------------------
 * Utility.java - The Utility class is designed to provide essential utility methods for a variety of
 * data types. It includes static methods for common operations related to data manipulation,
 * conversion, and handling. Developers can rely on this class to streamline their code by reusing
 * these utility methods across different data types. 😊
 * ---------------------------------------------------------------------------------------------------
 * Author : Patrik Eigenmann
 * eMail  : p.eigenmann@gmx.net
 * ---------------------------------------------------------------------------------------------------
 * Change log
 * Tue 2024-08-20	File created														 Version 00.01
 * Wed 2024-08-21	VersionControl implemented.											 Version 00.02
 * Wed 2024-08-21	Overwritten getVersion created.										 Version 00.03
 * Wed 2024-08-21	Method isNumeric implemented.										 Version 00.04
 * Wed 2024-08-21	Method strToInt(String sIntIn) implemented.							 Version 00.05
 * Wed 2024-08-21	Method double strToDouble(String sDoubleIn) implemented.			 Version 00.06
 * Thu 2024-08-22	Method double strToDouble(String sDoubleIn) implemented.			 Version 00.06
 * Tue 2024-08-27	Method intToString(int iNumberIn) implemented						 Version 00.07
 * Tue 2024-08-27	Method doubleToString(double dNumberIn) implemented					 Version 00.08
 * Tue 2024-08-27	Method floatToString(float fNumberIn) implemented					 Version 00.09
 * ---------------------------------------------------------------------------------------------------*/
package samael;

/**
 * The Utility class is designed to provide essential utility methods for a variety of data types. It
 * includes static methods for common operations related to data manipulation, conversion, and handling.
 * Developers can rely on this class to streamline their code by reusing these utility methods across
 * different data types. 😊
 */
public class Utility implements IVersionable {
	
	/**
	 * Override this method from the implemented VersionControl interface.
	 * The getVersion method in the Utility class retrieves version information. When called, it
	 * internally invokes VersionControl.getVersion(String component, 0, 1) to obtain the
	 * version string. This method ensures that no data type faces the abyss of conversion alone.
	 * @return component: Major#.Minor#
	 */
	public static String getVersion() {
	
		// For example, if the component name is “ExampleComponent” with a major version of 1 and
		// a minor version of 5, the toString method would return the string “ExampleComponent: 01.05”.
		//return IVersionable.getVersion(Utility.class.getName(), 0, 6);
		return VersionManager.getInstance(Utility.class.getName() , 0, 6).toString();
	}
	
	/**
	 * The isNumeric method is used to check if a given string can be interpreted as a numeric value. It
	 * attempts to convert the string into a number. If the conversion is successful, the method lets the
	 * developer know it was successful. If the conversion fails, the method lets the developer know it
	 * was unsuccessful.
	 * 
	 * @param sNumIn Numerical String.
	 * @returns successfully or not.
	 */
	public static boolean isNumeric(String sNumIn) {
		
		boolean b = false;
		
		try {
			// Try to convert the number string
			// into a numerical value.
			Double.parseDouble(sNumIn);
			b = true;
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			// @todo implement a logging mechanism
			// maybe flagged, debug info or not
		}
		
		return b;
	}
	
	/**
	 * The strToInt method is used to convert a given string into an integer. It includes error
	 * handling to ensure the string is valid before conversion. If the string is not initialized,
	 * empty, or not numeric, it defaults to “0”. The method then converts the string to an
	 * integer and lets the developer know the result.
	 * 
	 * @param sIntIn numerical string.
	 * @return value of the numerical string as integer.
	 */
	public static int strToInt(String sIntIn) {
		
		// Error handling if the String isn't initialized
		// or the String is empty or the String is not numeric.
		if(sIntIn==null ||
				sIntIn.equals("") ||
				!Utility.isNumeric(sIntIn))
			sIntIn = Integer.toString(0);
		
		return Integer.valueOf(sIntIn).intValue();
	}
	
	/**
	 * Converts an integer to its string representation.
	 *
	 * @param iNumberIn the integer to be converted to a string
	 * @return the string representation of the input integer
	 */
	public static String intToString(int iNumberIn) {
		return "" + iNumberIn;
	}
	
	/**
	 * The strToDouble method is used to convert a given string into an double. It includes error
	 * handling to ensure the string is valid before conversion. If the string is not initialized,
	 * empty, or not numeric, it defaults to “0”. The method then converts the string to a double
	 * and lets the developer know the result.
	 * 
	 * @param sDoubleIn numerical string.
	 * @return value of the numerical string as double.
	 */
	public static double strToDouble(String sDoubleIn) {
		
		// Error handling if the String isn't initialized
		// or the String is empty or the String is not numeric.
		if(sDoubleIn==null ||
				sDoubleIn.equals("") ||
				!Utility.isNumeric(sDoubleIn))
			sDoubleIn = Double.toString(0);
		
		return Double.valueOf(sDoubleIn).doubleValue();
	}
	
	/**
	 * Converts a double to its string representation.
	 *
	 * @param dNumberIn the double to be converted to a string
	 * @return the string representation of the input double
	 */
	public static String doubleToString(double dNumberIn) {
		return "" + dNumberIn;
	}
	
	/**
	 * The strToFloat method is used to convert a given string into an float. It includes error
	 * handling to ensure the string is valid before conversion. If the string is not initialized,
	 * empty, or not numeric, it defaults to “0”. The method then converts the string to a float
	 * and lets the developer know the result.
	 * 
	 * @param sFloatIn numerical string.
	 * @return value of the numerical string as float.
	 */
	public static float strToFloat(String sFloatIn) {
		
		// Error handling if the String isn't initialized
		// or the String is empty or the String is not numeric.
		if(sFloatIn==null ||
				sFloatIn.equals("") ||
				!Utility.isNumeric(sFloatIn))
			sFloatIn = Float.toString(0);
		
		return Float.valueOf(sFloatIn).floatValue();
	}
	
	
	/**
	 * Converts a float to its string representation.
	 *
	 * @param fNumberIn the float to be converted to a string
	 * @return the string representation of the input float
	 */
	public static String floatToString(float fNumberIn) {
		return "" + fNumberIn;
	}
	
	/**
	 * The strToBoolean method is used to convert a given string into an boolean. It includes error
	 * handling to ensure the string is valid before conversion. If the string is not initialized,
	 * empty, or "false", "no", "0". The method then converts the string to a float
	 * and lets the developer know the result.
	 * 
	 * @param sBooleanIn boolean string.
	 * @return value of the boolean string as boolean.
	 */
	public boolean strToBoolean(String sBooleanIn) {
	    
		if (sBooleanIn == null || sBooleanIn.trim().isEmpty()) {
	        return false; // Treat empty or uninitialized strings as false
	    }
	    
		String lowerStr = sBooleanIn.toLowerCase().trim();
	    
		switch (lowerStr) {
	        case "false":
	        case "no":
	        case "0":
	            return false;
	        default:
	            return true;
	    }
	}
}