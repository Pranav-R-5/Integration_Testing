package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.List;

public class PaytmStepdefs {
    String baseUrl="https://apiproxy.paytm.com/v3/movies/search/movies";
    static String movieName="";
    List<String> movierecord;
    Response response;

    PaytmMovies movies=new PaytmMovies();


    @Given("user get all the movies from API endpoint")
    public void userGetAllTheMoviesFromAPIEndpoint() {
       response= movies.getMovies(baseUrl);
    }

    @When("user get the movie record which shows only in kannada language")
    public void userGetTheMovieRecordWhichShowsOnlyInKannadaLanguage() {
       movierecord= movies.movie(baseUrl);
       System.out.println(movieName);
    }

    @Then("I get the response as {int}")
    public void iGetTheResponseAs(int arg0) {
        movies.assertion(arg0,response);
    }


    @And("user get the movie name")
    public void userGetTheMovieName() {
        movieName=movies.movieName(movierecord);
    }
}
