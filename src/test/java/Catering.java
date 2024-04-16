import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Catering {

    public WebDriver chrome_driver;

    // Before testing, need to open a window and navigate to testing website
    @BeforeTest
    void open_browser() throws InterruptedException{

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
        //refresh page to prevent elemets going stale in the DOM
        chrome_driver.navigate().refresh();
        Thread.sleep(500);
        chrome_driver.findElement(By.id("tou-button")).click();
    }

    // After testing, need to close and quit the driver since no longer in use
    @AfterTest
    void close_browser() throws InterruptedException {

        Thread.sleep(3000);
        chrome_driver.close();
        chrome_driver.quit();
    }

    //
    @Test (priority = 1)
    void go_to_catering() throws InterruptedException{

        chrome_driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div[2]/div/div/div[2]/div/ul/li[3]/a")).click();
        Thread.sleep(1000);

        Assert.assertEquals(chrome_driver.getTitle(), "Catering by Publix: Order Food Here for Your Event or Party | Publix Super Markets", "Incorrect page loaded");
    }

    @Test (priority = 2)
    void click_sandwich_platter() throws InterruptedException{

        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[1]/div[1]/div/div/div[1]/div/div[2]/div/a")).click();
        Thread.sleep(1000);

        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[1]/div[5]/div[1]/div/div[1]/section/span[2]/div[1]/fieldset/div/ul/li[1]/div/label/span[1]/input")).click();
        Thread.sleep(500);

        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[1]/div[3]/div/div/nav/ul/li[2]/a")).click();

        Assert.assertEquals(chrome_driver.getTitle(), "Deli Boxed Meals. | Publix Super Markets", "Incorrect Page Loaded");
    }
}
