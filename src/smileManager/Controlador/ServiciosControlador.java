/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smileManager.Controlador;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import smileManager.Vista.CrearServicioVista;


/**
 *
 * @author Ferna
 */
public class ServiciosControlador {

    private CrearServicioVista crearServicioVista;
    private DefaultTableModel model = new DefaultTableModel();
    private Conexion conexion = new Conexion();
    private Connection connection;
    private JTable tabla;
    String fila;

    ArrayList<String> userText = new ArrayList<>();
    ArrayList<String> colText = new ArrayList<>();
    ArrayList<String> campoText = new ArrayList<>();
    ArrayList<Integer> colIndex = new ArrayList<>();
    ArrayList<Integer> rowIndex = new ArrayList<>();

    public void cargarTabla(JTable tabla) {
        this.tabla = tabla;
        model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
        connection = conexion.conectarDB();
        ResultSet result;

        try {
            
            PreparedStatement preparedStatement = connection.prepareStatement("select Nombre, Precio from Tratamientos");
            result = preparedStatement.executeQuery();

            while (result.next()) {
                model.addRow(new Object[]{result.getString("Nombre"), result.getString("Precio")});

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
                    PreparedStatement preparedStatement = connection.prepareStatement("update Tratamientos set " + colText.get(i) + " =  '" + tabla.getValueAt(rowIndex.get(i), colIndex.get(i)).toString() + "' where Nombre = '" + userText.get(i) + "'");
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
    
    public void getDataOnClick() {
        fila = (tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
        System.err.println(fila);
    }

    public void eliminarRegistro() {
        try {
            connection = conexion.conectarDB();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from Tratamientos where Nombre = '" + fila + "'");
            preparedStatement.execute();
            connection.close();
        } catch (Exception e) {
        }
    }
    
    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public void getDataOnMousePress() {
        userText.add(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
        campoText.add(tabla.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn()).toString());
        colText.add(tabla.getColumnName(tabla.getSelectedColumn()));
        
//        switch (tabla.getColumnName(tabla.getSelectedColumn())) {
//            case "Contraseña" -> colText.add("Contrasenna");
//            case "Tipo de Usuario" -> colText.add("TipoDeUsuario");
//            case "Nombre" -> colText.add("NombreEmpleado");
//            case "Usuario" -> colText.add("Usuario");
//            default -> {
//            }
//        }
//        colIndex.add( tabla.getEditingColumn());
//        rowIndex.add(tabla.getEditingRow());
        colIndex.add(tabla.getSelectedColumn());
        rowIndex.add(tabla.getSelectedRow());
        System.out.println("GetDataOnMousePress: \nNombre: "+userText+"\nValor de la celda: "+campoText+"\nNombre de la columna: "+colText+"\nNumero de fila: "+rowIndex+"\nNumero de columna: "+colIndex);
        
        
    }
    
    public void setCrearUsuario(){
        
    }
    
    public void datos(){
        for (int i = 0; i < rowIndex.size(); i++) {
            System.err.println("Datos Nuevos: " + tabla.getValueAt(rowIndex.get(i), colIndex.get(i)));
        }
    }
}
