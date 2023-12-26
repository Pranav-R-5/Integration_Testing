package org.example;

import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BookmyShow {


    public void navigate(WebDriver driver,String url){

        driver.get(url);
        driver.manage().window().maximize();
        String title=driver.getTitle();
        Assert.assertTrue(title.equals("Movie Tickets, Plays, Sports, Events & Cinemas near Bengaluru - BookMyShow Bengaluru."));
    }

    public void searchMovie(WebDriver driver,String movie){
        System.out.println(movie);
        WebElement webElement=driver.findElement(By.id("2"));
        webElement.click();
        WebElement serachbox=driver.findElement(By.xpath("//input[@placeholder='Search for Movies, Events, Plays, Sports and Activities']"));
        serachbox.sendKeys(movie);

    }
    public void verifyMovie(WebDriver driver,String movie){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[@class='bwc__sc-1iyhybo-9 fMpEag']/div"))));
        String movieName=driver.findElement(By.xpath("//span[@class='bwc__sc-1iyhybo-13 kqrJYR']/strong")).getText();
        Assert.assertTrue(movieName.equals(movie));
//        driver.findElement(By.xpath("//li[@class='bwc__sc-1iyhybo-9 fMpEag']/div")).click();
    }

    public void selectMovie(WebDriver driver,String movieName){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> movies=driver.findElements(By.xpath("//span[@class='bwc__sc-3t17w7-45 bjOabr']/a"));
        for(WebElement movie:movies){
            if(movie.getText().equals(movieName)){
                movie.click();
                break;
            }
        }

    }

    public void selectShow(WebDriver driver){
//        List<WebElement> theatres=driver.findElements(By.xpath("//ul[@id='venuelist']/li/div[@class='body showtimes-details-container ']"));
//        List<WebElement> theatres=driver.findElements(By.xpath("//div[@class='showtime-pill-wrapper']"));
//        for (WebElement theatre :theatres){
           List<WebElement> fastsellingShows= driver.findElements(By.xpath("//a[@data-overall-avail-status='1']"));
           for(WebElement show:fastsellingShows){
               show.click();
               break;
           }
    }

    public void selectTicketQuantity(WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//div[@class='no-of-tickets no-of-tickets-button']/div"))));
//        driver.findElement(By.xpath("//div[@class='no-of-tickets no-of-tickets-button']/div")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@id='popQty']"))));
        driver.findElement(By.xpath("//ul[@id='popQty']/li")).click();
        WebElement selectSeats=driver.findElement(By.xpath("//div[@id='proceed-Qty']"));
        Assert.assertTrue(selectSeats.getText().equals("Select Seats"));
        selectSeats.click();
    }

    public void seats(WebDriver driver){
        List<WebElement> rows=driver.findElements(By.xpath("//tbody/tr"));

        for(WebElement row:rows){
            List<WebElement> data=row.findElements(By.tagName("td"));
            WebElement tableData=data.get(0).findElement(By.tagName("div"));
            if(tableData.getAttribute("class").equals("seatR Setrow1")) {
                String seat = tableData.findElement(By.tagName("div")).getText();
                List<WebElement> seats = data.get(1).findElements(By.tagName("div"));

                for(int i=1;i<seats.size()-1;i++){
                    try {
                        if (seats.get(i - 1).getAttribute("data-seat-type").equals("1") && seats.get(i + 1).getAttribute("data-seat-type").equals("1")) {
                            String seatNo = seats.get(i).findElement(By.tagName("a")).getText();
                            System.out.println(seat + seatNo);
                        }
                    }catch (Exception e){System.out.println("");}
                }
            }

        }
    }





}
