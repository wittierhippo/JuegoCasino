package InicioSesion;

//import Interfaz.panelJuego;
import Cliente.matraxRuleta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


    public class OyenteUsuario implements ActionListener{
    private Conexion conexion;
    private final Usuario login;
    private final JFrame frame;
    
    public OyenteUsuario(Usuario login, JFrame f){
        this.login = login;
        this.frame = f;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        if(boton.getName()=="iniciar"){
                try{
                    conexion = new Conexion();
                    String usuario = login.getTextUsuario().getText();
                    String password = new String(login.getTextPassword().getPassword());
                    conexion.enviarMensaje("Login " + usuario + " " + password);
                    String mensaje = conexion.recibirMensaje();
                    procesaMensaje(usuario, mensaje);
                }catch(IOException ex){
                    System.out.println(ex.getMessage());
                } catch (InterruptedException ex) {}
                }else{ 
		if("nuevo"==boton.getName()){
                System.out.println("Creando cuenta..");
                new crearCuenta().setVisible(true);
                }else{
            	if(boton.getName()=="cancelar"){
                System.exit(0);
                }
	    }
        }
    }
    
    private void procesaMensaje(String usuario, String mensaje) throws InterruptedException, IOException {

        switch(mensaje){
            case "OK":
                conexion = new Conexion();
                conexion.enviarMensaje("Tabla " + usuario);
                frame.setVisible(false);
                String creditos = conexion.recibirMensaje();
                matraxRuleta game = new matraxRuleta(usuario, creditos);
                game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                game.setSize(500, 600);
                game.setLocation(100, 100);
                game.setVisible(true);
                break;
            
            case "NotFound":
                JOptionPane.showMessageDialog(null, "No existe ese nombre de usuario");
                break;
            
            case "BadPassword":
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                break;
        }
    }
}