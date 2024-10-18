#include <stdio.h>
#include <stdlib.h>

/* ***************************************************************************************************
 * jHelloWorld.c - Starter Programm to run a Java application.
 * Please rename all <name> tags with the actual name of the java class, replace <day> and <date>
 * with the actual day (3 letter word) and date (Format YYYY-MM-DD), make sure there are no typos.
 * Compile and link the c program, and your good to go.
 * ---------------------------------------------------------------------------------------------------
 * Author:       Patrik Eigenmann
 * eMail:        p.eigenmann@gmx.net
 * ---------------------------------------------------------------------------------------------------
 * Change Log:
 * Sun 2024-09-01 System call java corrected. Working -classpath parameter.             Version: 00.01
 * Sun 2024-09-01 Hide the command prompt                                               Version: 00.02
 * Mon 2024-09-09 File created.                                                     	Version: 00.03
 * ***************************************************************************************************/

int main (int argc, char **argv) {

    // calling the java virtual machine on command line level but also hide the command line promt.
    // Windows:             "> NUL 2>&1" to hide the command prompt.
    // Linux/Unix/MacOS:    "> /dev/null 2>&1" to hide the command promt.
    system("java -classpath \".\" jHelloWorld");
    return 0;
}