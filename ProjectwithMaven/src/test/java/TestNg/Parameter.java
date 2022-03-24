package TestNg;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {
	@Test
	@Parameters("myName")
	public void parameterTest(String myName) {
	      System.out.println("Parameterized value is : " + myName);
	      String name=System.getProperty("name");
	      System.out.println(name);
	}
}
