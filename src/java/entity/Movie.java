/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Val Wong
 */
@Entity
@Table(name = "MOVIE")
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findByMovieid", query = "SELECT m FROM Movie m WHERE m.movieid = :movieid"),
    @NamedQuery(name = "Movie.findByMoviename", query = "SELECT m FROM Movie m WHERE m.moviename = :moviename"),
    @NamedQuery(name = "Movie.findByDescription", query = "SELECT m FROM Movie m WHERE m.description = :description"),
    @NamedQuery(name = "Movie.findByReleaseyear", query = "SELECT m FROM Movie m WHERE m.releaseyear = :releaseyear"),
    @NamedQuery(name = "Movie.findByRunningtime", query = "SELECT m FROM Movie m WHERE m.runningtime = :runningtime")})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOVIEID")
    private Integer movieid;
    @Size(max = 50)
    @Column(name = "MOVIENAME")
    private String moviename;
    @Size(max = 500)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 4)
    @Column(name = "RELEASEYEAR")
    private String releaseyear;
    @Column(name = "RUNNINGTIME")
    private Integer runningtime;
    @ManyToMany(mappedBy = "movieCollection")
    private Collection<Theater> theaterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private Collection<Movieshowing> movieshowingCollection;

    public Movie() {
    }

    public Movie(Integer movieid) {
        this.movieid = movieid;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseyear() {
        return releaseyear;
    }

    public void setReleaseyear(String releaseyear) {
        this.releaseyear = releaseyear;
    }

    public Integer getRunningtime() {
        return runningtime;
    }

    public void setRunningtime(Integer runningtime) {
        this.runningtime = runningtime;
    }

    public Collection<Theater> getTheaterCollection() {
        return theaterCollection;
    }

    public void setTheaterCollection(Collection<Theater> theaterCollection) {
        this.theaterCollection = theaterCollection;
    }

    public Collection<Movieshowing> getMovieshowingCollection() {
        return movieshowingCollection;
    }

    public void setMovieshowingCollection(Collection<Movieshowing> movieshowingCollection) {
        this.movieshowingCollection = movieshowingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieid != null ? movieid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.movieid == null && other.movieid != null) || (this.movieid != null && !this.movieid.equals(other.movieid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movie[ movieid=" + movieid + " ]";
    }
    
}
