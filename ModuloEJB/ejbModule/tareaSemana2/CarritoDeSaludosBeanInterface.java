package tareaSemana2;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface CarritoDeSaludosBeanInterface {

	void agregarSaludo(String saludo);
	
	 List<String> obtenerSaludos();
}
