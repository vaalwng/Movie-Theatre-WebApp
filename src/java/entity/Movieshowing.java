/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Val Wong
 */
@Entity
@Table(name = "MOVIESHOWING")
@NamedQueries({
    @NamedQuery(name = "Movieshowing.findAll", query = "SELECT m FROM Movieshowing m"),
    @NamedQuery(name = "Movieshowing.findByShowingid", query = "SELECT m FROM Movieshowing m WHERE m.movieshowingPK.showingid = :showingid"),
    @NamedQuery(name = "Movieshowing.findByTheaterid", query = "SELECT m FROM Movieshowing m WHERE m.movieshowingPK.theaterid = :theaterid"),
    @NamedQuery(name = "Movieshowing.findByMovieid", query = "SELECT m FROM Movieshowing m WHERE m.movieshowingPK.movieid = :movieid"),
    @NamedQuery(name = "Movieshowing.findByShowtime", query = "SELECT m FROM Movieshowing m WHERE m.showtime = :showtime"),
    @NamedQuery(name = "Movieshowing.findByMovieidAndTheaterid", query = "SELECT m FROM Movieshowing m WHERE m.movieshowingPK.movieid = :movieid and m.movieshowingPK.theaterid = :theaterid")})
public class Movieshowing implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MovieshowingPK movieshowingPK;
    @Size(max = 7)
    @Column(name = "SHOWTIME")
    private String showtime;
    @JoinColumn(name = "MOVIEID", referencedColumnName = "MOVIEID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Movie movie;
    @JoinColumn(name = "THEATERID", referencedColumnName = "THEATERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Theater theater;

    public Movieshowing() {
    }

    public Movieshowing(MovieshowingPK movieshowingPK) {
        this.movieshowingPK = movieshowingPK;
    }

    public Movieshowing(int showingid, int theaterid, int movieid) {
        this.movieshowingPK = new MovieshowingPK(showingid, theaterid, movieid);
    }

    public MovieshowingPK getMovieshowingPK() {
        return movieshowingPK;
    }

    public void setMovieshowingPK(MovieshowingPK movieshowingPK) {
        this.movieshowingPK = movieshowingPK;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieshowingPK != null ? movieshowingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movieshowing)) {
            return false;
        }
        Movieshowing other = (Movieshowing) object;
        if ((this.movieshowingPK == null && other.movieshowingPK != null) || (this.movieshowingPK != null && !this.movieshowingPK.equals(other.movieshowingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movieshowing[ movieshowingPK=" + movieshowingPK + " ]";
    }
    
}
