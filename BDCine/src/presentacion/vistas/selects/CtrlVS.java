/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.vistas.selects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import presentacion.vistas.reservar.CtrlVR;

/**
 *
 * @author Cheetos
 */
public class CtrlVS implements ActionListener {

    private VistaSelects vista;
    private ArrayList<String> numFunciones;
    private String opcionS;

    public CtrlVS(VistaSelects vista, int opcion) {
        this.vista = vista;
        numFunciones = new ArrayList<String>();
        switch (opcion) {
            case 1:
                opcionS = "cliente";
                break;
            case 2:
                opcionS = "funcion";
                break;
            case 3:
                opcionS = "sala";
                break;
            case 4:
                opcionS = "reserva";
                break;
            default:
                break;
        }
    }

    public void actualizarLista() {
        int longitud = 6;
        ResultSet result = vista.getModelo().select("*", opcionS);
        try {
            switch (opcionS) {
                case "cliente":
                    longitud = 8;
                    break;
                case "funcion":
                    longitud = 6;
                    break;
                case "sala":
                    longitud = 4;
                    break;
                case "reserva":
                    longitud = 4;
                    break;
                default:
                    break;
            }
            while (result.next()) {
                String func = "";
                for (int i = 1; i < longitud; i++) {
                    func += result.getString(i) + " | ";
                }
                vista.getMdlLista().addElement(func);
                //numFunciones.add(result.getString("num"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlVR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista.getjButton1()) {
            vista.getModelo().vistaPrincipal();
            vista.dispose();
        }
    }
}
