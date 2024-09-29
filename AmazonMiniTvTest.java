package _Gradle_Sample_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class AmazonMiniTvTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ak750\\Videos\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000); 
        

        driver.get("https://www.amazon.in/minitv");
        Thread.sleep(3000); 
        
        WebElement WebSeriesTab = driver.findElement(By.linkText("Web Series"));
        WebSeriesTab.click();
        Thread.sleep(2000); 
        
        WebElement HomeTab = driver.findElement(By.linkText("Home"));
        HomeTab.click();
        Thread.sleep(2000); 
        
        WebElement MoviesTab = driver.findElement(By.linkText("Movies"));
        MoviesTab.click();
        Thread.sleep(2000); 
        
        WebElement ImportedTab = driver.findElement(By.linkText("Imported"));
        ImportedTab.click();
        Thread.sleep(2000); 
        
        WebElement RomanceTab = driver.findElement(By.linkText("Romance"));
        RomanceTab.click();
        Thread.sleep(2000); 
        
        WebElement ComedyTab = driver.findElement(By.linkText("Comedy"));
        ComedyTab.click();
        Thread.sleep(2000); 
        
        WebElement TamilTab = driver.findElement(By.linkText("Tamil"));
        TamilTab.click();
        Thread.sleep(2000); 
        
        WebElement TeluguTab = driver.findElement(By.linkText("Telugu"));
        TeluguTab.click();
        Thread.sleep(2000); 
        
        WebElement searchbtn = driver.findElement(By.xpath("//*[@id=\"desktop_search_icon\"]/a/img"));
        searchbtn.click();
        WebElement searchInput = driver.findElement(By.cssSelector("input[placeholder='Shows, genres, movies and more']"));
       
        Thread.sleep(4000);
        searchInput.sendKeys("Hustlers");
        searchInput.sendKeys(Keys.ENTER);
        
        Thread.sleep(2000);
        
        WebElement firstVideoTitle = driver.findElement(By.xpath("//*[@id=\"infiniteScrollV3\"]/div/div/div[1]/a/div/img"));
        firstVideoTitle.click();
        
        driver.quit();
	}

}
