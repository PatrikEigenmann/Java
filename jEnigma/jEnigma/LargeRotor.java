/* -------------------------------------------------------------------------------------------------------
 * The LargeRotor class inherits all from its abstract parent Rotor. It representation of a rotor mechanism,
 * commonly used in encryption devices like the Enigma machine. It manages a rotor with a fixed alphabet
 * length, tracks the number of turns, and provides methods to manipulate and query the rotor’s state. The
 * class includes methods to rotate the rotor, reset it, and find the index of a character. The overwritten
 * setAlphabet method is specific for the SmallRotor.
 * -------------------------------------------------------------------------------------------------------
 * Author:	Patrik Eigenmann
 * eMail:	p.eigenmann@gmx.net
 * -------------------------------------------------------------------------------------------------------
 * Change Log:
 * Sun 2024-09-01 File created.																Version: 00.01
 * Sun 2024-09-01 Version control & getVersion implemented.									Version: 00.02
 * Fri 2024-09-27 Extended the alphabet to all alphanumeric characters.						Version: 00.03
 * Sat 2024-10-28 Just realized that I forgot to implement IVersionable.					Version: 00.04
 * -------------------------------------------------------------------------------------------------------*/
package jEnigma;

import samael.*;

/**
 * The LargeRotor class inherits all from its abstract parent Rotor. It representation of a rotor mechanism,
 * commonly used in encryption devices like the Enigma machine. It manages a rotor with a fixed alphabet
 * length, tracks the number of turns, and provides methods to manipulate and query the rotor’s state. The
 * class includes methods to rotate the rotor, reset it, and find the index of a character. The overwritten
 * setAlphabet method is specific for the SmallRotor.
 */
public class LargeRotor extends Rotor implements IVersionable {
    
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
		return VersionManager.getInstance(LargeRotor.class.getName(), 0, 4).toString();
	}
	
	/**
	 * My dear Watson, this method is employed to initialize the rotor array with a particular sequence of
	 * characters. It begins with a space and continues with letters arranged in a unique and deliberate
	 * order. This custom alphabet is crucial for the proper functioning of the rotor within the Enigma machine.
	 */
	@Override
    public void setAlphabet()
    {
		int  i = 0;

		rotor[i++] = '0';
		rotor[i++] = '1';
		rotor[i++] = ' ';
        rotor[i++] = 'B';
		rotor[i++] = '2';
        rotor[i++] = 'b';
        rotor[i++] = 'd';
        rotor[i++] = 'f';
        rotor[i++] = 'h';
		rotor[i++] = '3';
		rotor[i++] = '4';
        rotor[i++] = 'A';
        rotor[i++] = 'C';
        rotor[i++] = 'E';
        rotor[i++] = 'G';
		rotor[i++] = '5';
        rotor[i++] = 'c';
        rotor[i++] = 'e';
        rotor[i++] = 'g';
        rotor[i++] = 'i';
		rotor[i++] = '6';
        rotor[i++] = 'U';
        rotor[i++] = 'W';
        rotor[i++] = 'Y';
        rotor[i++] = 'j';
        rotor[i++] = 'l';
        rotor[i++] = 'n';
        rotor[i++] = 'p';
		rotor[i++] = '7';
		rotor[i++] = '8';
		rotor[i++] = '9';
        rotor[i++] = 'D';
        rotor[i++] = 'F';
        rotor[i++] = 'H';
        rotor[i++] = 'J';
        rotor[i++] = 'L';
        rotor[i++] = 'N';
        rotor[i++] = 'P';
        rotor[i++] = 'R';
        rotor[i++] = 'T';
        rotor[i++] = 'V';
        rotor[i++] = 'X';
        rotor[i++] = 'Z';
        rotor[i++] = 'I';
        rotor[i++] = 'K';
        rotor[i++] = 'M';
        rotor[i++] = 'O';
        rotor[i++] = 'Q';
        rotor[i++] = 'S';
        rotor[i++] = 'r';
        rotor[i++] = 't';
        rotor[i++] = 'v';
        rotor[i++] = 'x';
        rotor[i++] = 'z';
        rotor[i++] = 'a';
        rotor[i++] = 'k';
        rotor[i++] = 'm';
        rotor[i++] = 'o';
        rotor[i++] = 'q';
        rotor[i++] = 's';
        rotor[i++] = 'u';
        rotor[i++] = 'w';
        rotor[i] = 'y';
    }
}