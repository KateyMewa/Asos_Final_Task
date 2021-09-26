package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'bag-contents-holder--total')]//span[contains(@class, 'bag-total-price--subtotal')]")
    public WebElement totalPrice;

    public BagPage(WebDriver driver) {
        super(driver);
    }
}
