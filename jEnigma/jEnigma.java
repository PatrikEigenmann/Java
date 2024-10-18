/* -----------------------------------------------------------------------------------------------------------
 * The Enigma machine is a cipher device developed and used in the early- to mid-20th century to protect commercial,
 * diplomatic, and military communication. It was employed extensively by Nazi Germany during World War II, in all
 * branches of the German military. The Enigma machine was considered so secure that it was used to encipher the
 * most top-secret messages.
 * 
 * Around December 1932 Marian Rejewski, a Polish mathematician and cryptologist at the Polish Cipher Bureau, used
 * the theory of permutations,[8] and flaws in the German military-message encipherment procedures, to break message
 * keys of the plugboard Enigma machine.
 *
 * On 26 and 27 July 1939, in Pyry, just south of Warsaw, the Poles initiated French and British military intelligence
 * representatives into the Polish Enigma-decryption techniques and equipment, including Zygalski sheets and the
 * cryptologic bomb, and promised each delegation a Polish-reconstructed Enigma (the devices were soon delivered).
 *
 * In September 1939, British Military Mission 4, which included Colin Gubbins and Vera Atkins, went to Poland,
 * intending to evacuate cipher-breakers Marian Rejewski, Jerzy Różycki, and  Zygalski from the country. The
 * cryptologists, however, had been evacuated by their own superiors into Romania, at the time a Polish-allied
 * country. On the way, for security reasons, the Polish Cipher Bureau personnel had deliberately destroyed their
 * records and equipment. From Romania they traveled on to France, where they resumed their cryptological work,
 * collaborating by teletype with the British, who began work on decrypting German Enigma messages, using the
 * Polish equipment and techniques.
 * -----------------------------------------------------------------------------------------------------------
 * Author:		Patrik Eigenmann
 * eMail:		p.eigenmann@gmx.net
 * -----------------------------------------------------------------------------------------------------------
 * Change Log:
 * Sun 2023-06-18 File created.																	Version: 00.01
 * Sun 2023-06-18 Frame and all GUI elements created.											Version: 00.02
 * Sun 2023-06-18 Writing files (encryption & decryption).										Version: 00.03
 * Mon 2023-06-19 Encryption & decryption routine implemented.									Version: 00.04
 * Fri 2023-06-23 Implementation of the MessageHandler.											Version: 00.05
 * Sat 2023-06-24 Finishing up MessageHandling.													Version: 00.06
 * Sun 2023-06-25 Start implementing a MenuBar.													Version: 00.07
 * Mon 2023-06-26 Creating the menu items and event handling.									Version: 00.08
 * Tue 2023-06-27 Menu "Home" with it sub menu items which are "Settings", "Logfile", "Help"	Version: 00.09
 * Mon 2024-09-02 VersionControl & getVersion implemented.										Version: 00.10
 * Fri 2024-09-27 Rearranged the Menu with "About" and "Reset". To make it the same as in C#.	Version: 00.11
 * Sat 2024-09-28 Rearranged the buttons to make the application similar like in C#.			Version: 00.12
 * Sat 2024-09-28 Load/Save methods JFileChooser implemented.									Version: 00.13
 * Sat 2024-09-28 Rotor calculation replaced with Rotor.AlphabetLength.							Version: 00.14
 * Sat 2024-09-28 Application name and Version # implemented.									Version: 00.15
 * Mon 2024-09-30 BugFix -> txt were saved as .enigma and vice versa.							Version: 00.16
 * Wed 2024-10-02 Config implemented.															Version: 00.17
 * Thu 2024-10-03 Re-programmed the application name & version number.							Version: 00.18
 * Thu 2024-10-10 Class LogManager implemented.													Version: 00.19
 * Sat 2024-10-12 Logged all methods.															Verison: 00.20
 * -----------------------------------------------------------------------------------------------------------
 * To Do:
 * Implementing a Configuration System.																-> Done
 * Implementing an Error/Warning/Info Logging System.	App version updated.						-> Done
 * -----------------------------------------------------------------------------------------------------------*/

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

import jEnigma.*;
import samael.*;

