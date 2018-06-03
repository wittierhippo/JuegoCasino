package InicioSesion;



public class Usuario extends javax.swing.JPanel {

    public Usuario() {
        initComponents();
    }
    
    public void addEventos(OyenteUsuario oyente){
        botonCancelar.addActionListener(oyente);
        botonIniciar.addActionListener(oyente);
        botonNuevaCuenta.addActionListener(oyente);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitulo = new javax.swing.JPanel();
        tituloLogin = new javax.swing.JLabel();
        panelDatos = new javax.swing.JPanel();
        labelUsuario = new javax.swing.JLabel();
        textUsuario = new javax.swing.JTextField();
        labelContrasena = new javax.swing.JLabel();
        textPassword = new javax.swing.JPasswordField();
        panelBotones = new javax.swing.JPanel();
        botonIniciar = new javax.swing.JButton();
        botonNuevaCuenta = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(146, 10, 8));
        setPreferredSize(new java.awt.Dimension(380, 150));
        setLayout(new java.awt.BorderLayout());

        panelTitulo.setBackground(getBackground());

        tituloLogin.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        tituloLogin.setForeground(new java.awt.Color(254, 254, 254));
        tituloLogin.setText("Iniciar sesión");
        panelTitulo.add(tituloLogin);

        add(panelTitulo, java.awt.BorderLayout.NORTH);

        panelDatos.setBackground(getBackground());
        panelDatos.setPreferredSize(new java.awt.Dimension(200, 80));
        panelDatos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        labelUsuario.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        labelUsuario.setForeground(new java.awt.Color(254, 254, 254));
        labelUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelUsuario.setText("Usuario:");
        labelUsuario.setPreferredSize(new java.awt.Dimension(100, 30));
        panelDatos.add(labelUsuario);

        textUsuario.setColumns(13);
        textUsuario.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        panelDatos.add(textUsuario);

        labelContrasena.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        labelContrasena.setForeground(new java.awt.Color(254, 254, 254));
        labelContrasena.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelContrasena.setText("Contraseña:");
        labelContrasena.setPreferredSize(new java.awt.Dimension(100, 30));
        panelDatos.add(labelContrasena);

        textPassword.setColumns(13);
        textPassword.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        panelDatos.add(textPassword);

        add(panelDatos, java.awt.BorderLayout.CENTER);

        panelBotones.setBackground(getBackground());
        panelBotones.setPreferredSize(new java.awt.Dimension(380, 40));

        botonIniciar.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        botonIniciar.setText("Iniciar Sesion");
        botonIniciar.setName("iniciar"); // NOI18N
        botonIniciar.setPreferredSize(new java.awt.Dimension(120, 30));
        panelBotones.add(botonIniciar);

        botonNuevaCuenta.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        botonNuevaCuenta.setText("Crear cuenta");
        botonNuevaCuenta.setName("nuevo"); // NOI18N
        botonNuevaCuenta.setPreferredSize(new java.awt.Dimension(120, 30));
        panelBotones.add(botonNuevaCuenta);

        botonCancelar.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        botonCancelar.setText("Cancelar");
        botonCancelar.setName("cancelar"); // NOI18N
        botonCancelar.setPreferredSize(new java.awt.Dimension(100, 30));
        panelBotones.add(botonCancelar);

        add(panelBotones, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonIniciar;
    private javax.swing.JButton botonNuevaCuenta;
    private javax.swing.JLabel labelContrasena;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JTextField textUsuario;
    private javax.swing.JLabel tituloLogin;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the textPassword
     */
    public javax.swing.JPasswordField getTextPassword() {
        return textPassword;
    }

    /**
     * @return the textUsuario
     */
    public javax.swing.JTextField getTextUsuario() {
        return textUsuario;
    }
}
