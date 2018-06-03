package Cliente;

import InicioSesion.Conexion;
import java.awt.Color;
import java.util.Random;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class matraxRuleta extends javax.swing.JFrame {

    private final ImageIcon icons[] = new ImageIcon[3];
    private final String images[] = {"dados.png", "cartas.png", "fichas.png"};
    private final Color colores[] = {new Color(132,176,217), new Color(223,124,165), new Color(114,241,92)};
    private final int indexes[] = new int[3];
    private final int giros[] = new int[3];
    Random random = new Random();
    Vector<JLabel> labels = new Vector<>();
    private final String user;
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCabecera = new javax.swing.JPanel();
        etiquetaCasino = new javax.swing.JLabel();
        panelImagenes = new javax.swing.JPanel();
        etiquetaImage1 = new javax.swing.JLabel();
        etiquetaImage2 = new javax.swing.JLabel();
        etiquetaImage3 = new javax.swing.JLabel();
        panelEtiquetas = new javax.swing.JPanel();
        panelCreditos = new javax.swing.JPanel();
        valorCreditos = new javax.swing.JLabel();
        etiquetaCreditos = new javax.swing.JLabel();
        panelApuesta = new javax.swing.JPanel();
        valorApuesta = new javax.swing.JLabel();
        etiquetaApuesta = new javax.swing.JLabel();
        panelBotones = new javax.swing.JPanel();
        botonInsertar = new javax.swing.JButton();
        botonRetirar = new javax.swing.JButton();
        botonApostar = new javax.swing.JButton();
        botonJugar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Juego de Casino");
        setBackground(new java.awt.Color(1, 1, 1));
        setPreferredSize(new java.awt.Dimension(450, 555));
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        panelCabecera.setBackground(new java.awt.Color(146, 10, 8));
        panelCabecera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 253, 2), 5));
        panelCabecera.setPreferredSize(new java.awt.Dimension(400, 100));
        panelCabecera.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));

        etiquetaCasino.setBackground(panelCabecera.getBackground());
        etiquetaCasino.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        etiquetaCasino.setForeground(new java.awt.Color(254, 254, 254));
        etiquetaCasino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaCasino.setText("C A S I N O");
        etiquetaCasino.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 244, 0), 5, true));
        etiquetaCasino.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        etiquetaCasino.setOpaque(true);
        etiquetaCasino.setPreferredSize(new java.awt.Dimension(370, 80));
        panelCabecera.add(etiquetaCasino);

        getContentPane().add(panelCabecera);

        panelImagenes.setBackground(new java.awt.Color(146, 10, 8));
        panelImagenes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 253, 2), 5));
        panelImagenes.setPreferredSize(new java.awt.Dimension(400, 170));

        etiquetaImage1.setBackground(new java.awt.Color(132, 176, 217));
        etiquetaImage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/dados.png"))); // NOI18N
        etiquetaImage1.setOpaque(true);
        panelImagenes.add(etiquetaImage1);

        etiquetaImage2.setBackground(new java.awt.Color(223, 124, 165));
        etiquetaImage2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cartas.png"))); // NOI18N
        etiquetaImage2.setOpaque(true);
        panelImagenes.add(etiquetaImage2);

        etiquetaImage3.setBackground(new java.awt.Color(114, 241, 92));
        etiquetaImage3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fichas.png"))); // NOI18N
        etiquetaImage3.setOpaque(true);
        panelImagenes.add(etiquetaImage3);

        getContentPane().add(panelImagenes);

        panelEtiquetas.setBackground(new java.awt.Color(0, 0, 0));
        panelEtiquetas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 253, 2), 5));
        panelEtiquetas.setPreferredSize(new java.awt.Dimension(400, 100));
        panelEtiquetas.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));

        panelCreditos.setBackground(panelEtiquetas.getBackground());
        panelCreditos.setPreferredSize(new java.awt.Dimension(180, 80));

        valorCreditos.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        valorCreditos.setForeground(new java.awt.Color(254, 254, 254));
        valorCreditos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorCreditos.setText("1000");
        valorCreditos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(243, 253, 2), 3, true));
        valorCreditos.setPreferredSize(new java.awt.Dimension(150, 40));
        panelCreditos.add(valorCreditos);

        etiquetaCreditos.setBackground(etiquetaCreditos.getBackground());
        etiquetaCreditos.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        etiquetaCreditos.setForeground(new java.awt.Color(254, 254, 254));
        etiquetaCreditos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaCreditos.setText("CRÉDITOS");
        etiquetaCreditos.setPreferredSize(new java.awt.Dimension(150, 30));
        panelCreditos.add(etiquetaCreditos);

        panelEtiquetas.add(panelCreditos);

        panelApuesta.setBackground(panelEtiquetas.getBackground());
        panelApuesta.setPreferredSize(new java.awt.Dimension(180, 80));

        valorApuesta.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        valorApuesta.setForeground(new java.awt.Color(254, 254, 254));
        valorApuesta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorApuesta.setText("0");
        valorApuesta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(243, 253, 2), 3, true));
        valorApuesta.setPreferredSize(new java.awt.Dimension(150, 40));
        panelApuesta.add(valorApuesta);

        etiquetaApuesta.setBackground(etiquetaCreditos.getBackground());
        etiquetaApuesta.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        etiquetaApuesta.setForeground(new java.awt.Color(254, 254, 254));
        etiquetaApuesta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaApuesta.setText("APUESTA");
        etiquetaApuesta.setPreferredSize(new java.awt.Dimension(150, 30));
        panelApuesta.add(etiquetaApuesta);

        panelEtiquetas.add(panelApuesta);

        getContentPane().add(panelEtiquetas);

        panelBotones.setBackground(getBackground());
        panelBotones.setPreferredSize(new java.awt.Dimension(400, 90));
        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        botonInsertar.setBackground(panelBotones.getBackground());
        botonInsertar.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        botonInsertar.setForeground(new java.awt.Color(254, 254, 254));
        botonInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/boton2.png"))); // NOI18N
        botonInsertar.setText("Insertar");
        botonInsertar.setBorderPainted(false);
        botonInsertar.setContentAreaFilled(false);
        botonInsertar.setFocusPainted(false);
        botonInsertar.setFocusable(false);
        botonInsertar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonInsertar.setName("insertar"); // NOI18N
        botonInsertar.setPreferredSize(new java.awt.Dimension(90, 80));
        botonInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInsertarActionPerformed(evt);
            }
        });
        panelBotones.add(botonInsertar);

        botonRetirar.setBackground(panelBotones.getBackground());
        botonRetirar.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        botonRetirar.setForeground(new java.awt.Color(254, 254, 254));
        botonRetirar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/boton2.png"))); // NOI18N
        botonRetirar.setText("Retirar");
        botonRetirar.setBorderPainted(false);
        botonRetirar.setContentAreaFilled(false);
        botonRetirar.setFocusPainted(false);
        botonRetirar.setFocusable(false);
        botonRetirar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonRetirar.setName("retirar"); // NOI18N
        botonRetirar.setPreferredSize(new java.awt.Dimension(90, 80));
        botonRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRetirarActionPerformed(evt);
            }
        });
        panelBotones.add(botonRetirar);

        botonApostar.setBackground(panelBotones.getBackground());
        botonApostar.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        botonApostar.setForeground(new java.awt.Color(254, 254, 254));
        botonApostar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/boton2.png"))); // NOI18N
        botonApostar.setText("Apuesta");
        botonApostar.setBorderPainted(false);
        botonApostar.setContentAreaFilled(false);
        botonApostar.setFocusPainted(false);
        botonApostar.setFocusable(false);
        botonApostar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonApostar.setName("apostar"); // NOI18N
        botonApostar.setPreferredSize(new java.awt.Dimension(90, 80));
        botonApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonApostarActionPerformed(evt);
            }
        });
        panelBotones.add(botonApostar);

        botonJugar.setBackground(panelBotones.getBackground());
        botonJugar.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        botonJugar.setForeground(new java.awt.Color(254, 254, 254));
        botonJugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/boton2.png"))); // NOI18N
        botonJugar.setText("Jugar");
        botonJugar.setBorderPainted(false);
        botonJugar.setContentAreaFilled(false);
        botonJugar.setFocusPainted(false);
        botonJugar.setFocusable(false);
        botonJugar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonJugar.setName("jugar"); // NOI18N
        botonJugar.setPreferredSize(new java.awt.Dimension(90, 80));
        botonJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonJugarActionPerformed(evt);
            }
        });
        panelBotones.add(botonJugar);

        getContentPane().add(panelBotones);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonApostarActionPerformed
        String apuesta = JOptionPane.showInputDialog("Introduce la apuesta: ");
        if(apuesta != null)
             valorApuesta.setText(apuesta);
        else valorApuesta.setText("0");
    }//GEN-LAST:event_botonApostarActionPerformed

    private void botonInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInsertarActionPerformed
        String creditos = JOptionPane.showInputDialog("Ingresar créditos:");
        if(creditos == null)
            return;
        
        int total = Integer.parseInt(creditos);
        int nuevoTotal = Integer.parseInt(this.valorCreditos.getText());
        nuevoTotal += total;
        Conexion cliente = new Conexion();
        cliente.enviarMensaje("actualizaCreditos " + user + " " + nuevoTotal);
        valorCreditos.setText(Integer.toString(nuevoTotal));
    }//GEN-LAST:event_botonInsertarActionPerformed

    private void botonRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRetirarActionPerformed
        String reclamar = JOptionPane.showInputDialog("Retirar créditos:");
        
        if(reclamar == null)
            return;
        
        int retirar = Integer.parseInt(reclamar);
        int creditos = Integer.parseInt(valorCreditos.getText());

        if(retirar > creditos){
            JOptionPane.showOptionDialog(null, "No cuenta con suficientes créditos", "", 
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        }else{
            creditos -= retirar;
            valorCreditos.setText(creditos + "");
            Conexion cliente = new Conexion();
            cliente.enviarMensaje("actualizaCreditos " + user + " " + creditos);
        }
    }//GEN-LAST:event_botonRetirarActionPerformed

    private void botonJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonJugarActionPerformed
        
        int apuesta = Integer.parseInt(valorApuesta.getText());
        int creditos = Integer.parseInt(valorCreditos.getText());
        if(creditos >= apuesta){
            jugar();
        }else{
            JOptionPane.showMessageDialog(null, "Necesita mas creditos para jugar.");
        }
    }//GEN-LAST:event_botonJugarActionPerformed
