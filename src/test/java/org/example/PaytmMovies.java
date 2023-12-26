package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

public class PaytmMovies {

    public static Response getMovies(String url){
        RestAssured.baseURI=url;
        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .get("?version=3&site_id=6&channel=HTML5&child_site_id=370&city=bengaluru&mdp=1")
                .then()
                .extract().response();
        response.prettyPrint();
        org.junit.Assert.assertEquals(200,response.statusCode());
        return response;
    }


    public static List<String> movie(String url){
        RestAssured.baseURI = url;


        List<String> movieRecord = RestAssured.given()
                .when()
                .get("?version=3&site_id=6&channel=HTML5&child_site_id=370&city=bengaluru&mdp=1")
                .then()
                .extract()
                .path("data.groupedMovies.findAll { it.languageFormatGroups.lang[0] == 'Kannada' }.collect{it.toString()}");


        return movieRecord;
    }

    public static String movieName(List<String> movierecord){
        List<String> movies=new ArrayList<>();
        for(String s:movierecord){
            int index=s.indexOf("label:");
            int movieIndex=index+6;
            String movie="";
            while(s.charAt(movieIndex)!=','){
                movie+=s.charAt(movieIndex);
                movieIndex++;


            }
            movies.add(movie);
            System.out.println(movie);
        }
        return movies.get(0);
    }

    public void assertion(int statuscode,Response response){

        Assert.assertEquals(statuscode, response.statusCode());
    }




}
