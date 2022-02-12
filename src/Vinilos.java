public class Vinilos {
    //atributos
    public String nombre;
    public int canciones;
    public int id;
    public String fechaLanzamiento;

    //Constructor
    public Vinilos(){
        this.nombre = nombre;
        this.canciones = canciones;
        this.id = id;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    //getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCanciones() {
        return canciones;
    }

    public void setCanciones(int canciones) {
        this.canciones = canciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    //metodos

    public void PrestadoOno(){
        System.out.println("El vinilo se encuentra prestado");
    }

    public void devolverPrestado(){
        System.out.println("El vinilo se ha devuelto");
    }

    public void Prestar(){
        System.out.println("El vinilo se ha prestado");
    }

    public void Comprar(){
        System.out.println("El vinilo se ha comprado");
    }
    

}
