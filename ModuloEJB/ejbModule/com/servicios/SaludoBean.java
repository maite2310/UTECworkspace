package com.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SaludoBean
 */
@Stateless
@LocalBean
public class SaludoBean implements SaludoBeanRemote {

    /**
     * Default constructor. 
     */
    public SaludoBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String saludar(String nombre){
    	return "Hola "+ nombre;
    }

}
