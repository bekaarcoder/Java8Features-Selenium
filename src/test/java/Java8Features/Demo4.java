package Java8Features;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo4 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demowebshop.tricentis.com/");
		
		List<WebElement> product_list = driver.findElements(By.xpath("//h2[@class='product-title']//a"));
		List<WebElement> price_list = driver.findElements(By.xpath("//div[@class='prices']//span"));
		
		HashMap<String, Double> products = new HashMap<String, Double>();
		
		for(int i=0; i<product_list.size(); i++) {
			String title = product_list.get(i).getText();
			Double price = Double.parseDouble(price_list.get(i).getText());
			
			products.put(title, price);
		}
		
		products.forEach((title, price) -> System.out.println(title + " - " + price));
		
		driver.quit();

	}

}
