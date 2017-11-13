package genericsexample;

class Gen<T> {
   T ob;
   
   Gen(T o) {
    ob = o;
   }

    T getob() {
      return ob;
    }
    void showType()
    {
    	System.out.println("this is type " + ob.getClass().getName());
    }

}
public class GenDemo {

	public static void main (String args[])
	{
		Gen<Integer>iob;
		iob = new Gen<Integer>(88);
		iob.showType();
		int v = iob.getob();
		System.out.println("value :" + v);
		System.out.println();
		Gen<String>striob;
		striob = new Gen<String>("Generics String");
		striob.showType();
		String str = striob.getob();
		System.out.println("value :" + str);
		System.out.println();
	}
}
