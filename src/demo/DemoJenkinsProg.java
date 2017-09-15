package demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class DemoJenkinsProg {

	WebDriver driver;
	@Test
	public void demoTst()
	{
		System.out.println("Welcome to jenkins demo");
		String path=System.getProperty("user.dir");
				
		//System.setProperty("phantomjs.binary.path", path + "//phantomjs//phantomjs.exe");
		System.setProperty("webdriver.chrome.driver", path + "//chrome//chromedriver.exe");
		
		//driver=new PhantomJSDriver();//new  HtmlUnitDriver();//
		driver=new ChromeDriver();//new  HtmlUnitDriver();//
		System.out.println("Driver initialized");
		driver.manage().window().maximize();
		System.out.println("window maximized");
		driver.get("http://youtube.com");
		
		System.out.println(driver.getTitle());
		takeSnap(driver.getTitle(), driver);
		driver.quit();
		System.out.println("Browser closed");
	}
	public void takeSnap(String title,WebDriver driver)
	{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("C:\\Users\\PRITESH\\workspace\\JenkinsDemo\\snaps\\"+title+".png"));
			System.out.println("Snap taken");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}