package Java8Features;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo3 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demowebshop.tricentis.com/");
		
		driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(), 'Books')]")).click();
		
		List<WebElement> product_list = driver.findElements(By.xpath("//h2[@class='product-title']//a"));
		
		List<String >sorted_list = product_list.stream().map(product -> product.getText()).sorted().collect(Collectors.toList());
		
		Select sort_by = new Select(driver.findElement(By.id("products-orderby")));
		sort_by.selectByVisibleText("Name: A to Z");
		
		List<WebElement> product_list_after_sort = driver.findElements(By.xpath("//h2[@class='product-title']//a"));
		List<String> after_sort = product_list_after_sort.stream().map(product -> product.getText()).collect(Collectors.toList());
		
		if(sorted_list.equals(after_sort)) {
			System.out.println("Product Sorted.");
		} else {
			System.out.println("Product not sorted");
		}
		
		sorted_list.forEach(product -> System.out.println(product));
		after_sort.forEach(product -> System.out.println(product));
		
		driver.quit();

	}

}
