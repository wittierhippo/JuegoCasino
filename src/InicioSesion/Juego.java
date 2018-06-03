package InicioSesion;

import javax.swing.*;

public class Juego {
    
    public static void main(String args[]){
        JFrame frame = new JFrame();
        Usuario login = new Usuario();
        OyenteUsuario oyente = new OyenteUsuario(login, frame);
        login.addEventos(oyente);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400, 400);
        frame.setSize(400, 200);
        frame.add(login);
        frame.setVisible(true);
    }    
    
}
