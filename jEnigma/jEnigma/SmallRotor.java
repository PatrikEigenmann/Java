/* -------------------------------------------------------------------------------------------------------
 * The SmallRotor class inherits all from its abstract parent Rotor. It representation of a rotor mechanism,
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
 * -------------------------------------------------------------------------------------------------------*/
package jEnigma;

import samael.*;

/**
 * The SmallRotor class inherits all from its abstract parent Rotor. It representation of a rotor mechanism,
 * commonly used in encryption devices like the Enigma machine. It manages a rotor with a fixed alphabet
 * length, tracks the number of turns, and provides methods to manipulate and query the rotor’s state. The
 * class includes methods to rotate the rotor, reset it, and find the index of a character. The overwritten
 * setAlphabet method is specific for the SmallRotor.
 */
public class SmallRotor extends Rotor implements IVersionable {
    
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
		return VersionManager.getInstance( SmallRotor.class.getName(), 0, 3).toString();
	}
	
	/**
	 * This method meticulously initializes the rotor array with a bespoke sequence of characters, commencing
	 * with a space and proceeding through a distinct arrangement of letters. This custom alphabet is essential
	 * for the rotor’s functionality within the Enigma machine.
	 */
	@Override
    public void setAlphabet()
    {
        int i = 0; 

        rotor[i++] = ' ';
        rotor[i++] = 'E';
        rotor[i++] = 'J';
        rotor[i++] = 'O';
        rotor[i++] = 'T';
        rotor[i++] = 'Y';
        rotor[i++] = 'C';
        rotor[i++] = 'H';
        rotor[i++] = 'M';
        rotor[i++] = 'R';
        rotor[i++] = 'W';
        rotor[i++] = 'A';
        rotor[i++] = 'F';
        rotor[i++] = 'K';
        rotor[i++] = 'P';
        rotor[i++] = 'U';
        rotor[i++] = 'Z';
        rotor[i++] = 'D';
        rotor[i++] = 'I';
        rotor[i++] = 'N';
        rotor[i++] = 'S';
        rotor[i++] = 'X';
        rotor[i++] = 'B';
        rotor[i++] = 'G';
        rotor[i++] = 'L';
        rotor[i++] = 'Q';
        rotor[i++] = 'V';
        rotor[i++] = 'e';
        rotor[i++] = 'j';
        rotor[i++] = 'o';
        rotor[i++] = 't';
        rotor[i++] = 'y';
        rotor[i++] = 'c';
        rotor[i++] = 'h';
        rotor[i++] = 'm';
        rotor[i++] = 'r';
        rotor[i++] = 'w';
        rotor[i++] = 'a';
        rotor[i++] = 'f';
        rotor[i++] = 'k';
        rotor[i++] = 'p';
        rotor[i++] = 'u';
        rotor[i++] = 'z';
        rotor[i++] = 'd';
        rotor[i++] = 'i';
        rotor[i++] = 'n';
        rotor[i++] = 's';
        rotor[i++] = 'x';
        rotor[i++] = 'b';
        rotor[i++] = 'g';
        rotor[i++] = 'l';
        rotor[i++] = 'q';
        rotor[i++] = 'v';
        rotor[i++] = '0';
        rotor[i++] = '1';
        rotor[i++] = '2';
        rotor[i++] = '3';
        rotor[i++] = '4';
        rotor[i++] = '5';
        rotor[i++] = '6';
        rotor[i++] = '7';
        rotor[i++] = '8';
        rotor[i] = '9';

    }

}