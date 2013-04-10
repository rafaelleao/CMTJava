import org.antlr.runtime.*;
import org.antlr.stringtemplate.*;
import java.io.*;

public class Main {

	public static void main(String[] args){

		if(args.length==0){
			System.out.println("Usage: java -jar cmtjavac.jar <options> <source file>");
			System.exit(0);
		}

		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < args.length-1; i++) {
			buffer.append( args[i] );
			buffer.append(" ");
		}

		String parameters = buffer.toString();
		String filename = args[args.length - 1];
		try{
			compile(filename, parameters);
		}catch(Exception e){
			System.out.println("Exception caught compiling file: " + e);
			e.printStackTrace();
		}
		}

	public static void compile(String filename, String parameters) throws Exception {

		String source = "";
		String s = "";

		int last = filename.lastIndexOf(".cmtjava");
		if(last == -1){//arquivos devem ter extensão cmtjava
			System.out.println("Usage: java -jar cmtjavac.jar <options> <source file>");
			System.exit(0);
		}			
		else source = filename.substring(0, last); 

		last = source.lastIndexOf('/');
		if(last != -1)
			source = source.substring(last + 1 , source.length());	

		System.out.println("Translating " + source + ".cmtjava");

		String environmentVariable = System.getenv("CMTJAVAC");
		String pathForTemplate = environmentVariable + "/CMTJava.stg";

		// load in CMTJava.stg template group, put in templates variable
		FileReader groupFileR=null;
		try{
			groupFileR	= new FileReader(pathForTemplate);
		}catch(Exception e){
			System.out.println("Could not load the template file for translating the source file.\nPlease set the CMTJAVAC environment variable with the path of the template file");
			System.exit(0);
		}
		StringTemplateGroup templates = new StringTemplateGroup(groupFileR);
		groupFileR.close();

		File f = new File(filename); 
		FileInputStream fis = new FileInputStream(f); 
		ANTLRInputStream input = new ANTLRInputStream(fis);

		CMTJavaLexer lexer = new CMTJavaLexer(input);
		TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		CMTJavaParser parser = new CMTJavaParser(tokens);
		parser.setTemplateLib(templates);

		/*CMTJavaParser.compilationUnit_return r = */parser.compilationUnit();// parse rule compilationUnit
		//StringTemplate output = (StringTemplate)r.getTemplate();

		try { 
			BufferedWriter out = new BufferedWriter(new FileWriter(source+".java")); 
			out.write(tokens.toString()); 
			out.close(); 
		} catch (IOException e) { 
			e.printStackTrace();
		} 	

		Process t = null;
		try{
			t = Runtime.getRuntime().exec(environmentVariable + "/closures/bin/javac -g " + parameters + " " + source +".java");
		}catch(Exception e){
			System.out.println("Could not load the BGGA library compiler.\nPlease set the CMTJAVAC environment variable with the path of the closures library files");
			System.exit(0);
		}
		BufferedReader  stdInput = new BufferedReader(new InputStreamReader(t.getInputStream()));
		BufferedReader  stdError = new BufferedReader(new InputStreamReader(t.getErrorStream()));

		// read the output from the command
		System.out.println("Compiling " + source + ".java");
		while ((s = stdInput.readLine()) != null) {
			System.out.println(s);
		}

		// read any errors from the attempted command
		while ((s = stdError.readLine()) != null) {
			System.out.println(s);
		}
	}
}

