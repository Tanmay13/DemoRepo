package Action_Spicejet;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinks {
	
	
		   public static void main(String[] args) throws InterruptedException 
		   {
			   System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\TANMAY\\Downloads\\Assigement1-10\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.crmpro.com/index.html");
		      Thread.sleep(3000);
		      List<WebElement> links=driver.findElements(By.tagName("a"));
		      System.out.println("Total No Of Links :- "+links.size());
		      for(int i=0;i<links.size();i++)
		      {
		         WebElement el=links.get(i);
		         String url=el.getAttribute("href");
		         verifylink(url);
		      }
		   }
		   
		   public static void verifylink(String linkurl)
		   {
		      try
		      {
		      URL url=new URL(linkurl);
		      HttpURLConnection connection= (HttpURLConnection)url.openConnection();
		      connection.setConnectTimeout(3000);
		      connection.connect();
		      if(connection.getResponseCode()==200)
		      {
		         System.out.println(linkurl+" - "+connection.getResponseMessage());
		      }
		      if(connection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
		      {
		         System.out.println(linkurl+"-"+connection.getResponseMessage());
		      }
		      }
		      catch(Exception e)
		      {
		         e.printStackTrace();
		      }   
		   }
		}


