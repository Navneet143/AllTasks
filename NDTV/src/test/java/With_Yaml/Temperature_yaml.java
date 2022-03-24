package With_Yaml;

import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Temperature_yaml {
	WebDriver driver;
	Data data1 = new Data();
	Properties p1 = new Properties();
	Map<String, String> xpath;

	@BeforeSuite
	public void read_value() throws Throwable {
		FileReader reader = new FileReader("src/test/java/Data/data02.properties");
		p1.load(reader);
		System.out.println(p1.getProperty("browser"));
	}
	
	@BeforeTest
	public void read_data() throws Throwable {
		File file = new File(p1.getProperty("file"));
		ObjectMapper om = new ObjectMapper(new YAMLFactory());
		data1 = om.readValue(file, Data.class);
		System.out.println("Details:\n"+data1.getXpath().keySet());
		

	}

	@BeforeClass
	public void OpenBrowser() {
		if(p1.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().browserVersion(p1.getProperty("version")).setup();
			driver = new ChromeDriver();
		}
		if(p1.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().browserVersion(p1.getProperty("version")).setup();
			driver = new EdgeDriver();
		}
		if(p1.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().browserVersion(p1.getProperty("version")).setup();
			driver = new FirefoxDriver();
		}
		driver.get(p1.getProperty("site"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void CheckTemperature() {
		xpath=data1.getXpath();
		Temperature temp1 = new Temperature(driver, xpath);
		WebElement more_option= driver.findElement(By.xpath(xpath.get("main_menu")));
		more_option.click();
		driver.findElement(By.xpath(xpath.get("weather"))).click();
		temp1.set_SelectedCites();
		temp1.print_selectedcities();
		temp1.unSelectALL();
		for (String city : data1.getcity()) {
			if (temp1.all_cities.contains(city)) {
				if (!temp1.selected_cities.contains(city))
					driver.findElement(By.xpath(String.format(xpath.get("checkbox"), city))).click();	
				temp1.PrintTemp(city);
			}
			else
				System.out.println(city+" is not listed here!");	
		}
	}

	@AfterSuite
	public void CloseBroswer() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
