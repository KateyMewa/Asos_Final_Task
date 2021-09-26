package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class SectionPage extends BasePage {

    Random random = new Random();
    Integer randomProduct = random.nextInt(72);

    @FindBy(xpath = "//a[contains(@aria-label, 'River Island jersey bodycon racer')]")
    private WebElement dressOneLink;

    @FindBy(xpath = "//a[contains(@aria-label, 'ASOS EDITION cutwork fringe')]")
    private WebElement dressTwoLink;

    @FindBy(xpath = "//span[@class='_16nzq18']")
    public List<WebElement> priceList;

    public SectionPage(WebDriver driver) {
        super(driver);
    }

    public void clickDressOneLink() {
        dressOneLink.click();
    }

    public void clickDressTwoLink() {
        dressTwoLink.click();
    }

    public WebElement selectRandomProductPrice() {
        return priceList.get(randomProduct);
    }
}
