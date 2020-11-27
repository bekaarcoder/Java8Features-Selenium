package Java8Features;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demowebshop.tricentis.com/");
		
//		Actions action = new Actions(driver);
//		
//		action.sendKeys(Keys.CONTROL + "t").perform();
//		Thread.sleep(3000);
//		Set<String> window_handles = driver.getWindowHandles();
//		System.out.println(window_handles);
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.amazon.in/");
		
		Set<String> window_handles = driver.getWindowHandles();
		
		window_handles.forEach(window -> System.out.println(driver.switchTo().window(window).getTitle()));
		
		Thread.sleep(3000);
		
		driver.quit();

	}

}
