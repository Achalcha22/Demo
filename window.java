import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class getwindowhandle {
 @SuppressWarnings("deprecation")
public static void main(String[] args) throws Exception
 {
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
	 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	 driver.get("https://demoqa.com/browser-windows");
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,250)");
	 Thread.sleep(3000);
driver.findElement(By.id("windowButton")).click();
String main=driver.getWindowHandle();
System.out.println(main);
Set <String> child= driver.getWindowHandles();
for(String chil:child)
{
  String link=chil;
  if(!main.equalsIgnoreCase(link)) 
  {
	  driver.switchTo().window(link);
	  String test=driver.findElement(By.tagName("h1")).getText();
	  System.out.println(test);
	  Thread.sleep(3000);
	  driver.close();
  }
}
  driver.switchTo().window(main);
  System.out.println(driver.getTitle());
  Thread.sleep(2000);
  driver.close();
}
 }
