import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Locations {

    // location xpath = /html/body/div[2]/header/div[1]/div/div[2]/div/div/div[2]/div/div/button

    public WebDriver chrome_driver = new ChromeDriver();

    @Test (priority = 1)
    void open_browser() throws InterruptedException{
        chrome_driver.get("https://publix.com/");
        chrome_driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @Test (priority = 2)
    void navigate_to_locations() throws InterruptedException{

        // Navigate to Locations pop up
        chrome_driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div[2]/div/div/div[2]/div/div/button")).click();
        Thread.sleep(750);

        // Click view map button to open page
        chrome_driver.findElement(By.id("view-map-button")).click();
        Thread.sleep(2000);

        // Check if at correct location
        Assert.assertEquals(chrome_driver.getTitle(), "Locations | Publix Super Markets", "Location page not found");
        System.out.println("Location page loaded");
    }

    @Test (priority = 3)
    void pick_estero_store() throws InterruptedException {

        //Must click block location services to function correctly, this is for delay 
        Thread.sleep(2000);

        // Search for Estero in search bar
        chrome_driver.findElement(By.name("search")).sendKeys("Estero" + Keys.RETURN);
        Thread.sleep(1500);

        // Select publix location
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/div[1]/div[3]/ul/li[1]/div/div/div[2]/div[1]/div/button/span")).click();
        Thread.sleep(1000);

        // Selected location should appear as "out location" after loading
        String text = chrome_driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div[2]/div/div/div[2]/div/div/button")).getText();
        
        Assert.assertEquals(text, "Corkscrew Village", "Location not set correctly");
        System.out.println("Location set correctly");
    }

    @Test (priority = 4)
    void close_browser() throws InterruptedException {
        Thread.sleep(3000);
        chrome_driver.close();
        chrome_driver.quit();
    }
}
