Documentation:- 

I) Test Cases Documentation:
Scenario:
Automating UI test cases for BugBug platform focusing on project, tests management, and suites management functionalities.

Test Case 1: Create New Project
Description:
This test case verifies the functionality of creating a new project after signing into the BugBug platform.

Steps:

Open the BugBug platform sign-in page: https://app.bugbug.io/sign-in/
Log in with valid credentials.
Navigate to the project creation page.
Fill in the necessary details for the new project (e.g., project name, description).
Click on the "Create" button.
Verify that the project is successfully created and listed in the project management section.
Expected Outcome:
The new project should be created successfully, and it should be visible in the project list.

Test Case 2: Tests Management
Description:
This test case verifies the functionalities related to tests management, including creating, deleting, listing, and updating tests.

Steps:

Sign in to the BugBug platform.
Navigate to the tests management section.
Create a new test.
Verify that the new test is successfully created.
List all tests and verify that the newly created test is listed.
Update the details of the test.
Verify that the test details are updated correctly.
Delete the test.
Verify that the test is deleted and no longer listed.
Expected Outcome:
All test management actions (create, list, update, delete) should be performed successfully without errors.

Test Case 3: Suites Management
Description:
This test case verifies the functionalities related to suites management, including creating, deleting, listing, and updating suites.

Steps:

Sign in to the BugBug platform.
Navigate to the suites management section.
Create a new suite.
Verify that the new suite is successfully created.
List all suites and verify that the newly created suite is listed.
Update the details of the suite.
Verify that the suite details are updated correctly.
Delete the suite.
Verify that the suite is deleted and no longer listed.
Expected Outcome:
All suites management actions (create, list, update, delete) should be performed successfully without errors.

II) Documentation for How to Run the Case:
Pre-requisites:
JDK (Java Development Kit) installed.
Maven installed.
Git installed.
WebDriver for Selenium (ChromeDriver) installed.
Steps to Run the Test Case:
Clone the repository from GitHub using the following command:
bash
Copy code
git clone 
Navigate to the project directory:
bash
Copy code
cd 
Update the config.properties file with your BugBug platform username and password.
Open a terminal or command prompt.
Run the following command to execute the test case:
bash
Copy code
mvn clean test
The Selenium WebDriver will open a Chrome browser, sign in to the BugBug platform, and execute the test cases automatically.
Once the execution is complete, the test results will be displayed in the terminal, and any failures will be reported.
![image](https://github.com/gagan3512/Automation_bugbug/assets/53247977/c855e014-57e0-495d-b39f-5f2b35b71348)
