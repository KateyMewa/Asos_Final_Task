package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@data-auto-id='productList']")
    private WebElement searchResultsSection;

    @FindBy(xpath = "//h2[contains(text(), 'NOTHING MATCHES')]")
    private WebElement noResultsMessage;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchResultsSectionDisplayed() {
        return searchResultsSection.isDisplayed();
    }

    public boolean isNoSearchResultsMessageShown() {
        return noResultsMessage.isDisplayed();
    }
}
