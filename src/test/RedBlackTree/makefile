JCC = $(CMTJAVAC)/cmtjavac

JFLAGS = -cp ../../../build:. -d ../../../build/

default: TreeNode.class TRedBlackTree.class RedBlackTree.class Test.class

TreeNode.class: TreeNode.cmtjava
	$(JCC) $(JFLAGS) TreeNode.cmtjava

TRedBlackTree.class: TRedBlackTree.cmtjava
	$(JCC) $(JFLAGS) TRedBlackTree.cmtjava

RedBlackTree.class: RedBlackTree.cmtjava
	$(JCC) $(JFLAGS) RedBlackTree.cmtjava

Test.class: Test.cmtjava
	$(JCC) $(JFLAGS) Test.cmtjava

clean: 
	$(RM) *.java
				
