package examenes.julio2016;

public class Ejemplo1 {
   
   public static void main(String[] args) {
       String[] valores = {"uno", "dos", "tres", "cuatro"};
       String concatenado = "";
        for(int i=0;i < valores.length;i++){
           concatenado = valores[i]+concatenado;
        }
       System.out.println(concatenado);
    }
}

