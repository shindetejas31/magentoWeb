import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver = new BaseTest().getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("User is on the homepage")
    public void userIsOnHomePage() {
        assertTrue(homePage.isSignInLinkDisplayed());
    }

    @When("User clicks on the Sign In link")
    public void userClicksSignIn() {
        homePage.clickSignIn();
    }

    @When("User clicks on the Create Account link")
    public void userClicksCreateAccount() {
        homePage.clickCreateAccount();
    }

    @Then("User should be redirected to the login page")
    public void userShouldBeRedirectedToLogin() {
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Then("User should be redirected to the sign-up page")
    public void userShouldBeRedirectedToSignUp() {
        assertTrue(driver.getCurrentUrl().contains("signup"));
    }
}
