GRAMMAR  = CMTJava.g #Antlr grammar file
BIN = bin#Output folder
OP = -Xconversiontimeout 30000#To avoid compiler errors

all: genfiles

genfiles: grammar compile create_jar

grammar: 
	java org.antlr.Tool $(OP) -o bin $(GRAMMAR) 

compile:
	javac bin/*.java && javac Main.java -cp bin:. -d bin

create_jar:
	jar -cmf MANIFEST.MF cmtjavac.jar antlr/ org/ -C bin .

clean: 
	rm bin/*.class