/**
 * The Enigma machine is a cipher device developed and used in the early- to mid-20th century to protect
 * commercial, diplomatic, and military communication. It was employed extensively by Nazi Germany during
 * World War II, in all branches of the German military. The Enigma machine was considered so secure that
 * it was used to encipher the most top-secret messages.
 * 
 * Around December 1932 Marian Rejewski, a Polish mathematician and cryptologist at the Polish Cipher Bureau,
 * used the theory of permutations,[8] and flaws in the German military-message encipherment procedures, to
 * break message keys of the plugboard Enigma machine.
 *
 * On 26 and 27 July 1939, in Pyry, just south of Warsaw, the Poles initiated French and British military
 * intelligence representatives into the Polish Enigma-decryption techniques and equipment, including
 * Zygalski sheets and the cryptologic bomb, and promised each delegation a Polish-reconstructed Enigma
 * (the devices were soon delivered).
 *
 * In September 1939, British Military Mission 4, which included Colin Gubbins and Vera Atkins, went to
 * Poland, intending to evacuate cipher-breakers Marian Rejewski, Jerzy Różycki, and  Zygalski from
 * the country. The cryptologists, however, had been evacuated by their own superiors into Romania, at the
 * time a Polish-allied country. On the way, for security reasons, the Polish Cipher Bureau personnel had
 * deliberately destroyed their records and equipment. From Romania they traveled on to France, where they
 * resumed their cryptological work, collaborating by teletype with the British, who began work on
 * decrypting German Enigma messages, using the Polish equipment and techniques.
 */
public class jEnigma extends JFrame implements IVersionable {
	
	/**
	 * This line of code defines a unique identifier for the class, which is used during the serialization
	 * process. Serialization is a way to convert an object into a byte stream, allowing it to be easily
	 * saved to a file or sent over a network. The serialVersionUID ensures that the class can be correctly
	 * deserialized, even if the class definition changes over time.
	 */
	private static final long serialVersionUID = -704302372600755850L;
	
	/**
     * The major # indicates significat changes or milestones, and stable builds in software packages. When
     * the major # is incremented, it usually means that there are substantial updates, such as new features
     * major improvements, or changes that might be not backward compatible. For example, moving from version
     * 01.?? to 02.00 suggests a major overhaul or signigicant new functionality.
	 */
	private static final int appMajor = 0;
	
	/**
     * The minor # represents smaller updates or improvements that are backwards compatible. Incrementing the
     * the minor # typically means bug fixes, minor enhancements, or incremental improvements. For instance
     * going from version 01.02 to 01.03 indicating a minor ubdate that enhances the existing version without
     * breaking the compatibility. 
	 */
	private static final int appMinor = 4;
	
	/**
     * Provides the name of the application as defined in the configuration, along with the current
     * version number. This ensures consistency and transparency across our software deployments.
     * It's a centralized source of truth for identifying the application and its version.
     * This information is essential for tracking updates and maintaining version control.
	 * @return Name of the application along with the current application version #.
	 */
	private final String AppInfo() {
		
		/* Write an info message into the log file. */
		LogManager.writeMessage("Application info created.", LogManager.INFO, jEnigma.class, jEnigma.class);
		
		/* Putting the return string together and immediately return it. */
		return ConfigManager.getParameter("appName") + String.format(" v%02d.%02d", appMajor, appMinor);
	}

	/**
	 * Override this method from the implemented VersionControl interface.
	 * The getVersion method in the Utility class retrieves version information. When called, it internally
	 * invokes VersionControl.getVersion(String component, Major #, Minor #) to obtain the version
	 * string. This method ensures that no data type faces the abyss of conversion alone.
	 * 
	 * @return A formatted String: Component: component name, Version Major #.Minor #.
	 */
	public static String getVersion() {
		
		/* Write an info message into the log file. */
		LogManager.writeMessage("Version String Created.", LogManager.INFO, jEnigma.class, jEnigma.class);
		/** Return a formatted String: Component: component name, Version Major #, Minor # */
		return VersionManager.getInstance(jEnigma.class.getName() , 0, 20).toString();
	}
	
	/**
	 * The area where the message to cipher can be written.
	 */
	private JTextArea message;

