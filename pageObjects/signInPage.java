import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    WebDriver driver;

    private By emailField = By.xpath("//input[@id='email']");
    private By passwordField = By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']");
    private By signInButton = By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']");
    private By forgotPasswordLink = By.xpath("//a[@class='action remind']//span[contains(text(),'Forgot Your Password?')]");
    private By createAccountButton = By.xpath("//a[@class='action create primary']//span[contains(text(),'Create an Account')]");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter email into the email field
    public void enterEmail(String email) {
        try {
            WebElement emailElement = driver.findElement(emailField);
            emailElement.clear();  // Clear any existing value
            emailElement.sendKeys(email);
        } catch (Exception e) {
            System.out.println("Error while entering email: " + e.getMessage());
            throw new RuntimeException("Failed to enter email into the field", e);  // Throw runtime exception
        }
    }

    // Method to enter password into the password field
    public void enterPassword(String password) {
        try {
            WebElement passwordElement = driver.findElement(passwordField);
            passwordElement.clear();  // Clear any existing value
            passwordElement.sendKeys(password);
        } catch (Exception e) {
            System.out.println("Error while entering password: " + e.getMessage());
            throw new RuntimeException("Failed to enter password into the field", e);  // Throw runtime exception
        }
    }

    // Method to click the Sign In button
    public void clickSignInButton() {
        try {
            WebElement signInButtonElement = driver.findElement(signInButton);
            signInButtonElement.click();
        } catch (Exception e) {
            System.out.println("Error while clicking Sign In button: " + e.getMessage());
            throw new RuntimeException("Failed to click Sign In button", e);  // Throw runtime exception
        }
    }

    // Method to click the Forgot Password link
    public void clickForgotPassword() {
        try {
            WebElement forgotPasswordElement = driver.findElement(forgotPasswordLink);
            forgotPasswordElement.click();
        } catch (Exception e) {
            System.out.println("Error while clicking Forgot Password link: " + e.getMessage());
            throw new RuntimeException("Failed to click Forgot Password link", e);  // Throw runtime exception
        }
    }

    // Method to click the Create Account button
    public void clickCreateAccount() {
        try {
            WebElement createAccountButtonElement = driver.findElement(createAccountButton);
            createAccountButtonElement.click();
        } catch (Exception e) {
            System.out.println("Error while clicking Create Account button: " + e.getMessage());
            throw new RuntimeException("Failed to click Create Account button", e);  // Throw runtime exception
        }
    }

    // Method to fetch the result message after SignIn action
    public String getResultMessage() {
        try {
            WebElement resultElement = driver.findElement(By.xpath("//div[@class='message']"));
            return resultElement.getText();
        } catch (Exception e) {
            System.out.println("Error while fetching result message: " + e.getMessage());
            throw new RuntimeException("Failed to fetch result message", e);  // Throw runtime exception
        }
    }
}
