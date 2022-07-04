package selenium.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

public class MainPage {
    protected final WebDriver driver;
    protected final Actions action;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.action = new Actions(driver);
    }

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[2]")
    private WebElement dressesButton;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[2]/ul/li[2]")
    private WebElement eveningDressesButton;

    @FindBy(xpath = "//div[@class='shopping_cart']/a")
    private WebElement shoppingCartButton;

    @FindBy(xpath = "//a[@title='Check out']")
    private WebElement checkOutButton;

    public MainPage pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public MainPage hoverOnDressesButton(){
        this.action
                .moveToElement(dressesButton)
                .build()
                .perform();
        return this;
    }

    public EveningDressesPage clickEveningDressesButton(){
        eveningDressesButton.click();
        return new EveningDressesPage(driver);
    }

    public MainPage checkCartQuantityText(String cartQuantity){
        assertEquals(cartQuantity, shoppingCartButton.getText().substring(5));
        return this;
    }

    public MainPage hoverOnTheCart(){
        this.action
                .moveToElement(shoppingCartButton)
                .build()
                .perform();
        return this;
    }
    public CartPage clickCheckOut(){
        checkOutButton.click();
        return new CartPage(driver);
    }
}
