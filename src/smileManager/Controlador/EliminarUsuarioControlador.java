/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smileManager.Controlador;
import javax.swing.JTable;
import java.sql.*;

/**
 *
 * @author Ferna
 */
public class EliminarUsuarioControlador {
    
    private Connection connection;
    private Conexion conexion= new Conexion();
    private JTable tabla;
    String fila;
    
    public void setTabla(JTable tabla){
        this.tabla=tabla;
    }
    
    public void getDataOnClick() {
        fila=(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
        System.err.println(fila);
    }
    
    public void eliminarRegistro(){
        try {
            connection= conexion.conectarDB();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from Usuarios where Usuario = '"+fila+"'");
            preparedStatement.execute();
            connection.close();
        } catch (Exception e) {
        }
    }

}
