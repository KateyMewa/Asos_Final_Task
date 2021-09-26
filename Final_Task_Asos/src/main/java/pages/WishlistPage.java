package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends BasePage {

    @FindBy(xpath = "//button[text()='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[@class='overflowFade_2Vvqr']//p[contains(text(), 'jersey bodycon racer')]")
    public WebElement product;

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public boolean isProductDisplayed() {
        return product.isDisplayed();
    }
}
