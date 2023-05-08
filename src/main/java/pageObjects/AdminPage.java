package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends AbstractPage {
    @FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
    protected WebElement header;

    @FindBy(xpath = "//h1/small[text()='Version 2.0']")
    protected WebElement headerVersion;

    @FindBy(xpath = "//ol[@class='breadcrumb']//li[.=' Home']")
    protected WebElement pathStart;

    @FindBy(xpath = "//ol[@class='breadcrumb']//li[.='Dashboard']")
    protected WebElement pathSecondPart;

    @FindBy(id = "activeStudentCount")
    protected WebElement activeStudentCountIcon;

    @FindBy(id = "newStudentsCount")
    protected WebElement newStudentsCountIcon;

    @FindBy(id = "frozenStudentsCount")
    protected WebElement frozenStudentsCountIcon;

    @FindBy(id = "graduatedStudentsCount")
    protected WebElement graduatedStudentsCountIcon;

    @FindBy(xpath = "//h3[.='Consultancy Statistics']")
    protected WebElement statisticsBoxHeader;

    @FindBy(xpath = "//div[contains(@class,'box-tools pull-right')]//i[@class='fa fa-minus']|//i[@class='fa fa-plus']")
    protected WebElement minimizeMaximizeBoxButton;

    @FindBy(xpath = "//i[@class='fa fa-times']")
    protected WebElement closeBoxButton;


    public AdminPage(WebDriver driver) {
        super(driver);
    }
}
