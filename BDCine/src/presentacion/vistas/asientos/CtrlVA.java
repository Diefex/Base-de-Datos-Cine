package presentacion.vistas.asientos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

public class CtrlVA implements ActionListener {
    
    private VistaAsientos vista;
    
    public CtrlVA (VistaAsientos vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton b = (JButton)ae.getSource();
        String asiento = b.getText();
        try {
            ResultSet result = vista.getModelo().select("num", "entrada", "asiento='"+asiento+"' and num_funcion="+vista.getNumFuncion());
            result.next();
            String numEntrada = result.getString("num");
            ArrayList<String> valores = new ArrayList<String>();
            valores.add("default");
            valores.add(numEntrada);
            valores.add("null");
            vista.getModelo().insert("reserva", valores);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlVA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
