
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UtilsSuiteManagementTest {
    public static void loginForSuiteManagement(String email, String password, String projectName, String homepageUrl) {
        // Enter email
        WebElement usernameInput = SuitesManagement.driver.findElement(By.cssSelector("input[type='email'][name='email']"));
        WebElement passwordInput = SuitesManagement.driver.findElement(By.cssSelector("input[type='password'][name='password']"));
        WebElement signInButton = SuitesManagement.driver.findElement(By.cssSelector("button[data-testid='Button']"));

        usernameInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();

        // Wait for the page to load
        WebDriverWait wait = new WebDriverWait(SuitesManagement.driver, 10);
        wait.until(ExpectedConditions.urlContains("organizations"));

        // Assert if sign-in is successful
        Assert.assertTrue(SuitesManagement.driver.getCurrentUrl().contains("organizations"), "Sign in failed. User not redirected to dashboard.");

        // Wait for the "New project" form to be visible or locate the button to create a new project
        WebElement newProjectForm;
        try {
            newProjectForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='ProjectModal']")));
        } catch (org.openqa.selenium.TimeoutException e) {
            // If the "New project" form is not found, locate the button to create a new project
            WebElement newProjectButton = SuitesManagement.driver.findElement(By.cssSelector("button[data-testid='ProjectList.NewProjectButton']"));
            // Click on the button to create a new project
            newProjectButton.click();
        }

        // Wait for the project name input field to be visible
        WebElement projectNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name'][data-testid='Input']")));
        // Clear any existing text in the input field
        projectNameInput.clear();
        // Enter the project name
        projectNameInput.sendKeys(projectName);

        // Wait for the homepage URL input field to be visible
        WebElement homepageUrlInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='homepageUrl'][data-testid='Input']")));
        // Clear any existing text in the input field
        homepageUrlInput.clear();
        // Enter the homepage URL
        homepageUrlInput.sendKeys(homepageUrl);

        // Click on the "Create project" button
        WebElement createProjectButton = SuitesManagement.driver.findElement(By.cssSelector("button[data-testid='Button']"));
        createProjectButton.click();

        // Find the button using its data-testid attribute
        wait = new WebDriverWait(SuitesManagement.driver, 10);
        WebElement closeButton = SuitesManagement.driver.findElement(By.cssSelector("button[data-testid='Modal.CloseButton']"));

        // Click on the button
        closeButton.click();
        createTest();


    }

    public static void createTest(){
        WebDriverWait wait = new WebDriverWait(SuitesManagement.driver, 10);
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

        WebElement submitButton = SuitesManagement.driver.findElement(By.cssSelector("button[data-testid='EditTestModal.SubmitButton']"));
        submitButton.click();

//        // Wait for the arrow back icon to be clickable
//        WebElement arrowBackIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("svg[data-testid='ArrowBackRoundedIcon']")));
//        arrowBackIcon.click();
//
//        // Navigate back to the screen for creating a new test
//        WebElement createNewTestButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-testid='TestsActions.CreateNewTest']")));
//        createNewTestButton.click();
//        wait = new WebDriverWait(SuitesManagement.driver, 10);
//        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("svg[data-testid='CloseIcon']")));
//        closeButton.click();
    }

}
