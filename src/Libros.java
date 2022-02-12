import javax.naming.directory.SearchControls;
import java.util.ArrayList;
import java.util.Calendar;

public class Libros {

    // Atributos

    private String titulo;
    private String autor;
    private int isbn;
    private int cantidad;
    private int precio; // ESTO SERA UN POLIMORFISMO

    // Constructor

    public Libros(String titulo, String autor, int isbn, int cantidad, int precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Libros() {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    //metodos

    public void PrestadoOno(ArrayList<Libros> libros){
        // Saber si el libro esta prestado o no

        if (cantidad == 0){
            System.out.println("Todos los libros con el titulo " + titulo + " estan prestados");
        }else{
            System.out.println("Todos los libros con el titulo " + titulo + " estan disponibles");

            // Si esta disponible, coger el isbn y preguntar si quiere prestarlo

            getIsbn();
            System.out.println("Quiere prestar el libro con el isbn " + isbn + "?");
            System.out.println("1. Si");
            System.out.println("2. No");
            int opcion = Integer.parseInt(System.console().readLine());
            if (opcion == 1){
                System.out.println("El libro con el isbn " + isbn + " se ha prestado");
                cantidad--;
                Prestar(getIsbn(), libros);
            }else if (opcion == 2){
                System.out.println("El libro con el isbn " + isbn + " no se ha prestado");
            }

        }
    }

    public void devolverPrestado(){
        System.out.println("El vinilo se ha devuelto");
    }

    public void Prestar(int isbnPrestado, ArrayList<Libros> libros){

        // Prestar el libro

        // Preguntar datos del usuario

        System.out.println("Introduzca el nombre del usuario");
        String nombre = System.console().readLine();
        System.out.println("Introduzca el apellido del usuario");
        String apellido = System.console().readLine();
        System.out.println("Introduzca el DNI del usuario");
        int dni = Integer.parseInt(System.console().readLine());

        // Fecha de prestamo es hoy

        Calendar fecha = Calendar.getInstance();
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH);
        int anio = fecha.get(Calendar.YEAR);

        // Mostrar datos del usuario

        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("DNI: " + dni);
        System.out.println("Fecha de prestamo: " + dia + "/" + mes + "/" + anio);

        // Buscar el libro con el isbn usando el metodo buscarLibro

        Libros libro = buscarLibro(libros, isbnPrestado);

        // Mostrar datos del libro

        System.out.println("Titulo: " + libro.getTitulo());
        System.out.println("Autor: " + libro.getAutor());
        System.out.println("ISBN: " + libro.getIsbn());
        System.out.println("Cantidad: " + libro.getCantidad());
        System.out.println("Precio: " + libro.getPrecio());

        // Decir que devuelva el libro en un mes

        System.out.println("El libro se tiene que devolver en un mes");

        // Mostrar datos del libro

        System.out.println("Titulo: " + libro.titulo);
        System.out.println("Autor: " + libro.getAutor());
        System.out.println("ISBN: " + libro.getIsbn());
        System.out.println("Cantidad: " + libro.getCantidad());
        System.out.println("Precio: " + libro.getPrecio());


        // Poner fecha de devolucion

        Calendar fechaDevolucion = Calendar.getInstance();
        fechaDevolucion.add(Calendar.MONTH, 1);
        int diaDevolucion = fechaDevolucion.get(Calendar.DAY_OF_MONTH);
        int mesDevolucion = fechaDevolucion.get(Calendar.MONTH);
        int anioDevolucion = fechaDevolucion.get(Calendar.YEAR);

        // Mostrar fecha de devolucion

        System.out.println("Fecha de devolucion: " + diaDevolucion + "/" + mesDevolucion + "/" + anioDevolucion);

    }

    public void Comprar(){ // ESTO SERA UN POLIMORFISMO
        System.out.println("El vinilo se ha comprado");
    }

    public Libros buscarLibro(ArrayList<Libros> libros, int isbn){ // ESTO SERA UN POLIMORFISMO
        for (int i = 0; i < libros.size(); i++){
            if (libros.get(i).getIsbn() == isbn){
                // DEVOLVER EL LIBRO CON TODOS SUS DATOS EN FORMATO STRING
                return libros.get(i);
            }
        }
        return null;
    }
}
