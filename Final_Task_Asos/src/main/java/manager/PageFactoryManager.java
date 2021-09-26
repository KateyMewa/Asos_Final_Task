package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public BagPage getBagPage() {
        return new BagPage(driver);
    }

    public MyAccountPage getMyAccountPage() {
        return new MyAccountPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }

    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }

    public SectionPage getSectionPage() {
        return new SectionPage(driver);
    }

    public WishlistPage getWishlistPage() { return new WishlistPage(driver); }
}
