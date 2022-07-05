package ui_tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import selenium.Actions.StartDriver;
import selenium.Pages.MainPage;

public class CheckProductTest {
    static WebDriver driver;
    private final String URL = "http://automationpractice.com/index.php";

    MainPage page;

    @BeforeEach
    public void setup(){
        driver = StartDriver.initChromeDriver(URL);
        page = new MainPage(driver);
    }

    @Test
    @DisplayName("Scenario 1. Check printed dress data sheet")
    public void checkPrintedDressDataSheet(){
        page
                .hoverOnDressesButton()
                .clickEveningDressesButton()
                .hoverOnPrintedDress()
                .clickMoreButton()
                .checkDataSheetFields("Compositions", "Styles", "Properties")
                .checkDataSheetValues("Viscose", "Dressy", "Short Dress");
    }

    @Test
    @DisplayName("Scenario 2. Add printed dress to cart and check cart quantity")
    public void addPrintedDressToCart(){
        page
                .hoverOnDressesButton()
                .clickEveningDressesButton()
                .hoverOnPrintedDress()
                .clickMoreButton()
                .selectSize("M")
                .selectColor("Pink")
                .clickAddToCart()
                .clickContinueShopping()
                .checkCartQuantityText("1 Product");
    }

    @Test
    @DisplayName("Scenario 3. Delete printed dress from cart and check that cart is empty")
    public void deleteDressFromCart(){
        page
                .hoverOnDressesButton()
                .clickEveningDressesButton()
                .hoverOnPrintedDress()
                .clickMoreButton()
                .selectSize("M")
                .selectColor("Pink")
                .clickAddToCart()
                .clickContinueShopping()
                .hoverOnTheCart()
                .clickCheckOut()
                .clickDeleteButton()
                .checkEmptyCartMessage()
                .checkCartQuantityText("(empty)");
    }

    @AfterEach
    public void endTest(){
        driver.quit();
    }
}
