package example2;
class TwoGen <T, V> {
	
	T ob1;
	V ob2;
	TwoGen(T o1 ,V o2){
		ob1 = o1;
		ob2 = o2;
	}
	
	void showType()
	{
		System.out.println("this is T type :" + ob1.getClass().getName());
		System.out.println("this is V type :" + ob2.getClass().getName());
	}
	
	T getob1()
	{
		return ob1;
	}
	
	V getob2()
	{
		return ob2;
	}


}

public class SimpGen {

	public static void main(String[] args) {
		
		TwoGen<Integer,String> tgob1 = new TwoGen <Integer,String> (88,"generics");
		tgob1.showType();
		int t = tgob1.getob1();
		String str = tgob1.getob2();
		System.out.println("value :" + t);
		System.out.println("value :" + str);
		
		

	}

}
