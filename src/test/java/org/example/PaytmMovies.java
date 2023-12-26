package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.json.JSONObject;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PaytmMovies {

    public static Response getMovies(String url,String city){
        RestAssured.baseURI=url;
        Response response=given()
                .contentType(ContentType.JSON)
                .queryParam("city",city)
                .queryParam("mdp",1)
                .get()
                .then()
                .extract().response();
//        response.prettyPrint();
        return response;
    }

    public static List<Map<String, Object>> movies(Response response,String lang){
        JsonPath jsonPath=response.jsonPath();
        List<Map<String, Object>> movieRecord=jsonPath.get("data.groupedMovies.findAll { it.languageFormatGroups.lang[0] == '"+ lang +"' }");
        org.junit.Assert.assertTrue(movieRecord.size()>=1);
        return movieRecord;

    }


    public static String movieName(List<Map<String,Object>> movieRecord){
        List<String > movies=new ArrayList<>();
        for(Map<String,Object> map:movieRecord){
            movies.add(map.get("label").toString());
        }
        return movies.get(0);
    }

}
