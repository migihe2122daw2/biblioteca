public class ClienteEscolaMusica extends Cliente {

    // Atributos

    public String nombreEscuela;


    // Constructor

    public ClienteEscolaMusica() {
        this.nombreEscuela = nombreEscuela;
    }

    @Override
    public Integer devolverLibro(int isbn) {
        return null;
    }


    public ClienteEscolaMusica(String dni9, String nombre9, String apellidos9, String email9, String escuela9) {
        super(dni9, nombre9, apellidos9, email9);
        this.nombreEscuela = escuela9;
    }


    // Getters y Setters

    public String getNombreEscuela() {
        return nombreEscuela;
    }

    public void setNombreEscuela(String nombreEscuela) {
        this.nombreEscuela = nombreEscuela;
    }



}


