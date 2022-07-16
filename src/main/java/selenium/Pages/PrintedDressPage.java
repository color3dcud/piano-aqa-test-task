package selenium.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintedDressPage extends MainPage{

    public PrintedDressPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    private WebElement compositionsField;

    @FindBy(xpath = "//tbody/tr[2]/td[1]")
    private WebElement stylesField;

    @FindBy(xpath = "//tbody/tr[3]/td[1]")
    private WebElement propertiesField;

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    private WebElement compositionsValue;

    @FindBy(xpath = "//tbody/tr[2]/td[2]")
    private WebElement stylesValue;

    @FindBy(xpath = "//tbody/tr[3]/td[2]")
    private WebElement propertiesValue;

    @FindBy(xpath = "//select")
    private WebElement sizeSelector;

    @FindBy(xpath = "//select/option[1]")
    private WebElement sizeS;

    @FindBy(xpath = "//select/option[2]")
    private WebElement sizeM;

    @FindBy(xpath = "//select/option[3]")
    private WebElement sizeL;

    @FindBy(xpath = "//*[@id='color_to_pick_list']/li[1]")
    private WebElement beigeColorButton;

    @FindBy(xpath = "//*[@id='color_to_pick_list']/li[2]")
    private WebElement pinkColorButton;

    @FindBy(xpath = "//*[@id='add_to_cart']/button")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    private WebElement continueShoppingButton;

    public PrintedDressPage checkCompositionData(String compositionField, String compositionValue){
        assertEquals(compositionField, this.compositionsField.getText());
        assertEquals(compositionValue, this.compositionsValue.getText());
        return this;
    }

    public PrintedDressPage checkStylesData(String stylesField, String stylesValue){
        assertEquals(stylesField, this.stylesField.getText());
        assertEquals(stylesValue, this.stylesValue.getText());
        return this;
    }

    public PrintedDressPage checkPropertiesData(String propertiesField, String propertiesValue){
        assertEquals(propertiesField, this.propertiesField.getText());
        assertEquals(propertiesValue, this.propertiesValue.getText());
        return this;
    }

    public PrintedDressPage selectSize(String sizeLetter){
        sizeSelector.click();
        switch (sizeLetter){
            case "S":
                sizeS.click();
                return this;
            case "M":
                sizeM.click();
                return this;
            case "L":
                sizeL.click();
                return this;
            default:
                throw new IllegalStateException("Unexpected size value: " + sizeLetter);
        }
    }

    public PrintedDressPage selectColor(String color){
        switch (color){
            case "Beige":
                beigeColorButton.click();
                return this;
            case "Pink":
                pinkColorButton.click();
                return this;
            default:
                throw new IllegalStateException("Unexpected color value: " + color);
        }
    }

    public PrintedDressPage clickAddToCart(){
        addToCartButton.click();
        return this;
    }

    public PrintedDressPage clickContinueShopping(){
        continueShoppingButton.click();
        return this;
    }
}
