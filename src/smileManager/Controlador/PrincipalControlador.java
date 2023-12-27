/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smileManager.Controlador;
import smileManager.Vista.PacientesVista;
import smileManager.Vista.UsuariosVista;
import smileManager.Vista.PrincipalVista;
import smileManager.Vista.ServiciosVista;

/**
 *
 * @author Ferna
 */
public class PrincipalControlador {
    UsuariosVista usuariosVista;
    ServiciosVista serviciosVista;
    PacientesVista pacientesvista;
    
    
    public void UsuariosVista(PrincipalVista principalVista){
        usuariosVista= new UsuariosVista(principalVista);
        usuariosVista.setVisible(true);
        principalVista.setEnabled(false);
    }
    
    public void ServiciosVista(PrincipalVista principalVista){
        serviciosVista = new ServiciosVista(principalVista);
        serviciosVista.setVisible(true);
        principalVista.setEnabled(false);
    }
    
    public void PacientesVista(PrincipalVista principalVista){
        pacientesvista = new PacientesVista(principalVista);
        pacientesvista.setVisible(true);
        principalVista.setEnabled(false);
    }
    
}
