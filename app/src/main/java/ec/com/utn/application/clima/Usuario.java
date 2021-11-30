package ec.com.utn.application.clima;

public class Usuario {
    int id;
    String nombre_usuario, apellido_usuario, usuario, clave;

    public Usuario() {

    }

    public Usuario(String nombre_usuario, String apellido_usuario, String usuario, String clave) {

        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.usuario = usuario;
        this.clave = clave;
    }

    public boolean isNull(){
        if(nombre_usuario.equals("")&&apellido_usuario.equals("")&&usuario.equals("")&&clave.equals("")){
            return false;
            }
        else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre_usuario='" + nombre_usuario + '\'' +
                ", apellido_usuario='" + apellido_usuario + '\'' +
                ", usuario='" + usuario + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
