package stepdefinitions;

import com.google.errorprone.annotations.Var;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.sl.In;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.Optional;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionsSteps {

    private static final long TIMEOUT = 60;
    private static final String  SIGNIN_PAGE_CONDITION = "signin";
    private Double PRICE_SUM = 0.0;

    WebDriver driver;
    HomePage homePage;
    BagPage bagPage;
    MyAccountPage myAccountPage;
    ProductPage productPage;
    SearchResultsPage searchResultsPage;
    SignInPage signInPage;
    PageFactoryManager pageFactoryManager;
    SectionPage sectionPage;
    WishlistPage wishlistPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks header visibility")
    public void userChecksHeaderVisibility() {
        homePage.isHeaderVisible();
    }

    @And("User checks footer visibility")
    public void userChecksFooterVisibility() {
        homePage.isFooterVisible();
    }

    @And("User checks search panel visibility")
    public void userChecksSearchPanelVisibility() {
        homePage.isSearchPanelVisible();
    }

    @And("User checks main widgets visibility")
    public void userChecksBannerVisibility() {
        homePage.isWidgetsPanelVisible();
    }

    @And("User checks social media links visibility")
    public void userChecksSocialMediaLinksVisibility() {
        homePage.isSocialLinksBarVisible();
    }

    @Then("User enters {string} into search input")
    public void userEntersKeywordIntoSearchInput(final String keyword) {
        homePage.waitForPageLoadComplete(TIMEOUT);
        homePage.enteringTextIntoSearchField(keyword);
    }

    @Then("User clicks search button")
    public void userClicksSearchButton() {
        homePage.clickSearchButton();
    }

    @And("User checks that search results are reflected")
    public void userChecksThatSearchResultsAreReflected() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(TIMEOUT);
        assertTrue(searchResultsPage.isSearchResultsSectionDisplayed());
    }

    @And("User checks that message saying that no results is shown")
    public void userChecksNoResultsMessageIsShown() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(TIMEOUT);
        assertTrue(searchResultsPage.isNoSearchResultsMessageShown());
    }

    @And("User clicks MyAccount button")
    public void userClicksMyAccountButton() {
        homePage = pageFactoryManager.getHomePage();
        homePage.waitForPageLoadComplete(TIMEOUT);
        homePage.waitVisibilityOfElement(TIMEOUT, homePage.myAccountButton);
        homePage.clickMyAccountButton();
        homePage.waitVisibilityOfElement(TIMEOUT, homePage.myAccountDropdown);
    }

    @And("User clicks Sign In link")
    public void userClicksSignInLink() {
        homePage.clickSignInLink();
    }

    @Then("User enters {string} into email field")
    public void userEntersEmailIntoEmailField(final String email) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(TIMEOUT);
        signInPage.enterEmail(email);
    }

    @Then("User enters {string} into password field")
    public void userEntersPasswordIntoPasswordField(final String password) {
        signInPage.enterPassword(password);
    }

    @And("User clicks Sign In submitting button")
    public void userClicksSignInSubmittingButton() {
        signInPage.waitVisibilityOfElement(TIMEOUT, signInPage.signInButton);
        signInPage.clickSignInButton();
    }

    @And("User clicks MyAccount link")
    public void userClicksMyAccountLink() {
        homePage.clickMyAccountLink();
        if (driver.getCurrentUrl().contains(SIGNIN_PAGE_CONDITION)) {
            signInPage = pageFactoryManager.getSignInPage();
            signInPage.waitForPageLoadComplete(TIMEOUT);
        }
    }

    @And("User checks that MyAccountPage has in its url {string}")
    public void userChecksThatMyAccountPageIsOpen(final String keyword) {
        myAccountPage = pageFactoryManager.getMyAccountPage();
        myAccountPage.waitForPageLoadComplete(TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(keyword));
    }

    @And("User checks that loginErrorMessage is shown")
    public void userChecksThatLoginErrorMessageIsShown() {
        assertTrue(signInPage.isLoginErrorMessageShown());
    }

    @Then("User clicks to Women button")
    public void userClicksToWomenButton() {
       homePage = pageFactoryManager.getHomePage();
       homePage.waitVisibilityOfElement(TIMEOUT, homePage.womenSection);
       homePage.clickWomenSectionButton();
    }

    @Then("User hovers to Clothes section")
    public void userHoversToClothesSection() {
        homePage.hoverClothingButton();
        homePage.waitVisibilityOfElement(TIMEOUT, homePage.dressesLink);
    }

    @And("User goes to Dresses link")
    public void userGoesToDressesLink() {
        homePage.clickDressesLink();
    }

    @Then("User clicks to product One")
    public void userClicksToProductOne() {
        sectionPage = pageFactoryManager.getSectionPage();
        sectionPage.waitForPageLoadComplete(TIMEOUT);
        sectionPage.clickDressOneLink();
    }

    @Then("User chooses {string}")
    public void userChoosesSize(String size) {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(TIMEOUT);
        productPage.selectSize(size);
    }

    @And("User adds product price to total sum")
    public void userAddsProductPriceToTotalSum() {
        PRICE_SUM += productPage.getPrice(productPage.price);
    }

    @Then("User clicks AddToBag button")
    public void userClicksAddToBagButton() {
        productPage.clickAddToBagButton();
    }

    @Then("User checks that MinibagDropdown section is shown up")
    public void userChecksThatMinibagDropdownSectionIsShownUp() {
        productPage.waitVisibilityOfElement(TIMEOUT, productPage.minibagDropdownSection);
        assertTrue(productPage.isMinibagDropdownSectionVisible());
    }

    @And("User clicks DressesSection link")
    public void userClicksDressesSectionLink() {
        productPage.clickSectionDressesLink();
    }

    @Then("User clicks to product Two")
    public void userClicksToProductTwo() {
        sectionPage = pageFactoryManager.getSectionPage();
        sectionPage.waitForPageLoadComplete(TIMEOUT);
        sectionPage.clickDressTwoLink();
    }

    @And("User hovers to Bag button")
    public void userHoversToBagButton() {
        productPage.waitVisibilityOfElement(TIMEOUT, productPage.minibagDropdownSection);
        productPage.hoverBagButton();
    }

    @And("User clicks to ViewBag button")
    public void userClicksToViewBagButton() {
        productPage.clickViewBagButton();
    }

    @And("User checks that total price equals the sum of prices for two products")
    public void userChecksThatTotalPriceEqualsTheSumOfPricesForTwoProducts() {
        bagPage = pageFactoryManager.getBagPage();
        bagPage.waitForPageLoadComplete(TIMEOUT);
        bagPage.waitVisibilityOfElement(TIMEOUT, bagPage.totalPrice);
        Double T2 = bagPage.getPrice(bagPage.totalPrice);
        assertEquals(PRICE_SUM, T2);
    }

    @And("User clicks Country button")
    public void userClicksCountryButton() {
        homePage.waitForPageLoadComplete(TIMEOUT);
        homePage.clickCountryButton();
    }

    @And("User select the {string}")
    public void userSelectTheCurrency(String currency) {
        homePage.waitVisibilityOfElement(TIMEOUT, homePage.currencyList);
        homePage.selectCurrency(currency);
    }

    @And("User clicks UpdatePreferences button")
    public void userClicksUpdatePreferencesButton() {
        homePage.clickSaveChangesButton();
        homePage.waitForPageLoadComplete(TIMEOUT);
    }

    @Then("User checks that random product price contains {string}")
    public void userChecksThatRandomProductPriceContainsCurrencySymbol(String symbol) {
        sectionPage = pageFactoryManager.getSectionPage();
        sectionPage.waitForPageLoadComplete(TIMEOUT);
        assertTrue(sectionPage.selectRandomProductPrice().getText().contains(symbol));
    }

    @Then("User clicks SaveToWishlist button")
    public void userClicksSaveToWishlistButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(TIMEOUT);
        productPage.waitVisibilityOfElement(TIMEOUT, productPage.saveToWishlistButton);
        productPage.clickSaveToWishlistButton();
    }

    @And("User clicks Wishlist button")
    public void userClicksWishlistButton() {
        productPage.clickWishlistButton();
        wishlistPage = pageFactoryManager.getWishlistPage();
        wishlistPage.waitForPageLoadComplete(TIMEOUT);
    }

    @Then("User clicks Sign In button")
    public void userClicksSignInButton() {
        wishlistPage.waitVisibilityOfElement(TIMEOUT, wishlistPage.signInButton);
        wishlistPage.clickSignInButton();
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(TIMEOUT);
        signInPage.waitVisibilityOfElement(TIMEOUT, signInPage.signInButton);
    }

    @Then("User checks that the product is saved in wishlist after authorization")
    public void userChecksThatTheProductIsSavedInWishlistAfterAuthorization() {
        wishlistPage = pageFactoryManager.getWishlistPage();
        wishlistPage.waitVisibilityOfElement(TIMEOUT, wishlistPage.product);
        assertTrue(wishlistPage.isProductDisplayed());
    }

    @And("User clicks MyAccount details button")
    public void userClicksMyAccountDetailsButton() {
        myAccountPage = pageFactoryManager.getMyAccountPage();
        myAccountPage.waitVisibilityOfElement(TIMEOUT, myAccountPage.accountDetailsLink);
        myAccountPage.clickAccountDetailsLink();
    }

    @Then("User clears Email filed")
    public void userClearsEmailFiled() {
        myAccountPage.waitVisibilityOfElement(TIMEOUT, myAccountPage.emailField);
        myAccountPage.clearCurrentEmailInEmailField();
    }

    @And("User clicks Submit changes button")
    public void userClicksSubmitChangesButton() {
        myAccountPage.clickSubmitButton();
    }

    @And("User checks that message with {string} is shown")
    public void userChecksThatErrorMessageIsShown(String keyword) {
        assertTrue(myAccountPage.getErrorMessage().contains(keyword));
    }

    @Then("User enters {string}")
    public void userEntersIncorrectEmail(String incorrectEmail) {
        myAccountPage.enterWrongEmailIntoEmailField(incorrectEmail);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
