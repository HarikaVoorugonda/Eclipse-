package DBtestingpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DbtestingScript {
	public static WebElement username,password, login;
	public static WebDriver driver;
	public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("JDBC Driver is loaded");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/harika", "root","root");
	System.out.println("Connected to Mysql");
	Statement stmt= con.createStatement();
	ResultSet rs=stmt.executeQuery(" Select * from customer");
	rs.next();
	System.setProperty("WebDriver.chrome.driver","F:\\Selenium\\drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	for(int i=0;i<3;i++)
	{
	String un=rs.getString(1);
	String pwd=rs.getString(2);
	rs.next();
	System.out.println(un+" "+pwd);
	driver.get("https://adactinhotelapp.com/HotelAppBuild2/index.php");
	username=driver.findElement(By.name("username"));
	password=driver.findElement(By.name("password"));
	login=driver.findElement(By.name("login"));
	username.sendKeys(un);
	password.sendKeys(pwd);
	login.click();
	boolean x=driver.getTitle().contains("Search");
	if(x) {
	System.out.println("Login is sucessful");
	}else {
		System.out.println("login is failed");
	}
	}
	}

}
