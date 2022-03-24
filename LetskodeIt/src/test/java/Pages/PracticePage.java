package Pages;

import Pages.PropReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

public class PracticePage {

	YamlReaderFile reader = new YamlReaderFile();

	public int checkRadio(WebDriver driver) throws Exception {
		List<WebElement> radioButtons = driver.findElements(By.cssSelector(reader.getData("xpath.allradios")));
		int selected = 0;
		String car = PropReader.getdata("car1");
		String r_xpath = String.format(reader.getData("xpath.radiobutton"), car.toLowerCase());
		driver.findElement(By.xpath(r_xpath)).click();
		for (WebElement radio : radioButtons) {
			if (radio.isSelected())
				selected++;
		}
		return selected;
	}

	public String checkOptions(WebDriver driver) throws Exception {
		WebElement option = driver.findElement(By.xpath(reader.getData("xpath.option")));
		Select s = new Select(option);
		s.selectByVisibleText(PropReader.getdata("car1"));
		return s.getFirstSelectedOption().getText();
	}

	public Boolean checkMultipleSelect(WebDriver driver) throws Exception {
		WebElement d = driver.findElement(By.xpath(reader.getData("xpath.multiselect")));
		Select s = new Select(d);
		String[] fruit = PropReader.getdata("fruits").split(",");
		for (int i = 0; i < fruit.length; i++)
			s.selectByValue(fruit[i]);

		System.out.println(s.getAllSelectedOptions().size() == fruit.length);
		return s.getAllSelectedOptions().size() == fruit.length;
	}

	public Boolean checkCheckbox(WebDriver driver) throws Exception {
		String[] car = PropReader.getdata("cars").split(",");
		List<WebElement> we = driver.findElements(By.xpath(reader.getData("xpath.checkbox")));
		for (WebElement element : we) {
			for (int i = 0; i < car.length; i++) {
				if (element.getAttribute("value").equals(car[i])) {
					element.click();
					break;
				}
			}
		}
		int count = 0;
		for (WebElement element : we) {
			if (element.isSelected())
				count++;
		}
		// System.out.println(count);
		return count == car.length;
	}
	
	public Boolean selectCourse(WebDriver driver) throws Exception {
		String course = PropReader.getdata("course");
		driver.findElement(By.xpath(reader.getData("xpath.inputbox"))).sendKeys(course);
		driver.findElement(By.xpath(reader.getData("xpath.inputbox"))).submit();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(reader.getData("xpath.search"))).click();
		Boolean check = driver.getTitle().contains(course);
		driver.close();
		return  check;
	}

	public Boolean checkWindow(WebDriver driver) throws Throwable {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(reader.getData("xpath.window"))).click();
		List<String> l1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(l1.get(1));
		Boolean check= selectCourse(driver);
		driver.switchTo().window(l1.get(0));
		return check;
	}
	
	public Boolean checkTab(WebDriver driver) throws Throwable {
		driver.findElement(By.xpath(reader.getData("xpath.opentab"))).click();
		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Boolean check= selectCourse(driver);
		driver.switchTo().window(tabs.get(0));
		return check;
	}

	public Boolean AlertFound(WebDriver driver,String name, String xpath) throws Exception {
		WebElement enterName = driver.findElement(By.xpath(reader.getData("xpath.entername")));
		enterName.sendKeys(name);
		driver.findElement(By.xpath(xpath)).click();
		Alert alert = driver.switchTo().alert();
		Boolean check;
		check = alert.getText().contains(name);
		alert.dismiss();
		return check;
	}
	
	public Boolean checkButton(WebDriver driver,String xpath) throws Exception {
		driver.findElement(By.xpath(xpath)).click();
		WebElement textBox = driver.findElement(By.xpath(reader.getData("xpath.exampleinput")));
		if(textBox.isEnabled()) {
			textBox.sendKeys(PropReader.getdata("name"));
			return true;
		}
		else
			return false;
	}
	
	public Boolean checkEnableButton(WebDriver driver) throws Exception {
		Boolean check1, check2;
		check1=checkButton(driver, reader.getData("xpath.disable"));
		check2=checkButton(driver, reader.getData("xpath.enable"));
		return !check1==check2;
	}
	
	public Boolean checkAlert(WebDriver driver) throws Exception {
		Boolean check1, check2;
		check1=AlertFound(driver,PropReader.getdata("name"), "//input[@value=\"Alert\"]" );
		check2=AlertFound(driver,PropReader.getdata("name"),"//input[@value=\"Confirm\"]");
		return check1==check2;
	}

	public Boolean checkHideButton(WebDriver driver,String xpath) throws Exception{
		WebElement web = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript(reader.getData("scroll"), web);
		web.click();
		WebElement textBox = driver.findElement(By.xpath(reader.getData("xpath.textbox")));
		if (textBox.isDisplayed())
			return true;
		else
			return false;
	}
	
	public Boolean checkHide(WebDriver driver) throws Exception {
		Boolean check1, check2;
		check1 = checkHideButton(driver,reader.getData("xpath.hide"));
		check2 = checkHideButton(driver,reader.getData("xpath.show"));
		return !check1==check2;
	}
	
	public Boolean mouseover(WebDriver driver,String xpath) throws Exception {
		WebElement web = driver.findElement(By.xpath(reader.getData("xpath.mousehover")));
		Actions act = new Actions(driver);
		((JavascriptExecutor) driver).executeScript(reader.getData("scroll"), web);
		act.moveToElement(web).build().perform();
		driver.findElement(By.xpath(xpath)).click();
		return driver.findElement(By.xpath(reader.getData("xpath.page"))).isDisplayed();
	}
	
	public Boolean checkmouseover(WebDriver driver) throws Exception {
		Boolean check1, check2;
		check1=mouseover(driver,reader.getData("xpath.top"));
		check2=mouseover(driver,reader.getData("xpath.reload"));
		return check1==check2;

	}
	
	public Boolean checkIframe(WebDriver driver) throws Exception {
		driver.switchTo().frame(reader.getData("frameid"));
		String course = PropReader.getdata("course"); 
		driver.findElement(By.xpath(reader.getData("xpath.inputbox"))).sendKeys(course);
		driver.findElement(By.xpath(reader.getData("xpath.inputbox"))).submit();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(reader.getData("xpath.search"))).click();
		Boolean check = driver.findElement(By.xpath(reader.getData("xpath.header"))).getText().contains(course);
		//System.out.println(check);
		driver.switchTo().parentFrame();
		return check;
	}

}
