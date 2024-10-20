/* ***************************************************************************************************
 * HelloWorld.c - Starter Programm to run a Java application.
 * Please rename all <name> tags with the actual name of the java class, replace <day> and <date>
 * with the actual day (3 letter word) and date (Format YYYY-MM-DD), make sure there are no typos.
 * Compile and link the c program, and your good to go.
 * 
 * Compiler information:
 * gcc HelloWorld.c -o HelloWorld
 * clang HelloWorld.c -o HelloWorld
 * ---------------------------------------------------------------------------------------------------
 * Author:       Patrik Eigenmann
 * eMail:        p.eigenmann@gmx.net
 * ---------------------------------------------------------------------------------------------------
 * Change Log:
 * Sun 2024-10-17 System call java corrected. Working -classpath parameter.             Version: 00.01
 * Sun 2024-10-17 Hide the command prompt                                               Version: 00.02
 * Mon 2024-10-17 File created.                                                     	Version: 00.03
 * Sat 2024-10-19 Optimized for MacOS and Windows.										Version: 00.04
 * ***************************************************************************************************/
#include <stdio.h>
#include <stdlib.h>


int main (int argc, char **argv) {

	// Windows:				-> system("java -classpath \".\" HelloWorld");
	// Unix/Linux/MacOS:	-> system("java -classpath \".\" HelloWorld");
    system("java -classpath \".\" HelloWorld");
    return 0;
}