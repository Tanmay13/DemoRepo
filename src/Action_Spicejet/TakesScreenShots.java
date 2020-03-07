package Action_Spicejet;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakesScreenShots {
	
public static WebDriver driver;
	
	public  static  void SSforPASS() throws Exception
	{
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\TANMAY\\Selenium\\ActionClass_Practice\\ScreenShots"));
		System.out.println("Pass screen shot taken");
		
		
		
	}

}
