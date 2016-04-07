/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.MessageFacade;
import entities.Message;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author adamvoight
 */
@Named(value = "MessageView")
@RequestScoped
public class MessageView {

    @EJB
    private MessageFacade messageFacade;
    
        private String message;

    /**
     * Get the value of message
     *
     * @return the value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the value of message
     *
     * @param message new value of message
     */
    public void setMessage(String message) {
        this.message = message;
    }
    public MessageFacade getMessageFacade(){
       return messageFacade;
    }

    // Returns the total number of messages
    public int getNumberOfMessages() {
        return messageFacade.findAll().size();
    }

    // Saves the message and then returns the string "theend"
    public String postMessage(){
       this.messageFacade.create(message);
       return "theend";
    }
    
    
}
