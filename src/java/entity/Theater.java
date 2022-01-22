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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "THEATER")
@NamedQueries({
    @NamedQuery(name = "Theater.findAll", query = "SELECT t FROM Theater t"),
    @NamedQuery(name = "Theater.findByTheaterid", query = "SELECT t FROM Theater t WHERE t.theaterid = :theaterid"),
    @NamedQuery(name = "Theater.findByTheatername", query = "SELECT t FROM Theater t WHERE t.theatername = :theatername"),
    @NamedQuery(name = "Theater.findByAddress", query = "SELECT t FROM Theater t WHERE t.address = :address"),
    @NamedQuery(name = "Theater.findByZipcode", query = "SELECT t FROM Theater t WHERE t.zipcode = :zipcode")})
public class Theater implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "THEATERID")
    private Integer theaterid;
    @Size(max = 50)
    @Column(name = "THEATERNAME")
    private String theatername;
    @Size(max = 50)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 5)
    @Column(name = "ZIPCODE")
    private String zipcode;
    @JoinTable(name = "THEATERMOVIES", joinColumns = {
        @JoinColumn(name = "THEATERID", referencedColumnName = "THEATERID")}, inverseJoinColumns = {
        @JoinColumn(name = "MOVIEID", referencedColumnName = "MOVIEID")})
    @ManyToMany
    private Collection<Movie> movieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theater")
    private Collection<Movieshowing> movieshowingCollection;

    public Theater() {
    }

    public Theater(Integer theaterid) {
        this.theaterid = theaterid;
    }

    public Integer getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(Integer theaterid) {
        this.theaterid = theaterid;
    }

    public String getTheatername() {
        return theatername;
    }

    public void setTheatername(String theatername) {
        this.theatername = theatername;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Collection<Movie> getMovieCollection() {
        return movieCollection;
    }

    public void setMovieCollection(Collection<Movie> movieCollection) {
        this.movieCollection = movieCollection;
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
        hash += (theaterid != null ? theaterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theater)) {
            return false;
        }
        Theater other = (Theater) object;
        if ((this.theaterid == null && other.theaterid != null) || (this.theaterid != null && !this.theaterid.equals(other.theaterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Theater[ theaterid=" + theaterid + " ]";
    }
    
}
