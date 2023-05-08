package tests;

import org.junit.Test;
import pageObjects.AdminEmployeesPage;
import pageObjects.CreateEmployeeDialog;

public class CreateEmployeeTest extends BaseClass {

    @Test
    public void createEmployeeTest() {
        String name = "boba";
        String surname = "mentor";
        String nameSurname = name + " " + surname;
        AdminEmployeesPage adminEmployees = adminPage.openAdminEmployees();
        CreateEmployeeDialog employeeDialog = adminEmployees.clickCreateEmployeeButton();
        employeeDialog.fillEmployeeData(name, surname, "20");
        adminEmployees = employeeDialog.clickSave();
        adminEmployees.find(nameSurname);
        adminEmployees.verifyClientIsDisplayed(nameSurname);
    }
}
