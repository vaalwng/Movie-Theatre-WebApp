/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Val Wong
 */
@Embeddable
public class MovieshowingPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "SHOWINGID")
    private int showingid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "THEATERID")
    private int theaterid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOVIEID")
    private int movieid;

    public MovieshowingPK() {
    }

    public MovieshowingPK(int showingid, int theaterid, int movieid) {
        this.showingid = showingid;
        this.theaterid = theaterid;
        this.movieid = movieid;
    }

    public int getShowingid() {
        return showingid;
    }

    public void setShowingid(int showingid) {
        this.showingid = showingid;
    }

    public int getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(int theaterid) {
        this.theaterid = theaterid;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) showingid;
        hash += (int) theaterid;
        hash += (int) movieid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovieshowingPK)) {
            return false;
        }
        MovieshowingPK other = (MovieshowingPK) object;
        if (this.showingid != other.showingid) {
            return false;
        }
        if (this.theaterid != other.theaterid) {
            return false;
        }
        if (this.movieid != other.movieid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MovieshowingPK[ showingid=" + showingid + ", theaterid=" + theaterid + ", movieid=" + movieid + " ]";
    }
    
}
