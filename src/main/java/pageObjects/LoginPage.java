package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-submit")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String userName, String password) {
        userNameInput.clear();
        userNameInput.sendKeys(userName);

        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public AdminPage submit() {
        submitButton.click();
        return new AdminPage(driver);
    }

}
