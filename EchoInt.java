public interface EchoInt extends java.rmi.Remote 
{
    public int pago(int cantidad_a_pagar, String tarjeta, String cvv)throws java.rmi.RemoteException;
}