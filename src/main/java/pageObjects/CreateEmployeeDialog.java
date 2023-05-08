package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateEmployeeDialog {
    WebDriver driver;

    @FindBy(id = "firstName")
    protected WebElement firstNameField;

    @FindBy(id = "lastName")
    protected WebElement lastNameField;

    @FindBy(id = "maxClients")
    protected WebElement maxLoadField;

    @FindBy(xpath = "//button[contains(text(),\"save\")]")
    protected WebElement saveButton;

    public CreateEmployeeDialog(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillEmployeeData(String firstName, String lastName, String maxLoad) {

        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        maxLoadField.sendKeys(maxLoad);
    }

    public AdminEmployeesPage clickSave() {
        saveButton.click();
        return new AdminEmployeesPage(driver);
    }
}
