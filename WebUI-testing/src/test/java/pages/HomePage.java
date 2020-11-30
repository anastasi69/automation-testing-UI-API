package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;

public class HomePage extends BasePage{

    @FindBy(xpath="//div[@id='nav-belt']//a[@data-nav-role='signin']")
    private WebElement signInButton;

    @FindBy(xpath="//div[@class=\"nav-right\"]//span[contains(text(), 'AmazonTest')]")
    private WebElement userName;

    @FindBy(xpath="//input[@aria-label='Search']")
    private WebElement searchInput;

    @FindBy(xpath="//div[@id='nav-search']//input[@type='submit']")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String keyword) {
        searchInput.sendKeys(keyword, Keys.ENTER);
    }
    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public WebElement getUserName(String name) {
        return driver.findElement(By.xpath("//div[@class=\"nav-right\"]//span[contains(text(), '" + name + "')]"));
    }



}
