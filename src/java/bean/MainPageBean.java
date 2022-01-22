/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.moviedbEJB;
import entity.Theater;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Val Wong
 */
@Named(value = "mainPageBean")
@RequestScoped
public class MainPageBean {

    @EJB
    private moviedbEJB moviedbEJB;

    public MainPageBean() {
    }
    
    public void validateZipCode(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
        
        String zipcode = (String) value;
        
        List<Theater> temp = moviedbEJB.findTheatreByZipcode(zipcode);
        
        if(temp.isEmpty()) {
            FacesMessage message = new FacesMessage("Zip Code not registered within database. Note: 5-Digit Format. Ex. 75034 & 75056.");
            throw new ValidatorException(message);
        }
        
    }
    
}
