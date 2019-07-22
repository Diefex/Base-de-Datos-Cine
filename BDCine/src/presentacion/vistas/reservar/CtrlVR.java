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
            if ((vista.getTxtNombre().getText() != "") && (vista.getTxtId().getText() != "")) {
                ResultSet cliente = vista.getModelo().select("num", "cliente", "nombre='" + vista.getTxtNombre().getText() + "' and id='" + vista.getTxtId().getText() + "';");
                try {
                    if (cliente.next()) {
                        if (vista.getSelectedFuncion() >= 0) {
                            ArrayList<String> asientos = new ArrayList<String>();
                            ArrayList<String> vendidas = new ArrayList<String>();
                            ResultSet result = vista.getModelo().select("asiento, vendida", "entrada", "num_funcion=" + numFunciones.get(vista.getSelectedFuncion()));
                            while (result.next()) {
                                asientos.add(result.getString("asiento"));
                                if (result.getBoolean("vendida")) {
                                    vendidas.add(result.getString("asiento"));
                                }
                            }
                            VistaAsientos v = new VistaAsientos(vista.getModelo(), asientos, vendidas, numFunciones.get(vista.getSelectedFuncion()), cliente.getInt("num"));
                            v.setVisible(true);
                            vista.dispose();
                        }
                    } else {
                        vista.getTxtNombre().setText("El cliente no existe en la Base de Datos");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CtrlVR.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                vista.getTxtNombre().setText("Ingrese sus datos");
            }
        }
        if (ae.getSource() == vista.getBtnCancelar()) {
            vista.getModelo().vistaPrincipal();
            vista.dispose();
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
