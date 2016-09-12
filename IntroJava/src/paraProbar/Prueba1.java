package paraProbar;

import java.util.Date;

public class Prueba1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date1 = new Date(2016, 8, 30);
		long timestamp = date1.getTime();
		System.out.println(timestamp);
		
		Date date = new Date(2016, 9, 20);
		 timestamp = date.getTime();
		System.out.println(timestamp);
		
		 date = new Date(2017, 1, 2);
		 timestamp = date.getTime();
		System.out.println(timestamp);
		
		 date = new Date(2017, 2, 4);
		 timestamp = date.getTime();
		System.out.println(timestamp);
	}

}
