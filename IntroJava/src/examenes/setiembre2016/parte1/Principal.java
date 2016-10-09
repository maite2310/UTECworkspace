package examenes.setiembre2016.parte1;

import java.util.LinkedList;

public class Principal {

	public static void main(String[] args) {
		A a1 = new A();
		a1.detalle= "detalle 1";
		a1.horas = 3.5;
		
		A a2 = new A();
		a2.detalle= "detalle 2";
		a2.horas = 10.2;
		
		LinkedList<A> mi_lista = new LinkedList<A>();
		mi_lista.add(a1);
		mi_lista.add(a2);
		
		for(A a : mi_lista){
			System.out.println(a.getHorasTotal(6));
		}		
	}
}
