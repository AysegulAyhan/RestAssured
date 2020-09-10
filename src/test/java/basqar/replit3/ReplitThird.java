package basqar.replit3;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ReplitThird {
 public Cookies cookies;
 private String id;


    @BeforeClass
    public  void init(){
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
    public void createGrade(){
        PojoGrade body=new PojoGrade();
        body.setActive(true);
        body.setName("annaE");
        body.setOrder("88");
        body.setShortName("96");
        id = given()
                .cookies(cookies)
                .body(body)
                .contentType(ContentType.JSON)
                .when().post("/school-service/api/grade-levels")
                .then()
                .statusCode(201)
                .extract().response().jsonPath().getString("id");
    }
    @Test(dependsOnMethods = "createGrade")
    public void updateGrade(){
        PojoGrade body=new PojoGrade();
        body.setName("whiteN");
        body.setShortName("664");
        body.setId(id);//PUT ICIN ID YI URIYE EKLEMEK HATALI, CUNKU MANUAL BAKILDIGINDA PUT METHODUNUN URISINDE ID YOK!
        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(body)
                .when().put("/school-service/api/grade-levels")
                .then()
                .statusCode(200);

    }
    @Test(dependsOnMethods = "createGrade")
    public void deleteGrade(){
        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when().delete("/school-service/api/grade-levels/"+id)
                .then()
                .statusCode(200);

    }
}
