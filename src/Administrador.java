public class Administrador extends Usuario {

    public String usuario = "admin";
    public String contra = "admin";


    // Constructor

    public Administrador() {
        super();
    }

    // Getters y Setters

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

}
