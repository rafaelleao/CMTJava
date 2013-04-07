JCC = java -jar ../../../cmtjavac.jar

JFLAGS = -cp ../../../build:. -d ../../../build/

default: Fork.class Philosopher.class Test.class

Fork.class: Fork.cmtjava
	$(JCC) $(JFLAGS) Fork.cmtjava

Philosopher.class: Philosopher.cmtjava
	$(JCC) $(JFLAGS) Philosopher.cmtjava

Test.class: Test.cmtjava
	$(JCC) $(JFLAGS) Test.cmtjava

clean: 
	$(RM) *.class
	$(RM) *.java
				
