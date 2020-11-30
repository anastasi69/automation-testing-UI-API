package features;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.List;

import static org.junit.Assert.*;

public class StepDefinitions {

    private WebDriver driver;

    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String SOURCE = "src\\test\\resources\\chromedriver.exe";
    private static final String AMAZON_URL = "https://www.amazon.com.au/";

    public static final int EXPECTED_COUNT = 48;

    @Before
    public void openingTheSite() {
        System.setProperty(CHROME_DRIVER, SOURCE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AMAZON_URL);
    }

    @After
    public void tearUp() {
        driver.close();
    }

    @Given("I open authorisation page")
    public void i_open_authorisation_page() {
        HomePage home = new HomePage(driver);
        home.clickSignInButton();
    }

    @When("I click on the button")
    public void i_submit_the_form() {
        SignInPage signIn = new SignInPage(driver);
        signIn.clickContinueButton();
    }

    @Then("The error message about empty field is displayed")
    public void the_message_is_displayed() {
        SignInPage signIn = new SignInPage(driver);
        assertTrue(signIn.getErrorMessage().isDisplayed());
    }


    @When("I enter {string} and click Continue button")
    public void iEnterAndClickContinueButton(String email) {
        SignInPage signIn = new SignInPage(driver);
        signIn.enterValueInField("ap_email", email);
        signIn.clickContinueButton();
    }

    @And("I enter {string} and click Sign-In button")
    public void iEnterAndClickSignInButton(String password) {
        SignInPage signIn = new SignInPage(driver);
        signIn.enterValueInField("ap_password", password);
        signIn.clickSignInButton();
    }

    @Then("I see the main page and my {string} in the header")
    public void iSeeTheMainPageAndMyInTheHeader(String name) {
        HomePage home = new HomePage(driver);
        assertTrue(home.getUserName(name).isDisplayed());
    }

    @Then("The error message about nonexistent account with that email is displayed")
    public void theErrorMessageAboutNonexistentAccountWithThatEmailIsDisplayed() {
        SignInPage signIn = new SignInPage(driver);
        assertTrue(signIn.getNonexistentAccountError().isDisplayed());
    }

    @Then("The error message about incorrect is displayed")
    public void theErrorMessageAboutIncorrectIsDisplayed() {
        SignInPage signIn = new SignInPage(driver);
        assertTrue(signIn.getWarningPasswordError().isDisplayed());
        //assertTrue(signIn.getIncorrectPasswordError().isDisplayed());
    }

    @Given("I enter {string} in the search field")
    public void iEnterInTheSearchField(String keyword) {
        HomePage home = new HomePage(driver);
        home.searchProduct(keyword);
    }

    @When("I click on the search button")
    public void iClickOnTheSearchButton() {
        new HomePage(driver).clickSearchButton();
    }

    @Then("I see searched product by {string}")
    public void iSeeSearchedProductBy(String keyword) {
        SearchResultPage results = new SearchResultPage(driver);
        assertTrue(results.getSearchResultsStatus(keyword).isDisplayed());

        List<WebElement> resultsItem = results.getListOfSearchedProduct();
        assertEquals(EXPECTED_COUNT, resultsItem.size());
    }

    @Then("I see no result")
    public void iSeeNoResult() {
        SearchResultPage results = new SearchResultPage(driver);
        assertTrue(results.getNoResultsText().isDisplayed());
    }

    @And("I open random product")
    public void iOpenRandomProduct() {
        SearchResultPage results = new SearchResultPage(driver);
        List<WebElement> resultsItem = results.getListOfSearchedProduct();
        int number = (int)Math.floor(Math.random()*48);
        WebElement item = resultsItem.get(number);
        item.click();
    }

    @And("click on the Add to Cart button")
    public void clickOnTheAddToCartButton() {
        ProductDetailedPage pdp = new ProductDetailedPage(driver);
        pdp.clickAddToCart();
    }

    @Then("I see {int} item in the cart")
    public void iSeeItemInTheCart(int number) {
        HucPostView cart = new HucPostView(driver);
        assertEquals(number,Integer.parseInt(cart.getNumberInCart()));
    }
}

