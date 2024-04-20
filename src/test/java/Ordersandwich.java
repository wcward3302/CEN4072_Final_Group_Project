// Test class = order sandwich
// Goal = find and customize sandwich, add to cart
// Author = William Ward

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ordersandwich {

    //Public chrome driver variable for class to access
    public WebDriver chrome_driver;

    //Test 1 - Open browser, navigate to site, set location to prevent random pop up
    @Test (priority = 1)
    void open_browser() throws InterruptedException{
        
        // Open new chrome driver, maximize, and navigate to site
        chrome_driver = new ChromeDriver();
        chrome_driver.manage().window().maximize();
        chrome_driver.get("https://publix.com/");

        // Will run into issues if location is not selected at this point
        chrome_driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div[2]/div/div/div[2]/div/div/button")).click();
        Thread.sleep(1000);
        // end location input a string as then return to fetch 
        chrome_driver.findElement(By.name("search")).sendKeys("Estero" + Keys.RETURN);
        Thread.sleep(1000);
        chrome_driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div[2]/div/div/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div/div[3]/ul/li[1]/div/div/div[2]/div[1]/div/button")).click();
        Thread.sleep(3000);
    }

    //Test 2 - navigate to order ahead items list
    @Test (priority = 2)
    void order_ahead() throws InterruptedException{

        JavascriptExecutor js = (JavascriptExecutor) chrome_driver;
        js.executeScript("window.scrollBy(0,600)", "");
        Thread.sleep(500);

        // Click order ahead for list of sandwiches
        chrome_driver.findElement(By.xpath("/html/body/div[2]/section/div[2]/div[4]/a")).click();
        Thread.sleep(1000);

        // Select customize sandwich
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div[4]/div/div/button[1]")).click();
        Thread.sleep(1000);
    }

    @Test (priority = 3)
    void modify_sandwich() throws InterruptedException{
        //Select half sandwich
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/div/div[1]/div[2]/fieldset[1]/div[2]/div[1]/label")).click();
        Thread.sleep(1000);

        // add item to order
        chrome_driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div[2]/div/button")).click();
        Thread.sleep(1000);
    }

    //Test 3 - Close and quit driver
    @Test (priority = 4)
    void close_browser() throws InterruptedException {

        // quit and close web driver
        Thread.sleep(3000);
        chrome_driver.close();
        chrome_driver.quit();
    }

}
