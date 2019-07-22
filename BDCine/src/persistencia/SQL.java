package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQL {

    private static SQL sql;
    
    private final String BD;
    private final String USER;
    private final String PASS;

    private SQL() {
        BD = "jdbc:postgresql://localhost:5432/Cine";
        USER = "postgres";
        PASS = "postgres2019";
    }
    
    public static SQL comando(){
        if(sql == null){
            sql = new SQL();
        }
        return sql;
    }

    public ResultSet select(String campos, String tabla) {
        try (Connection connection = DriverManager.getConnection(BD, USER, PASS)) {

            Statement statement = connection.createStatement();

            String query = "SELECT " + campos + " FROM " + tabla;

            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;

        } catch (SQLException e) {
            System.out.println("Falló la conexion. excepcion SQL");
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet select(String campos, String tabla, String condiciones) {
        try (Connection connection = DriverManager.getConnection(BD, USER, PASS)) {

            Statement statement = connection.createStatement();

            String query = "SELECT " + campos + " FROM " + tabla + " WHERE " + condiciones;

            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;

        } catch (SQLException e) {
            System.out.println("Falló la conexion. execpcion SQL");
            e.printStackTrace();
            return null;
        }
    }
    
    public void insert(String tabla, ArrayList<String> valores) {
        try (Connection connection = DriverManager.getConnection(BD, USER, PASS)) {

            String ins = "INSERT INTO " + tabla + " VALUES (";
            for (int i = 0; i < valores.size(); i++) {
                if (i == 0) {
                    ins += valores.get(i);
                } else {
                    ins += "," + valores.get(i);
                }
            }
            ins += ");";

            PreparedStatement psql = connection.prepareStatement(ins);
            int resultado = psql.executeUpdate();
            if(resultado==1){
                System.out.println("insert Realizado");
            }
            psql.close();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}