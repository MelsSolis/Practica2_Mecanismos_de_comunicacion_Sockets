import java.net.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class EchoObjectSkeleton implements EchoInterface {
    String myURL="localhost";
    //Constructor de la clase EchoObjectSkeleton
    public EchoObjectSkeleton()
    {
        try {
            // obtengo el nombre del equipo donde estoy ejecutando y lo guardo en la propiedad MyURL
            myURL=InetAddress.getLocalHost().getHostName();
        }catch (UnknownHostException e){
            // si no pude conocer el nombre del equipo, mantengo el nombre localhost para MyURL
            myURL="localhost";
        }
    }
    
    public int pago(int cantidad_a_pagar, String tarjeta, String cvv)throws java.rmi.RemoteException{

        int saldo = (int) Math.floor(Math.random()*50000);
        int check=0;
        
        try{            
            if(tarjeta.length()==14||tarjeta.length()==16){    
                System.out.println("La tarjeta: "+ tarjeta + " SI existe");
                if(cvv.length()==3){
                    System.out.println("El CVV: "+cvv+" SI existe");
                    if(saldo>=cantidad_a_pagar){
                        System.out.println("Saldo en tarjeta: "+ (saldo) + "\nPago aceptado.");
                        check = 1;
                    }else{
                        System.out.println("Saldo en tarjeta: "+ (saldo) + "\nPago denegado.");
                    }
                }else{
                    System.out.println("El CVV: "+cvv+" NO existe");
                }
            }else{
                System.out.println("La tarjeta: "+ tarjeta + " NO existe");
            }                
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return check;
    }
    
}