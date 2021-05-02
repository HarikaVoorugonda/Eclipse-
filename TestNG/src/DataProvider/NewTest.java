package DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class NewTest {
		WebDriver driver;
		@Test(dataProvider="Adactin")
		public void logintoAdatin(String Un, String Pwd) throws Exception
		{
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.navigate().to("http://adactin.com/HotelAppBuild2/index.php");
		 driver.findElement(By.name("username")).sendKeys(Un);
		 Thread.sleep(3000);
		 driver.findElement(By.name("password")).sendKeys(Pwd);
		 driver.findElement(By.name("login")).click();
		 Thread.sleep(3000);
		 Assert.assertTrue(driver.getTitle().contains("Search"),"User not able to login");
		 System.out.println("Login sucessfully"); }
		 @DataProvider(name="Adactin")
		 public Object[][] login() {
		  Object data[][]=new Object[3][2];
		  data[0][0]="rameshadepu";
		  data[0][1]="ramesh";
		  data[1][0]="sandeepj";
		  data[1][1]="sandeep";
		  data[2][0]="saireddy";
		  data[2][1]="saireddy";
		  return data;
		 }
	}