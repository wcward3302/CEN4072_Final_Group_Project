import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Signup {

    public WebDriver chrome_driver = new ChromeDriver();

    @Test (priority = 1)
    void open_browser() throws InterruptedException{

        chrome_driver.get("https://publix.com/");
        chrome_driver.manage().window().maximize();
        Thread.sleep(1000);


        // Navigate to the sign up page
        chrome_driver.findElement(By.id("userSignUp")).click();
        Thread.sleep(2000);
    }

    @Test (priority = 2)
    void start_sign_up() throws InterruptedException{

        // Variables to insert into sign up field
        String first_name = "Test";
        String last_name = "Testing";
        String zip_code = "34119";

        // Start inserting info into given fields
        chrome_driver.findElement(By.name("FirstName")).sendKeys(first_name);
        Thread.sleep(500);
        chrome_driver.findElement(By.name("LastName")).sendKeys(last_name);
        Thread.sleep(500);
        chrome_driver.findElement(By.name("ZipCode")).sendKeys(zip_code);
        Thread.sleep(500);
    }

    public void clear_field(WebElement element){

        // Issue with .clear() method, need non-tested function to clear inputs
        element.sendKeys("Delete");
        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
    }

    @Test (priority = 3)
    void navigate_to_signup() throws InterruptedException{
        // Check if current title is correct
        Assert.assertEquals(chrome_driver.getTitle(), "Register | Publix Super Markets", "Incorrect page");        
    }

    @Test (priority = 4)
    void test_passwords() throws InterruptedException{

        WebElement element = chrome_driver.findElement(By.name("Password"));

        // Different passwords to test
        String good_password = "Testing123!!!";
        String bad_password_1 = "Test";
        String bad_password_2 = "test123";

        //Toggle to show password field
        chrome_driver.findElement(By.id("input_Password15-toggle")).click();


        // ------------------------ First password attempt (bad pword) ------------------------
        clear_field(element);
        element.sendKeys(bad_password_1);
        Thread.sleep(1000);

        // If password is bad, clicking join now will have an error message
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/form/div[3]/button")).click();
        String error_text_1 = chrome_driver.findElement(By.id("input_Password15_error")).getText();

        // get error message, if empty, then test fail
        Assert.assertNotEquals(error_text_1, "", "no error is present");
        Thread.sleep(2000);



        // ------------------------ Second password attempt (bad pword) ------------------------
        clear_field(element);
        element.sendKeys(bad_password_2);
        Thread.sleep(1000);

        // If password is bad, clicking join now will have an error message
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/form/div[3]/button")).click();
        String error_text_2 = chrome_driver.findElement(By.id("input_Password15_error")).getText();

        // get error message, if empty, then test fail
        Assert.assertNotEquals(error_text_2, "", "no error is present");
        Thread.sleep(2000);


        // ------------------------ Third password attempt (good pword) ------------------------
        clear_field(element);
        element.sendKeys(good_password);
        Thread.sleep(1000);

        // If password is good, clicking join now will not have an error message
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/form/div[3]/button")).click();
        String error_text_3 = chrome_driver.findElement(By.id("input_Password15_error")).getText();

        // get error message, if empty, then test pass
        Assert.assertEquals(error_text_3, "", "error is present");
        Thread.sleep(2000);
    }

    @Test (priority = 5)
    void test_email_use() throws InterruptedException {

        // This will fill the email field and check see if the system notices that the address is currently in use
        // error id = input_EmailAddress13_error
        String email_add = "testng.selenium.exam@gmail.com";

        // Insert email
        chrome_driver.findElement(By.name("EmailAddress")).sendKeys(email_add);
        Thread.sleep(1000);

        // Click join to make possible error appear
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(2000);

        String error_text = chrome_driver.findElement(By.id("input_EmailAddress13_error")).getText();

        // get error message, if empty, then test fail
        // Issue with site - when using automation, it will not confirm if address is currently in use
        Assert.assertEquals(error_text, "", "no error is present");
        Thread.sleep(2000);
    }

    @Test (priority = 6)
    void close_browser() throws InterruptedException {

        Thread.sleep(3000);
        chrome_driver.close();
        chrome_driver.quit();
    }
}
