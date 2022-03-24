package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorType {

	YamlReaderFile reader = new YamlReaderFile();
	WebDriver driver;

	@BeforeMethod
	public void openChrome() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(reader.getData("link"));
	}

	public WebElement locatorCheck(String locator, String locatortype) throws Exception {
		switch (locatortype.toLowerCase()) {
		case "css":
			return driver.findElement(By.cssSelector(locator));
		case "xpath":
			return driver.findElement(By.xpath(locator));
		case "id":
			return driver.findElement(By.id(locator));
		case "class":
			return driver.findElement(By.className(locator));
		case "name":
			return driver.findElement(By.name(locator));
		case "tag":
			return driver.findElement(By.tagName(locator));
		case "linktext":
			return driver.findElement(By.linkText(locator));
		}
		return null;
	}

	@Test
	public void checkMultipleSelectByXpath() throws Exception {
		WebElement d = locatorCheck(reader.getData("locator1.locatorvalue"), reader.getData("locator1.locatortype")); 
		Select s = new Select(d);
		String[] fruit = reader.getData("fruits").split(",");
		for (int i = 0; i < fruit.length; i++)
			s.selectByValue(fruit[i]);

		System.out.println(s.getAllSelectedOptions().size() == fruit.length);
//		s.getAllSelectedOptions().size() == fruit.length;
	}
	
	@Test
	public void checkMultipleSelectByName() throws Exception {
		WebElement d = locatorCheck(reader.getData("locator2.locatorvalue"), reader.getData("locator2.locatortype")); 
		Select s = new Select(d);
		String[] fruit = reader.getData("fruits").split(",");
		for (int i = 0; i < fruit.length; i++)
			s.selectByValue(fruit[i]);

		System.out.println(s.getAllSelectedOptions().size() == fruit.length);
//		s.getAllSelectedOptions().size() == fruit.length;
	}
	
	@Test
	public void checkMultipleSelectById() throws Exception {
		WebElement d = locatorCheck(reader.getData("locator3.locatorvalue"), reader.getData("locator3.locatortype")); 
		Select s = new Select(d);
		String[] fruit = reader.getData("fruits").split(",");
		for (int i = 0; i < fruit.length; i++)
			s.selectByValue(fruit[i]);

		System.out.println(s.getAllSelectedOptions().size() == fruit.length);
//		s.getAllSelectedOptions().size() == fruit.length;
	}
	
	@Test
	public void checkMultipleSelectByCss() throws Exception {
		WebElement d = locatorCheck(reader.getData("locator4.locatorvalue"), reader.getData("locator4.locatortype")); 
		Select s = new Select(d);
		String[] fruit = reader.getData("fruits").split(",");
		for (int i = 0; i < fruit.length; i++)
			s.selectByValue(fruit[i]);

		System.out.println(s.getAllSelectedOptions().size() == fruit.length);
//		s.getAllSelectedOptions().size() == fruit.length;
	}
	@AfterMethod
	public void closeBrowser() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}
}

