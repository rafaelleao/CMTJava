JCC = $(CMTJAVAC)/cmtjavac

JFLAGS = -cp ../../../build:. -d ../../../build/

default: Node.class TLinkedList.class LinkedList.class Test.class

Node.class: Node.cmtjava
	$(JCC) $(JFLAGS) Node.cmtjava

TLinkedList.class: TLinkedList.cmtjava
	$(JCC) $(JFLAGS) TLinkedList.cmtjava

LinkedList.class: LinkedList.cmtjava
	$(JCC) $(JFLAGS) LinkedList.cmtjava

Test.class: Test.cmtjava
	$(JCC) $(JFLAGS) Test.cmtjava

clean: 
	$(RM) *.java
				
