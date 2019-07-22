package presentacion.vistas.asientos;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JPanel;
import presentacion.Modelo;

public class VistaAsientos extends javax.swing.JFrame {

    private Modelo modelo;
    private CtrlVA ctrl;
    private String numFuncion;
    private final int TAMBTN = 60;
    private ArrayList<JButton> btnsAsientos = new ArrayList<JButton>();
    private int tamX = 0, tamY = 0;

    public VistaAsientos(Modelo modelo, ArrayList<String> asientos, ArrayList<String> vendidas, String numFuncion) {
        this.modelo = modelo;
        this.ctrl = new CtrlVA(this);
        this.numFuncion = numFuncion;
        if (asientos.size() > 0) {
            Collections.sort(asientos);
            char a = asientos.get(0).charAt(0);
            int x = 10, y = 55;
            int fila = 0;
            for (int i=0; i<asientos.size(); i++) {
                if (asientos.get(i).charAt(0) != a) {
                    if (tamX < x) {
                        tamX = x;
                    }
                    x = 10;
                    y += TAMBTN;
                    a = asientos.get(i).charAt(0);
                }
                JButton btn = new JButton(asientos.get(i));
                for(String vendida : vendidas){
                    if(asientos.get(i).equalsIgnoreCase(vendida)){
                        btn.setEnabled(false);
                    }
                }
                btn.setBounds(x, y, TAMBTN, TAMBTN);
                btn.addActionListener(ctrl);
                btnsAsientos.add(btn);
                this.add(btn);
                fila++;
                x += TAMBTN;
                tamY = y + TAMBTN + 10;
            }
        }
        this.setUndecorated(true);
        initComponents();
        this.setSize(tamX, tamY);
        this.setLocationRelativeTo(null);
    }

    public String getNumFuncion() {
        return numFuncion;
    }

    public Modelo getModelo() {
        return modelo;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PANTALLA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(243, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
