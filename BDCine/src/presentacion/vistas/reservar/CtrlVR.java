package presentacion.vistas.reservar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import presentacion.vistas.asientos.VistaAsientos;

public class CtrlVR implements ActionListener {

    private VistaReservar vista;
    private ArrayList<String> numFunciones;

    public CtrlVR(VistaReservar vista) {
        this.vista = vista;
        numFunciones = new ArrayList<String>();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista.getBtnReservar()) {
            ArrayList<String> asientos = new ArrayList<String>();
            ResultSet result = vista.getModelo().select("asiento", "entrada", "num_funcion="+numFunciones.get(vista.getSelectedFuncion()));
            try {
                while (result.next()) {
                    asientos.add(result.getString("asiento"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlVR.class.getName()).log(Level.SEVERE, null, ex);
            }
            VistaAsientos v = new VistaAsientos(vista.getModelo(), asientos, numFunciones.get(vista.getSelectedFuncion()));
            v.setVisible(true);
        }
    }

    public void actualizarLista() {
        ResultSet result = vista.getModelo().select("*", "cartelera");
        try {
            while (result.next()) {
                String func = "";
                for (int i = 1; i < 5; i++) {
                    func += result.getString(i) + " | ";
                }
                vista.getMdlLista().addElement(func);
                numFunciones.add(result.getString("num"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlVR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
