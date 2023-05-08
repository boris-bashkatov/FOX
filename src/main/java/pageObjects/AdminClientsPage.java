package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class AdminClientsPage extends AbstractPage {

    @FindBy(xpath = "//button[contains(text(),'Create Client')]")
    protected WebElement createClient;

    @FindBy(xpath = "//button[@name='refresh']")
    protected WebElement refreshButton;

    @FindBy(xpath = "//input[@placeholder='Поиск']")
    protected WebElement searchField;

    @FindBy(xpath = "//*[contains(text(),'записей на страницу')]/span/button")
    protected WebElement dropDownPages;

    @FindBy(xpath = "//li[@class='page-pre']/a")
    protected WebElement previousPageButton;

    @FindBy(xpath = "//li[@class='page-next']/a")
    protected WebElement nextPageButton;

    @FindBy(xpath = "//li[@class='page-number' or @class='page-last']/a")
    protected List<WebElement> pageButtons;

    @FindBy(xpath = "//td//a")
    public List<WebElement> tableText;

    public AdminClientsPage(WebDriver driver) {
        super(driver);
    }

    public CreateClientDialog clickCreateClient() {

        createClient.click();
        return new CreateClientDialog(driver);
    }

    public void find(String searchName) {
        searchField.clear();
        searchField.sendKeys(searchName);
    }

    public void printTableText() {
        for (int i = 0; i < tableText.size(); i++) {
            System.out.print(tableText.get(i).getText());
            System.out.println(" - " + tableText.get(i).getText());
            searchField.click();
        }
    }

    public OpenedClientPage openClientPage(String nameSurname) {
        WebElement checkedElement = driver.findElement(By.xpath(String.format("//*[.='%s']", nameSurname)));
        checkedElement.click();
        return new OpenedClientPage(driver);
    }

}
