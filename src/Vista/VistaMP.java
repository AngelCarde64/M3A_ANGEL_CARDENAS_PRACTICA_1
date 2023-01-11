package Vista;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

// Para que pueda se pueda cargar dentro del panel osea paneles dentro de otros
public class VistaMP extends javax.swing.JFrame {

    public VistaMP() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Practica En Clases #1 - PROMAGAMACION VISUAL - ANGEL CARDENAS");
    }

    public JButton getPersona_Button() {
        return Persona_Button;
    }

    public void setPersona_Button(JButton Persona_Button) {
        this.Persona_Button = Persona_Button;
    }

    public JMenuItem getjMenuItemCrearPersona() {
        return jMenuItemCrearPersona;
    }

    public void setjMenuItemCrearPersona(JMenuItem jMenuItemCrearPersona) {
        this.jMenuItemCrearPersona = jMenuItemCrearPersona;
    }

    public JDesktopPane getjDesktop() {
        return jDesktop;
    }

    public void setjDesktop(JDesktopPane jDesktop) {
        this.jDesktop = jDesktop;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktop = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        lblMensaje = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        Persona_Button = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        tlbAdd = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButtonFile = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButtonIMPRIMIR = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuPersonas = new javax.swing.JMenu();
        jMenuItemCrearPersona = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuProductos = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuVentas = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuReportes = new javax.swing.JMenu();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopLayout = new javax.swing.GroupLayout(jDesktop);
        jDesktop.setLayout(jDesktopLayout);
        jDesktopLayout.setHorizontalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopLayout.setVerticalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 0));

        lblMensaje.setForeground(new java.awt.Color(255, 255, 255));
        lblMensaje.setText("Tienda v1.1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(539, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMensaje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        jToolBar1.setRollover(true);

        Persona_Button.setBackground(new java.awt.Color(51, 51, 51));
        Persona_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/follow.png"))); // NOI18N
        Persona_Button.setBorder(null);
        Persona_Button.setBorderPainted(false);
        Persona_Button.setFocusable(false);
        Persona_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Persona_Button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(Persona_Button);
        jToolBar1.add(jSeparator4);

        tlbAdd.setBackground(new java.awt.Color(51, 51, 51));
        tlbAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ADD.png"))); // NOI18N
        tlbAdd.setToolTipText("Mantenimiento de Personas");
        tlbAdd.setBorder(null);
        tlbAdd.setBorderPainted(false);
        tlbAdd.setFocusable(false);
        tlbAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tlbAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(tlbAdd);
        jToolBar1.add(jSeparator3);

        jButtonFile.setBackground(new java.awt.Color(51, 51, 51));
        jButtonFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/FOLDER.png"))); // NOI18N
        jButtonFile.setBorder(null);
        jButtonFile.setBorderPainted(false);
        jButtonFile.setFocusable(false);
        jButtonFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButtonFile);
        jToolBar1.add(jSeparator2);

        jButtonIMPRIMIR.setBackground(new java.awt.Color(51, 51, 51));
        jButtonIMPRIMIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/IMPRIMIR.png"))); // NOI18N
        jButtonIMPRIMIR.setToolTipText("Imprimir el reporte");
        jButtonIMPRIMIR.setBorder(null);
        jButtonIMPRIMIR.setBorderPainted(false);
        jButtonIMPRIMIR.setFocusable(false);
        jButtonIMPRIMIR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonIMPRIMIR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonIMPRIMIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIMPRIMIRActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonIMPRIMIR);

        jMenuPersonas.setText("Personas");

        jMenuItemCrearPersona.setText("Crear Persona");
        jMenuItemCrearPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCrearPersonaActionPerformed(evt);
            }
        });
        jMenuPersonas.add(jMenuItemCrearPersona);

        jMenuItem4.setText("Reporte Personas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuPersonas.add(jMenuItem4);

        jMenuBar1.add(jMenuPersonas);

        jMenuProductos.setText("Productos");

        jMenuItem2.setText("Crear Producto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuProductos.add(jMenuItem2);

        jMenuBar1.add(jMenuProductos);

        jMenuVentas.setText("Ventas");

        jMenuItem1.setText("Tulas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuVentas.add(jMenuItem1);

        jMenuBar1.add(jMenuVentas);

        jMenuReportes.setText("Reportes");
        jMenuBar1.add(jMenuReportes);

        jMenuAyuda.setText("Ayuda");
        jMenuBar1.add(jMenuAyuda);

        jMenuSalir.setText("Salir");
        jMenuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktop)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSalirMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "¡Hasta la proxima!.",
                "Hasta la proxima pa", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }//GEN-LAST:event_jMenuSalirMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItemCrearPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCrearPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemCrearPersonaActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButtonIMPRIMIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIMPRIMIRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonIMPRIMIRActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Persona_Button;
    private javax.swing.JButton jButtonFile;
    private javax.swing.JButton jButtonIMPRIMIR;
    private javax.swing.JDesktopPane jDesktop;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItemCrearPersona;
    private javax.swing.JMenu jMenuPersonas;
    private javax.swing.JMenu jMenuProductos;
    private javax.swing.JMenu jMenuReportes;
    private javax.swing.JMenu jMenuSalir;
    private javax.swing.JMenu jMenuVentas;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JButton tlbAdd;
    // End of variables declaration//GEN-END:variables
}
