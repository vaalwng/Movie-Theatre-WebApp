/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Movie;
import entity.Movieshowing;
import entity.Theater;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Val Wong
 */
@Stateless
public class moviedbEJB {

    @PersistenceContext(unitName = "MovieTheatreProjectPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public Theater getTheatre(int theatreid) {
        return em.createNamedQuery("Theater.findByTheatreid", Theater.class).getSingleResult();
    }

    public List<Theater> findTheatreByZipcode(String zipcode) {
        return em.createNamedQuery("Theater.findByZipcode", Theater.class).setParameter("zipcode", zipcode).getResultList();
    }

    public Collection<Movie> findMoviesForTheater(int theaterid) {
        Theater theater = em.find(Theater.class, theaterid);
        return theater.getMovieCollection();
    }

    public List<Movieshowing> findShowingsForMovie(int movieID, int theaterID) {
        return em.createNamedQuery("Movieshowing.findByMovieidAndTheaterid", Movieshowing.class).setParameter("movieid", movieID).setParameter("theaterid", theaterID).getResultList();
    }

    public double calculatePayment(int quantity) {
        return quantity * 10.00;
    }

}