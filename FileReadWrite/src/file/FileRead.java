package file;
import java.io.*;
public class FileRead {

	public static void main(String[] args) {

	int i;
	FileInputStream fin;
	if(args.length != 1)
	{
		System.out.println("Usage:file Read filename");
	}
		
	try{
		fin = new FileInputStream(args[0]);
	} catch(FileNotFoundException e)
	{
		System.out.println("cannot open file");
		return ;
	}
	
	try{
		do{
			i = fin.read();
			if(i != -1)
				System.out.println((char) i);
			
	    } while(i != -1);
	} catch(IOException e){
		System.out.println("Error reading file");
				
	}
	
	try{
		fin.close();
	}catch(IOException e){
		System.out.println("file close");
	}
	
	
	}

}
