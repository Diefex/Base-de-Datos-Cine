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
        BD = "jdbc:postgresql://localhost:5433/Cine";
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
    
    public void update(String tabla, ArrayList<String> campos, ArrayList<String> condiciones){
        try (Connection connection = DriverManager.getConnection(BD, USER, PASS)) {

            String ins = "UPDATE " + tabla + " SET ";
            for (int i = 0; i < campos.size(); i++) {
                if (i == 0) {
                    ins += campos.get(i);
                } else {
                    ins += "," + campos.get(i);
                }
            }
            ins += " WHERE ";
            for (int i = 0; i < condiciones.size(); i++) {
                if (i == 0) {
                    ins += condiciones.get(i);
                } else {
                    ins += "," + condiciones.get(i);
                }
            }
            ins += "; ";

            PreparedStatement psql = connection.prepareStatement(ins);
            int resultado = psql.executeUpdate();
            if(resultado==1){
                System.out.println("update Realizado");
            }
            psql.close();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void generarEntradas(){
        int funcion = 1;
            char letra = 'A';
            try (Connection connection = DriverManager.getConnection(BD, USER, PASS)) {
                while (funcion != 9) {
                    switch (funcion) {
                        case 1:
                            do { //Caso A1
                                for (int numero = 0; numero < 10; numero++) {
                                    String ins = "INSERT INTO ENTRADA(num, num_funcion, asiento, vendida) VALUES (default," + funcion + ", '" + letra + String.valueOf(numero) + "',false);";
                                    PreparedStatement psql = connection.prepareStatement(ins);
                                    int resultado = psql.executeUpdate();
                                    if (resultado == 1) {
                                        System.out.println("Insert Realizado");
                                    }
                                    psql.close();
                                }
                                switch (letra) {
                                    case 'A':
                                        letra = 'B';
                                        break;
                                    case 'B':
                                        letra = 'C';
                                        break;
                                    case 'C':
                                        letra = 'D';
                                        break;
                                    case 'D':
                                        letra = 'E';
                                        break;
                                    case 'E':
                                        letra = 'F';
                                        break;
                                    default:
                                        break;
                                }
                            } while (letra != 'F');
                            letra ='A';
                            break;
                        case 2:
                            do { //Caso A2
                                for (int numero = 0; numero < 10; numero++) {
                                    String ins = "INSERT INTO ENTRADA(num, num_funcion, asiento, vendida) VALUES (default," + funcion + ", '" + letra + String.valueOf(numero) + "',false);";
                                    PreparedStatement psql = connection.prepareStatement(ins);
                                    int resultado = psql.executeUpdate();
                                    if (resultado == 1) {
                                        System.out.println("Insert Realizado");
                                    }
                                    psql.close();
                                }
                                switch (letra) {
                                    case 'A':
                                        letra = 'B';
                                        break;
                                    case 'B':
                                        letra = 'C';
                                        break;
                                    case 'C':
                                        letra = 'D';
                                        break;
                                    case 'D':
                                        letra = 'E';
                                        break;
                                    case 'E':
                                        letra = 'F';
                                        break;
                                    case 'F':
                                        letra = 'G';
                                        break;
                                    case 'G':
                                        letra = 'H';
                                        break;
                                    case 'H':
                                        letra = 'I';
                                        break;
                                    case 'I':
                                        letra = 'J';
                                        break;
                                    case 'J':
                                        letra = 'K';
                                        break;
                                    default:
                                        break;
                                }
                            } while (letra != 'K');
                            letra ='A';
                            break;
                        case 3:
                            do { //Caso A2
                                for (int numero = 0; numero < 10; numero++) {
                                    String ins = "INSERT INTO ENTRADA(num, num_funcion, asiento, vendida) VALUES (default," + funcion + ", '" + letra + String.valueOf(numero) + "',false);";
                                    PreparedStatement psql = connection.prepareStatement(ins);
                                    int resultado = psql.executeUpdate();
                                    if (resultado == 1) {
                                        System.out.println("Insert Realizado");
                                    }
                                    psql.close();
                                }
                                switch (letra) {
                                    case 'A':
                                        letra = 'B';
                                        break;
                                    case 'B':
                                        letra = 'C';
                                        break;
                                    case 'C':
                                        letra = 'D';
                                        break;
                                    case 'D':
                                        letra = 'E';
                                        break;
                                    case 'E':
                                        letra = 'F';
                                        break;
                                    case 'F':
                                        letra = 'G';
                                        break;
                                    case 'G':
                                        letra = 'H';
                                        break;
                                    case 'H':
                                        letra = 'I';
                                        break;
                                    case 'I':
                                        letra = 'J';
                                        break;
                                    case 'J':
                                        letra = 'K';
                                        break;
                                    default:
                                        break;
                                }
                            } while (letra != 'K');
                            letra ='A';
                            break;
                        case 4:
                            do { //Caso A2
                                for (int numero = 0; numero < 10; numero++) {
                                    String ins = "INSERT INTO ENTRADA(num, num_funcion, asiento, vendida) VALUES (default," + funcion + ", '" + letra + String.valueOf(numero) + "',false);";
                                    PreparedStatement psql = connection.prepareStatement(ins);
                                    int resultado = psql.executeUpdate();
                                    if (resultado == 1) {
                                        System.out.println("Insert Realizado");
                                    }
                                    psql.close();
                                }
                                switch (letra) {
                                    case 'A':
                                        letra = 'B';
                                        break;
                                    case 'B':
                                        letra = 'C';
                                        break;
                                    case 'C':
                                        letra = 'D';
                                        break;
                                    case 'D':
                                        letra = 'E';
                                        break;
                                    case 'E':
                                        letra = 'F';
                                        break;
                                    case 'F':
                                        letra = 'G';
                                        break;
                                    case 'G':
                                        letra = 'H';
                                        break;
                                    case 'H':
                                        letra = 'I';
                                        break;
                                    case 'I':
                                        letra = 'J';
                                        break;
                                    case 'J':
                                        letra = 'K';
                                        break;
                                    default:
                                        break;
                                }
                            } while (letra != 'K');
                            letra ='A';
                            break;
                        case 5:
                            do { //Caso A1
                                for (int numero = 0; numero < 10; numero++) {
                                    String ins = "INSERT INTO ENTRADA(num, num_funcion, asiento, vendida) VALUES (default," + funcion + ", '" + letra + String.valueOf(numero) + "',false);";
                                    PreparedStatement psql = connection.prepareStatement(ins);
                                    int resultado = psql.executeUpdate();
                                    if (resultado == 1) {
                                        System.out.println("Insert Realizado");
                                    }
                                    psql.close();
                                }
                                switch (letra) {
                                    case 'A':
                                        letra = 'B';
                                        break;
                                    case 'B':
                                        letra = 'C';
                                        break;
                                    case 'C':
                                        letra = 'D';
                                        break;
                                    case 'D':
                                        letra = 'E';
                                        break;
                                    case 'E':
                                        letra = 'F';
                                        break;
                                    default:
                                        break;
                                }
                            } while (letra != 'F');
                            letra ='A';
                            break;
                        case 6:
                            do { //Caso A2
                                for (int numero = 0; numero < 10; numero++) {
                                    String ins = "INSERT INTO ENTRADA(num, num_funcion, asiento, vendida) VALUES (default," + funcion + ", '" + letra + String.valueOf(numero) + "',false);";
                                    PreparedStatement psql = connection.prepareStatement(ins);
                                    int resultado = psql.executeUpdate();
                                    if (resultado == 1) {
                                        System.out.println("Insert Realizado");
                                    }
                                    psql.close();
                                }
                                switch (letra) {
                                    case 'A':
                                        letra = 'B';
                                        break;
                                    case 'B':
                                        letra = 'C';
                                        break;
                                    case 'C':
                                        letra = 'D';
                                        break;
                                    case 'D':
                                        letra = 'E';
                                        break;
                                    case 'E':
                                        letra = 'F';
                                        break;
                                    case 'F':
                                        letra = 'G';
                                        break;
                                    case 'G':
                                        letra = 'H';
                                        break;
                                    case 'H':
                                        letra = 'I';
                                        break;
                                    case 'I':
                                        letra = 'J';
                                        break;
                                    case 'J':
                                        letra = 'K';
                                        break;
                                    default:
                                        break;
                                }
                            } while (letra != 'K');
                            letra ='A';
                            break;
                        case 7:
                            do { //Caso A1
                                for (int numero = 0; numero < 10; numero++) {
                                    String ins = "INSERT INTO ENTRADA(num, num_funcion, asiento, vendida) VALUES (default," + funcion + ", '" + letra + String.valueOf(numero) + "',false);";
                                    PreparedStatement psql = connection.prepareStatement(ins);
                                    int resultado = psql.executeUpdate();
                                    if (resultado == 1) {
                                        System.out.println("Insert Realizado");
                                    }
                                    psql.close();
                                }
                                switch (letra) {
                                    case 'A':
                                        letra = 'B';
                                        break;
                                    case 'B':
                                        letra = 'C';
                                        break;
                                    case 'C':
                                        letra = 'D';
                                        break;
                                    case 'D':
                                        letra = 'E';
                                        break;
                                    case 'E':
                                        letra = 'F';
                                        break;
                                    default:
                                        break;
                                }
                            } while (letra != 'F');
                            letra ='A';
                            break;
                        case 8:
                            do { //Caso A2
                                for (int numero = 0; numero < 10; numero++) {
                                    String ins = "INSERT INTO ENTRADA(num, num_funcion, asiento, vendida) VALUES (default," + funcion + ", '" + letra + String.valueOf(numero) + "',false);";
                                    PreparedStatement psql = connection.prepareStatement(ins);
                                    int resultado = psql.executeUpdate();
                                    if (resultado == 1) {
                                        System.out.println("Insert Realizado");
                                    }
                                    psql.close();
                                }
                                switch (letra) {
                                    case 'A':
                                        letra = 'B';
                                        break;
                                    case 'B':
                                        letra = 'C';
                                        break;
                                    case 'C':
                                        letra = 'D';
                                        break;
                                    case 'D':
                                        letra = 'E';
                                        break;
                                    case 'E':
                                        letra = 'F';
                                        break;
                                    case 'F':
                                        letra = 'G';
                                        break;
                                    case 'G':
                                        letra = 'H';
                                        break;
                                    case 'H':
                                        letra = 'I';
                                        break;
                                    case 'I':
                                        letra = 'J';
                                        break;
                                    case 'J':
                                        letra = 'K';
                                        break;
                                    default:
                                        break;
                                }
                            } while (letra != 'K');
                            letra ='A';
                            break;
                        default:
                            break;
                    }
                    funcion++;
                }
            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}