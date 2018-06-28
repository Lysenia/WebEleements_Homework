package fifthelement;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementsHomeWork {
	
	WebDriver driver;
	Faker faker = new Faker();
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
	}
	
	@Test
	public void SeleniumWebElementsForm() {
		driver.navigate().to("https://forms.zohopublic.com/murodil/form/SeleniumWebElements/formperma/eCecYgX4WMcmjxvXVq6UdhA2ABXIoqPAxnAF8H8CCJg");
		
		List<WebElement> inputBoxes = driver.findElements(By.xpath("//input[@type='text']"));
		for(WebElement eachInputBox: inputBoxes) {
			eachInputBox.sendKeys(faker.name().firstName());
		}
		
		List<WebElement> dropDowns = driver.findElements(By.tagName("select"));
		for(WebElement eachDroDown: dropDowns) {
			Select select = new Select(eachDroDown);
			select.selectByIndex(faker.number().numberBetween(1, 4));
			
		}
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(WebElement eachCheckBox: checkBoxes) {
			
			eachCheckBox.click();
		}
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
		
		for(WebElement each: radioButtons) {
			each.click();
		}
		
		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		for(WebElement each: buttons) {
			each.click();
			
		}
		
		assertEquals(inputBoxes.size(),2);
		assertEquals(dropDowns.size(),3);
		assertEquals(checkBoxes.size(),9);
		assertEquals(radioButtons.size(),9,"Message will show if it fails");
		assertEquals(buttons.size(),1,"Message will show if it fails");
	}
		
			
		/*
		 * Homework:
		 * 	Loop through each inputbox and enter random names
		 *  Loop through each dropDown and randomly select by index
		 *  Loop through each checkBoxes and select each one
		 *  Loop through each radioButton and click one by one by waiting one second intervals
		 *  click all buttons
		 */
		
		
    	
}

    	

    	
    	
    

	





