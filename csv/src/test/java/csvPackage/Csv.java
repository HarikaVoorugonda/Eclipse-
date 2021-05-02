package csvPackage;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Csv {
	public static void main(String[] args) throws CsvValidationException, IOException {
		String Data = "C:\\Users\\chintu\\eclipse-workspace\\csv\\CsvFolderFile\\Adactin.csv"; 

		CSVReader read = new CSVReader(new FileReader(Data)); 

		String [] Cell; 

		WebDriverManager.chromedriver().setup(); 

		WebDriver driver= new ChromeDriver(); 

		driver.manage().window().maximize(); 

		driver.get("https://adactinhotelapp.com/index.php"); 

		WebDriverWait wait = new WebDriverWait(driver, 5); 



		while ((Cell = read.readNext())!=null) { 
			
			
             for(int i=0;i<=1;i++) {
            	 
            	 
				String username =Cell[i]; 

				String pswd = Cell[i+1];
				
				
				System.out.print("i :: "+i+':'+Cell[i]+':'+Cell[i+1]);
				


                driver.findElement(By.id("username")).sendKeys(username); 

				driver.findElement(By.id("password")).sendKeys(pswd); 

				driver.findElement(By.id("login")).click(); 

				wait.until(ExpectedConditions.titleContains("Search Hotel")); 

				driver.close(); 

			}	

		}
	}
}
