JCC = $(CMTJAVAC)/cmtjavac

JFLAGS = -cp ../../../build:. -d ../../../build/

default: TAccount.class Account.class Test.class

TAccount.class: TAccount.cmtjava
	$(JCC) $(JFLAGS) TAccount.cmtjava

Account.class: Account.cmtjava
	$(JCC) $(JFLAGS) Account.cmtjava

Test.class: Test.cmtjava
	$(JCC) $(JFLAGS) Test.cmtjava

clean: 
	$(RM) *.java
				
