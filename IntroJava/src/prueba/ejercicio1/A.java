package prueba.ejercicio1;

public class A{
    public String nombre;
    public int bonificacion;

    public int getSueldo (int cantDias, int valorHora) {
    	return cantDias* valorHora * this.bonificacion;
    }	
} 