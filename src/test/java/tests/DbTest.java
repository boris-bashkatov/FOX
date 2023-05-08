package tests;

import org.junit.Test;

import java.sql.SQLException;
import java.util.Map;

public class DbTest {
    DataBase dataBase = new DataBase();
    String returnedResult;
    Map<String, String> returnedMAP;


    @Test
    public void randomActiveClient() throws SQLException {
        returnedResult = (dataBase.runQuery("select concat(c.last_name,' ',c.first_name) from client c inner join deal d ON d.client_id = c.id where status = 'ACTIVE' order by random() limit 1"));
        System.out.println("randomActiveClient: " + returnedResult);
        dataBase.validateNameSurnameLength(returnedResult);
    }

    @Test
    public void randomMentorMoreThanTenClients() throws SQLException {
        returnedResult = (dataBase.runQuery("select concat(e.last_name, ' ', e.first_name) from employee e where max_clients > 10 order by random() limit 1"));
        System.out.println("randomMentorMoreThanTenClients: " + returnedResult);
        dataBase.validateNameSurnameLength(returnedResult);
    }

    @Test
    public void randomClientWithContractJunOct() throws SQLException {
        returnedResult = (dataBase.runQuery("SELECT Concat(c.last_name, ' ', c.first_name) FROM client c inner join deal d ON d.client_id = c.id inner join contract cont on cont.deal_id = d.id WHERE EXTRACT( MONTH FROM cont.contract_date ) > 06 and EXTRACT( MONTH FROM cont.contract_date ) <= 10 order by random() limit 1"));
        System.out.println("randomClientWithContractJunOct: " + returnedResult);
        dataBase.validateNameSurnameLength(returnedResult);
    }

    @Test
    public void clientStatus() throws SQLException {
        returnedMAP = (dataBase.mapPopulation("SELECT Concat(c.last_name, ' ', c.first_name) as Client, d.status FROM client c inner join deal d ON d.client_id = c.id inner join consultancy co ON d.consultancy_id = co.id"));
        returnedMAP.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
