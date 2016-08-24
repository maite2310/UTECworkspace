package semana6.ejComplementarios;

import org.omg.DynamicAny.DynAnyPackage.InvalidValueHelper;

public class Consultorio {

	private String numConsultorio;
	private String direccion;
	private String doctor;
	private Paciente [] pacientes = new Paciente [100];
	private int indiceUltimo =0;
	
	//Constructor por defecto
	public Consultorio (){
		
	}
	
	public Consultorio (String numero, String direccion, String doctor){
		this.numConsultorio= numero;
		this.direccion= direccion;
		this.doctor=doctor;
	}
	
	public String getNumConsultorio() {
		return numConsultorio;
	}
	public void setNumConsultorio(String numConsultorio) {
		this.numConsultorio = numConsultorio;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public Paciente[] getPacientes() {
		return pacientes;
	}
	public void setPacientes(Paciente[] pacientes) {
		this.pacientes = pacientes;
	}
	
	public void agregarPaciente (Paciente p){
		this.pacientes[indiceUltimo]=p;
		indiceUltimo++;
	}
	
	public Paciente[] listarPacientes (){
		Paciente[] ret= null;
		if (indiceUltimo>0){
			ret = new Paciente [indiceUltimo];
			for (int i=0; i<indiceUltimo; i++){
				ret [i]= pacientes[i];
			}
		}
		return ret;
	}
	
	

	
	
}
