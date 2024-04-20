// Test class = Shopping list
// Goal = navigate to items, add item to shopping list, modify quantity, remove
// Author = Josh Wurtenberg

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Shoppinglist {

    //Publix chrome driver variable for class to access
    public WebDriver chrome_driver;

    //Test 1 - Open browser, navigate to site, set location to prevent random pop up
    @Test (priority = 1)
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

    //Test 2 - Navigate to list of items, add item to shopping list
    @Test (priority = 2)
    void addToList() throws InterruptedException{

        // Navigate to item
        chrome_driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div[2]/div/div/div[2]/div/ul/li[1]/div/button")).click();
        Thread.sleep(3000);

        chrome_driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div[2]/div/div/div[2]/div/ul/li[1]/div/div/ul/li[2]/a")).click();
        Thread.sleep(2000);

        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[5]/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[4]/button")).click();
        Thread.sleep(2000);

    }

    //Test 3 - modify quantity of item in shopping list
    @Test (priority = 3)
    void modifyQuantity() throws InterruptedException {
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/div/div/div[1]/div[2]/ul/li[1]/a/span[2]")).click();
        Thread.sleep(2000);
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div[2]/table/tr[2]/tr/ul/li/div[3]/div/div/div[3]/button")).click();
        Thread.sleep(2000);

        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div[2]/table/tr[2]/tr/ul/li/div[3]/div/div/div[1]/button")).click();
        Thread.sleep(2000);

    }

    //Test 4 - remove item from shopping list
    @Test (priority = 4)
    void removeFromList() throws InterruptedException {
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div[2]/table/tr[2]/tr/ul/li/div[4]/div/button")).click();
        Thread.sleep(500);
    }

    //Test 5 - close and quit driver
    @Test (priority = 5)
    void close_browser() throws InterruptedException {
        Thread.sleep(3000);
        chrome_driver.close();
        chrome_driver.quit();
    }

}
