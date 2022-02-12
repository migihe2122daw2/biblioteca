import java.util.Calendar;

public class PrestadoVinilo {

    //atributos
    private Vinilos nombre;
    private Vinilos canciones;
    private Vinilos id;
    private Vinilos fechaLanzamieto;
    private ClienteEscolaMusica nombreEscuela;
    private Calendar f_entrada;
    private Calendar f_devolucion;
    public String multa;

    // Constructor

    public PrestadoVinilo(Vinilos nombre, Vinilos canciones, Vinilos id, Vinilos fechaLanzamieto, ClienteEscolaMusica nombreEscuela, Calendar f_entrada, Calendar f_devolucion, String multa) {
        this.nombre = nombre;
        this.canciones = canciones;
        this.id = id;
        this.fechaLanzamieto = fechaLanzamieto;
        this.nombreEscuela = nombreEscuela;
        this.f_entrada = f_entrada;
        this.f_devolucion = f_devolucion;
        this.multa = multa;
    }

    // Getters y setters

    public Calendar getF_entrada() {
        return f_entrada;
    }

    public void setF_entrada(Calendar f_entrega) {
        this.f_entrada = f_entrega;
    }

    public Calendar getF_devolucion() {
        return f_devolucion;
    }

    public void setF_devolucion(Calendar f_devolucion) {
        this.f_devolucion = f_devolucion;
    }

    public String getMulta() {
        return multa;
    }

    public void setMulta(String multa) {
        this.multa = multa;
    }

    // toString

    @Override
    public String toString() {
        return "Prestado{" + "f_entrega=" + f_entrada + ", f_devolucion=" + f_devolucion + ", multa=" + multa + '}';
    }

    //metodos

    public void multa(){

        // Se multara el libro si la fecha de devolucion es menor a la fecha de entrada

        if (f_devolucion.compareTo(f_entrada) < 0) {
            multa = "Multa";
        } else {
            multa = "No Multa";
        }

        switch (multa) {
            case "Multa":
                System.out.println("El libro esta multado");
                break;
            case "No Multa":
                System.out.println("El libro no esta multado");
                break;
        }
    
    }

}
