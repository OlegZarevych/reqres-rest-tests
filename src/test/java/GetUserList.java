import POJO.ListUsers;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetUserList {

    @Test
    public void getAllUsersListTest() {
        when().get(Endpoints.users).
                then().
                statusCode(200).
                body("total", equalTo(12));
        }

}
