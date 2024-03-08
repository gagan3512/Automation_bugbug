import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Util {
    public static void loginAndCreateProject(String email, String password, String projectName, String homepageUrl) {
        // Enter email
        WebElement usernameInput = Login.driver.findElement(By.cssSelector("input[type='email'][name='email']"));
        WebElement passwordInput = Login.driver.findElement(By.cssSelector("input[type='password'][name='password']"));
        WebElement signInButton = Login.driver.findElement(By.cssSelector("button[data-testid='Button']"));

        usernameInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();

        // Wait for the page to load
        WebDriverWait wait = new WebDriverWait(Login.driver, 10);
        wait.until(ExpectedConditions.urlContains("organizations"));

        // Assert if sign-in is successful
        Assert.assertTrue(Login.driver.getCurrentUrl().contains("organizations"), "Sign in failed. User not redirected to dashboard.");

        // Wait for the "New project" form to be visible or locate the button to create a new project
        WebElement newProjectForm;
        try {
            newProjectForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='ProjectModal']")));
        } catch (org.openqa.selenium.TimeoutException e) {
            // If the "New project" form is not found, locate the button to create a new project
            WebElement newProjectButton = Login.driver.findElement(By.cssSelector("button[data-testid='ProjectList.NewProjectButton']"));
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
        WebElement createProjectButton = Login.driver.findElement(By.cssSelector("button[data-testid='Button']"));
        createProjectButton.click();
    }


}