	/**
	 * Here the encrypted message will be shown.
	 */
	private JTextArea encrypted;

	/**
	 * File extention for the message file.
	 */
	private final String decryptExtention = ".txt";

	/**
	 * File extention for the encrypted file.
	 */
	private final String encryptExtention = ".enigma";

	/**
	 * The Enigma machine had three rotor responsible for encrypting messages. The smallest rotor contains all
	 * alphanumeric characters in a random order and rotates one position after each letter is encrypted.
	 */
	private SmallRotor smrotor;
    
	/**
	 * The medium rotor in the Enigma machine contains all alphanumeric characters in a random order. It
	 * advances one position after every 26 characters are encrypted, providing an additional layer of
	 * complexity to the encryption process.
	 */
	private MedRotor medrotor;
    
	/**
	 * The large rotor in the Enigma machine contains all alphanumeric characters in a random order. It
	 * advances one position after every 676 characters are encrypted, adding a significant layer of complexity
	 * to the encryption process.
	 */
	private LargeRotor lgrotor;
    
	/**
	 * The constructor method of the jEnigma class initializes the frame and its components. It sets up a
	 * window with a customized content that can be displayed. The construction method is a generated method,
	 * and can feel certainly a little bit robotic. But the designer is doing actually a good job creating
	 * the code for the GUI.
	 */
	public jEnigma() {
		
		setTitle(AppInfo());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 424);

		// Setup the panel
		JPanel pnl = new JPanel();
		setContentPane(pnl);
		pnl.setLayout(new BorderLayout());
		
