package semana3.teorico.enums;

public class PruebaEnum {
	 
    public enum TipoClase {
    	LENGUA, CIENCIA, MATEMATICA, SOCIAL
    }
    
    public static void main(String[] args) {
    	
    	TipoClase tc = TipoClase.valueOf("SOCIAL");
    	String tcName = tc.name();
    	
        TipoClase tipo1= TipoClase.LENGUA;
        TipoClase tipo2 = TipoClase.SOCIAL; 
                       
        if(tipo1.name().equals("LENGUA")){
        	System.out.println("Tipo Clase es LENGUA");
        }
        
        TipoClase tipo3 = TipoClase.valueOf("CIENCIA");
        
        System.out.println("La posición de LENGUA es:"+tipo1.ordinal());
        System.out.println("La posición de SOCIAL es:"+tipo2.ordinal());
    
        if(tipo2.compareTo(tipo1)>0){
        	System.out.println(tipo2 + " > " + tipo1);
        }
        
        if(tipo2!=tipo1){
        	System.out.println(tipo2+" es distinto de "+tipo1);
        }
        
        if(tipo2==TipoClase.SOCIAL){
        	System.out.println(tipo2+" es igual a "+TipoClase.SOCIAL);
        }
        
        String cadena = "SOCIAL";
        if(TipoClase.valueOf(cadena) == TipoClase.SOCIAL){
            System.out.println("Tipo Clase es "+TipoClase.SOCIAL.name());
        }       
        
        for(TipoClase tipo : TipoClase.values()){
            System.out.println(tipo);      
        }    
    }
}
