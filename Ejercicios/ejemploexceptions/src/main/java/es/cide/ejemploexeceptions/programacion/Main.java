package es.cide.ejemploexeceptions.programacion;

//41663903R
//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        int num1, num2;
        try{
            num1=0;
            num2=62/num1;
            System.out.println("Final del intento");
        }
        catch(ArithmeticException e){
            //imprime por consola el mensaje de excepcion
            e.printStackTrace();
            System.out.println("Error: no se puede dividir por 0");
        }
        finally{
            System.out.println("Fin");
        }
    }
}