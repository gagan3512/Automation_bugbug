import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
    static WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Set up Chrome driver path
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        // Initialize ChromeDriver instance
        driver = new ChromeDriver();
        // Maximize browser window
        driver.manage().window().maximize();
        // Navigate to the BugBug.io sign-in page
        driver.get("https://app.bugbug.io/sign-in/");
    }

    @Test(priority = 1)
    public void signInTest() {
        Util.loginAndCreateProject("gagantuli12345@gmail.com", "Password123456789", "Gagan Project", "https://exampleairlines.com");
    }
    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
