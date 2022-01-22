/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.moviedbEJB;
import entity.Movie;
import entity.Movieshowing;
import entity.Theater;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Val Wong
 */
@Named(value = "showMovieBean")
@SessionScoped
public class ShowMovieBean implements Serializable {

    @EJB
    private moviedbEJB moviedbEJB;

    private Theater theater;
    private Movie movie;
    private String time;

    public ShowMovieBean() {
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String showMovie(Theater theater) {
        this.theater = theater;
        return "ShowMovie";
    }

    public String showMovieDetail(Movie movie) {
        this.movie = movie;
        return "ShowMovieDetail";
    }
    
    public String showPayment(String time) {
        this.time = time;
        return "Payment";
    }

    public Collection<Movie> getMovieList() {
        if (theater != null) {
            return moviedbEJB.findMoviesForTheater(theater.getTheaterid());
        } else {
            return null;
        }
    }

    public String displayImage() {

        int movieID = movie.getMovieid();

        if (movieID == 1) {
            return "f9thefastsaga.jpg";
        } else if (movieID == 2) {
            return "hitmanswifesbodyguard.jpg";
        } else if (movieID == 3) {
            return "aquietplaceparttwo.jpg";
        } else if (movieID == 4) {
            return "cruella.jpg";
        } else if (movieID == 5) {
            return "blackwidow.jpg";
        } else if (movieID == 6) {
            return "thebossbaby.jpg";
        } else if (movieID == 7) {
            return "raya.jpg";
        } else if (movieID == 8) {
            return "demonslayer.jpg";
        } else if (movieID == 9) {
            return "thehousenextdoor.jpg";
        } else if (movieID == 10) {
            return "foreverpurge.jpg";
        } else {
            return "";
        }
    }

    public List<Movieshowing> getMovieShowTimes() {
        if (theater != null && movie != null) {
            return moviedbEJB.findShowingsForMovie(movie.getMovieid(), theater.getTheaterid());
        } else {
            return null;
        }
    }
    
}