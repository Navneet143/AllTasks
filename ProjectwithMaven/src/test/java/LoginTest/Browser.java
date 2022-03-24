package LoginTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.yaml.snakeyaml.Yaml;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	public static String get_temp(String str1) {
		Pattern p = Pattern.compile("\\b[0-9]+\\b");
		Matcher m = p.matcher(str1);
		// System.out.println(m.find()+" "+m.group(0));
		if (m.find())
			return m.group(0);
		return "Not Found";
	}

	public static void main(String[] args) throws FileNotFoundException {
		InputStream inputStream = new FileInputStream("src/test/java/Yaml/data.yml");
		Yaml yaml = new Yaml();
		Map<String, Map<String, String>> data = yaml.load(inputStream);
		System.out.println(data);
		Map<String, String> xpath= new HashMap<String, String>();
		xpath=data.get("xpath");
		System.out.println(xpath.keySet());
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ndtv.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
		WebElement more_option = driver.findElement(By.xpath("//a[@id=\"h_sub_menu\"]"));
		System.out.println(more_option);
		more_option.click();
		driver.findElement(By.xpath("//a[text()=\"WEATHER\"]")).click();
		List<WebElement> inputs = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
		System.out.println(inputs);
    for(WebElement x:inputs) {
    	String city=x.getAttribute("id");
    	if(x.isSelected())
    	{
    		System.out.print("The Tempareture of "+city+"is:- ");
    		
    		List<WebElement> Temp=driver.findElements(By.xpath(String.format("//div[@title=\"%s\"]//span[@class]",city)));//Xpath-//div[@title="Mumbai"]//span[@class]
    		for(WebElement temperature:Temp) {
    			System.out.print(get_temp(temperature.getText())+"\u00B0"+" ");
    			//System.out.println(temperature.toString());
    		}
    		System.out.println();
    	}
    }
		driver.close();
	}

}