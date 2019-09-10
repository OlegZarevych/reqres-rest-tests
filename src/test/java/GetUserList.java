import JsonScheme.JsonScheme;
import POJO.CreateUserRequest;
import POJO.ListUsers;
import io.restassured.response.Response;
import org.junit.Test;
import com.google.gson.Gson;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class GetUserList {

    @Test
    public void getAllUsersListTest() {
        when().
                get(Endpoints.users).
        then().
                statusCode(200).
                body("total", equalTo(12)).
                body(matchesJsonSchemaInClasspath(JsonScheme.AllUsersJson));
        }

        @Test
        public void getUsers_invalidValue_returnNotFound()
        {
            when().
                    get(Endpoints.users + "/100500").
            then().
                    statusCode(404);
        }

        @Test
        public void postCreateUser_validValues_ShouldReturnCreated()
        {
            Gson gson = new Gson();

            CreateUserRequest request = new CreateUserRequest();

            request.Name = "Oleg";
            request.Job = "AQA";

            given().
                    contentType("application/json").
                    body(gson.toJson(request)).
            when().
                    post(Endpoints.users).
            then().
                    statusCode(201).
                    and().
                    time(lessThan(5000L));
        }

}
