
---------------------------------------
INSTALLATION/USAGE GUIDE FOR CMTJava
---------------------------------------

This distribution contains the following files:

src/
	test/									Test programs written in CMTJava
	stm/									CMTJava's transaction support library

build.sh								Scripts for compiling the library code and the samples
test_samples.sh					Script to run the sample programs

--------------------
1. REQUIRED SOFTWARE 
--------------------

 1. Sun's Java(TM) JDK (tested with Java 1.7 but should also work with Java 1.6)
 2. make
 3. BGGA closures (for using closures in Java - include under "compiler" folder)

-------------------------------------------------------
2. INSTALLATION
-------------------------------------------------------

To work properly, the CMTJAVA compilation tool needs to find where the template file and the
closures folder are located.
       
			Set the CMTJAVAC environment variable with the path where the template file (CMTJava.stg)
			and the root folder of the BGGA closures files are. Both the template file and the
			closures folder are located in the "compiler" folder.
			Example (if you extracted the cmtjava package to the desktop): 
			export CMTJAVAC=~/Desktop/cmtjava/compiler/

---------------------------------
3. USAGE
---------------------------------

The usage of CMTJava is divided into two parts:

---------------------------------
3.1 TRANSFORMATION & COMPILATION
---------------------------------

  The CMTJava source files (.cmtjava) are first translated into Java + closures (.java) to be compiled with 
	the BGGA closures compiler. These files won't compile with the standard Java compiler.
	The translated files are generated in the same folder of the CMTJava source files.
	To generate then, the CMTJAVA compilation tool will look for the template file (CMTJava.stg) in the folder 
	$CMTJAVAC/CMTJava.stg

	After the translation, the .java files are compiled with the BGGA closures compiler. The CMTJAVA
	compilation tool will look for the BGGA compiler in the folder $CMTJAVAC/closures/bin/javac 

	For compiling the file called Foo.cmtjava, you need to type:
	$> $CMTJAVAC/cmtjavac Foo.cmtjava

	You can also pass arguments to compiler, an in pure Java.
	$> $CMTJAVAC/cmtjavac -cp pathForClasses:. -d bin Foo.cmtjava


---------------------------------
3.1 EXECUTION
---------------------------------

To run the classes generated, just instantiante the Java virtual machine of the BGGA closures library. Example:
	$> $CMTJAVAC/cmtjava Foo

---------------------------------
4. COMPILE THE SAMPLE FILES
---------------------------------

In this package, there's a script to compile the sample files. 
To compile the sample data structures in CMTJava, just run the script "build.sh"
To test if the sample files are working, execute the "test_samples.sh" script


