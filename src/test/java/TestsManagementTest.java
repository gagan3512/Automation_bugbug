import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.List;

public class TestsManagementTest {
    static WebDriver driver;
    WebDriverWait wait;

    /**
     *This class will run individual test - you have to remove @ignore tag. If you want to run particular test.
     */

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
        UtilsTestsManagementTest.loginForTestManagement("gagantuli12345@gmail.com", "Password123456789", "Gagan Project", "https://exampleairlines.com");

    }


    @Test(priority = 1)
    public void createTest() {
        UtilsTestsManagementTest.createTest();
    }

    @Ignore
    @Test(priority = 2)
    public void deleteTest() {
        WebDriverWait wait = new WebDriverWait(TestsManagementTest.driver, 10);
        WebElement testNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name'][data-testid='Input']")));
        // Clear any existing text in the input field
        testNameInput.clear();
        // Enter the name of the test
        testNameInput.sendKeys("Test Case 1");

        // Add a small delay to allow the test name to be processed
        try {
            Thread.sleep(1000); // 1 second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement submitButton = TestsManagementTest.driver.findElement(By.cssSelector("button[data-testid='EditTestModal.SubmitButton']"));
        submitButton.click();

        // Click on the three dots menu
        wait = new WebDriverWait(driver, 10);

        // Wait for the button to be clickable
        WebElement threeDotsButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-testid='TestDetails.TestHeaderActions.Menu.Button']")));

        // Click on the three dots button
        threeDotsButton.click();
    }

    @Ignore
    @Test(priority = 3)
    public void listTests() {
        UtilsTestsManagementTest.createTest();
        // Find the row group containing the list of tests
        WebElement rowGroup = driver.findElement(By.cssSelector("div[role='rowgroup']"));

        // Find all <a> elements representing individual tests
        List<WebElement> testElements = rowGroup.findElements(By.cssSelector("a[role='row']"));

        // Print the number of tests found
        System.out.println("Number of tests listed: " + testElements.size());

        // Iterate through each test element and print its name
        for (WebElement testElement : testElements) {
            WebElement testNameElement = testElement.findElement(By.cssSelector("span[data-testid='TextCell']"));
            String testName = testNameElement.getText();
            System.out.println("Test Name: " + testName);
        }
    }


    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
