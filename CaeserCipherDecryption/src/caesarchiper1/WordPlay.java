package caesarchiper1;

public class WordPlay {
	
	public boolean isVowel(char ch)
	{
		if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
			return true;
		if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
			return true;
		return false;
	}
	
	public void tester()
	{
		System.out.println(isVowel('F'));
		System.out.println(isVowel('E'));
		WordPlay obj = new WordPlay();
		String str = obj.replaceVowels("Hello World", '*');
		System.out.println(str);
		str = obj.emphasize("dna ctgaaactga", 'a');
		System.out.println(str);
	}
	
	public String replaceVowels(String phrase, char ch)
	{
		for(int i = 0; i < phrase.length(); i++)
		{
			if(isVowel(phrase.charAt(i)) == true)
				phrase = phrase.substring(0, i) + ch + phrase.substring(i+1, phrase.length());
		}
		return phrase;
	}
	
	public String emphasize(String phrase, char ch)
	{
		for(int i = 0; i < phrase.length(); i++)
		{
			if(phrase.charAt(i) == ch)
			{
				if(i%2 == 0)
					phrase = phrase.substring(0, i) + '*' + phrase.substring(i+1, phrase.length());
				else
					phrase = phrase.substring(0, i) + '+' + phrase.substring(i+1, phrase.length());
			}
			
		}
		return phrase;
	}
	
	public static void main(String[] args)
	{
		WordPlay ob = new WordPlay();
		ob.tester();
	}
	
}
