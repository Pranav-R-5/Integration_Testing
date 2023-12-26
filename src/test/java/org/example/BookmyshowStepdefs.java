package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookmyshowStepdefs {
    String basUrl="https://in.bookmyshow.com/explore/home/bengaluru";
    String movie= PaytmStepdefs.movieName;

    ChromeDriver driver=new ChromeDriver();
    BookmyShow bookmyShow=new BookmyShow();

    @Given("user navigate to bookmyshow")
    public void userNavigateToBookmyshow() {
        bookmyShow.navigate(driver,basUrl);
    }

    @When("user search the movie")
    public void userSearchTheMovie() {
        bookmyShow.searchMovie(driver,movie);
    }

    @And("user verify the movie")
    public void userVerifyTheMovie() {
        bookmyShow.verifyMovie(driver,movie);
    }

    @And("user select the movie from the screen")
    public void userSelectTheMovieFromTheScreen() {
        bookmyShow.selectMovie(driver,movie);
    }

    @And("user selects the fast filling show")
    public void userSelectsTheFastFillingShow() {
        bookmyShow.selectShow(driver);
    }

    @And("user selects the number of tickets")
    public void userSelectsTheNumberOfTickets() {
        bookmyShow.selectTicketQuantity(driver);
    }

    @Then("user prints the seats which has adjacent empty seats")
    public void userPrintsTheSeatsWhichHasAdjancentEmptySeats() {
        bookmyShow.seats(driver);
        driver.quit();
    }
}
