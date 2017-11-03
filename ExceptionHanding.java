package ru.main;


public class ExceptionHanding {

 public static void main(String[] args){
	 ExceptionHanding name = new ExceptionHanding();
	 int a = 0,b = 3, c = 0;
	 int ar[] = {3,4,5,6,7};
	 name.exceptionTest(b, c, ar);
 }

public void exceptionTest(int b, int c, int[] ar) {
	int a;
	try{
		 System.out.println("print");
		 a = b / c;
		 System.out.println("a");
		 System.out.println(ar[10]);
		 
	 }catch(ArrayIndexOutOfBoundsException e){
		 e.printStackTrace();
		 
	 }catch(ArithmeticException e){
		 e.printStackTrace();
		 
	 }catch(Exception e){
		 
		 e.printStackTrace();
		 
		 
	 }finally{
		 if(c != 0){
			 a = b / c;
			 System.out.println(a);
			 
		 }
	 }
}
}

