package file;

import java.io.*;
import java.util.*;
public class File {
	public static void main(String[] args) throws Exception
	{
		FileReader file = new FileReader("file.txt");
		BufferedReader buf = new BufferedReader(file);
		int c;
		while((c = buf.read()) != -1)
		{
			System.out.print((char)c);
		}
		System.out.print("\n");
		file.close();
	
		FileWriter fw = new FileWriter("file1.txt");
		String s ;
	    Scanner in = new Scanner(System.in);
	    s = in.nextLine();
	    for(int i = 0; i<s.length(); i++)
	    {
	    	fw.write((int)s.charAt(i));
	    }
	    fw.close();
	
	
	}
	
	
	
	
}
