import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.SignupPage;
import com.fasterxml.jackson.databind.JsonNode;

import static org.junit.Assert.assertEquals;

public class SignUpSteps {
    SignupPage signupPage = new SignupPage(new BaseTest().getDriver());
    JsonNode testData;

    @Given("User is testing sign-up with {string} scenario")
    public void userIsTestingSignUpWithScenario(String scenario) {
        testData = TestDataReader.getSignUpData(scenario);
        if (testData == null) {
            throw new RuntimeException("No data found for scenario: " + scenario);
        }
    }

    @When("User enters sign-up details")
    public void userEntersSignUpDetails() {
        signupPage.enterFirstName(testData.get("firstName").asText());
        signupPage.enterLastName(testData.get("lastName").asText());
        signupPage.enterEmail(testData.get("email").asText());
        signupPage.enterPassword(testData.get("password").asText());
        signupPage.enterConfirmPassword(testData.get("confirmPassword").asText());
        signupPage.clickCreateAccount();
    }

    @Then("Sign-up should show appropriate result")
    public void signUpShouldShowAppropriateResult() {
        String actualResult = signupPage.getResultMessage(); // Assuming a method to fetch result message
        String expectedResult = testData.get("expectedResult").asText();
        assertEquals("Sign-up result mismatch!", expectedResult, actualResult);
    }
}
