/* -------------------------------------------------------------------------------------------------------
 * The java class jHelloWorld creates a program that displays a small window with the message “Hello Javax
 * Swing World!” in a fancy font. When you run the program, a window pops up with this message. It’s a
 * basic example of how to create a graphical user interface (GUI) in Java.
 * -------------------------------------------------------------------------------------------------------
 * Author:	Patrik Eigenmann
 * eMail:	p.eigenmann@gmx.net
 * -------------------------------------------------------------------------------------------------------
 * Change Log:
 * Wed 2024-10-17 Class file created.														Version 00.01
 * -------------------------------------------------------------------------------------------------------*/
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * The java class jHelloWorld creates a program that displays a small window with the message “Hello Javax
 * Swing World!” in a fancy font. When you run the program, a window pops up with this message. It’s a
 * basic example of how to create a graphical user interface (GUI) in Java.
 */
public class jHelloWorld extends JFrame {

	/**
	 * This line of code defines a unique identifier for the class, which is used during the serialization
	 * process. Serialization is a way to convert an object into a byte stream, allowing it to be easily
	 * saved to a file or sent over a network. The serialVersionUID ensures that the class can be correctly
	 * deserialized, even if the class definition changes over time.
	 */
	private static final long serialVersionUID = -5773514672291962786L;
	
	private JPanel contentPane;

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
					jHelloWorld frame = new jHelloWorld();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public jHelloWorld() {
		setTitle("jHelloWorld App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 119);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Hello Javax Swing World.");
		lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.ITALIC, 40));
		contentPane.add(lblNewLabel);
	}
}
