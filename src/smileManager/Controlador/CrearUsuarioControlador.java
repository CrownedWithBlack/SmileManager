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
public class CrearUsuarioControlador {
    
    Conexion conexion= new Conexion();
    Connection connection ;


    
    
    public boolean guardarUsuarioCreado(String user, String pass, String nombre,String rol){

        try {
            connection=conexion.conectarDB();
            ResultSet result;
            PreparedStatement selectStatement = connection.prepareStatement("select Usuario from Usuarios where Usuario = '"+user+"'");
            result=selectStatement.executeQuery();
            if(result.getString("Usuario")==null){
                 PreparedStatement preparedStatement = connection.prepareStatement("insert into Usuarios(Usuario,Contrasenna,TipoDeUsuario,NombreEmpleado) values('"+user+"','"+pass+"','"+nombre+"','"+rol+"')");    
                 preparedStatement.execute();
                 connection.close();
            }
            
            else if(result.getString("Usuario").equals(user)){
                JOptionPane.showMessageDialog(null, "Ese usuario ya se encuentra en uso", "Error de Usuario", 0);
                connection.close();
                return false;
            }
           
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return true;
    }
    
}
