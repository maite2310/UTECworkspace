package semana7.actividad;

public class Persona {
	private String nombre;
	private String ci;
	private String credencial;
	private String paisOrigen;
	private boolean habilitado;
	
	
	Persona(String nombre, String ci, String credencial, String paisOrigen, boolean habilitado){
		this.nombre = nombre;
		this.ci = ci;
		this.credencial = credencial;
		this.paisOrigen = paisOrigen;
		this.habilitado = habilitado;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getCredencial() {
		return credencial;
	}
	public void setCredencial(String credencial) {
		this.credencial = credencial;
	}
	public String getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	
	public void puedeVotar() throws NoVotaException{
		if(!this.habilitado){
			throw new NoVotaException("No puede votar: No esta habilitado por el BPS");
		}
		else{
			if(this.credencial.isEmpty() && paisOrigen.equals("Uruguay")){
				throw new NoVotaException("No puede votar: Es de uruguay y no tiene credencial");
			}
			else if(!paisOrigen.equals("Uruguay") && this.ci.isEmpty() ){
				throw new NoVotaException("No puede votar: No es de uruguay y no tiene ci");
			}
		}
	}
	
}
