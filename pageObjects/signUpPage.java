import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {
    WebDriver driver;

    private By firstName = By.xpath("//input[@id='firstname']");
    private By lastName = By.xpath("//input[@id='lastname']");
    private By email = By.xpath("//input[@id='email_address']");
    private By password = By.xpath("//input[@id='password']");
    private By confirmPassword = By.xpath("//input[@id='password-confirmation']");
    private By createAccountButton = By.xpath("//button[@title='Create an Account']");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter first name into the first name field
    public void enterFirstName(String fName) {
        try {
            WebElement firstNameElement = driver.findElement(firstName);
            firstNameElement.clear();  // Clear any existing value
            firstNameElement.sendKeys(fName);
        } catch (Exception e) {
            System.out.println("Error while entering first name: " + e.getMessage());
            throw new RuntimeException("Failed to enter first name", e);  // Throw runtime exception with the error details
        }
    }

    // Method to enter last name into the last name field
    public void enterLastName(String lName) {
        try {
            WebElement lastNameElement = driver.findElement(lastName);
            lastNameElement.clear();  // Clear any existing value
            lastNameElement.sendKeys(lName);
        } catch (Exception e) {
            System.out.println("Error while entering last name: " + e.getMessage());
            throw new RuntimeException("Failed to enter last name", e);  // Throw runtime exception with the error details
        }
    }

    // Method to enter email into the email field
    public void enterEmail(String emailId) {
        try {
            WebElement emailElement = driver.findElement(email);
            emailElement.clear();  // Clear any existing value
            emailElement.sendKeys(emailId);
        } catch (Exception e) {
            System.out.println("Error while entering email: " + e.getMessage());
            throw new RuntimeException("Failed to enter email", e);  // Throw runtime exception with the error details
        }
    }

    // Method to enter password into the password field
    public void enterPassword(String pwd) {
        try {
            WebElement passwordElement = driver.findElement(password);
            passwordElement.clear();  // Clear any existing value
            passwordElement.sendKeys(pwd);
        } catch (Exception e) {
            System.out.println("Error while entering password: " + e.getMessage());
            throw new RuntimeException("Failed to enter password", e);  // Throw runtime exception with the error details
        }
    }

    // Method to enter confirmation password into the confirmation field
    public void enterConfirmPassword(String confirmPwd) {
        try {
            WebElement confirmPasswordElement = driver.findElement(confirmPassword);
            confirmPasswordElement.clear();  // Clear any existing value
            confirmPasswordElement.sendKeys(confirmPwd);
        } catch (Exception e) {
            System.out.println("Error while entering confirmation password: " + e.getMessage());
            throw new RuntimeException("Failed to enter confirmation password", e);  // Throw runtime exception with the error details
        }
    }

    // Method to click the Create Account button
    public void clickCreateAccount() {
        try {
            WebElement createAccountButtonElement = driver.findElement(createAccountButton);
            createAccountButtonElement.click();
        } catch (Exception e) {
            System.out.println("Error while clicking Create Account button: " + e.getMessage());
            throw new RuntimeException("Failed to click Create Account button", e);  // Throw runtime exception with the error details
        }
    }
}
