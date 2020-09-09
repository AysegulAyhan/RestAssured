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
    public void createAccount(){
        PojoReplit body=new PojoReplit();
        body.setName("KittyBank");
        body.setIban("GS23 2424 2375 7");
        body.setCurrency("USD");
        body.setIntegrationCode("101165");
        body.setSchoolId("5c5aa8551ad17423a4f6ef1d");


        id = given()
                .cookies(cookies)
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("/school-service/api/bank-accounts")
                .then().statusCode(201)
                .extract().jsonPath().getString("id");
    }
    @Test(priority = 1)
    public void deleteAccount(){
      given()
              .cookies(cookies)
              .contentType(ContentType.JSON)
              .when()
              .delete("/school-service/api/bank-accounts/"+id)
              .then().statusCode(200);
    }

}
