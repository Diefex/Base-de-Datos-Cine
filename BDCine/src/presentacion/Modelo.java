package presentacion;

import java.sql.ResultSet;
import java.util.ArrayList;
import persistencia.SQL;
import presentacion.vistas.principal.VistaPrincipal;
import presentacion.vistas.reservar.VistaReservar;
import presentacion.vistas.selects.VistaSelects;

public class Modelo {

    public void vistaPrincipal() {
        VistaPrincipal vistaP = new VistaPrincipal(this);
        vistaP.setVisible(true);
        SQL sql = SQL.comando();
        //sql.generarEntradas();
    }

    public void vistaReservar() {
        VistaReservar vistaR = new VistaReservar(this);
        vistaR.setVisible(true);
    }
    
    public void vistaSelects(int Opcion) {
        VistaSelects vistaS = new VistaSelects(this, Opcion);
        vistaS.setVisible(true);
    }

    public ResultSet select(String campos, String tabla) {
        SQL sql = SQL.comando();
        return sql.select(campos, tabla);
    }

    public ResultSet select(String campos, String tabla, String condiciones) {
        SQL sql = SQL.comando();
        return sql.select(campos, tabla, condiciones);
    }

    public void insert(String tabla, ArrayList<String> valores) {
        SQL sql = SQL.comando();
        sql.insert(tabla, valores);
    }

    public void update(String tabla, ArrayList<String> campos, ArrayList<String> condiciones) {
        SQL sql = SQL.comando();
        sql.update(tabla, campos, condiciones);
    }

}
