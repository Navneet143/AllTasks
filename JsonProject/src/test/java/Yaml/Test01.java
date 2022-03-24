package Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

public class Test01 {

	WebDriver driver;

	Map<String, String> data = new HashMap<>();
	
	@BeforeClass
	public void before_Class() {
		System.out.println("In class");
	}

	@BeforeTest
	public void getYaml() throws Throwable{
			File f1 = new File("src/test/java/Yaml/data1.yml");
			//InputStream inputstream = new FileInputStream(f1);
			FileReader fr = new FileReader(f1);
			Yaml yaml = new Yaml();
			data = yaml.load(fr);
	}

	@Test()
	public void printData() {
		System.out.println(data);
	}
}
