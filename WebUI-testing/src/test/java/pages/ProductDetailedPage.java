package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailedPage extends BasePage {

    @FindBy(xpath="//input[@id='add-to-cart-button']")
    private WebElement addToCart;

    public ProductDetailedPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart() {
        addToCart.click();
    }
}
