package tareaSemana2;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

import com.servicios.SaludoBean;

@Stateless
public class CarritoDeSaludosBean implements CarritoDeSaludosBeanInterface {
	
	@EJB
	private SaludoBean saludoBean;
	
	private List<String> saludos = new ArrayList<String>();
	
	public void agregarSaludo(String saludo){
		saludoBean.saludar(saludo);
		saludos.add(saludo);
	}
	
	public List<String> obtenerSaludos(){
		return saludos;
	}
}
