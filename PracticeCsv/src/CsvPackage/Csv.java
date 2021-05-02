package CsvPackage;

import CsvDataBase.CSVReader;
import CsvDataBase.ChromeDriver;
import CsvDataBase.CsvReader;
import CsvDataBase.FileReader;
import CsvDataBase.String;
import CsvDataBase.WebDriver;
import CsvDataBase.WebDriverWait;

public class Csv {
	String Data = "C:/Users/chintu/Desktop/DBtesting.csv"; 

	CsvReader read = new CSVReader(new FileReader(Data)); 

	String [] Cell; 

	WebDriverManager.chromedriver().setup(); 

	WebDriver driver= new ChromeDriver(); 

	driver.manage().window().maximize(); 

	driver.get("https://adactinhotelapp.com/index.php"); 

	WebDriverWait wait = new WebDriverWait(driver, 5); 

	 

	while ((Cell = read.readNext())!=null) { 

	 

	for(int i=0;i<1;i++) { 

	String username =Cell[i]; 

	String pswd = Cell[i+1]; 

	 

	 

	driver.findElement(By.id("username")).sendKeys(username); 

	driver.findElement(By.id("password")).sendKeys(pswd); 

	driver.findElement(By.id("login")).click(); 

	wait.until(ExpectedConditions.titleContains("SearchHotel")); 

	driver.close(); 

}
