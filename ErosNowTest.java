package _OTT_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ErosNowTest {

    private WebDriver driver;


    public WebDriver launchBrowser(String B) throws InterruptedException {
        switch (B) {  
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\ak750\\Downloads\\geckodriver-v0.35.0-win64\\geckodriver.exe");
                driver = new FirefoxDriver();
                System.out.println("Running test in Firefox...");
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\ak750\\Videos\\chromedriver-win64\\chromedriver.exe");
                driver = new ChromeDriver();
                System.out.println("Running test in Chrome...");
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "C:\\Users\\ak750\\Downloads\\edgedriver_win64\\msedgedriver.exe");
                driver = new EdgeDriver();
                System.out.println("Running test in Edge...");
                break;
            default:
                System.out.println("Invalid browser specified!");
                return null;
        }
        return driver; 
    }


    public void getBrowser(WebDriver driver) throws InterruptedException {
        if (driver != null) {
            driver.get("https://www.hotstar.com");
            driver.manage().window().maximize();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/div[2]/aside/nav/div[2]/a/button/span[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("input[placeholder='Movies, shows and more']")).sendKeys("Stree");
            Thread.sleep(1000);
//            driver.findElement(By.className(" ON_INVERSE BUTTON2_SEMIBOLD")).click();
//            Thread.sleep(1000);
        } else {
            System.out.println("Driver not initialized!");
        }
    }


    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.");
        } else {
            System.out.println("Driver is null, nothing to close.");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ErosNowTest autoTest = new ErosNowTest();

        WebDriver driver = autoTest.launchBrowser("firefox");
        autoTest.getBrowser(driver);
        autoTest.closeBrowser();

//        driver = autoTest.launchBrowser("chrome");
//        autoTest.getBrowser(driver);
//        autoTest.closeBrowser();

        driver = autoTest.launchBrowser("edge");
        autoTest.getBrowser(driver);
        autoTest.closeBrowser();
    }
}
