package niktzatz.util.safe;

/**
 * @author Nikolaos D. Tzatzalas
 */
public class MyMain
{

	public static void main(String [] args)
	{
		A a = new A();
		B b = new B();
		C c = new C();
		c.setGreeting("hello there!");
		b.setC(c);
		a.setB(b);
		
		System.out.println(Safe.String(a, "getB().getC().getGreeting()"));
		System.out.println(Safe.String(a, "getB().getD().getGreeting()"));
	}

}
