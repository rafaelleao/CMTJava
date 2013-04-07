JCC = java -jar ../../../cmtjavac.jar

JFLAGS = -cp ../../../build:. -d ../../../build/

default:Node.class TLinkedBlockingQueue.class LinkedBlockingQueue.class Main.class

Node.class: Node.cmtjava
	$(JCC) $(JFLAGS) Node.cmtjava

TLinkedBlockingQueue.class: TLinkedBlockingQueue.cmtjava
	$(JCC) $(JFLAGS) TLinkedBlockingQueue.cmtjava

LinkedBlockingQueue.class: LinkedBlockingQueue.cmtjava
	$(JCC) $(JFLAGS) LinkedBlockingQueue.cmtjava

Main.class: Main.cmtjava
	$(JCC) $(JFLAGS) Main.cmtjava

clean: 
	$(RM) *.class
	$(RM) *.java
				
