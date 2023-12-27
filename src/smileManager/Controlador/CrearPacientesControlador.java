/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smileManager.Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ferna
 */
public class CrearPacientesControlador {
    
    Conexion conexion= new Conexion();
    Connection connection ;


    
    
    public boolean guardarPacienteCreado(String nombre, String domicilio,String DoB, String telefono){

        try {
            connection=conexion.conectarDB();
            ResultSet result;
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Pacientes(Nombre, domicilio, DOB,Telefono) values('"+nombre+"','"+domicilio+"','"+DoB+"','"+telefono+"')");    
            preparedStatement.execute();
            connection.close();   
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return true;
    }
}
