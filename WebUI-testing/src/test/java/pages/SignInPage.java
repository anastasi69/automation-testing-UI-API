package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;

import static org.openqa.selenium.By.xpath;

public class SignInPage extends BasePage{

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement signInButton;

    @FindBy(xpath="//div[contains(text(), 'Enter your email or mobile phone number')]")
    private WebElement emailInputError;

    @FindBy(xpath="//div[@id='auth-error-message-box']")
    private WebElement nonexistentAccountError;

    @FindBy(xpath="//div[@id='auth-error-message-box'][@span=contains(text(), 'Your password is incorrect')]")
    private WebElement incorrectPasswordError;

    @FindBy(xpath="//div[@id='auth-warning-message-box']")
    private WebElement warningPasswordError;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterValueInField(String property, String value) {
        WebElement locator = driver.findElement(By.xpath("//input[@id='"+ property +"']"));
        locator.sendKeys(value);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public WebElement getErrorMessage() {
        return emailInputError;
    }

    public WebElement getNonexistentAccountError() {
        return nonexistentAccountError;
    }

    public WebElement getIncorrectPasswordError() {
        return incorrectPasswordError;
    }

    public WebElement getWarningPasswordError() {
        return warningPasswordError;
    }
}
