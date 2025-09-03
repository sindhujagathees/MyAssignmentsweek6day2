package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateNewAccountSalesForce {
	public ChromeDriver driver;
	String accountName;
	@Given("Launch the chrome browser")
	public void launch_the_chrome_browser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		 driver = new ChromeDriver(options);
		 driver.manage().window().maximize();
	    
	}

	@Given("Load the Salesforce url")
	public void load_the_salesforce_url() {
	driver.get("https://login.salesforce.com");  
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Given("Enter the username as vidyar@testleaf.com")
	public void enter_the_username_as_vidya_r_testleaf_com() {
	driver.findElement(By.id("username")).sendKeys("vidyar@testleaf.com");   
	}

	@Given("Enter the password")
	public void enter_the_password() {
	driver.findElement(By.id("password")).sendKeys("Sales@123");   
	}

	@When("Click Login button")
	public void click_login_button() {
	driver.findElement(By.id("Login")).click();  
	}

	@Then("should be able to login")
	public void should_be_able_to_login() {
	System.out.println("Logged in successfully");    
	}

	@Then("Click on toggle menu button from the left corner")
	public void click_on_toggle_menu_button_from_the_left_corner() {
	driver.findElement(By.xpath("//button[@class='slds-button slds-context-bar__button slds-icon-waffle_container slds-show']")).click();    
	}

	@Then("Click view All and click Sales from App Launcher")
	public void click_view_all_and_click_sales_from_app_launcher() throws InterruptedException {
		Thread.sleep(5000);
	driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();  
	driver.findElement(By.xpath("//p[text()='Sales']")).click();
	}

	@Then("Click on Accounts tab")
	public void click_on_accounts_tab() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement accountsTab = driver.findElement(By.xpath("//a/span[text()='Accounts']"));
	js.executeScript("arguments[0].click();", accountsTab);   
	}

	@Then("Click on New button")
	public void click_on_new_button() {
	driver.findElement(By.xpath("//a[@title='New']/div[text()='New']")).click();  
	}

	@Then("Enter Sindhuja as account name")
	public void enter_Sindhuja_as_account_name() {
		accountName="Sindhuja";
	driver.findElement(By.xpath("(//input[@class='slds-input'])[5]")).sendKeys("Sindhuja");   
	}

	@Then("Select Ownership as Public")
	public void select_ownership_as_public() {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement ownership = driver.findElement(By.xpath("(//div[@class='slds-form-element__control'])[6]"));
		js1.executeScript("arguments[0].scrollIntoView();", ownership);
		Actions action = new Actions(driver);
		action.moveToElement(ownership).perform();
		action.click(ownership).perform();   
	}

	@Then("Click save and verify Account name")
	public void click_save_and_verify_account_name() {
	driver.findElement(By.xpath("(//lightning-base-combobox-item)[2]//span[text()='Public']")).click();  
	driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	}

	@Then("The Account name displayed in the screen should be Sindhuja")
	public void the_account_name_displayed_in_the_screen_should_be_sindhuja() {
		if (accountName.equalsIgnoreCase("Sindhuja")) {
			System.out.println("The account with name Sindhuja has been created");
		} else
			System.out.println("Account name is not Sindhuja");    
	}



}
