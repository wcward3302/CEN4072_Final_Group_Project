import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShoppingList {

    // location xpath = /html/body/div[2]/header/div[1]/div/div[2]/div/div/div[2]/div/div/button

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

    }

    // After testing, need to close and quit the driver since no longer in use
    @AfterTest
    void close_browser() throws InterruptedException {
        Thread.sleep(3000);
        chrome_driver.close();
        chrome_driver.quit();
    }

    @Test (priority = 1)
    void addToList() throws InterruptedException{

        // Navigate to item
        chrome_driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div[2]/div/div/div[2]/div/ul/li[1]/div/button")).click();
        Thread.sleep(3000);
        chrome_driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div[2]/div/div/div[2]/div/ul/li[1]/div/div/ul/li[2]/a")).click();
        Thread.sleep(2000);
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[5]/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[4]/button")).click();
        Thread.sleep(750);

    }

    @Test (priority = 2)
    void modifyQuantity() throws InterruptedException {
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/div/div/div[1]/div[2]/ul/li[1]/a/span[2]")).click();
        Thread.sleep(500);
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div[2]/table/tr[2]/tr/ul/li/div[3]/div/div/div[3]/button")).click();
        Thread.sleep(2000);

        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div[2]/table/tr[2]/tr/ul/li/div[3]/div/div/div[1]/button")).click();
        Thread.sleep(2000);

    }


    @Test (priority = 3)
    void removeFromList() throws InterruptedException {
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div[2]/table/tr[2]/tr/ul/li/div[4]/div/button")).click();
        Thread.sleep(500);
        Assert.assertEquals(chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div[2]/div/div[1]")).getText(), "Get started by adding items to your list.", "Error, shopping list is not empty");
    }
}
