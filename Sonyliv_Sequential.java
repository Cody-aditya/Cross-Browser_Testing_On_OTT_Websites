package _OTT_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sonyliv_Sequential {
    public static void main(String[] args) throws InterruptedException {
        browser("edge");
        browser("firefox");
//        browser("chrome");
    }

    public static void browser(String br) throws InterruptedException {
        WebDriver driver = null;

        switch (br.toLowerCase()) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\ak750\\Downloads\\geckodriver-v0.35.0-win64\\geckodriver.exe");
                driver = new FirefoxDriver();
                System.out.println("Running test on Firefox...");
                break;
//            case "chrome":
//                String chromeBinary = "C:\\Users\\ak750\\Downloads\\chrome-win64\\chrome.exe";
//                // Set up ChromeOptions to use the custom binary
//                ChromeOptions options = new ChromeOptions();
//                options.setBinary(chromeBinary);
//                System.setProperty("webdriver.chrome.driver", "C:\\Users\\ak750\\Videos\\chromedriver-win64\\chromedriver.exe");
//                driver = new ChromeDriver(options);
//                System.out.println("Running test on Chrome...");
//                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "C:\\Users\\ak750\\Downloads\\edgedriver_win64\\msedgedriver.exe");
                driver = new EdgeDriver();
                System.out.println("Running test on Edge...");
                break;
            default:
                System.out.println("Invalid browser specified!");
                return;
        }

        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // Navigate to JioCinema
        driver.get("https://www.jiocinema.com/");
        Thread.sleep(3000);

        // Click on the "Movies" tab
        WebElement moviesTab = driver.findElement(By.xpath("//*[@id='navItem-Movies']/span"));
        moviesTab.click();
        Thread.sleep(2000);

        // Scroll to the bottom of the page
        scrollToBottom(driver);

        // Click on the first video title
        WebElement firstVideoTitle = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[46]/div[2]/div/div/div[3]/a/div/article/picture/img"));
        firstVideoTitle.click();
        Thread.sleep(2000);

        // Click on the "More" tab
        WebElement moreTab = driver.findElement(By.xpath("//*[@id='navItem-more']/div/a/span"));
        moreTab.click();
        Thread.sleep(5000);

        // Quit browser
        driver.quit();
        System.out.println("Test completed in " + br + ".");
    }

    // Method to scroll to the bottom of the page
    public static void scrollToBottom(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

        while (true) {
            // Scroll down to the bottom
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // Wait for new content to load
            Thread.sleep(2000);

            // Calculate new scroll height and compare with last height
            long newHeight = (long) js.executeScript("return document.body.scrollHeight");
            if (newHeight == lastHeight) {
                break; // Exit the loop if no new content is loaded
            }
            lastHeight = newHeight;
        }
    }
}
