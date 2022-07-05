package selenium.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EveningDressesPage extends MainPage{

    public EveningDressesPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Printed Dress'][1]")
    private WebElement printedDress;

    @FindBy(xpath = "//a[@title='View'][1]")
    private WebElement moreButton;

    // TODO: Allure steps - EveningDressesPage
    public EveningDressesPage hoverOnPrintedDress(){
        this.action
                .moveToElement(printedDress)
                .build()
                .perform();
        return this;
    }

    public PrintedDressPage clickMoreButton(){
        moreButton.click();
        return new PrintedDressPage(driver);
    }
}
