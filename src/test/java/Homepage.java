import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Homepage {

    public WebDriver chrome_driver;

    // Before testing, need to open a window and navigate to testing website
    @BeforeTest
    void open_browser() throws InterruptedException{

        ChromeOptions chrome_options = new ChromeOptions();
        chrome_options.addArguments("disable-geolocation");
        chrome_driver = new ChromeDriver(chrome_options);
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
        //refresh page to prevent elemets going stale in the DOM
        chrome_driver.navigate().refresh();
    }

    // After testing, need to close and quit the driver since no longer in use
    @AfterTest
    void close_browser() throws InterruptedException {

        Thread.sleep(3000);
        chrome_driver.close();
        chrome_driver.quit();
    }


    // First test, test home page buy one get one link
    @Test (priority = 1)
    void home_page_bogo() throws InterruptedException{

        chrome_driver.findElement(By.xpath("/html/body/div[2]/section/div[1]/div/div/nav/ul/li[1]/a")).click();
        Thread.sleep(1000);

        // Check if page loaded is correct
        Assert.assertEquals(chrome_driver.getTitle(), "BOGO | Publix Super Markets", "Page not loaded correctly");
        Thread.sleep(500);

        // Click publix icon to return to home
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/a")).click();
        Thread.sleep(1000);
    }

    // Fourth test, test home page grad link
    @Test (priority = 2)
    void home_page_grad() throws InterruptedException{

        chrome_driver.findElement(By.xpath("/html/body/div[2]/section/div[1]/div/div/nav/ul/li[2]/a")).click();
        Thread.sleep(1000);

        // Check if page loaded is correct
        Assert.assertEquals(chrome_driver.getTitle(), "Celebrate Graduation with Publix | Publix Super Markets", "Page not loaded correctly");

        // Click publix icon to return to home after refreshing to ensure element is not stale
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/a")).click();
        Thread.sleep(1000);
    }

    // Fifth test, test home page Subs and Wraps link
    @Test (priority = 3)
    void home_page_subs() throws InterruptedException{

        chrome_driver.findElement(By.xpath("/html/body/div[2]/section/div[1]/div/div/nav/ul/li[3]/a")).click();
        Thread.sleep(1000);

        // Check if page loaded is correct
        Assert.assertEquals(chrome_driver.getTitle(), "Publix Deli Subs and Wraps | Publix Super Markets", "Page not loaded correctly");
        Thread.sleep(500);

        // Click publix icon to return to home
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/a")).click();
        Thread.sleep(1000);
    }

    // Sixth test, test home page cakes links
    @Test (priority = 4)
    void home_page_cakes() throws InterruptedException{

        chrome_driver.findElement(By.xpath("/html/body/div[2]/section/div[1]/div/div/nav/ul/li[4]/a")).click();
        Thread.sleep(1000);

        // Check if page loaded is correct
        Assert.assertEquals(chrome_driver.getTitle(), "Order Bakery Cakes and Custom Personalized Cakes | Publix Super Markets", "Page not loaded correctly");
        Thread.sleep(500);

        // Click publix icon to return to home
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/a")).click();
        Thread.sleep(1000);
    }

    // First test is to follow and return from most of the navigation links found on the home page
    @Test (priority = 5)
    void drop_down_weeklyads() throws InterruptedException{

        // click dropdown, then click weekly ads
        chrome_driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div[2]/div/div/div[2]/div/ul/li[1]/div/button")).click();
        Thread.sleep(500);
        chrome_driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div[2]/div/div/div[2]/div/ul/li[1]/div/div/ul/li[1]/a")).click();
        Thread.sleep(1000);

        // Check if page loaded is correct
        Assert.assertEquals(chrome_driver.getTitle(), "Weekly Ad | Publix Super Markets", "Page not loaded correctly");
        Thread.sleep(500);

        // Click publix icon to return to home
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/a")).click();
    }

    // Second test, test drop down buy one get one link
    @Test (priority = 6)
    void drop_down_bogo() throws InterruptedException{

        // click dropdown, then click weekly ads
        chrome_driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div[2]/div/div/div[2]/div/ul/li[1]/div/button")).click();
        Thread.sleep(500);
        chrome_driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div[2]/div/div/div[2]/div/ul/li[1]/div/div/ul/li[2]/a")).click();
        Thread.sleep(1000);

        // Check if page loaded is correct
        Assert.assertEquals(chrome_driver.getTitle(), "BOGO | Publix Super Markets", "Page not loaded correctly");
        Thread.sleep(500);

        // Click publix icon to return to home
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/a")).click();
    }
}
