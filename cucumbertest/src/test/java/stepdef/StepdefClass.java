package stepdef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepdefClass {
	
	WebDriver driver;
	
	@Given("website url")
	public void website_url() {
	   
        System.setProperty("webdriver.chrome.driver","c:\\Chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
	}

	@When("i click on Tshirt")
	public void i_click_on_Tshirt() {
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
	}

	@When("i select medium size and blue color")
	public void i_select_medium_size_and_blue_color() {
		 driver.findElement(By.xpath("//*[@id=\"ul_layered_id_attribute_group_1\"]/li[2]/label/a")).click();
         driver.findElement(By.xpath("//*[@id=\"ul_layered_id_attribute_group_3\"]/li[2]/label/a")).click();
	}

	@Then("i click on ADD to cart.")
	public void i_click_on_ADD_to_cart() throws InterruptedException {
		 driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")).click();
		 Thread.sleep(5000);
         WebElement msg=driver.findElement(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//descendant::h2"));
         
         String text= msg.getText();
         String actual_text="Product successfully added to your shopping cart";
         System.out.println("hello "+text);
         
 Assert.assertEquals(actual_text, text);
	}
	

}
