package Action_Spicejet;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class SpiceJetActions {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\TANMAY\\Downloads\\Assigement1-10\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@id='highlight-addons']"))).build().perform();
		String T1=driver.getTitle();
		System.out.println("The Title of Current Page is:"+T1);
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[contains(text(),'SpiceAssurance')]")).click();
		
		String T2=driver.getTitle();
		System.out.println("The title of Current page is:"+T2);
		//Assert.assertEquals(T1, T2);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert('My Name is Tanmay and im QA Automation Engineer');");
		driver.switchTo().alert().accept();
		
		driver.close();
		

	}

}
