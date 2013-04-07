JCC = java -jar ../../../cmtjavac.jar

# define a makefile variable for compilation flags
# the -g flag compiles with debugging information
#
JFLAGS = -cp ../../../build:. -d ../../../build/

# typing 'make' will invoke the first target entry in the makefile 
# (the default one in this case)
#
default: Node.class TLinkedList.class LinkedList.class Test.class

# this target entry builds the Average class
# the Average.class file is dependent on the Average.java file
# and the rule associated with this entry gives the command to create it
#
Node.class: Node.cmtjava
	$(JCC) $(JFLAGS) Node.cmtjava

TLinkedList.class: TLinkedList.cmtjava
	$(JCC) $(JFLAGS) TLinkedList.cmtjava

LinkedList.class: LinkedList.cmtjava
	$(JCC) $(JFLAGS) LinkedList.cmtjava

Test.class: Test.cmtjava
	$(JCC) $(JFLAGS) Test.cmtjava

# To start over from scratch, type 'make clean'.  
# Removes all .class files, so that the next make rebuilds them
#
clean: 
	$(RM) *.class
	$(RM) *.java
				
