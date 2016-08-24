package semana7.tareaEstudiantes;

public class Persona {
		
		private String nombre;
		private String ci;
		private String credencial;
		private String paisDeOrigen;
		private boolean habilitado;
		
		public Persona() {
			this.nombre = "";
			this.ci = "";
			this.credencial = "";
			this.paisDeOrigen = "";
			this.habilitado = false;
		}
		
		public Persona(String nombre, String ci, String credencial, String paisDeOrigen, boolean habilitado){
			this.nombre = nombre;
			this.ci = ci;
			this.credencial = credencial;
			this.paisDeOrigen = paisDeOrigen;
			this.habilitado = habilitado;
						
		}
		
		public String getNombre() {
			return this.nombre;
		}
		
		public void setNombre (String nombre){
			this.nombre = nombre;
		}
		
		public String getCi(){
			return this.ci;
		}
		
		public void setCi(String ci){
			this.ci = ci;
		}
		
		public String getCredencial(){
			return this.credencial;
		}
		
		public void setCredencial(String credencial){
			this.credencial = credencial;
		}
		public String getPaisDeOrigen(){
			return this.paisDeOrigen;
		}
		
		public void setPaisDeOrigen(String paisDeOrigen){
			this.paisDeOrigen = paisDeOrigen;
		}
		
		public boolean getHabilitado(){
			return this.habilitado;			
		}
		
		public void setHabilitado(boolean habilitado){
			this.habilitado = habilitado;
		}
		
		
		public void puedeVotar(boolean habilitado) throws NoVotaException{
			if (habilitado == true && this.ci.length() == 8 && this.credencial.length() == 8) {
				
				System.out.println(this.nombre + " " + "Habilitado a Votar");
				
			}
			
			
			if (this.paisDeOrigen == "Uruguay" && this.credencial.isEmpty()){
					
					throw new NoVotaException ("Es de Uruguay y no tiene credencial");
					
				}	
				
				else if (this.paisDeOrigen != "Uruguay" && this.ci.isEmpty()){
					
					throw new NoVotaException("No puede votar");
				}
				
						
			if (habilitado == false) {System.out.println(this.nombre + " " +"No esta habilitado por el BPS");
			}
}
}

