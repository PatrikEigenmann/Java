/* -------------------------------------------------------------------------------------------------------
 * The MedRotor class inherits all from its abstract parent Rotor. It representation of a rotor mechanism,
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
 * The MedRotor class inherits all from its abstract parent Rotor. It representation of a rotor mechanism,
 * commonly used in encryption devices like the Enigma machine. It manages a rotor with a fixed alphabet
 * length, tracks the number of turns, and provides methods to manipulate and query the rotor’s state. The
 * class includes methods to rotate the rotor, reset it, and find the index of a character. The overwritten
 * setAlphabet method is specific for the SmallRotor.
 */
public class MedRotor extends Rotor implements IVersionable{
	
	/**
	 * Override this method from the implemented VersionControl interface.
	 * The getVersion method in the Utility class retrieves version information. When called, it internally
	 * invokes VersionControl.getVersion(String component, Major #, Minor #) to obtain the version
	 * string. This method ensures that no data type faces the abyss of conversion alone.
	 * 
	 * @return "Component" component: "Version" Major#.Minor#
	 */
	public static String getVersion() {
		
		/** Return A formatted String: Component: component name, Version Major #.Minor #. */
		return VersionManager.getInstance(MedRotor.class.getName(), 0, 3).toString();
	}
	
	/**
	 * In this most esteemed method, the rotor array is endowed with a sequence of characters, commencing with
	 * a space and followed by letters in a singular and distinguished order. This bespoke alphabet is of
	 * paramount importance to the rotor’s operation within the Enigma contrivance.
	 */
    @Override
    public void setAlphabet()
    {
        int i = 0; 

        rotor[i++] = '2';
        rotor[i++] = ' ';
        rotor[i++] = '5';
        rotor[i++] = 'E';
        rotor[i++] = 'J';
        rotor[i++] = 'O';
        rotor[i++] = 'T';
        rotor[i++] = 'Y';
        rotor[i++] = 'C';
        rotor[i++] = 'H';
        rotor[i++] = '6';
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
        rotor[i++] = '9';
        rotor[i++] = 'e';
        rotor[i++] = 'j';
        rotor[i++] = 'o';
        rotor[i++] = 't';
        rotor[i++] = '8';
        rotor[i++] = '3';
        rotor[i++] = 'y';
        rotor[i++] = 'c';
        rotor[i++] = 'h';
        rotor[i++] = '0';
        rotor[i++] = 'm';
        rotor[i++] = 'r';
        rotor[i++] = 'w';
        rotor[i++] = 'a';
        rotor[i++] = 'f';
        rotor[i++] = 'k';
        rotor[i++] = '7';
        rotor[i++] = 'p';
        rotor[i++] = 'u';
        rotor[i++] = 'z';
        rotor[i++] = 'd';
        rotor[i++] = 'i';
        rotor[i++] = '4';
        rotor[i++] = 'n';
        rotor[i++] = 's';
        rotor[i++] = 'x';
        rotor[i++] = 'b';
        rotor[i++] = 'g';
        rotor[i++] = 'l';
        rotor[i++] = 'q';
        rotor[i++] = 'v';
        rotor[i] = '1';

    }
}