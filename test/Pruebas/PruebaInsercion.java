/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import smileManager.Controlador.Conexion;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Ferna
 */
public class PruebaInsercion {

    Conexion conexion = new Conexion();
    Connection connection;
    ArrayList<String> nombre = new ArrayList<>();
    ArrayList<String> domicilio = new ArrayList<>();
    ArrayList<String> DOB = new ArrayList<>();
    ArrayList<String> tel = new ArrayList<>();
    JFrame frame = new JFrame();

    public static void main(String[] args) {
        PruebaInsercion prueba = new PruebaInsercion();
        prueba.main();

    }

    private void main() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int contRead = 0, contWrite = 0;
        try {
            connection = conexion.conectarDB();
            ResultSet result;
            PreparedStatement statement = connection.prepareStatement("select * from Pacientes");
            statement.execute();
            result = statement.executeQuery();
            while (result.next()) {
                nombre.add(result.getString("Nombre"));
                domicilio.add(result.getString("Domicilio"));
                DOB.add(result.getString("DOB"));
                tel.add(result.getString("Telefono"));
                contRead++;
            }
            
//            for (int i = 0; i < contRead; i++) {
//                 statement = connection.prepareStatement("insert into Pacientes(Nombre,Domicilio,DOB,Telefono ) values('"+nombre.get(i)+"','"+domicilio.get(i)+"','"+DOB.get(i)+"','"+tel.get(i)+"')");
//                statement.execute();
//            }

        } catch (SQLException e) {
            System.err.println(e);
        }
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

}
