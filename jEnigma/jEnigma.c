/* ***************************************************************************************************
 * jEnigma.c - Starter Programm to run a Java application.
 * Please rename all <name> tags with the actual name of the java class, replace <day> and <date>
 * with the actual day (3 letter word) and date (Format YYYY-MM-DD), make sure there are no typos.
 * Compile and link the c program, and your good to go.
 *
 * Compiler information:
 * gcc jEnigma.c -o jEnigma(.bin)
 * clang jEnigma.c -o jEnigma(.bin)
 * ---------------------------------------------------------------------------------------------------
 * Author:       Patrik Eigenmann
 * eMail:        p.eigenmann@gmx.net
 * ---------------------------------------------------------------------------------------------------
 * Change Log:
 * Sun 2024-09-01 System call java corrected. Working -classpath parameter.             Version: 00.01
 * Sun 2024-09-01 Hide the command prompt                                               Version: 00.02
 * Tue 2024-10-01 File created.                                                         Version: 00.03
 * Mon 2024-10-14 Optimized for Mac OS.													Version: 00.04
 * ***************************************************************************************************/
#include <stdio.h>
#include <stdlib.h>

int main (int argc, char **argv) {
	
	// Pleas uncomment whichever fits best for you, and change the path to your Samael project or where
	// you have your java libraries and jar-files. Thank you.
    // Windows:				-> system("java -classpath \"D:\\Development\\Java\\Samael;.\" jEnigma");
    // Linux/Unix/MacOS:    -> system("java -classpath \"/home/development/java/Samael:./\" jEnigma");
    // MacOS:				-> system("java -classpath \"/Users/patrik/development/java/Samael:./\" jEnigma");
    system("java -classpath \"D:\\Development\\Java\\Samael;.\" jEnigma");
    return 0;
}