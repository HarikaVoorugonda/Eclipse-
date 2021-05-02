package DataProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest1 {
	@Test(dataProvider="Adactin")

	public void login(String un,String pwd) throws Exception { 
 

	WebDriver driver=new ChromeDriver(); 

	driver.manage().window().maximize(); 

	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 

	driver.get("https://adactinhotelapp.com/HotelAppBuild2/index.php"); 

	 

	driver.findElement(By.name("username")).sendKeys(un); 

	Thread.sleep(3000); 

	driver.findElement(By.name("password")).sendKeys(pwd); 

	driver.findElement(By.name("login")).click(); 

	Assert.assertTrue(driver.getTitle().contains("Search"),"User not able to login"); 

	System.out.println("Login sucessfully"); 

	} 

	@DataProvider(name="Adactin") 
	

	public Object[][] login() throws Exception { 

	Class.forName("com.mysql.jdbc.Driver"); 

	System.out.println("JDBC Driver Loded"); 

	 

	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/harika\", \"root\",\"root\""); 

	System.out.println("Connected to Mysql"); 

	Statement stmt = con.createStatement(); 

	ResultSet rs = stmt.executeQuery("select * from customer");
	System.out.print(rs);

	rs.next(); 

	Object data[][]=new Object[3][2]; 

	data[0][0]= rs.getString(1);  

	data[0][1]= rs.getString(2); 

	 return data; 

	}              

}
