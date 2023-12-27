/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smileManager.Controlador;

import java.io.File;
import java.sql.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import smileManager.Modelo.UsuarioModelo;
import smileManager.Vista.PrincipalVista;
import smileManager.Vista.LoginVista;

/**
 *
 * @author Ferna
 */
public class LoginControlador {
    
    private Conexion   conexion;
    PrincipalVista administradorVista;
    private Connection connection;
    
    public void iniciarSesion(UsuarioModelo usuarioModelo,LoginVista loginVista, Conexion conexion){
        this.conexion = conexion;
        if ("".equals(conexion.getRutaDB())){
            JOptionPane.showMessageDialog(null, "No se encontro una base de datos, favor de seleccionar una desde el menu archivo", "", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        connection= conexion.conectarDB();
        ResultSet result= null;
        
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select Usuario,Contrasenna,TipoDeUsuario,NombreEmpleado from Usuarios where Usuario = '"+usuarioModelo.getUsuario()+"' and Contrasenna = '"+usuarioModelo.getContrasenna()+"'");
            result=preparedStatement.executeQuery();
            if(result.getString("Usuario")==null){
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas","Error de conexión",JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            usuarioModelo.setNombre(result.getString("NombreEmpleado"));
            usuarioModelo.setTipoDeUsuario(result.getString("TipoDeUsuario"));
            connection.close();
        } catch (SQLException ex) {
        }

            administradorVista = new PrincipalVista(usuarioModelo);
            administradorVista.setVisible(true);
            loginVista.dispose();
        
            
        
        
    }
    
}
