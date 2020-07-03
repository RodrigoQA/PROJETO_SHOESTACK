package api;

import api.core.BaseTest;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
public class ConsultaTrello extends BaseTest {

    @Test
    public void testFazerConsultarTrello_NomeEstruturaList(){
        Object nomeList = given()
                .when().get("https://api.trello.com/1/actions/592f11060f95a3d3d46a987a")
                .then().statusCode(200)
                .body("data.list.name",Matchers.is("Professional"))
                .extract().path("data.list.name");
                 System.out.println("Nome da estrutura list: " + nomeList);

    }
}
