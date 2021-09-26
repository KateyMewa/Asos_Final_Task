package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;



    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoadComplete(long timeToWait) {
        (new WebDriverWait(this.driver, timeToWait)).until((webDriver) -> {
            return ((JavascriptExecutor)webDriver)
                    .executeScript("return document.readyState", new Object[0]).equals("complete");
        });
    }

    public void waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public Double getPrice(WebElement price) {
        StringBuilder text = new StringBuilder(price.getText());
        StringBuilder rawPrice = text.deleteCharAt(0);//.deleteCharAt(text.length() - 1).deleteCharAt(text.length() - 2).deleteCharAt(text.length() - 3);
        return Double.parseDouble(rawPrice.toString());
    }

    @FindBy(xpath = "//a[@aria-label='Saved Items']")
    public WebElement wishlistButton;

    public void clickWishlistButton() {
        wishlistButton.click();
    }
}
