package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminReportsCashflowPage extends AbstractPage {

    @FindBy(xpath = "//h3[.='Cash Flow Report']")
    protected WebElement header;

    @FindBy(id = "selectedConsultancyField")
    protected WebElement cosiltancyField;

    @FindBy(id = "beginDateField")
    protected WebElement beginDateField;

    @FindBy(id = "endDateField")
    protected WebElement endDateField;

    @FindBy(xpath = "//button[.='Make report']")
    protected WebElement makeReportButton;


    public AdminReportsCashflowPage(WebDriver driver) {

        super(driver);
    }
}