public matraxRuleta(String user, String creditos) {
        getContentPane().setBackground(Color.BLACK);
        initComponents();
        this.user = user;
        this.valorCreditos.setText(creditos);
        
        for(int i=0; i<3; i++){
            indexes[i] = -1;
            icons[i] = (new ImageIcon(this.getClass().getResource("/resources/" + images[i])));
        }
        
        labels.add(etiquetaImage1);
        labels.add(etiquetaImage2);
        labels.add(etiquetaImage3);
        
    }
    
    public void jugar(){
        for(int i=0; i<3; i++)
            giros[i] = random.nextInt((50 - 20) + 1) + 20;
        
        Timer timer = new Timer(100, null);
        timer.addActionListener((e) -> {
            
            boolean band = true;
            
            for(int i=0; i<3; i++){
                if(giros[i] == 0)
                    continue;
                band = false;
                giros[i]--;
                indexes[i] = (indexes[i] + 1) % 3;
                labels.get(i).setIcon(icons[indexes[i]]);
                labels.get(i).setBackground(colores[indexes[i]]);
            }
            
            if(band){
                checarResultado();
                timer.stop();
            }
            else timer.restart();
        });

        timer.start();
    }
    
    public void checarResultado(){
        
        int apuesta  = Integer.parseInt(valorApuesta.getText());
        int creditos = Integer.parseInt(valorCreditos.getText());
        Conexion cliente = new Conexion();
        
        if(indexes[0] == indexes[1] && indexes[1] == indexes[2]){
            apuesta *= 2;
            creditos += apuesta;
            cliente.enviarMensaje("NuevoJuego " + user + " " + creditos + " Gana");
        }
        else if(indexes[0] == indexes[1] || indexes[0] == indexes[2] || indexes[1] == indexes[2]){
            apuesta /= 2;
            creditos += apuesta;
            cliente.enviarMensaje("NuevoJuego " + user + " " + creditos + " Gana");
        }
        else {
            creditos -= apuesta;
            cliente.enviarMensaje("NuevoJuego " + user + " " + creditos + " Pierde");
        }
        valorCreditos.setText(Long.toString(creditos));
        cliente = new Conexion();
        cliente.enviarMensaje("actualizaCreditos " + user + " " + creditos);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(matraxRuleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(matraxRuleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(matraxRuleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(matraxRuleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new matraxRuleta("Lupita", "0").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonApostar;
    private javax.swing.JButton botonInsertar;
    private javax.swing.JButton botonJugar;
    private javax.swing.JButton botonRetirar;
    private javax.swing.JLabel etiquetaApuesta;
    private javax.swing.JLabel etiquetaCasino;
    private javax.swing.JLabel etiquetaCreditos;
    private javax.swing.JLabel etiquetaImage1;
    private javax.swing.JLabel etiquetaImage2;
    private javax.swing.JLabel etiquetaImage3;
    private javax.swing.JPanel panelApuesta;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCabecera;
    private javax.swing.JPanel panelCreditos;
    private javax.swing.JPanel panelEtiquetas;
    private javax.swing.JPanel panelImagenes;
    private javax.swing.JLabel valorApuesta;
    private javax.swing.JLabel valorCreditos;
    // End of variables declaration//GEN-END:variables
}
