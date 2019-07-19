package presentacion;

import java.sql.ResultSet;
import java.util.ArrayList;
import persistencia.SQL;
import presentacion.vistas.principal.VistaPrincipal;
import presentacion.vistas.reservar.VistaReservar;

public class Modelo {
    
    public void vistaPrincipal(){
        VistaPrincipal vistaP = new VistaPrincipal(this);
        vistaP.setVisible(true);
    }
    
    public void vistaReservar() {
        VistaReservar vistaR = new VistaReservar(this);
        vistaR.setVisible(true);
    }
    
    public ResultSet select(String campos, String tabla){
        SQL sql = SQL.comando();
        return sql.select(campos, tabla);
    }
    
    public ResultSet select(String campos, String tabla, String condiciones){
        SQL sql = SQL.comando();
        return sql.select(campos, tabla, condiciones);
    }
    
    public void insert(String tabla, ArrayList<String> valores){
        SQL sql = SQL.comando();
        sql.insert(tabla, valores);
    }
    
}
