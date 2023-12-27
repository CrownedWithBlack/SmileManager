/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smileManager.Controlador;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import smileManager.Vista.CrearUsuarioVista;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Ferna
 */
public class UsuariosControlador {

    private CrearUsuarioVista crearUsuarioVista;
    private DefaultTableModel model = new DefaultTableModel();
    private Conexion conexion = new Conexion();
    private Connection connection;
    private JTable tabla;

    ArrayList<String> userText = new ArrayList<>();
    ArrayList<String> colText = new ArrayList<>();
    ArrayList<String> campoText = new ArrayList<>();
    ArrayList<Integer> colIndex = new ArrayList<>();
    ArrayList<Integer> rowIndex = new ArrayList<>();

    public void cargarTabla(JTable tablaUsuarios) {
        this.tabla = tablaUsuarios;
        model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
        connection = conexion.conectarDB();
        ResultSet result;

        try {
            
            PreparedStatement preparedStatement = connection.prepareStatement("select Usuario,Contrasenna,TipoDeUsuario,NombreEmpleado from Usuarios");
            result = preparedStatement.executeQuery();

            while (result.next()) {
                model.addRow(new Object[]{result.getString("Usuario"), result.getString("Contrasenna"), result.getString("NombreEmpleado"),result.getString("TipoDeUsuario")});

            }
            connection.close();

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al cargar la tabla", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean guardar() {
        
        if(userText.isEmpty()){
            return false;
        }
        else{
            connection = conexion.conectarDB();
            try {
                for (int i = 0; i < userText.size(); i++) {
//                PreparedStatement preparedStatement = connection.prepareStatement("update Usuarios set "+colText.get(i)+" =  '"+tabla.getValueAt(rowIndex.get(i), colIndex.get(i)).toString()+"' where Usuario = '"+userText.get(i)+"'");
                    PreparedStatement preparedStatement = connection.prepareStatement("update Usuarios set " + colText.get(i) + " =  '" + tabla.getValueAt(rowIndex.get(i), colIndex.get(i)).toString() + "' where Usuario = '" + userText.get(i) + "'");
                    preparedStatement.execute();
                }
                connection.close();
             
            } catch (SQLException e) {
            }

            return true;
        }

    }
    
    public void vaciarBuffer(){
        userText.clear();
        campoText.clear();
        colText.clear();
        rowIndex.clear();
        colIndex.clear();
        
    }

    public void getDataOnMousePress() {
        userText.add(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
        campoText.add(tabla.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn()).toString());
//        switch (tabla.getColumnName(tabla.getEditingColumn())) {
        switch (tabla.getColumnName(tabla.getSelectedColumn())) {
            case "Contraseña" -> colText.add("Contrasenna");
            case "Tipo de Usuario" -> colText.add("TipoDeUsuario");
            case "Nombre" -> colText.add("NombreEmpleado");
            case "Usuario" -> colText.add("Usuario");
            default -> {
            }
        }
//        colIndex.add( tabla.getEditingColumn());
//        rowIndex.add(tabla.getEditingRow());
        colIndex.add(tabla.getSelectedColumn());
        rowIndex.add(tabla.getSelectedRow());
        System.out.println("GetDataOnMousePress: \nUsuario: "+userText+"\nValor de la celda: "+campoText+"\nNombre de la columna: "+colText+"\nNumero de fila: "+rowIndex+"\nNumero de columna: "+colIndex);
        
        
    }
    
    public void setCrearUsuario(){
        
    }
    
    public void datos(){
        for (int i = 0; i < rowIndex.size(); i++) {
            System.err.println("Datos Nuevos: " + tabla.getValueAt(rowIndex.get(i), colIndex.get(i)));
        }
    }
}
