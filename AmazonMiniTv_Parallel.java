package _OTT_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonMiniTv_Parallel {

	public static void main(String[] args) {

        Thread firefoxThread = new Thread(() -> {
            try {
                runTestInBrowser("firefox");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread chromeThread = new Thread(() -> {
            try {
                runTestInBrowser("chrome");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread edgeThread = new Thread(() -> {
            try {
                runTestInBrowser("edge");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        firefoxThread.start();
        chromeThread.start();
        edgeThread.start();


        try {
            firefoxThread.join();
            chromeThread.join();
            edgeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tests completed.");
    }


    public static void runTestInBrowser(String browser) throws InterruptedException {
        WebDriver driver = null;


        switch (browser.toLowerCase()) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\ak750\\Downloads\\geckodriver-v0.35.0-win64\\geckodriver.exe");
                driver = new FirefoxDriver();
                System.out.println("Running test in Firefox...");
                break;
            case "chrome":
            	String chromeBinary = "C:\\Users\\ak750\\Downloads\\chrome-win64\\chrome.exe";
                ChromeOptions options = new ChromeOptions();
                options.setBinary(chromeBinary);
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\ak750\\Videos\\chromedriver-win64\\chromedriver.exe");
                driver = new ChromeDriver(options);
                System.out.println("Running test on Chrome...");
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "C:\\Users\\ak750\\Downloads\\edgedriver_win64_1\\msedgedriver.exe");
                driver = new EdgeDriver();
                System.out.println("Running test in Edge...");
                break;
            default:
                System.out.println("Invalid browser specified!");
                return;
        }


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
        
        Thread.sleep(4000);
        
        WebElement Watchbtn = driver.findElement(By.cssSelector("button.Button_button__PjVhE.Button_primary___XGO6"));
        Watchbtn.click();

        Thread.sleep(2000);
        
        driver.navigate().back();
        Thread.sleep(2000); 
        
        driver.navigate().back();
        Thread.sleep(2000); 

        driver.quit();
        System.out.println("Test completed in " + browser + ".");
    }
}
