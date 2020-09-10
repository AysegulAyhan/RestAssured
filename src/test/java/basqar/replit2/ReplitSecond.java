package basqar.replit2;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ReplitSecond {
    private Cookies cookies;
    private String id;

    @BeforeClass
    public void init(){

        baseURI = "https://test.basqar.techno.study";
        Map<String,String> credentials=new HashMap<>();
        credentials.put("username","daulet2030@gmail.com");
        credentials.put("password","TechnoStudy123@");
        cookies = given().
                contentType(ContentType.JSON)
                .body(credentials)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                .extract().response().detailedCookies();
    }

    @Test
    public void createLocation(){
        PojoLocation body=new PojoLocation();
        body.setCapacity("100");
        body.setName("INTERNATIONAL POLITICS");
        body.setShortName("1808");
        body.setType("CLASS");
        School school=new School();
        school.setId("5c5aa8551ad17423a4f6ef1d");
        body.setSchool(school);
        id = given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/school-service/api/location")
                .then()
                .statusCode(201)
                .extract().response().jsonPath().getString("id");
    }
    @Test(priority = 1)
    public void deleteLocation(){
        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .delete("/school-service/api/location/"+id)
                .then().statusCode(200);
    }
}
