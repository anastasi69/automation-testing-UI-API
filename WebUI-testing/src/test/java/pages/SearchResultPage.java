package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage{

    @FindBy(xpath="//span/h1[@span=contains(text(), 'Bedtime Originals Plush Monkey Ollie')]")
    private WebElement searchedResultsStatus;

    @FindBy(xpath="//span[contains(text(), 'No results for')]")
    private WebElement noResultsText;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchResultsStatus(String keyword) {
        return driver.findElement(By.xpath("//span/h1[@span=contains(text(), '"+ keyword +"')]"));
    }

    public List<WebElement> getListOfSearchedProduct() {
        return driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//h2/a"));
    }

    public WebElement getNoResultsText() {
        return noResultsText;
    }

}
