import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;

public class Vinilos {
    //atributos
    public String nombre;
    public int canciones;
    public int id;
    public String fechaLanzamiento;

    //Constructor
    public Vinilos(String nombre, int canciones, int id, String fechaLanzamiento) {
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

    public void Prestar(int id, ArrayList<Vinilos> vinilos){

        // Prestar el vinilo

        // Preguntar datos del usuarioEscuela

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del usuario");
        String nombre = sc.nextLine();
        System.out.println("Introduce el apellido del usuario");
        String apellido = sc.nextLine();
        System.out.println("Introduce el DNI del usuario");
        String dni = sc.nextLine();
        System.out.println("Introduce el nombre de la escuela");
        String escuela = sc.nextLine();

        // FECHA DE PRESTAMO

        Calendar fecha = Calendar.getInstance();
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH);
        int anio = fecha.get(Calendar.YEAR);
        String fechaPrestamo = dia + "/" + mes + "/" + anio;

        // Mostrar datos del usuario

        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("DNI: " + dni);
        System.out.println("Escuela: " + escuela);

        // Buscar el vinilo con metodo buscarVinilo

        Vinilos vinilo = buscarVinilo(vinilos, id);

        // Mostrar datos del vinilo

        System.out.println("Nombre: " + vinilo.nombre);
        System.out.println("Canciones: " + vinilo.canciones);
        System.out.println("ID: " + vinilo.id);
        System.out.println("Fecha de lanzamiento: " + vinilo.fechaLanzamiento);
        System.out.println("El vinilo se tiene que devolver en un mes");

        // Fehca de devolucion

        Calendar fechaDevolucion = Calendar.getInstance();
        fechaDevolucion.add(Calendar.MONTH, 1);
        int diaDevolucion = fechaDevolucion.get(Calendar.DAY_OF_MONTH);
        int mesDevolucion = fechaDevolucion.get(Calendar.MONTH);
        int anioDevolucion = fechaDevolucion.get(Calendar.YEAR);
        String fechaDevolucionString = diaDevolucion + "/" + mesDevolucion + "/" + anioDevolucion;
        System.out.println("Fecha de devolucion: " + fechaDevolucionString);

    }

    public Vinilos buscarVinilo(ArrayList<Vinilos> vinilos, int id){
        Vinilos vinilo = null;
        for(Vinilos vinilo1 : vinilos){
            if(vinilo1.id == id){
                vinilo = vinilo1;
            }
        }
        return vinilo;
    }



    public void Comprar(){
        System.out.println("El vinilo se ha comprado");
    }
    

}
