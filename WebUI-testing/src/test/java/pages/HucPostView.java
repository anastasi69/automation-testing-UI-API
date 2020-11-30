package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HucPostView extends BasePage{

    @FindBy(xpath="//span[@id='nav-cart-count']")
    private WebElement cart;

    public HucPostView(WebDriver driver) {
        super(driver);
    }

    public String getNumberInCart() {
        return cart.getText();
    }

}
