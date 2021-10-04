package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCart {

	static WebDriver driver = null;
	//static String baseURL = "http://dataportal.uksouth.cloudapp.azure.com:3000/";
	static String browser = "chrome";

	/****SCENARIO 1****/
	public void createDriver() {
		driver = DriverSetup.getWebDriver(browser);
	}


	/*************COMMON STEPS*************/

	@Given("User is on homepage")
	public void clickMenuIcon() {
		//Navigating to homepage
		createDriver();
	}
	@Then("User add the item to cart")
	public void addingToCart(){

		//Clicking on Add to your basket button
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div/button[1]/span[1]")).click();

	}
	@Then("User is redirected to products page and User selects a product")
	public void productSelection(){
		//Selecting the first product
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/div/h6[1]/a")).click();

	}

	@And("Details of products are displayed")
	public void scrollDownToAddButton(){
		//Locating add to cart button using xpath and store in variable "Element"        		
		WebElement Element = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div/button[1]/span[1]"));

		// Scrolling down the page till the element is found	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
		//Selecting quantity
		Select qty = new Select(driver.findElement(By.id("product-quantity")));
		qty.selectByVisibleText("3");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@And("User Goes to my cart")
	public void myCart(){
		driver.findElement(By.id("basket")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}

	/*************SCENARIO 1*************/
	
	//Click on menu icon on homepage
	@When("User clicks on menu icon")
	public void clickmenu() {
		driver.findElement(By.xpath("//*[local-name()='svg' and @id = 'menu']")).click();

		// explicit wait - to wait for the "all products" button to be click-able
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/nav/div[3]/div[2]/span")));
	}
	@And("User clicks on all products link")
	public void clickAllProdutsLink() {
		//Click on all products from menu as soon as it becomes clickable
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/nav/div[3]/div[2]/span")).click();
	}




	/****SCENARIO 2****/
	@When("User enters the products name in search bar")
	public void enterProductName() {
		String productName = "iphone";
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/input")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/input")).sendKeys(productName);
	}
	@And("User clicks on search icon")
	public void search() {
		driver.findElement(By.id("searchicon")).click();
	}




	/****SCENARIO 3****/
	@When("User selects a product from homepage")
	public void scrollDownToProduct(){
		// Scrolling down the page till the element is found
		WebElement Element = driver.findElement(By.xpath("/html/body/div/div/div[4]/div[2]/div/div[1]/div[2]/div/p[1]/a"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", Element);
				
				//Selecting the product from homepage
				Element.click();
	}
	

}

