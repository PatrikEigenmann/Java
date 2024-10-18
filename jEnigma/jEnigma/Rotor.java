/* -------------------------------------------------------------------------------------------------------------------
 * The Rotor class is an abstract representation of a rotor mechanism, commonly used in encryption devices like the
 * Enigma machine. It manages a rotor with a fixed alphabet length, tracks the number of turns, and provides methods
 * to manipulate and query the rotor’s state. The class includes methods to rotate the rotor, reset it, and find the
 * index of a character. The setAlphabet method is abstract, requiring subclasses to define the specific alphabet used.
 * -------------------------------------------------------------------------------------------------------------------
 * Author:	Patrik Eigenmann
 * eMail:	p.eigenmann@gmx.net
 * -------------------------------------------------------------------------------------------------------------------
 * Change Log:
 * Sun 2024-09-01 File created.																			Version: 00.01
 * Sun 2024-09-01 Version control & getVersion implemented.												Version: 00.02
 * Fri 2024-09-27 Changed the number of characters from the alphabet to all alphanumeric characters.	Version: 00.03
 * ------------------------------------------------------------------------------------------------------------------- */
package jEnigma;

import samael.*;

/**
 * The Rotor class is an abstract representation of a rotor mechanism, commonly used in encryption devices
 * like the Enigma machine. It manages a rotor with a fixed alphabet length, tracks the number of turns,
 * and provides methods to manipulate and query the rotor’s state. The class includes methods to rotate
 * the rotor, reset it, and find the index of a character. The setAlphabet method is abstract, requiring
 * subclasses to define the specific alphabet used.
 */
public abstract class Rotor implements IVersionable {
	
	/**	All alphanumeric characters plus the space are 63 characters. */
	public static final int AlphabetLength = 63;

	/**	Initialize the rotor and reserve space for each letter in the alphabet. */
    protected char [] rotor = new char[AlphabetLength];

	/**	Initialize how many turns were made. */
    protected int turns = 0;

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
		return VersionManager.getInstance(Rotor.class.getName() , 0, 3).toString();
	}
    
    /**
     * The constructor of the Rotor class initializes the rotor’s state when an instance of the class is
     * created. It sets the initial number of turns to zero and initializes the rotor’s alphabet by calling
     * the setAlphabet method. This ensures that the rotor starts in a known state with a defined alphabet.
     */
    public Rotor() {
        turns = 0;
        setAlphabet();
    }
    
    /**
	 * The indexOf method is like a detective for your rotor’s alphabet. It hunts down the given character
	 * and returns its position. If the character is missing in action, it returns -1, signaling that the
	 * search came up empty.
	 * 
	 * @param c The character to search for in the rotor’s alphabet.
	 * @return The index of the character c in the rotor’s alphabet, or -1 if the character is not found.
	 */
    public int indexOf(char c) {
        for(int i = 0; i < AlphabetLength; i++) {
            if(rotor[i] == c)
            return i;
        }

        return -1;
    }

    /**
     * In the shadowy depths of the Rotor class, the turns method lurks, waiting to reveal the number of
     * times the rotor has twisted and turned. Each call to this method brings forth the eerie count of
     * rotations, a silent witness to the rotor’s relentless journey.
     * 
     * @return The haunting number of turns the rotor has endured.
     */
    public int turns() {
    	return turns;
    }

    /**
     * In the delicate dance of the turn method, the rotor’s first character, c, is gently moved aside,
     * making way for the others to follow. One by one, they shift, each taking the place of the one
     * before, until c finds its new home at the end. With each turn, the rotor’s journey continues, and
     * the count of turns, like the beats of a heart, increases by one, marking the passage of time in
     * this mechanical romance.
     */
    public void turn() {
    	
    	char c = rotor[0];
    	for(int i = 1; i < AlphabetLength;i++){
            rotor[i-1] = rotor[i];
    	}

    	rotor[AlphabetLength-1] = c;

    	turns++;
    }

    /**
     * Ah, the charAt method, a true connoisseur’s delight. This method, with all the grace of a well-aged
     * scotch, retrieves the character at the specified index i from our esteemed rotor array. One might
     * say it’s akin to selecting the finest cigar from a humidor—precise, deliberate, and oh-so-satisfying.
     * 
     * @param i The index at which to retrieve the character, much like choosing the perfect seat at the club.
     * @return The character residing at the distinguished position i in the rotor array.
     */
    public char charAt(int i)
    {
    	return rotor[i];
    }

    /**
     * Aye, the Reset method, it’s a proper grafter’s tool, innit? This method rolls up its sleeves and gets
     * to work, setting the turns back to zero, like clocking out after a hard day’s graft. Then, it calls
     * setAlphabet to get everything shipshape and Bristol fashion, ready for another round. No fuss, no
     * muss, just good honest work.
     */
    public void Reset() {
        turns = 0;
        setAlphabet();
    }

    /**
     * Ah, the setAlphabet method, a paragon of scholarly abstraction. This method, in its most erudite form,
     * remains unimplemented, awaiting the intellectual prowess of a subclass to bestow upon it a concrete
     * definition. It is the very essence of polymorphism, a testament to the flexibility and extensibility
     * of our rotor mechanism. One might say it is the blank canvas upon which the subclasses shall paint their
     * unique alphabets, thus contributing to the grand tapestry of our encryption endeavor.
     */
    public abstract void setAlphabet();
}
