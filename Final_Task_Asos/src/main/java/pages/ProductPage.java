package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage extends BasePage {

    Actions action = new Actions(driver);

    @FindBy(xpath = "//select[@data-id='sizeSelect']/option")
    private List<WebElement> sizeList;

    @FindBy(xpath = "//button[@data-test-id='add-button']")
    private  WebElement addToBagButton;

    @FindBy(xpath = "//div[@data-testid='minibag-dropdown']")
    public WebElement minibagDropdownSection;

    @FindBy(xpath = "//ol[@class='q0MjRbt']//a[text()='Dresses']")
    private WebElement sectionDressesLinks;

    @FindBy(xpath = "//span[@class='_1z5n7CN']")
    private WebElement bagButton;

    @FindBy(xpath = "//a[@data-test-id='bag-link']")
    public WebElement viewBagButton;

    @FindBy(xpath = "//span[@data-id='current-price']")
    public WebElement price;

    @FindBy(xpath = "//button[@class='save-button']")
    public WebElement saveToWishlistButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void selectSize(String size) {
        for (WebElement option : sizeList) {
            if (option.getText().contains(size)) {
                option.click();
                break;
            }
        }
    }

    public void clickAddToBagButton() {
        addToBagButton.click();
    }

    public boolean isMinibagDropdownSectionVisible() {
        return minibagDropdownSection.isDisplayed();
    }

    public void clickSectionDressesLink() {
        sectionDressesLinks.click();
    }

    public void hoverBagButton() {
        action.moveToElement(bagButton).perform();;
    }

    public void clickViewBagButton() {
        viewBagButton.click();
    }

    public void clickSaveToWishlistButton() {
        saveToWishlistButton.click();
    }
}
