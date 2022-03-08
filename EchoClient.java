import java.io.*;
import java.net.*;

public class EchoClient {
    //definimos el Stub del cliente
    private static EchoObjectStub ss;
    
    public static void main(String[] args){
        //revisamos que los argumentos para ejecutar el programa son correctos
        int pago;
        String tarjeta="";
        String cvv="";

        if (args.length<2) {
            System.out.println("Para ejecutar , hazlo en este formato: Echo <nombre o IP del Equipo> <numero de puerto>");
            System.exit(1);
        }
        //instanciamos el STUB
        ss = new EchoObjectStub();
        //le asignamos al STUB el puerto y nombre del equipo HOST (el nombre del servidor) 
        ss.setHostAndPort(args[0],Integer.parseInt(args[1]));
        
        try{  
        
            //preparo "apuntador" que es el lector de flujo para el teclado
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            
            //asigno a una variable y leo una linea del lector de flujo que leyo del teclado
            System.out.println("Digite los 14 o 16 numeros de su tarjeta: ");
            tarjeta=in.readLine();
            System.out.println("Digite los 3 numeros de su cvv: ");
            cvv=in.readLine();
            System.out.println("Digite la cantidad a pagar ($): ");
            pago=Integer.parseInt(in.readLine());
            
            //Invocar el stub con el metodo remoto echo e Imprimir .. 
            //por pantalla lo que regreso el metodo remoto echo
            if(ss.pago(pago,tarjeta,cvv)== 1)
                System.out.println("Pago Exitoso");
            else
                System.out.println("Pago Denegado");

        }catch (IOException e){
            System.err.println("Falla conexion de E/S con el host:"+args[0]);
        }
    }
}
