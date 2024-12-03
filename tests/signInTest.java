import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.SignInPage;
import utils.BaseTest;
import utils.TestDataReader;
import com.fasterxml.jackson.databind.JsonNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignInTest extends BaseTest {
    private WebDriver driver;
    private SignInPage signInPage;
    private JsonNode testData;

    @BeforeEach
    public void setUp() {
        // Initialize the driver and page object
        driver = getDriver();
        signInPage = new SignInPage(driver);
    }

    /**
     * Test case for valid login
     */
    @Test
    public void testValidLogin() {
        testData = TestDataReader.getSignInData("validLogin");
        runSignInTest(testData);
    }

    /**
     * Test case for invalid email
     */
    @Test
    public void testInvalidEmail() {
        testData = TestDataReader.getSignInData("invalidEmail");
        runSignInTest(testData);
    }

    /**
     * Test case for incorrect password
     */
    @Test
    public void testIncorrectPassword() {
        testData = TestDataReader.getSignInData("incorrectPassword");
        runSignInTest(testData);
    }

    /**
     * Test case for empty fields
     */
    @Test
    public void testEmptyFields() {
        testData = TestDataReader.getSignInData("emptyFields");
        runSignInTest(testData);
    }

    /**
     * Helper method to run Sign-In tests
     * @param testData The test data to be used for this scenario
     */
    private void runSignInTest(JsonNode testData) {
        // Navigate to the sign-in page (if required by your application)
        driver.get("https://example.com/signin"); // Replace with actual URL

        // Enter email and password from the test data
        signInPage.enterEmail(testData.get("email").asText());
        signInPage.enterPassword(testData.get("password").asText());
        signInPage.clickSignInButton();

        // Fetch the actual result message from the UI
        String actualResult = signInPage.getResultMessage();

        // Compare the actual result with the expected result
        assertEquals(testData.get("expectedResult").asText(), actualResult, 
                     "Sign-In result did not match the expected result!");
    }
}
