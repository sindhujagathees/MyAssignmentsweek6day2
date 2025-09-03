package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	public ChromeDriver driver;
	@Given("Launch the browser")
	public void launch_the_browser() {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("guest");
		driver = new ChromeDriver(option);
	    
	}

	@And("Load the url")
	public void load_the_url() {
		driver.get("https://login.salesforce.com");  
	}

	@And("Enter username as vidyar@testleaf.com")
	public void enter_username_as_vidyar_testleaf_com() {
		driver.findElement(By.id("username")).sendKeys("vidyar@testleaf.com");    
	}

	@And("Enter the password as Sales@{int}")
	public void enter_the_password_as_sales(Integer int1) {
		driver.findElement(By.id("password")).sendKeys("Sales@123"); 
	}

	@When("Click on the Login button")
	public void click_on_the_login_button() {
		driver.findElement(By.id("Login")).click();   
	}

	@Then("It should be able to login")
	public void it_should_be_able_to_login() {
		System.out.println("Logged in  successfully");   
	}


}
