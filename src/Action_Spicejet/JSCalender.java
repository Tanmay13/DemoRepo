package Action_Spicejet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSCalender {
	
	//https://www.spicejet.com/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\TANMAY\\Downloads\\Assigement1-10\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com");
		
		WebElement date=driver.findElement(By.id("ctl00_mainContent_view_date1"));
		String DataJS="2-11-2019";
		CalenderByJS(driver,date,DataJS);
	}
	
	public static void CalenderByJS(WebDriver driver,WebElement element,String DataJS)
	{
		
		JavascriptExecutor js =((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('Value','"+DataJS+"');", element);
		
	}

}
