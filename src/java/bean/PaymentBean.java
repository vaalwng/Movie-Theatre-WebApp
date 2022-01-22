/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.moviedbEJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Val Wong
 */
@Named(value = "paymentBean")
@SessionScoped
public class PaymentBean implements Serializable {

    @EJB
    private moviedbEJB moviedbEJB;

    public PaymentBean() {
    }

    private int quantity;
    private String card;
    private String name;
    private String expMonth;
    private String expYear;
    private String cvv;
    private double total;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String  calculatePayment() {
        total = moviedbEJB.calculatePayment(quantity);
        return "ThankYou";
    }

    public void validateZipCode(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
        
        char ch;
        boolean hasAllNumbers = true;
        int digits = 0;
        
        String cardNumber = (String) value;
        
        for(int i = 0; i < cardNumber.length(); i++) {
            ch = cardNumber.charAt(i);
            if(Character.isLetter(ch)) {
                hasAllNumbers = false;
            }
            digits++;
        }
               
        if((hasAllNumbers==false) || (digits!=16)) {
            FacesMessage message = new FacesMessage("Invalid Credit Card Number. Note: 16-Digit Format.");
            throw new ValidatorException(message);
        }
        
    }    
    
}