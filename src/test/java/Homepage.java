// Test class = Home page
// Goal = visit links, navigate around home page
// Author = William Ward

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homepage {

    //Public chrome driver variable for class to access
    public WebDriver chrome_driver;

    //Test 1 - open browser, navigate to site, set location to prevent random pop up
    @Test (priority = 1)
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
        Thread.sleep(500);
        chrome_driver.findElement(By.id("tou-button")).click();
    }

    //Test 2 - Click Buy one get one link to test
    @Test (priority = 2)
    void home_page_bogo() throws InterruptedException{

        chrome_driver.findElement(By.xpath("/html/body/div[2]/section/div[1]/div/div/nav/ul/li[1]/a")).click();
        Thread.sleep(1000);

        // Check if page loaded is correct
        Assert.assertEquals(chrome_driver.getTitle(), "BOGO | Publix Super Markets", "Page not loaded correctly");

        // Click publix icon to return to home
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/a")).click();
        Thread.sleep(1000);
    }


    //Test 3 - Click graduation items link to test
    @Test (priority = 3)
    void home_page_grad() throws InterruptedException{

        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[1]/div/div/nav/ul/li[2]/a")).click();
        Thread.sleep(1000);

        // Check if page loaded is correct
        Assert.assertEquals(chrome_driver.getTitle(), "Order Graduation Cakes, Cupcakes, and Platters | Publix Super Markets", "Page not loaded correctly");

        // Click publix icon to return to home
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/a")).click();
        Thread.sleep(1000);
    }

    //Test 4 - visit buy one get one drop down menu link to test
    @Test (priority = 4)
    void drop_down_bogo() throws InterruptedException{

        // click dropdown, then click weekly ads
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/div/div/div[2]/div/ul/li[1]/div/button")).click();
        Thread.sleep(500);
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/div/div/div[2]/div/ul/li[1]/div/div/ul/li[2]/a")).click();
        Thread.sleep(1000);

        // Check if page loaded is correct
        Assert.assertEquals(chrome_driver.getTitle(), "BOGO | Publix Super Markets", "Page not loaded correctly");
        Thread.sleep(500);

        // Click publix icon to return to home
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/a")).click();
    }

    //Test 5 - click contact us link at bottom of page
    @Test (priority = 5)
    void contact_us() throws InterruptedException{

        chrome_driver.findElement(By.xpath("/html/body/div[1]/footer/div/nav/ul/li[1]/div[1]/ul/li[3]/div/a")).click();
        Thread.sleep(500);

        Assert.assertEquals(chrome_driver.getTitle(), "Contact Us | Publix Super Markets", "Page not loaded correctly");

        // Click publix icon to return to home
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/a")).click();
    }

    //Test 6 - Click publix policies link at bottom of page
    @Test (priority = 6)
    void policy_info() throws InterruptedException{

        chrome_driver.findElement(By.xpath("/html/body/div[1]/footer/div/nav/ul/li[1]/div[1]/ul/li[4]/div/a")).click();
        Thread.sleep(500);

        Assert.assertEquals(chrome_driver.getTitle(), "Publix Policies | Publix Super Markets", "Page not loaded correctly");

        // Click publix icon to return to home
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/a")).click();
    }

    //Test 7 - close and quit driver
    @Test (priority = 7)
    void close_browser() throws InterruptedException {

        Thread.sleep(3000);
        chrome_driver.close();
        chrome_driver.quit();
    }
}
