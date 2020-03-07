package Action_Spicejet;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DropDownSorting {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\TANMAY\\Downloads\\Assigement1-10\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.ebay.com/");
		  Thread.sleep(3000);  
	      WebElement element = driver.findElement(By.id("gh-cat"));
	      element.click();
	      List<WebElement> dropDownvalues = element.findElements(By.tagName("option"));
	      ArrayList<String> listValues = new ArrayList<String>();
	      for(WebElement value : dropDownvalues) {
	         System.out.println("values are"+ value.getText());
	         listValues.add(value.getText());
	      }
	      boolean sortedOrNot = sortedOrNot(listValues);
	      Assert.assertEquals(false, sortedOrNot);
	      driver.close();
	   }
	   public static boolean sortedOrNot(ArrayList<String> dropDownValues) {
	      System.out.println("number of values "+ dropDownValues.size());
	      for(int i=0; i<dropDownValues.size();i++) {
	         int temp = dropDownValues.get(i).compareTo(dropDownValues.get(i+1));
	         if(temp>1) {
	            System.out.println("i value"+i);
	            return false;
	         }
	      }
	      return true; 

		
	}

}
