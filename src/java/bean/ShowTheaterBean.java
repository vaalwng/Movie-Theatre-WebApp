/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.moviedbEJB;
import entity.Theater;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author Val Wong
 */
@Named(value = "showTheaterBean")
@SessionScoped
public class ShowTheaterBean implements Serializable {

    @EJB
    private moviedbEJB moviedbEJB;
    
    private String zipcode;
    
    public ShowTheaterBean() {
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    public String showTheater() {
        return "ShowTheater";
    }
    
    public List<Theater> getTheaterList() {
        return moviedbEJB.findTheatreByZipcode(zipcode);
    }
    
//    public String backToTheatreList() {
//        FacesContext fc = FacesContext.getCurrentInstance();
//        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
//        
//        String zip = params.get("zipcode");
//        zipcode = zip;
//
//        return "ShowTheatre";
//    }    
    
}