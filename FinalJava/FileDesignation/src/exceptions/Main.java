package exceptions;

import java.io.File;
import java.io.StringReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InvalidDocumentCodeException{
		// TODO Auto-generated method stub
		
		InvalidDocumentCodeException problem = new InvalidDocumentCodeException("Improper designation for a document.");
		File f = null;
	    File f1 = null;
	    File f3 = null;
	    File f4 = null;
	    File f2 = null;
	    String v, v1, v2, v3, v4;
	    
		f = new File("AA.txt");
        f1 = new File("BB.txt");
        f2 = new File("CA.txt");
        f3 = new File("DB.txt");
        f4 = new File("UA.txt");
        
        v = f.getName();
        v1 = f1.getName();
        v2 = f2.getName();
        v3 = f3.getName();
        v4 = f4.getName();
        
        StringReader reader = new StringReader(v);
        char aChar = v.charAt(0);
        char aChar1 = v1.charAt(0);
        char aChar2 = v2.charAt(0);
        char aChar3 = v3.charAt(0);
        char aChar4 = v4.charAt(0);
        
        //1
        
        try {
        	if(aChar != 'U' && aChar != 'C' && aChar != 'P') {
        	
        		throw problem;
        	}
        else {
        	System.out.println("Processing file called: " + v.charAt(0) + v.charAt(1) + ".txt");
        }

        	
        }
      
        catch (Exception InvalidDocumentCodeException) {
        	
        	}
        
        //2
        try {
        	if(aChar1 != 'U' && aChar1 != 'C' && aChar1 != 'P') {
        	
        		throw problem;
        	}
        else {
        	System.out.println("Processing file called: " + v1.charAt(0) + v1.charAt(1) + ".txt");
        }

        	
        }
      
        catch (Exception InvalidDocumentCodeException) {
        	
        	}
        
        
        //3
        try {
        	if(aChar2 != 'U' && aChar2 != 'C' && aChar2 != 'P') {
        	
        		throw problem;
        	}
        else {
        	System.out.println("Processing file called: " + v2.charAt(0) + v2.charAt(1) + ".txt");
        }

        	
        }
      
        catch (Exception InvalidDocumentCodeException) {
        	
        	}
        
        
        
        //4
        try {
        	if(aChar3 != 'U' && aChar3 != 'C' && aChar3 != 'P') {
        	
        		throw problem;
        	}
        else {
        	System.out.println("Processing file called: " + v3.charAt(0) + v3.charAt(1) + ".txt");
        }

        	
        }
      
        catch (Exception InvalidDocumentCodeException) {
        	
        	}
        
        
        //5
        try {
        	if(aChar4 != 'U' && aChar4 != 'C' && aChar4 != 'P') {
        	
        		throw problem;
        	}
        else {
        	System.out.println("Processing file called: " + v4.charAt(0) + v4.charAt(1) + ".txt");
        }

        	
        }
      
        catch (Exception InvalidDocumentCodeException) {
        	
        	}
        
        
  
	}

}
