package semana2.tarea1;

public class Actividad1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Declaraci�n de las variables de tipo String
		String nombre;
		String apellido;
		
		// Declaraci�n de las variables de tipo n�mero entero
		int a;
		int b;
		int c;
		
		// Sentencia de asignaci�n
		// A la variable "nombre" declarada anteriormente le asigno un texto correspondiente a mi nombre
		// A la variable "apellido" declarada anteriormente le asigno un texto correspondiente a mi apellido

		nombre = "Valeria";
		apellido = "Cardozo";
		
		// Declaro la variable "nombreCompleto" y le asigno la cadena de texto resultado de la 
		// concatenaci�n de las variables "nombre" y "apellido"
		
		String nombreCompleto = nombre + " " + apellido;
		
		// Sentencia de asignaci�n
		// A la variable "a" le asigno el valor 380, a "b" el valor 200
		// y a la variable "c" le asigno la operaci�n de suma de las variables "a" y "b"
		
		a = 380;
		b = 200;
		c = a + b;
		
		// Impresiones en consola de los resultados de las operaciones realizadas
		System.out.println("Mi nombre es:" + nombreCompleto);
		System.out.println("La suma de a + b es:" + c);
			
		
	}

}
