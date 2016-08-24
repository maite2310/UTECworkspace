package prueba.ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class Principal {
    public static void main (String [] args) {
    	List<A> mi_lista= new LinkedList<A>();


    	A a1 = new A();
    	a1.nombre = "Juan";
		a1.bonificacion = 2;
		mi_lista.add(a1);
		
		A a2 = new A();
		a2.nombre = "Maria";
		a2.bonificacion = 1;
		mi_lista.add(a2);
		
		for (A a: mi_lista){
			System.out.println ( a.getSueldo(1, 10) );
		}

    }	
} 