		/**
		 * The mb is a menu bar which hosts the menu "About" & "Reset".
		 */
		JMenuBar mb = new JMenuBar();
		JMenu mnuAbout = new JMenu("About");
		mnuAbout.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				mnuAboutPressed();
			}
		});

		/** Add the whole menu "About" to the menubar. */
		mb.add(mnuAbout);
		
		JMenu mnuReset = new JMenu("Reset");
		mnuReset.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				mnuResetPressed();
			}
		});
		
		mb.add(mnuReset);
		
		
		/** Set the menubar in the JFrame. */
		setJMenuBar(mb);


		// Message Panel
		JPanel msg_pnl = new JPanel();
		pnl.add(msg_pnl, BorderLayout.CENTER);
		msg_pnl.setLayout(new GridLayout(0, 1, 0, 10));
		
		// Message TextArea
		message = new JTextArea();
		msg_pnl.add(message);
		message.setColumns(10);
		
		// Encryption TextArea
		encrypted = new JTextArea();
		msg_pnl.add(encrypted);
		encrypted.setColumns(10);
		
		// Control Panel
		JPanel ctl_pnl = new JPanel();
		pnl.add(ctl_pnl, BorderLayout.EAST);
		ctl_pnl.setLayout(new GridLayout(0, 1, 0, 0));
		
		// Encryption button.
		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEncryptPressed();
			}
		});
		ctl_pnl.add(btnEncrypt);
		
		// Button to load the message file. 
		JButton btnMessageLoad = new JButton("Load");
		btnMessageLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnMessageLoadPressed();
			}
		});
		ctl_pnl.add(btnMessageLoad);
		
		// Save the Message.
		JButton btnMessageSave = new JButton("Save");
		btnMessageSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnMessageSavePressed();
			}
		});
		ctl_pnl.add(btnMessageSave);
		
		// Encryption area
		JLabel lblNewLabel_1 = new JLabel("");
		ctl_pnl.add(lblNewLabel_1);
		
		// Decryption area
		JLabel lblNewLabel;
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnDecryptPressed();
			}
		});
		ctl_pnl.add(btnDecrypt);
		
				// Load the decryption file
				JButton btnDecryptLoad = new JButton("Load");
				btnDecryptLoad.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						btnDecryptionLoadPressed();
					}
				});
				ctl_pnl.add(btnDecryptLoad);
		
		// Save the decrcyption file
		JButton btnDecryptSave = new JButton("Save");
		btnDecryptSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnDecryptionSavePressed();
			}
		});
		ctl_pnl.add(btnDecryptSave);
		lblNewLabel = new JLabel("");
		ctl_pnl.add(lblNewLabel);
		
		/* Write an info message into the log file. */
		LogManager.writeMessage("jEnigma instance created.", LogManager.INFO, jEnigma.class, jEnigma.class);
		
		// Getting the rotor's initialized.
		smrotor = new SmallRotor();
		medrotor = new MedRotor();
		lgrotor = new LargeRotor();
	}
	
	/**
	 * This procedure will be called, when
	 * the encrypt button is pressed.
	 */
	private void btnEncryptPressed() {

		String plain = message.getText();
		//plain = plain.toUpperCase();
		String cypher = "";
	
		for(int i = 0; i < plain.length();i++) {
			cypher += EncryptChar(plain.charAt(i));
		}

		encrypted.setText(cypher);
	
		/* Write an info message into the log file. */
		LogManager.writeMessage("Encryption button pressed.", LogManager.INFO, jEnigma.class, jEnigma.class);
		
		smrotor.Reset();
		medrotor.Reset();
		lgrotor.Reset();
	}
	
	/**
	 * This procedure is called when the 
	 * message load button was pressed.
	 */
	private void btnMessageLoadPressed() {
		
		Path directoryPath = Paths.get(System.getProperty("user.home"), "Documents", "enigma");
	    
	    // Create the directory if it doesn't exist
	    if (!Files.exists(directoryPath)) {
	        try {
	            Files.createDirectories(directoryPath);
	        } catch (IOException e) {
	        	/* Write an error message in the log file. */
	        	LogManager.writeMessage(e.getMessage(), LogManager.ERROR, jEnigma.class, jEnigma.class);
	            return;
	        }
	    }
	    
	    JFileChooser fileChooser = new JFileChooser(directoryPath.toFile());
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
	    fileChooser.setFileFilter(filter);
	    int returnValue = fileChooser.showOpenDialog(null);
	    
	    if (returnValue == JFileChooser.APPROVE_OPTION) {
	        String fileName = fileChooser.getSelectedFile().getPath();
	        message.setText("");
	        
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line = reader.readLine();
	            while (line != null) {
	                message.setText(message.getText() + line + "\n");
	                line = reader.readLine();
	            }
	        } catch (IOException e) {
	        	
	        	/* Write an error message in the log file. */
	        	LogManager.writeMessage(e.getMessage(), LogManager.ERROR, jEnigma.class, jEnigma.class);
	        }
	    }
	    
	    /* Write an info message in the log file. */
	    LogManager.writeMessage("Load button @ plain text pressed.", LogManager.INFO, jEnigma.class, jEnigma.class);
	    
	}
	
	/**
	 * This procedure will be called when the
	 * message save button was pressed.
	 */
	private void btnMessageSavePressed() {
		
		Path directoryPath = Paths.get(System.getProperty("user.home"), "Documents", "enigma");
	    
	    // Create the directory if it doesn't exist
	    if (!Files.exists(directoryPath)) {
	        try {
	            Files.createDirectories(directoryPath);
	        } catch (IOException e) {
	            /* Write an error message in the log file. */
	    	    LogManager.writeMessage(e.getMessage(), LogManager.ERROR, jEnigma.class, jEnigma.class);
	            return;
	        }
	    }
	    
	    JFileChooser fileChooser = new JFileChooser(directoryPath.toFile());
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
	    fileChooser.setFileFilter(filter);
	    int returnValue = fileChooser.showSaveDialog(null);
	    
	    if (returnValue == JFileChooser.APPROVE_OPTION) {
	        String fileName = fileChooser.getSelectedFile().getPath();
	        if(!fileName.endsWith(decryptExtention))
	        	fileName += decryptExtention;
	        String[] lines = message.getText().split("\n");
	        
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
	            for (String line : lines) {
	                writer.write(line);
	                writer.newLine();
	            }
	        } catch (IOException e) {
	        	
	        	//LogManager.writeMessage(e.getMessage(), LogManager.ERROR, jEnigma.class);
	        	LogManager.writeMessage(e.getMessage(), LogManager.ERROR, jEnigma.class, jEnigma.class);
	        }
	    }
	    
	    //LogManager.writeMessage("jEnigma button save message pressed.", jEnigma.class);
	    LogManager.writeMessage("Save button @ plain text pressed.", LogManager.INFO, jEnigma.class, jEnigma.class);
	}
	
	/**
	 * This method will be called when the menu
	 * About is pressed.
	 */
	private void mnuAboutPressed() {
		
		String message = AppInfo() + "\n---------------------------------------\n";
		message += jEnigma.getVersion() + "\n";
		//message += jLogfile.getVersion() + "\n";
		//message += jSettings.getVersion() + "\n";
		message += Rotor.getVersion() + "\n";
		message += SmallRotor.getVersion() + "\n";
		message += MedRotor.getVersion() + "\n";
		message += LargeRotor.getVersion() + "\n";
		message += "\n\n";
		message += VersionManager.addFramework();
		
		JOptionPane.showMessageDialog(this, message, ConfigManager.getParameter("about.Title"), JOptionPane.PLAIN_MESSAGE);
		
    	/* Write an info message in the log file. */
    	LogManager.writeMessage("About button in menu pressed.", LogManager.INFO, jEnigma.class, jEnigma.class);
	}
	
	/**
	 * This method will reset the text boxes to start fresh. The method is
	 * called from the main menu.
	 */
	private void mnuResetPressed() {
		message.setText("");
		encrypted.setText("");
		
    	/* Write an info message in the log file. */
    	LogManager.writeMessage("Reset button in menu pressed.", LogManager.INFO, jEnigma.class, jEnigma.class);
	}
	
	/**
	 * This procedure will be called when the
	 * decrypt button was pressed.
	 */
	private void btnDecryptPressed() {
		String cypher = encrypted.getText();
		//cypher = cypher.toUpperCase();
		String plaintxt = "";
	
		for(int i = 0; i < cypher.length();i++)
		{
			plaintxt += DecryptChar(cypher.charAt(i));
		}
	
		message.setText(plaintxt);
	
		smrotor.Reset();
		medrotor.Reset();
		lgrotor.Reset();
	}
	
	/**
	 * This procedure will be called when the
	 * decryption load button was pressed.
	 */
	private void btnDecryptionLoadPressed() {
		
		Path directoryPath = Paths.get(System.getProperty("user.home"), "Documents", "enigma");
	    
	    // Create the directory if it doesn't exist
	    if (!Files.exists(directoryPath)) {
	        try {
	            Files.createDirectories(directoryPath);
	        } catch (IOException e) {
	        	/* Write an error message in the log file. */
	        	LogManager.writeMessage(e.getMessage(), LogManager.ERROR, jEnigma.class, jEnigma.class);
	            return;
	        }
	    }
	    
	    JFileChooser fileChooser = new JFileChooser(directoryPath.toFile());
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("Encrypted Files", "enigma");
	    fileChooser.setFileFilter(filter); // Set the file filter to the JFileChooser
	    int returnValue = fileChooser.showOpenDialog(null);
	    
	    if (returnValue == JFileChooser.APPROVE_OPTION) {
	        String fileName = fileChooser.getSelectedFile().getPath();
	        encrypted.setText("");
	        
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line = reader.readLine();
	            while (line != null) {
	                encrypted.setText(encrypted.getText() + line + "\n");
	                line = reader.readLine();
	            }
	        } catch (IOException e) {
	        	/* Write an error message in the log file. */
	        	LogManager.writeMessage(e.getMessage(), LogManager.ERROR, jEnigma.class, jEnigma.class);
	        }
	    }
	    
    	/* Write an info message in the log file. */
    	LogManager.writeMessage("Load button @ encrypted text pressed.", LogManager.INFO, jEnigma.class, jEnigma.class);
	}
	
	/**
	 * This procedure will be called when the 
	 * decryption save button was pressed.
	 */
	private void btnDecryptionSavePressed() {
		Path directoryPath = Paths.get(System.getProperty("user.home"), "Documents", "enigma");
	    
	    // Create the directory if it doesn't exist
	    if (!Files.exists(directoryPath)) {
	        try {
	            Files.createDirectories(directoryPath);
	        } catch (IOException e) {
	        	/* Write an error message in the log file. */
	        	LogManager.writeMessage(e.getMessage(), LogManager.ERROR, jEnigma.class, jEnigma.class);
	            return;
	        }
	    }
	    
	    JFileChooser fileChooser = new JFileChooser(directoryPath.toFile());
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("Encrypted Files", "enigma");
	    fileChooser.setFileFilter(filter); // Set the file filter to the JFileChooser
	    int returnValue = fileChooser.showSaveDialog(null);
	    
	    if (returnValue == JFileChooser.APPROVE_OPTION) {
	        String fileName = fileChooser.getSelectedFile().getPath();
	        if(!fileName.endsWith(encryptExtention))
	        	fileName += encryptExtention;
	        
	        String[] lines = encrypted.getText().split("\n");
	        
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
	            for (String line : lines) {
	                writer.write(line);
	                writer.newLine();
	            }
	        } catch (IOException e) {
	        	/* Write an info message in the log file. */
	        	LogManager.writeMessage(e.getMessage(), LogManager.INFO, jEnigma.class, jEnigma.class);
	        }
	    }
	    
    	/* Write an info message in the log file. */
    	LogManager.writeMessage("Save button @ encrypted text pressed.", LogManager.INFO, jEnigma.class, jEnigma.class);
	}

	/**
	 * Encryption on character level.
	 * @param Character to encrypt.
	 * @return Encrypted character.
	 */
    private char EncryptChar(char c) {
    	char ch = 0;
		try {
			ch = lgrotor.charAt(smrotor.indexOf(c));
			ch = lgrotor.charAt(medrotor.indexOf(ch));
		}
		catch(Exception e) {
            /**
             * If the string contains '\0' it means that's the end of the string,
             * and because the character initialization is with a '\0' a space
             * will not be processed and the return value of ch was = '\0' 
             * Old Code: if (c != '\n')
             */
			ch = c;
			
	    	/* Write an error message in the log file. */
	    	LogManager.writeMessage(e.getMessage(), LogManager.ERROR, jEnigma.class, jEnigma.class);
			
			return ch;
		}

    	/* Write an info message in the log file. */
    	LogManager.writeMessage("Encrypt character: " + c + " into " + ch, LogManager.INFO, jEnigma.class, jEnigma.class);
		
    	smrotor.turn();

		if(smrotor.turns() % Rotor.AlphabetLength == 0)
			medrotor.turn();
		
		if(medrotor.turns() % Rotor.AlphabetLength == 0)
			lgrotor.turn();

		return ch;
	}

	/**
	 * Decryption on character level.
	 * @param Character to decrypt.
	 * @return Decrypted character.
	 */
	private char DecryptChar(char c)
	{
    	char ch = 0;
		try {
			ch = medrotor.charAt(lgrotor.indexOf(c));      
			ch = smrotor.charAt(lgrotor.indexOf(ch));
		}
		catch(Exception e) {
            /**
             * If the string contains '\0' it means that's the end of the string,
             * and because the character initialization is with a '\0' a space
             * will not be processed and the return value of ch was = '\0' 
             * Old Code: if (c != '\n')
             */
			ch = c;
			
	    	/* Write an error message in the log file. */
	    	LogManager.writeMessage(e.getMessage(), LogManager.ERROR, jEnigma.class, jEnigma.class);
			
	    	return ch;
    	}
		
		smrotor.turn();

    	/* Write an info message in the log file. */
    	LogManager.writeMessage("Decrypt character: " + c + " into " + ch, LogManager.INFO, jEnigma.class, jEnigma.class);
		
		if(smrotor.turns() % Rotor.AlphabetLength == 0)
				medrotor.turn();
		
		if(medrotor.turns() % Rotor.AlphabetLength == 0)
			lgrotor.turn();

		return ch;
	}

	/**
	 * This method is the entry point of the application and starts a small program that displays a window on your
	 * screen. It ensures that the window is created and shown correctly, and it catches any errors that might
	 * occur during this process.
	 * 
	 * @param args are the command line arguments.
	 */
	public static void main(String[] args) {
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jEnigma frame = new jEnigma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}