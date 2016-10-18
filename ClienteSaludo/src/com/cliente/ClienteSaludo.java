package com.cliente;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.servicios.SaludoBeanRemote;

public class ClienteSaludo {

	public static void main(String[] args) throws NamingException{
        SaludoBeanRemote saludoBean = (SaludoBeanRemote) InitialContext.doLookup("ModuloEJB/SaludoBean!com.servicios.SaludoBeanRemote");
	
        System.out.println(saludoBean.saludar("mi nombre"));
        System.out.println("Excelente!");

	}

}
