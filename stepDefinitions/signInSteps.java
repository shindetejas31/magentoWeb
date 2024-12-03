import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.SignInPage;
import com.fasterxml.jackson.databind.JsonNode;

import static org.junit.Assert.assertEquals;

public class SignInSteps {
    SignInPage signInPage = new SignInPage(new BaseTest().getDriver());
    JsonNode testData;

    // Step to initialize data based on the scenario passed
    @Given("User is testing sign-in with {string} scenario")
    public void userIsTestingSignInWithScenario(String scenario) {
        testData = TestDataReader.getSignInData(scenario);
        if (testData == null) {
            throw new RuntimeException("No data found for scenario: " + scenario);
        }
    }

    // Step to enter the sign-in details (email and password) into the UI
    @When("User enters sign-in details")
    public void userEntersSignInDetails() {
        // Enter email and password from the JSON file based on the scenario
        signInPage.enterEmail(testData.get("email").asText());
        signInPage.enterPassword(testData.get("password").asText());
        signInPage.clickSignInButton();
    }

    // Step to verify the result after the user clicks the sign-in button
    @Then("Sign-in should show appropriate result")
    public void signInShouldShowAppropriateResult() {
        // Fetch the actual result message from the UI after attempting to sign in
        String actualResult = signInPage.getResultMessage();
        String expectedResult = testData.get("expectedResult").asText();  // Expected result from JSON
        // Compare the actual result with the expected result
        assertEquals("Sign-in result mismatch!", expectedResult, actualResult);
    }
}
