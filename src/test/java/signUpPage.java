import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class signUpPage {
    private WebDriver driver;
    @Before
    public void setUp() {
        // Set ChromeDriver system property
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        // Instantiate ChromeDriver
        driver = new ChromeDriver();
        // Navigate to BugBug website
        driver.get("https://bugbug.io/v2/");
    }

    @Test
    public void signUpTest() {
        // Click on the "Sign up for free" button by class name
        WebElement signUpButton = driver.findElement(By.cssSelector("a.menuSignUp"));
        signUpButton.click();
        // Handle confirmation dialog (if present)
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            // No alert found, continue with the rest of the script
            System.out.println("No alert found.");
        }
        // Retry generating email with a delay
        String email = null;
        for (int i = 0; i < 3; i++) { // Retry 3 times
            email = generateTemporaryEmail();
            if (email != null) {
                break;
            }
            try {
                TimeUnit.SECONDS.sleep(5); // Wait for 5 seconds before retrying
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        // Proceed if email is successfully generated
        if (email != null) {
            // Find the email input field by its name attribute
            WebElement emailInput = driver.findElement(By.name("email"));
            // Clear any existing text in the input field
            emailInput.clear();
            // Enter the email address into the input field
            emailInput.sendKeys(email);
            // Find the password input field by its name attribute
            WebElement passwordInput = driver.findElement(By.name("password1"));
            // Clear any existing text in the input field
            passwordInput.clear();
            // Enter the password into the input field
            passwordInput.sendKeys("password123456789");
            // Find the confirm password input field by its name attribute
            WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
            // Clear any existing text in the input field
            confirmPasswordInput.clear();
            // Enter the confirm password into the input field
            confirmPasswordInput.sendKeys("password123456789");
            // Find the button by its data-testid attribute
            WebElement createAccountButton = driver.findElement(By.cssSelector("button[data-testid='Button']"));
            // Click on the button
            createAccountButton.click();
            // Verify "Verify your e-mail address" page popes up
            WebElement sendAgainLink = null;
            try {
                sendAgainLink = driver.findElement(By.cssSelector("a[data-testid='Link']"));
                Assert.assertNotNull("Send again link not found", sendAgainLink);
                TestReport.report("Verify 'Verify your e-mail address' page", true);
            } catch (NoSuchElementException e) {
                TestReport.report("Verify 'Verify your e-mail address' page", false);
                Assert.fail("Failed to verify 'Verify your e-mail address' page: Send again link not found");
            }
        }
        else {
            System.out.println("Failed to generate temporary email after multiple retries.");
        }
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

    // Method to generate a temporary email address
    private static String generateTemporaryEmail() {
        // Generate a random string for the email address
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder email = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            email.append(characters.charAt(random.nextInt(characters.length())));
        }
        email.append("@gmail.com"); // You can use any domain here
        return email.toString();
    }
}
