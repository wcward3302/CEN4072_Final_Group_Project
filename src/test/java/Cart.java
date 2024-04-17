import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Cart {

    public WebDriver chrome_driver;

    @Test (priority = 1)
    void open_browser() throws InterruptedException{

        chrome_driver = new ChromeDriver();
        chrome_driver.manage().window().maximize();
        chrome_driver.get("https://publix.com/");
        Thread.sleep(1000);
    }

    @Test (priority = 2)
    void add_item_cart() throws InterruptedException{
        // Go to catering
        Thread.sleep(1000);
        chrome_driver.findElement(By.xpath("/html/body/div[2]/section/div[1]/div/div/nav/ul/li[5]/a")).click();
        Thread.sleep(1000);
        
        Assert.assertEquals(chrome_driver.getTitle(), "Catering by Publix: Order Food Here for Your Event or Party | Publix Super Markets", "Incorrect page");

        // select location
        // end location input a string as then return to fetch 
        chrome_driver.findElement(By.name("search")).sendKeys("Estero" + Keys.RETURN);
        Thread.sleep(1000);
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/div/div/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div/div[3]/ul/li[1]/div/div/div[2]/div[1]/div/button")).click();
        Thread.sleep(3000);

        //click chicken platters for list
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[1]/div[1]/div/div/div[3]/div/div[2]/div/a")).click();
        Thread.sleep(500);

        //Scroll down to see platters
        JavascriptExecutor js = (JavascriptExecutor) chrome_driver;
        js.executeScript("window.scrollBy(0,600)", "");

        // add popcorn chicken platter to cart
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[1]/div[4]/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[4]/div/div/button[2]")).click();
        Thread.sleep(2000);

        //click review order to see cart
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/div/div/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/button")).click();
        Thread.sleep(1000);

        //Click to confirm location
        chrome_driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div/div/button[2]")).click();
        Thread.sleep(1000);
    }

    @Test (priority = 3)
    void modify_cart() throws InterruptedException{
        // Increase quantity in cart
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/div[1]/div[2]/ul/li/div/div[3]/form/div/div[3]/button")).click();
        Thread.sleep(1000);
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/div[1]/div[2]/ul/li/div/div[3]/form/div/div[1]/button")).click();
        Thread.sleep(1000);
    }

    @Test (priority = 4)
    void remove_cart() throws InterruptedException{
        // Duplicate in cart
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/div[1]/div[2]/ul/li/div/div[5]/div/button[1]")).click();
        Thread.sleep(1000);

        //Remove from cart
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/div[1]/div[2]/ul/li/div/div[5]/div/button[2]")).click();
        Thread.sleep(1000);
    }

    @Test (priority = 5)
    void checkout(){
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/div[2]/div/div/div/div[3]/button")).click();
    }

    @Test (priority = 10)
    void close_browser() throws InterruptedException {
        Thread.sleep(2000);
        chrome_driver.close();
        chrome_driver.quit();
    }
}