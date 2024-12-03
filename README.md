# Magento Web Automation Repository

This repository contains automated test scripts and Page Object Model (POM) files for testing the Magento Web application. The main functionalities tested are **sign-up** and **sign-in** processes. The tests are implemented using **Selenium WebDriver** and **Java**, following the **Page Object Model (POM)** design pattern.

## Repository Overview

This project automates the testing of the Magento Web application, focusing on testing the **Sign-Up** and **Sign-In** functionalities. The tests are implemented in Java, and the WebDriver is used to automate browser actions. The tests are structured using the Page Object Model (POM) design pattern for better maintainability and scalability.

### Key Features:
- **Sign-Up Test Cases**: Automates the process of creating a new account and validates successful and invalid registration scenarios.
- **Sign-In Test Cases**: Automates the process of signing in to an existing account and validates successful and invalid login scenarios.
- **Page Object Model (POM)**: The project uses POM to manage elements and actions related to both the Sign-Up and Sign-In pages.

## Project Structure

- **`SignupPage.java`**: Contains the Page Object Model for the sign-up page. It includes methods for entering user details such as first name, last name, email, password, confirming the password, and submitting the registration form.
- **`SignInPage.java`**: Contains the Page Object Model for the sign-in page. It includes methods for entering the username, password, and clicking the login button.
- **`SignUpTest.java`**: Contains the test cases for validating the sign-up functionality. It tests valid sign-up scenarios as well as invalid scenarios like mismatched passwords and invalid email formats.
- **`SignInTest.java`**: Contains the test cases for validating the sign-in functionality. It includes tests for successful login, invalid password, and unregistered email cases.
- **`BaseTest.java`**: Contains setup and teardown methods for initializing WebDriver, opening the browser, and cleaning up after tests.

## Test Scenarios

### 1. **Sign-Up Test Cases**
   - **Valid Sign-Up**: Tests that a user can successfully create an account by entering valid details (first name, last name, email, and password).
   - **Invalid Email Format**: Tests that an error message is displayed when the email entered is in an invalid format.
   - **Password Mismatch**: Tests that an error message is shown when the password and confirm password fields do not match.
   - **Empty Fields**: Tests that an error message is displayed when any required field (e.g., first name, last name, email, or password) is left empty.

### 2. **Sign-In Test Cases**
   - **Valid Sign-In**: Tests that a user can successfully log in with valid credentials (email and password).
   - **Invalid Password**: Tests that an error message is displayed when an incorrect password is entered for a registered email.
   - **Unregistered Email**: Tests that an error message is displayed when a non-registered email is used to attempt a sign-in.

