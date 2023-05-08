package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class OpenedClientPage extends AbstractPage {
    public OpenedClientPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    protected WebElement firstName;

    @FindBy(id = "lastName")
    protected WebElement lastName;

    @FindBy(id = "email")
    protected WebElement email;

    @FindBy(id = "country")
    protected WebElement country;

    @FindBy(id = "city")
    protected WebElement city;

    @FindBy(id = "phoneNumber")
    protected WebElement phoneNumber;

    @FindBy(id = "skype")
    protected WebElement skype;

    public void verifyClientContactFields(Map <String,String> mapForValidation) {
        Assert.assertEquals("name validation failed", getValueOfElement(firstName), mapForValidation.get("name"));
        Assert.assertEquals("surname validation failed", getValueOfElement(lastName), mapForValidation.get("surname"));
        Assert.assertEquals("email validation failed", getValueOfElement(email), mapForValidation.get("email"));
        Assert.assertEquals("country validation failed", getValueOfElement(country), mapForValidation.get("country"));
        Assert.assertEquals("city validation failed", getValueOfElement(city), mapForValidation.get("city"));
        Assert.assertEquals("phone number validation failed", getValueOfElement(phoneNumber), mapForValidation.get("phoneNumber"));
        Assert.assertEquals("skype validation failed", getValueOfElement(skype), mapForValidation.get("skype"));
    }
}
