package semana8.actividadEst;

// Clase Hija que crea objetos del Tipo Empleados Mensuales, que hereda de la clase Empleado.

public class EmpMensual extends Empleado {

	// Definimos los atributos propios de la clase
	private double salarioMensual;
	private String tipoRegimen;

	// ***** M�TODO CONSTRUCTOR *****

	public EmpMensual(String pNombre, String pApellido, int pNumeroBps, int pNumeroFuncionario, String pDireccion,
			String pTelefono, double pSalarioMensual, String pTipoRegimen) {
		// Invoca al constructor de la clase padre: Empleado
		super(pNombre, pApellido, pNumeroBps, pNumeroFuncionario, pDireccion, pTelefono);
		this.salarioMensual = pSalarioMensual;
		this.tipoRegimen = pTipoRegimen;
	}

	// **********************************

	// ***** M�TODOS ACCESORES Y MODIFICADORES *****
	// M�todos p�blicos para asignar valor (SET) y obtener valor (GET) de las
	// variables privadas
	
	public double getSalarioMensual() {
		return salarioMensual;
	}

	public void setSalarioMensual(double salarioMensual) {
		this.salarioMensual = salarioMensual;
	}

	public String getTipoRegimen() {
		return tipoRegimen;
	}

	public void setTipoRegimen(String tipoRegimen) {
		this.tipoRegimen = tipoRegimen;
	}

	// *********************************************
	
	// HEREDA EL M�TODO DE LA CLASE PADRE EMPLEADO Y SOBREESCRIBE EL C�LCULO DEL SUELDO
	// PARA EL EMPLEADO MENSUAL
	public double getSueldo(){
		return this.salarioMensual;
	}
}
