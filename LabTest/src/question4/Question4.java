package question4;
import java.util.Scanner;


public class Question4 {
	public static void main(String[] args)
	{
		Question4 value = new Question4();
		value.calculate();
	}
	
	public void calculate()
	{
		
		Numeric num = new Numeric();
		String a = null,b = null,c = null;
		Scanner in = new Scanner(System.in);
		int f = 1;
		boolean flag = false;
		double result = 0,x,y,z;
		try
		{
			a = in.next();
			x = Double.valueOf(a);
			if(num.isNumeric(a))
			{
				b = in.next();
				if(b.equals("!"))
				{
					int fact = Integer.valueOf(a);
					System.out.println(factorial(fact));
				}
				else if(b.equals("+"))
				{
					y = in.nextDouble();
					result = x + y;
					
				}
				else if(b.equals("-"))
				{
					y = in.nextDouble();
					result = x - y;
					
				}
				else if(b.equals("*"))
				{
					y = in.nextDouble();
					result = x * y;
					
				}
				else if(b.equals("/"))
				{
					y = in.nextDouble();
					result = x / y;
					
				}
				else if(b.equals("%"))
				{
					y = in.nextDouble();
					result = x % y;
				}
				else if(b.equals("^"))
				{
					y = in.nextDouble();
					result = Math.pow(x,y);
				}
				else if(b.equals("sqrt"))
				{
					y = in.nextDouble();
					result =Math.sqrt(x);
				}
				System.out.println( result);
			}
			
		}catch(Exception e)

		{
			System.out.println("result is invalid");
		}
		
	
	}
	public int factorial(int n)
	{
		if(n == 1)
			return 1;
		else
			return n*factorial(n-1);
	}

}

  class Numeric
  {
    public static boolean isNumeric( String s )
  {
      return ( isDouble(s) || isInteger(s) );
  }
    
  public static boolean isDouble( String s )
  {
      double n = 0;
  try
 {
	  
    n = Double.valueOf( s );
 }
  catch ( NumberFormatException e )
 {
	  
    return false;
 }
  
   return true;
 }
  
  public static boolean isInteger( String s )
 {
   int n = 0;
   try
  {  
    n = Integer.valueOf( s );
  }
  catch ( NumberFormatException e )
 {
     return false;
 }
    return true;
  }
 } 