package Cucumber;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CucumberMaven {

	public static WebDriver driver;

	@Given("^User present in Adactin Login page$")
	public void adactinLoginPage() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
	}

	@When("^User Enter Username$")
	public void username() {
		driver.findElement(By.id("username")).sendKeys("rameshadepu");

	}

	@When("^User Enter Password$")
	public void password() {
		driver.findElement(By.id("password")).sendKeys("ramesh");
	}

	@When("^User Click on Login Button$")
	public void login() {
		driver.findElement(By.id("login")).click();
	}

	@Then("^Get Title of the Page$")
	public void TitleOfPage() {
		String ExpectedTitle  = "Adactin.com - Search Hotel";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}


	@Then("^Select Location$")
	public void select_location() {
		Select Location = new Select(driver.findElement(By.id("location")));
		Location.selectByValue("Paris");
	
	}
	@Then("^Select Hotel$")
	public void select_hotel() {
		Select Hotel = new Select(driver.findElement(By.id("hotels")));
		Hotel.selectByValue("Hotel Sunshine");
	}
	@Then("^Select Room Type$")
	public void select_room_type() {
		Select Room = new Select(driver.findElement(By.id("room_type")));
		Room.selectByValue("Super Deluxe");
	}

	@Then("^No Of Rooms$")
	public void no_of_rooms() {
		Select Number = new Select(driver.findElement(By.id("room_nos")));
		Number.selectByValue("1");
		}

	@Then("^Check-In$")
	public void check_in() {
		driver.findElement(By.id("datepick_in")).sendKeys("19/04/2021");
		
	}

	@Then("^Check-out$")
	public void check_out() {
		driver.findElement(By.id("datepick_out")).sendKeys("20/04/2021");
	}

	@Then("^Adults Per Room$")
	public void adults_per_room() {
		Select Adult = new Select(driver.findElement(By.id("adult_room")));
	    Adult.selectByValue("2");
	}

	@Then("^User clickon Search Button$")
	public void user_clickon_search_button() {
		driver.findElement(By.id("Submit")).submit();
		
	}

	@Then("^Hotel Availabilty$")
	public void hotel_availabilty() {
		
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		
	}

    @Then("^Close$")
	public void close() {
		driver.close();
	}
}
