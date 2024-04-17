// Test class = Weekly ads
// Goal = Navigate to weekly ads, change to list view, scroll down list
// Author = Josh Wurtenberg

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Weeklyads {

    //Public chrome driver variable for class to access
    public WebDriver chrome_driver;

    //Test 1 - Open browser, navigate to site
    @Test (priority = 1)
    void open_browser() throws InterruptedException{

        chrome_driver = new ChromeDriver();
        chrome_driver.manage().window().maximize();
        chrome_driver.get("https://www.publix.com");
        Thread.sleep(1000);
    }


    //Test 2 - navigate to weekly ads
    @Test (priority = 2)
    void go_to_weekly_flyer() throws InterruptedException{
        chrome_driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div[2]/div/div/div[2]/div/ul/li[5]/a")).click();
        Thread.sleep(2000);

        //check if page is correct
        Assert.assertEquals(chrome_driver.getTitle(), "Weekly Ad | Publix Super Markets", "Incorrect page");
    }

    //Test 3 - set location, change list view
    @Test (priority = 3)
    void scroll_flyer() throws InterruptedException{
        
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/div/div/div[2]/div/div/button")).click();
        Thread.sleep(1000);
        // end location input a string as then return to fetch 
        chrome_driver.findElement(By.name("search")).sendKeys("Estero" + Keys.RETURN);
        Thread.sleep(1000);
        // click select location
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/div/div/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div/div[3]/ul/li[1]/div/div/div[2]/div[1]/div/button")).click();
        Thread.sleep(9000);

        //change to list view
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[3]/div/button[2]")).click();
        Thread.sleep(1000);

        // wait and scroll down to see flyer window
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) chrome_driver;
        js.executeScript("window.scrollBy(0,300)", "");

        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,600)", "");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,900)", "");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,1200)", "");
        Thread.sleep(1000);

    }

    //Test 4 - close and quit driver
    @Test (priority = 4)
    void close_browser() throws InterruptedException {
        Thread.sleep(3000);
        chrome_driver.close();
        chrome_driver.quit();
    }
}
