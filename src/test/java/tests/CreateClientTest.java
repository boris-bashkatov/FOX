package tests;

import org.junit.Test;
import pageObjects.AdminClientsCreatePage;
import pageObjects.AdminClientsPage;
import pageObjects.CreateClientDialog;
import pageObjects.OpenedClientPage;
import utils.RandomGenerator;

import java.util.HashMap;
import java.util.Map;

public class CreateClientTest extends BaseClass {

    @Test
    public void CreateClientTest() {
        String name = RandomGenerator.getRandomString(3, 10).toLowerCase();
        String surname = RandomGenerator.getRandomString(5, 12).toLowerCase();
        String nameSurname = name + " " + surname;
        String email = RandomGenerator.getRandomString(3, 10) + '@' + RandomGenerator.getRandomString(1, 7) + ".com";
        String country = RandomGenerator.capitaliseStringFirstLetter(RandomGenerator.getRandomString(3, 50).toLowerCase());
        String city = RandomGenerator.capitaliseStringFirstLetter(RandomGenerator.getRandomString(3, 50).toLowerCase());
        String phoneNumber = RandomGenerator.getRandomNum(5, 12);
        String skype = RandomGenerator.getRandomAlphanumeric(5, 12);
        Map<String, String> createdUserDataMap = new HashMap<>();

        AdminClientsPage adminClients = adminPage.openAdminClients();
        CreateClientDialog createClientDialog = adminClients.clickCreateClient();
        createClientDialog.enterNameLastName(name, surname);
        AdminClientsCreatePage adminClientsCreate = createClientDialog.clickSave();
        createdUserDataMap.put("name", name);
        createdUserDataMap.put("surname", surname);
        createdUserDataMap.put("email", email);
        createdUserDataMap.put("country", country);
        createdUserDataMap.put("city", city);
        createdUserDataMap.put("phoneNumber", phoneNumber);
        createdUserDataMap.put("skype", skype);
        adminClientsCreate.fillClientData(createdUserDataMap);
        adminClients = adminClientsCreate.clickSave();
        adminClients.find(nameSurname);
        OpenedClientPage openedClientPage = adminClients.openClientPage(nameSurname);
        openedClientPage.verifyClientContactFields(createdUserDataMap);
    }
}
