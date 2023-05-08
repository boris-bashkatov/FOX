package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdminEmployeesPage extends AbstractPage {
    @FindBy(xpath = "//table[@data-toggle='table']//span")
    protected List<WebElement> mentorsNameList;

    @FindBy(xpath = "//table[@data-toggle='table']//tr/td[3]")
    protected List<WebElement> mentorsWorkload;

    @FindBy(xpath = "//span[@class='pagination-info']")
    protected WebElement reccordsCount;

    @FindBy(xpath = "//span[@class='page-size']")
    protected WebElement pageSize;

    @FindBy(xpath = "//button[contains(text(),\"Create\")]")
    protected WebElement createEmployeeButton;

    @FindBy(xpath = "//input[@placeholder='Поиск']")
    protected WebElement searchField;

    public AdminEmployeesPage(WebDriver driver) {
        super(driver);
    }

    public CreateEmployeeDialog clickCreateEmployeeButton() {
        createEmployeeButton.click();
        return new CreateEmployeeDialog(driver);
    }

    public void find(String searchName) {
        searchField.clear();
        searchField.sendKeys(searchName);
    }

    public void printNameWorkload() {
        for (int i = 0; i < mentorsNameList.size(); i++) {
            System.out.print(mentorsNameList.get(i).getText());
            System.out.println(" - " + mentorsWorkload.get(i).getText());
        }
    }

    public void printRecordNumber() {
        System.out.println(reccordsCount.getText());
        System.out.println(pageSize.getText() + " записей на страницу");
    }
}