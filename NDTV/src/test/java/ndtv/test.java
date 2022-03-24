package ndtv;

import org.testng.annotations.Test;

public class test {

	@Test
	public void getvalue() {
		String name=System.getProperty("Name");
		System.out.println(name);
	}
}
