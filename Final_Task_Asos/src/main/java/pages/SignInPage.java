package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[@name='Username']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement signInButton;

    @FindBy(xpath = "//li[@id='loginErrorMessage']")
    private WebElement loginErrorMessage;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public boolean isLoginErrorMessageShown() { return loginErrorMessage.isDisplayed();
    }
}
