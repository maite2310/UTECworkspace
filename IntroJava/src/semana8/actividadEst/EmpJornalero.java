package semana8.actividadEst;

//Clase Hija que crea objetos del Tipo Empleados Jornaleros, que hereda de la clase Empleado.

public class EmpJornalero extends Empleado {

	// Definimos los atributos propios de la clase
	private double valorHora;
	private double horasRealizadasMes;

	// ***** MÉTODO CONSTRUCTOR *****

	public EmpJornalero(String pNombre, String pApellido, int pNumeroBps, int pNumeroFuncionario, String pDireccion,
			String pTelefono, double pValorHora, double pHorasRealizadasMes) {
		super(pNombre, pApellido, pNumeroBps, pNumeroFuncionario, pDireccion, pTelefono);
		this.valorHora = pValorHora;
		this.horasRealizadasMes = pHorasRealizadasMes;
	}

	// **********************************

	// ***** MÉTODOS ACCESORES Y MODIFICADORES *****
	// Métodos públicos para asignar valor (SET) y obtener valor (GET) de las
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
	
	// HEREDA EL MÉTODO DE LA CLASE PADRE EMPLEADO Y SOBREESCRIBE EL CÁLCULO DEL SUELDO
	// PARA EL EMPLEADO JORNALERO
	public double getSueldo(){
		return this.valorHora * this.horasRealizadasMes;
	}
	
}
