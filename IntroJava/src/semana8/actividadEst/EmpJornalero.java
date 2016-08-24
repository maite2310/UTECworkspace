package semana8.actividadEst;

//Clase Hija que crea objetos del Tipo Empleados Jornaleros, que hereda de la clase Empleado.

public class EmpJornalero extends Empleado {

	// Definimos los atributos propios de la clase
	private double valorHora;
	private double horasRealizadasMes;

	// ***** M�TODO CONSTRUCTOR *****

	public EmpJornalero(String pNombre, String pApellido, int pNumeroBps, int pNumeroFuncionario, String pDireccion,
			String pTelefono, double pValorHora, double pHorasRealizadasMes) {
		super(pNombre, pApellido, pNumeroBps, pNumeroFuncionario, pDireccion, pTelefono);
		this.valorHora = pValorHora;
		this.horasRealizadasMes = pHorasRealizadasMes;
	}

	// **********************************

	// ***** M�TODOS ACCESORES Y MODIFICADORES *****
	// M�todos p�blicos para asignar valor (SET) y obtener valor (GET) de las
	// variables privadas

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public double getHorasRealizadasMes() {
		return horasRealizadasMes;
	}

	public void setHorasRealizadasMes(double horasRealizadasMes) {
		this.horasRealizadasMes = horasRealizadasMes;
	}
	
	// *********************************************
	
	// HEREDA EL M�TODO DE LA CLASE PADRE EMPLEADO Y SOBREESCRIBE EL C�LCULO DEL SUELDO
	// PARA EL EMPLEADO JORNALERO
	public double getSueldo(){
		return this.valorHora * this.horasRealizadasMes;
	}
	
}
