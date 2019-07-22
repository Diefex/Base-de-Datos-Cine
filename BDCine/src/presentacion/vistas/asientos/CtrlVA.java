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
    private ArrayList vendidos;
    
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
            ArrayList<String> campos = new ArrayList<String>();
            ArrayList<String> condiciones = new ArrayList<String>();
            campos.add("vendida=true");
            condiciones.add("asiento='"+asiento+"'");
            vista.getModelo().update("entrada", campos, condiciones);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlVA.class.getName()).log(Level.SEVERE, null, ex);
        }
        vista.getModelo().vistaPrincipal();
        vista.dispose();
    }
    
}
