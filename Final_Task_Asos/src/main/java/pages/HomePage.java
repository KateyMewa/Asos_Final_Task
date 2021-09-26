package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    Actions action = new Actions(driver);

    @FindBy(xpath = "//div[@id='chrome-header']")
    private WebElement header;

    @FindBy(xpath = "//div[@id='chrome-footer']")
    private WebElement footer;

    @FindBy(xpath = "//form[@data-testid='search-form']")
    private WebElement searchPanel;

    @FindBy(xpath = "//ul[@data-testid='widgets']")
    public WebElement widgetsPanel;

    @FindBy(xpath = "//ul[@data-testid='social-links-bar']")
    private WebElement socialLinksBar;

    @FindBy(xpath = "//input[@id = 'chrome-search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@data-testid= 'search-button-inline']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@aria-label = 'My Account']")
    public WebElement myAccountButton;

    @FindBy(xpath = "//a[@data-testid='signin-link']")
    private WebElement signInLink;

    @FindBy(xpath = "//a[@data-testid='myaccount-link']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//div[@data-testid='myaccount-dropdown']")
    public WebElement myAccountDropdown;

    @FindBy(xpath = "//a[@data-testid='women-floor']")
    public WebElement womenSection;

    @FindBy(xpath = "//button[@data-id='96b432e3-d374-4293-8145-b00772447cde']")
    private WebElement clothingButton;

    @FindBy(xpath = "//a[contains(@href, '/?cid=8799&nlid=ww|clothing|shop+by+product|dresses')]")
    public WebElement dressesLink;

    @FindBy(xpath = "//div[@class='_2jtZkvR']//button[@data-testid='country-selector-btn']")
    public WebElement countryButton;

    @FindBy(xpath = "//select[@id='currency']")
    public WebElement currencyList;

    @FindBy(xpath = "//button[@data-testid='save-country-button']")
    private WebElement saveChangesButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void isHeaderVisible() {
        header.isDisplayed();
    }

    public void isFooterVisible() {
        footer.isDisplayed();
    }

    public void isSearchPanelVisible() {
        searchPanel.isDisplayed();
    }

    public void isWidgetsPanelVisible() {
        widgetsPanel.isDisplayed();
    }

    public void isSocialLinksBarVisible() {
        socialLinksBar.isDisplayed();
    }

    public void enteringTextIntoSearchField(String keyword) {
        searchField.sendKeys(keyword);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickMyAccountButton() {
        myAccountButton.click();
    }

    public void clickSignInLink() {
        signInLink.click();
    }

    public void clickMyAccountLink() {
        myAccountLink.click();
    }

    public void hoverClothingButton() {
        action.moveToElement(clothingButton).perform();
    }

    public void clickDressesLink() {
        dressesLink.click();
    }

    public void clickWomenSectionButton() {
        womenSection.click();
    }

    public void clickCountryButton() {
        countryButton.click();
    }

    public void selectCurrency (String currency) {
        Select currencySelect;
        {
            assert currencyList != null;
            currencySelect = new Select(currencyList);
        }
        currencySelect.selectByVisibleText(currency);
    }

    public void clickSaveChangesButton() {
        saveChangesButton.click();
    }
}
