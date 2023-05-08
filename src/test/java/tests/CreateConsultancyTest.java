package tests;

import org.junit.Test;
import pageObjects.AdminConsultanciesPage;
import pageObjects.CreateConsultancyDialog;

public class CreateConsultancyTest extends BaseClass {

    @Test
    public void createConsultancyTest() {
        String title = "Bishop";

        AdminConsultanciesPage adminConsultancies = adminPage.openAdminConsultancies();
        CreateConsultancyDialog consultancyNew = adminConsultancies.createNewConsultancy();
        consultancyNew.fillConsultancy(title, "rulling", "99", "88", "100", "989");
        adminConsultancies = consultancyNew.saveConsultancy();
        adminConsultancies.findConsultancy(title);
        adminConsultancies.verifyClientIsDisplayed(title);
    }
}
