package basqar.replit1;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ReplitOne {

    private Cookies cookies;

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
    public void createAccount(){
        PojoReplit body=new PojoReplit();
        body.setName("SumerBank");
        body.setIban("GS23 2424 2355 9");
        body.setCurrency("USD");
        body.setIntegrationCode("101101");
        body.setSchoolId("5c5aa8551ad17423a4f6ef1d");


        given()
                .cookies(cookies)
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("/school-service/api/bank-accounts")
                .then().statusCode(201);
    }

}
