package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class PaytmStepdefs {
    String baseUrl="https://apiproxy.paytm.com/v3/movies/search/movies?version=3&site_id=6&channel=HTML5&child_site_id=370";
    static String movieName="";
    List<Map<String,Object>> movierecord;
    Response response;

    PaytmMovies movies=new PaytmMovies();



    @Given("user get all the movies from API endpoint in city {string}")
    public void userGetAllTheMoviesFromAPIEndpointInCity(String city) {
        response= movies.getMovies(baseUrl,city);
    }

    @When("user get the movie record which shows only in {string} language")
    public void userGetTheMovieRecordWhichShowsOnlyInLanguage(String language) {
        movierecord= movies.movies(response,language);

    }


    @And("user get the movie name")
    public void userGetTheMovieName() {
        movieName=movies.movieName(movierecord);
        System.out.println(movieName);
    }
}
