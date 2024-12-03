import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    private By signInLink = By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");
    private By createAccountLink = By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignIn() {
        driver.findElement(signInLink).click();
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountLink).click();
    }

    public boolean isSignInLinkDisplayed() {
        return driver.findElement(signInLink).isDisplayed();
    }

    public boolean isCreateAccountLinkDisplayed() {
        return driver.findElement(createAccountLink).isDisplayed();
    }
}
