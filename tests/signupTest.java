import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.SignUpPage;
import utils.BaseTest;
import utils.TestDataReader;
import com.fasterxml.jackson.databind.JsonNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignupTest extends BaseTest {
    private WebDriver driver;
    private SignUpPage signUpPage;
    private JsonNode testData;

    @BeforeEach
    public void setUp() {
        // Initialize the driver and page object
        driver = getDriver();
        signUpPage = new SignUpPage(driver);
    }

    /**
     * Test case for valid signup
     */
    @Test
    public void testValidSignup() {
        testData = TestDataReader.getSignUpData("validSignup");
        runSignupTest(testData);
    }

    /**
     * Test case for invalid email
     */
    @Test
    public void testInvalidEmail() {
        testData = TestDataReader.getSignUpData("invalidEmail");
        runSignupTest(testData);
    }

    /**
     * Test case for mismatched passwords
     */
    @Test
    public void testMismatchedPasswords() {
        testData = TestDataReader.getSignUpData("mismatchedPasswords");
        runSignupTest(testData);
    }

    /**
     * Test case for empty fields
     */
    @Test
    public void testEmptyFields() {
        testData = TestDataReader.getSignUpData("emptyFields");
        runSignupTest(testData);
    }

    /**
     * Helper method to run Signup tests
     * @param testData The test data to be used for this scenario
     */
    private void runSignupTest(JsonNode testData) {
        // Navigate to the signup page (if required by your application)
        driver.get("https://example.com/signup"); // Replace with actual URL

        // Enter data from the test JSON
        signUpPage.enterFirstName(testData.get("firstName").asText());
        signUpPage.enterLastName(testData.get("lastName").asText());
        signUpPage.enterEmail(testData.get("email").asText());
        signUpPage.enterPassword(testData.get("password").asText());
        signUpPage.enterConfirmPassword(testData.get("confirmPassword").asText());
        signUpPage.clickSignUpButton();

        // Fetch the actual result message from the UI
        String actualResult = signUpPage.getResultMessage();

        // Compare the actual result with the expected result
        assertEquals(testData.get("expectedResult").asText(), actualResult, 
                     "Signup result did not match the expected result!");
    }
}
