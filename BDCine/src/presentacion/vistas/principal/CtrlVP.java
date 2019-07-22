package presentacion.vistas.principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlVP implements ActionListener {

    private VistaPrincipal vista;

    public CtrlVP(VistaPrincipal vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista.getBtnReservar()) {
            vista.getModelo().vistaReservar();
            vista.dispose();
        }
        if (ae.getSource() == vista.getBtnReservas()) {
            vista.getModelo().vistaSelects(4);
            vista.dispose();
        }
        if (ae.getSource() == vista.getBtnSalas()) {
            vista.getModelo().vistaSelects(3);
            vista.dispose();
        }
        if (ae.getSource() == vista.getBtnFunciones()) {
            vista.getModelo().vistaSelects(2);
            vista.dispose();
        }
        if (ae.getSource() == vista.getBtnClientes()) {
            vista.getModelo().vistaSelects(1);
            vista.dispose();
        }
    }
}
