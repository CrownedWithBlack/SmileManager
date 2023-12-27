package smileManager.Modelo;

/**
 *
 * @author Ferna
 */
public class UsuarioModelo {
    private String usuario;
    private String contrasenna;
    private String tipoDeUsuario;
    private String nombre;

    public UsuarioModelo() {
    }

    public UsuarioModelo(String Usuario, String contrasenna, String TipoDeUsuario, String Nombre) {
        this.usuario = Usuario;
        this.contrasenna=contrasenna;
        this.tipoDeUsuario=TipoDeUsuario;
        this.nombre = Nombre;
    }

    public UsuarioModelo(String usuario, String contrasenna) {
        this.usuario = usuario;
        this.contrasenna = contrasenna;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String Usuario) {
        this.usuario = Usuario;
    }
    
    public String getContrasenna(){
        return contrasenna;
    }
    public void setContrasenna(String contrasenna){
        this.contrasenna=contrasenna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }
    
    
    @Override
    public String toString() {
        return "UsuarioModelo{" + "usuario=" + usuario + ", contrasenna=" + contrasenna + ", tipoDeUsuario=" + tipoDeUsuario + ", nombre=" + nombre + '}';
    }
    
}
