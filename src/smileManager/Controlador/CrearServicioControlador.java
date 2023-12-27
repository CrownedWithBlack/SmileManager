/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smileManager.Controlador;
import java.sql.*;
import javax.swing.JOptionPane;
import smileManager.Vista.CrearUsuarioVista;

/**
 *
 * @author Ferna
 */
public class CrearServicioControlador {
    
    Conexion conexion= new Conexion();
    Connection connection ;


    
    
    public boolean guardarServicioCreado(String nombre, String precio){

        try {
            connection=conexion.conectarDB();
            ResultSet result;
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Tratamientos(Nombre, Precio) values('"+nombre+"','"+precio+"')");    
            preparedStatement.execute();
            connection.close();   
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return true;
    }
    
}
