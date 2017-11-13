package caesarchiper;
import edu.duke.*;

public class CaesarChiper {
	public String encrypt(String input,int key)
	{
		String s = "";
		String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String caeserAlUpper	 = alphabetUpper.substring(key,26);
		caeserAlUpper += alphabetUpper.substring(0,key);
		String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
		String caesarAlLower = alphabetLower.substring(key,26);
		caesarAlLower += alphabetLower.substring(0,key);
		
		for(int i = 0;i < input.length();i++)
		{
		 if(Character.isAlphabetic(input.charAt(i)))
		 {
			if(Character.isUpperCase(input.charAt(i)))
			{
			    s += caeserAlUpper.charAt(alphabetUpper.indexOf(input.charAt(i)));
			}   
			 else
			 {
				 s += caesarAlLower.charAt(alphabetLower.indexOf(input.charAt(i)));
			 }
		 }
		   else
			 s += input.charAt(i); 
			
		}
		
		return s;
	}
	public void testCaeser()
	{
		int key = 22 ;
		FileResource fr = new FileResource();
		String message = fr.asString();
		String encrypted = encrypt(message, key);
		System.out.println("key is " + key + " \n" + encrypted);
		
	}
	public String encryptTwoKeys(String input, int key1, int key2)
	{
		String s1 = "";
		String s2 = "";
		for(int i = 0; i < input.length(); i++)
		{
			s1 += input.charAt(i);
			if(i != input.length()-1)
				i++;
			s2 += input.charAt(i);
		}
		s1 = encrypt(s1, key1);
		s2 = encrypt(s2, key2);
		String s = "";
		for(int i = 0; i < ( (input.length() + 1) / 2); i++)
		{
			s += s1.charAt(i);
			s += s2.charAt(i);
		}
		return s;
	}
		
	

	public static void main(String args[])
	{
		CaesarChiper c = new CaesarChiper();
		System.out.println(c.encrypt(" FIRST LEGIN ATTACK EAST FLANK ",23));
		c.testCaeser();
		System.out.println(c.encryptTwoKeys("FIRST LEGIN",23,17));
		
	}
}
