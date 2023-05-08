package tests;

import drivers.MyChromeDriver;
import drivers.PageDriver;
import org.junit.After;
import org.junit.Before;
import pageObjects.AdminPage;
import pageObjects.LoginPage;

public class BaseClass {
    protected PageDriver pageDriver;
    protected AdminPage adminPage;

    /**
     * Open Chrome browser
     */
    @Before
    public void login() {
        pageDriver = new MyChromeDriver();

        pageDriver.open("http://foxminded.com.ua/");
        LoginPage login = new LoginPage(pageDriver.getWebDriver());
        login.enterName("admin", "admin");

        adminPage = login.submit();
    }

    @After
    public void closeBrowser() {
        pageDriver.close();
    }
}
