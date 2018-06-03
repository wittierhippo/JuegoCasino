package InicioSesion;
import java.io.*;
import java.net.*;

public class Conexion{
    static final String host = "localhost";
    static final int puerto = 1234;
    private DataOutputStream salida;
    private DataInputStream entrada;
    
    public Conexion(){
        Socket socket = null;
        try{
            socket = new Socket(host, puerto);
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());
        }catch(Exception ex){
        }
    }
    
    public void enviarMensaje(String mensaje){
        try {
            getSalida().writeUTF(mensaje);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public String recibirMensaje() throws IOException{
        String mensaje = getFlujo().readUTF();
        return mensaje;
    }
    
    public DataOutputStream getSalida() {
        return salida;
    }

    public DataInputStream getFlujo() {
        return entrada;
    }
}
