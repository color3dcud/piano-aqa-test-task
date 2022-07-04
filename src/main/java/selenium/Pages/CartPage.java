package selenium.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.*;

public class CartPage extends MainPage{

    public CartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement emptyCartMessage;

    public CartPage clickDeleteButton(){
        deleteButton.click();
        pause(3000);
        return this;
    }

    public CartPage checkEmptyCartMessage(){
        assertEquals("Your shopping cart is empty.", emptyCartMessage.getText());
        return this;
    }
}
