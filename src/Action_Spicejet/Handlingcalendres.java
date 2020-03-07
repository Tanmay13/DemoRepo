package Action_Spicejet;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Handlingcalendres {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\TANMAY\\Downloads\\Assigement1-10\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.crmpro.com/index.html");

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("TanmayCRM");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("8600421149");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		// Switch in to frame
		driver.switchTo().frame("mainpanel");

		String date = "16-May-2019";

		String DateArray[] = date.split("-");// {18/November/2019}
		String Day = DateArray[0];
		String Month = DateArray[1];
		String Year = DateArray[2];

		Select sl = new Select(driver.findElement(By.xpath("//select[@name='slctMonth']")));
		sl.selectByVisibleText(Month);

		Select sl2 = new Select(driver.findElement(By.xpath("//select[@name='slctYear']")));
		sl2.selectByVisibleText(Year);

		//// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[3]

		//// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[5]/td[1]
		//// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[5]/td[1]

		String BeforeXpath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String AfterXapth = "]/td[";
		final int Totleweekdays = 7;
		boolean flag = false;
		for (int rn = 2; rn <= 7; rn++) {

			for (int cn = 1; cn <= 7; cn++) {

				String Days = driver.findElement(By.xpath(BeforeXpath + rn + AfterXapth + cn + "]")).getText();
				System.out.println(Days);
				if (Days.equals(Day)) {
					driver.findElement(By.xpath(BeforeXpath + rn + AfterXapth + cn + "]")).click();
					flag = true;
					break;

				}

			}
			if (flag) {
				break;

			}

		}

		Thread.sleep(5000);

		// driver.close();

	}
}
