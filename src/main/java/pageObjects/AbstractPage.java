package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
    protected WebDriver driver;

    @FindBy(xpath = "//li[.='MAIN NAVIGATION']")
    protected WebElement mainNavigation;

    @FindBy(xpath = " //span[.='Dashboard']")
    protected WebElement dashboard;

    @FindBy(xpath = "//span[.='Сделки']")
    protected WebElement dealsMenu;

    @FindBy(xpath = "//span[.='Сделки']/../..//a[.=' Новые']")
    protected WebElement dealsNewMenu;

    @FindBy(xpath = "//span[.='Сделки']/../..//a[.=' Архив']")
    protected WebElement dealsArchiveMenu;

    @FindBy(xpath = "//span[.='Сделки']/../..//a[.=' Все']")
    protected WebElement dealsAllMenu;

    @FindBy(xpath = "//span[.='Очередь']")
    protected WebElement queueMenu;

    @FindBy(xpath = "//span[.='Клиенты']")
    protected WebElement clientsMenu;

    @FindBy(xpath = "//span[.='Менторы']")
    protected WebElement mentorsMenu;

    @FindBy(xpath = "//span[.='Договора']//..//..//a[.=' Все']")
    protected WebElement contractsAllMenu;

    @FindBy(xpath = "//span[.='Договора']//..//..//a[.=' Тестовые']")
    protected WebElement contractsTestMenu;

    @FindBy(xpath = "//span[.='Услуги']")
    protected WebElement consultanciesMenu;

    @FindBy(xpath = "//span[.='Счета']//../..//a[.=' Все']")
    protected WebElement invoicesAllMenu;

    @FindBy(xpath = "//span[.='Счета']//../..//a[.=' Выставить']")
    protected WebElement invoicesIssueMenu;

    @FindBy(xpath = "//span[.='Счета']//../..//a[.=' Просроченные']")
    protected WebElement invoicesDebtMenu;

    @FindBy(xpath = "//span[.='Зарплаты']//../..//a[.='Зарплата']")
    protected WebElement sallaryMenu;

    @FindBy(xpath = "//span[.='Зарплаты']//../..//a[.='Формирование зарплаты']")
    protected WebElement sellaryPayrollMenu;

    @FindBy(xpath = "//span[.='Платежи']")
    protected WebElement paymentMenu;

    @FindBy(xpath = "//span[.='Пользователи']")
    protected WebElement usersMenu;

    @FindBy(xpath = "//span[.='Движение денег']")
    protected WebElement cashflowMenu;


    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AdminDealsNewPage openAdminDealsNewPage() {
        dealsMenu.click();
        dealsNewMenu.click();
        return new AdminDealsNewPage(driver);
    }

    public AdminDealsArchivedPage openAdminDealsArchivedPage() {
        dealsMenu.click();
        dealsNewMenu.click();
        return new AdminDealsArchivedPage(driver);
    }

    public AdminDealsPage openAdminDealsPage() {
        dealsMenu.click();
        dealsNewMenu.click();
        return new AdminDealsPage(driver);
    }

    public AdminClientsPage openAdminClients() {
        clientsMenu.click();
        return new AdminClientsPage(driver);
    }

    public AdminEmployeesPage openAdminEmployees() {
        mentorsMenu.click();
        return new AdminEmployeesPage(driver);
    }

    public AdminConsultanciesPage openAdminConsultancies() {
        consultanciesMenu.click();
        return new AdminConsultanciesPage(driver);
    }

    public void verifyClientIsDisplayed(String searchedText) {
        WebElement checkedElement = driver.findElement(By.xpath(String.format("//*[.='%s']", searchedText)));
        Assert.assertTrue("Record not found!", checkedElement.isDisplayed());
    }

    public void verifyFieledEqualTo(String textForValidation, WebElement validatedElement) {
        Assert.assertEquals(validatedElement.getText(), textForValidation);
    }

    public String getValueOfElement(WebElement inputWebElement) {
        return inputWebElement.getAttribute("value");
    }


}
