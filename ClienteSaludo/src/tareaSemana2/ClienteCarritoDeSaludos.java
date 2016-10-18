package tareaSemana2;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.servicios.SaludoBeanRemote;

public class ClienteCarritoDeSaludos {

	public static void main(String[] args)  throws NamingException {
		CarritoDeSaludosBeanInterface carritoDeSaludosBean = (CarritoDeSaludosBeanInterface) InitialContext.doLookup("ModuloEJB/CarritoDeSaludosBean!tareaSemana2.CarritoDeSaludosBeanInterface");
			
		  carritoDeSaludosBean.agregarSaludo("A");
		  carritoDeSaludosBean.agregarSaludo("B");
		  carritoDeSaludosBean.agregarSaludo("C");

	      List<String> saludos  = carritoDeSaludosBean.obtenerSaludos();
	      
	      for(String s : saludos){
	    	  System.out.println(s);
	      }
	        

	}

}
