package Servidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author EL MATRAX
 */
public class interfazServidor extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    public interfazServidor() {
        initComponents();
        addEventos();
    }
    public class OyenteServidor implements ActionListener{
    private Connection conexion;
    private final interfazServidor interfaz;
    private final int PORT = 1234;
    
    public OyenteServidor(interfazServidor interfaz){
        this.interfaz = interfaz;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton boton = (JButton) ae.getSource();
        if("conectar".equals(boton.getName())){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/juegocasino?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
                System.out.println("Se ha establecido la conexión");
                new Hilo().start();
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("Error al conectar con la Base de Datos");
            }
        }
    }
    
    public class Hilo extends Thread {
        private DataInputStream entrada;
        private DataOutputStream salida;
        private String line [];
        
        @Override
        public void run(){
            try {
                ServerSocket servidor = new ServerSocket(PORT);
                Socket socket = null;
                while(true){
                    socket = servidor.accept();
                    entrada = new DataInputStream(socket.getInputStream());
                    salida = new DataOutputStream(socket.getOutputStream());

                    String mensaje = entrada.readUTF();
                    line = mensaje.split(" ");
                    switch (line[0]){
                        case "Login":
                            login();
                            break;
                        case "Tabla":
                            actualizaTabla();
                            break;
                        case "actualizaCreditos":
                            actualizaImporte();
                            break;
                        case "NuevoJuego":
                            actualizaJuegos();
                            break;
                        case "NuevaCuenta":
                            crearCuenta();
                            break;
                        case "Puntaje":
                            obtenerImporte();
                            break;
                    }
                    socket.close();
                }
            } catch (IOException | SQLException ex) {}

        }
        
        private void login() throws IOException {
            try {
                String consulta = "SELECT count(idJugador) FROM jugador WHERE usuario=\"" + line[1] + "\"";
                Statement query = conexion.createStatement();
                ResultSet resultado = query.executeQuery(consulta);
                int numRows = 0;
                if (resultado.next()) {
                    numRows = resultado.getInt(1);
                }
                
                if (numRows == 1) {
                    consulta = "SELECT password FROM jugador WHERE usuario=\"" + line[1] + "\"";
                    resultado = query.executeQuery(consulta);
                    String password = "";
                    if (resultado.next()) {
                        password = resultado.getString(1);
                    }

                    if (line[2].equals(password)) {
                        salida.writeUTF("OK");
                    } else {
                        salida.writeUTF("BadPassword");
                    }
                } else {
                    salida.writeUTF("NotFound");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        private void actualizaTabla() throws IOException, SQLException {
            
            String query;
            Statement st;
            ResultSet rs;
            DefaultTableModel modelo = (DefaultTableModel) interfaz.getTablaUsuarios().getModel();
            Object[] row = new Object[5];
            query = "SELECT usuario, creditos, juegos, ganados, perdidos FROM cuenta, jugador WHERE usuario = \""
                    + line[1] + "\" AND jugador.idCuenta = cuenta.idCuenta";
            st = conexion.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                for (int i = 0; i < 5; i++) {
                    row[i] = rs.getObject(i + 1);
                }
            }
            salida.writeUTF(Integer.toString((Integer) row[1]));
            modelo.addRow(row);
            interfaz.getTablaUsuarios().setModel(modelo);
        }
        
        private void actualizaImporte() {
            String query = "UPDATE cuenta SET creditos = " + line[2] + " WHERE idCuenta = "
                    + "(SELECT idCuenta FROM jugador WHERE usuario = \""
                    + line[1] + "\");";
            Statement st;
            try {
                st = conexion.createStatement();
                int r = st.executeUpdate(query);
                DefaultTableModel modelo = (DefaultTableModel) interfaz.getTablaUsuarios().getModel();
                int rows = modelo.getRowCount();
                for (int i = 0; i < rows; i++) {
                    String nombre = (String) modelo.getValueAt(i, 0);
                    if (nombre.equals(line[1])) {
                        modelo.setValueAt(line[2], i, 1);
                    }
                }
            } catch (SQLException ex) {}
        }
        
        private void actualizaJuegos() {
            String query;
            if (line[3].equals("Win")) {
                query = "UPDATE cuenta SET creditos = " + line[2] + ", ganados = ganados + 1, juegos = juegos + 1  WHERE idCuenta = "
                        + "(SELECT idCuenta FROM jugador WHERE usuario = \""
                        + line[1] + "\");";
            } else {
                query = "UPDATE cuenta SET creditos = " + line[2] + ", perdidos = perdidos + 1, juegos = juegos + 1 WHERE idCuenta = "
                        + "(SELECT idCuenta FROM jugador WHERE usuario = \""
                        + line[1] + "\");";
            }
            try {
                Statement st = conexion.createStatement();
                int r = st.executeUpdate(query);
                DefaultTableModel modelo = (DefaultTableModel) interfaz.getTablaUsuarios().getModel();
                int rows = modelo.getRowCount();
                for (int i = 0; i < rows; i++) {
                    String nombre = (String) modelo.getValueAt(i, 0);
                    int win = (int) modelo.getValueAt(i, 3);
                    int loss = (int) modelo.getValueAt(i, 4);
                    int juegos = (int) modelo.getValueAt(i, 2);
                    if (nombre.equals(line[1])) {
                        modelo.setValueAt(line[2], i, 1);
                        juegos++;
                        modelo.setValueAt(juegos, i, 2);
                        if (line[3].equals("Gana")) {
                            win++;
                            modelo.setValueAt(win, i, 3);
                        } else {
                            loss++;
                            modelo.setValueAt(loss, i, 4);
                        }
                    }
                }
            } catch (SQLException ex) {

            }
        }
        
        public void obtenerImporte() throws SQLException, IOException{
            
            String consulta = "SELECT idJugador FROM jugador WHERE nombreUsuario=\"" + line[1] + "\"";
            Statement query = conexion.createStatement();
            ResultSet resultado = query.executeQuery(consulta);
            int idJugador = 0;
            if (resultado.next()) {
                idJugador = resultado.getInt(1);
            }
            
            consulta = "SELECT puntaje FROM cuenta, cuentade, jugador WHERE jugador.idJugador = " + idJugador + " AND Jugador.idJugador = CuentaDe.idJugador AND Cuenta.idCuenta = CuentaDe.idCuenta;";
            query = conexion.createStatement();
            resultado = query.executeQuery(consulta);
            int importe = 0;
            if (resultado.next()) 
                importe = resultado.getInt(1);
            salida.writeUTF(importe + "");
        }
        
        private void crearCuenta() throws IOException{
            try {
                String consulta = "SELECT count(idJugador) FROM jugador WHERE usuario=\"" + line[1] + "\"";
                Statement query = conexion.createStatement();
                ResultSet resultado = query.executeQuery(consulta);
                int numRows = 0;
                if (resultado.next()) 
                    numRows = resultado.getInt(1);
                
                // Si el usuario existe
                if (numRows == 1) {
                    salida.writeUTF("Existe");
                } else {
                    
                    int r;
                    
                    consulta = "INSERT INTO cuenta(creditos, juegos, ganados, perdidos) VALUES(0, 0, 0, 0)";
                    query = conexion.createStatement();
                    r = query.executeUpdate(consulta);
                    
                    consulta = "SELECT idCuenta FROM cuenta;";
                    query = conexion.createStatement();
                    resultado = query.executeQuery(consulta);
                    int idCuenta = 0;
                    resultado.afterLast();
                    if(resultado.previous())
                        idCuenta = resultado.getInt(1);
                    consulta = "INSERT INTO jugador(usuario, password, idCuenta) VALUES(\"" +line[1]+"\", \""+ line[2]+"\", " +idCuenta +")";
                    r = query.executeUpdate(consulta);
                    if(r >= 1) 
                        salida.writeUTF("OK");
                    
                    
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
    
    public void addEventos(){
        OyenteServidor oyente = new OyenteServidor(this);
        jButton1.addActionListener(oyente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jTextField2 = new javax.swing.JTextField();
        panelServidor = new javax.swing.JPanel();
        etiquetaServidor = new javax.swing.JLabel();
        textoServidor = new javax.swing.JTextField();
        panelPuerto = new javax.swing.JPanel();
        etiquetaPuerto = new javax.swing.JLabel();
        textoPuerto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 320));
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        panelServidor.setPreferredSize(new java.awt.Dimension(200, 40));

        etiquetaServidor.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        etiquetaServidor.setText("Servidor :");
        panelServidor.add(etiquetaServidor);

        textoServidor.setEditable(false);
        textoServidor.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoServidor.setText("localhost");
        panelServidor.add(textoServidor);

        getContentPane().add(panelServidor);

        panelPuerto.setPreferredSize(new java.awt.Dimension(200, 40));

        etiquetaPuerto.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        etiquetaPuerto.setText("Puerto : ");
        panelPuerto.add(etiquetaPuerto);

        textoPuerto.setEditable(false);
        textoPuerto.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoPuerto.setText("1234");
        panelPuerto.add(textoPuerto);

        getContentPane().add(panelPuerto);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(480, 182));

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Importe", "Juegos", "Ganados", "Perdidos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        //tablaUsuarios.setMinimumSize(new java.awt.Dimension(75, 200));
        jScrollPane1.setViewportView(tablaUsuarios);

        getContentPane().add(jScrollPane1);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Conectar Servidor");
        jButton1.setName("conectar"); // NOI18N
        getContentPane().add(jButton1);

        pack();
    }// </editor-fold>                        

    public static void main(String args[]) {
        interfazServidor interfaz = new interfazServidor();
        interfaz.setVisible(true);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel etiquetaPuerto;
    private javax.swing.JLabel etiquetaServidor;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel panelPuerto;
    private javax.swing.JPanel panelServidor;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField textoPuerto;
    private javax.swing.JTextField textoServidor;
    // End of variables declaration                   

    /**
     * @return the tablaUsuarios
     */
    public javax.swing.JTable getTablaUsuarios() {
        return tablaUsuarios;
    }

    /**
     * @param tablaUsuarios the tablaUsuarios to set
     */
    public void setTablaUsuarios(javax.swing.JTable tablaUsuarios) {
        this.tablaUsuarios = tablaUsuarios;
    }
}
