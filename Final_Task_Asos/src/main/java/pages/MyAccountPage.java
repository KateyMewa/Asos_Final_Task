package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//a[contains(@href, 'my-details')]")
    public WebElement accountDetailsLink;

    @FindBy(xpath = "//input[@name='emailAddress']")
    public WebElement emailField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='xwPKc79xq5utHleRNQpBs']/span")
    public WebElement errorMessage;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickAccountDetailsLink() {
        accountDetailsLink.click();
    }

    public void clearCurrentEmailInEmailField() {
        emailField.clear();
    }
    public void enterWrongEmailIntoEmailField(String email) {
        emailField.sendKeys(email);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
