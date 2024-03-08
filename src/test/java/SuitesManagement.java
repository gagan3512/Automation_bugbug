import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SuitesManagement {
    static WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up Chrome driver path
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        // Initialize ChromeDriver instance
        driver = new ChromeDriver();
        // Maximize browser window
        driver.manage().window().maximize();
        // Navigate to the BugBug.io sign-in page
        driver.get("https://app.bugbug.io/sign-in/");
        UtilsSuiteManagementTest.loginForSuiteManagement("gagantuli12345@gmail.com", "Password123456789", "Gagan Project", "https://exampleairlines.com");
    }

    @Test(priority = 1)
    public void createTestSuite() {
        // Wait for the link to be clickable
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement suitesLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[@data-testid='Menu.Navigation']//a[@data-testid='Link' and contains(@href, '/suites/')]")));
        // Click on the link
        suitesLink.click();
        // Find the New suite button using its data-testid attribute
        WebElement newSuiteButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-testid='SuitesActions.CreateNewSuite']")));
        // Click on the New suite button
        newSuiteButton.click();
        // Wait for the name input field to be visible
        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
        // Enter text into the input field
        nameInput.sendKeys("Suite 1");
        wait = new WebDriverWait(driver, 10);

        // Locate the "Create suite" button using its data-testid attribute
        WebElement createSuiteButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-testid='Button']")));

        // Click on the "Create suite" button
        createSuiteButton.click();
}

    @Test(priority = 3)
    public void deleteSuite() {
        // Wait for the delete button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Locate the parent element containing all suite rows
        WebElement suiteList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='SuitesList']")));

        // Find all suite rows
        List<WebElement> suiteRows = suiteList.findElements(By.cssSelector("a[data-testid='SuiteRow']"));

        // Loop through each suite row
        for (WebElement suiteRow : suiteRows) {
            // Find the delete button within the suite row
            WebElement deleteButton = suiteRow.findElement(By.cssSelector("button[data-testid='DeleteButton']"));

            // Click on the delete button
            deleteButton.click();

            // You might want to add additional logic here to confirm deletion if needed
        }
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
