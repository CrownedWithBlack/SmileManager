
package smileManager.Controlador;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author Ferna
 */
public class Conexion {
        //ejemplo de cadena de conexion   rutaDB="jdbc:sqlite:G:\Otros ordenadores\Mi Ordenador\Escuela\Ingenieria de Software I\SmileManager\src\smileManager\Recursos\SmileManagerDB.db"
//    private String rutaDB="jdbc:sqlite:G:\\Otros ordenadores\\Mi Ordenador\\Escuela\\Ingenieria de Software I\\SmileManager\\src\\smileManager\\Modelo\\SmileManagerDB.db"; // jdbc:sqlite: siempre debe incluirse
    private String rutaDB="jdbc:sqlite:C:\\Base\\SmileManagerDB.db"; // jdbc:sqlite: siempre debe incluirse
//    private String rutaDB="";
    private String pathDB ;
//    private String rutaDB="jdbc:sqlite:"+pathDB; // jdbc:sqlite: siempre debe incluirse
    
    protected Connection connection;

    public String getRutaDB() {
        return rutaDB;
    }
    
    
    public Connection conectarDB(){
        try{
            connection=DriverManager.getConnection(rutaDB);
            if(connection!=null)
                System.out.println("conexion exitosa");
        }catch(SQLException e){
            System.out.println("Conexion fallida");
        }
        return connection;
    }
    
        public void setRutaDB(JFrame frame){
         JFileChooser jFileChooser = new JFileChooser("G:\\Otros ordenadores\\Mi Ordenador\\Escuela\\Ingenieria de Software I\\SmileManager\\src\\smileManager\\Modelo");
        int result = jFileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFIle = jFileChooser.getSelectedFile();
            pathDB = selectedFIle.getAbsolutePath();
            this.rutaDB="jdbc:sqlite:".concat(pathDB);
        }
    }
    
}
