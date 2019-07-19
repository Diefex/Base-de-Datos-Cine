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
        if (ae.getSource()==vista.getBtnReservar()){
            vista.getModelo().vistaReservar();
            vista.dispose();
        }
        if(ae.getSource()==vista.getBtnReservas()){
            
        }
    }
    
}
