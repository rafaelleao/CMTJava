#CMTJava

This distribution contains the following files:

* src/test/	Test programs written in CMTJava
	
* src/stm/	CMTJava's transaction support code

* build.sh	Scripts for compiling transaction management code and the sample data structures
* test_samples.sh	Script to run the sample programs

##1. REQUIRED SOFTWARE 

 1. Sun's Java(TM) JDK (tested with Java 1.7 but should also work with Java 1.6)
 2. make
 3. BGGA closures (for using closures in Java - included under "compiler" folder)

##2. INSTALLATION

First of all, clone the repository or download it as a 
zip file on this [link](https://github.com/rafaelleao/CMTJava/archive/master.zip)


After downloading the files, you can run the installation script (located at the root folder) with this command:

    . ./install.sh

Then you are ready to compile and run CMTJava programs

##3. COMPILE AND RUN THE SAMPLE FILES

In this package, there's a script to compile the sample files. 

To  compile the sample data structures in CMTJava, just run the script "build.sh"

    ./build.sh
    
To test if the sample files are working, execute the "test_samples.sh" script

    ./test_samples.sh
    
##4. HOW IT WORKS

### COMPILATION

To 
compile a file called Foo.cmtjava, you should type:
	
	$> cmtjavac Foo.cmtjava

You can also pass arguments to compiler, as we can do with the standard Java compiler.
	
	$> cmtjavac -cp pathForClasses:. -d bin Foo.cmtjava

The CMTJava source files (.cmtjava) are first translated into Java + closures (.java).
Then, these files are compiled with the BGGA closures compiler. 
It's not possible to compile them with the standard Java compiler.

To generate the code, the CMTJAVA compilation tool will look for the template file (CMTJava.stg) in the folder 

    $CMTJAVAC/CMTJava.stg

After the translation, the .java files are compiled with the BGGA closures compiler. The CMTJava
compilation tool will look for the BGGA compiler in the folder $CMTJAVAC/closures/bin/javac 

### EXECUTION

To run the classes generated, just write the command:
	
	$> cmtjava Foo


