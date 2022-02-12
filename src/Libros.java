import java.util.ArrayList;
import java.util.Calendar;
import java.util.*;

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

    public int PrestadoOno(ArrayList<Libros> libros){
        // Saber si el libro esta prestado o no

        if (cantidad == 0){
            System.out.println("Todos los libros con el titulo " + titulo + " estan prestados");
        }else{
            System.out.println("Todos los libros con el titulo " + titulo + " estan disponibles");

            return cantidad;
        }
        return 0;
    }

    public void devolverPrestado(){
        System.out.println("El vinilo se ha devuelto");
    }

    public void Prestar(int isbnPrestado, ArrayList<Libros> libros){

        // Prestar el libro

        // Preguntar datos del usuario

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca el nombre del usuario");
        String nombre = sc.nextLine();
        System.out.println("Introduzca el apellido del usuario");
        String apellido = sc.nextLine();
        System.out.println("Introduzca el DNI del usuario");
        int dni = sc.nextInt();

        // Fecha de prestamo es la actual

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

        // Decir que devuelva el libro en un mes

        System.out.println("El libro se tiene que devolver en un mes");

        // Poner fecha de devolucion

        Calendar fechaDevolucion = Calendar.getInstance();
        fechaDevolucion.add(Calendar.MONTH, 1);
        int diaDevolucion = fechaDevolucion.get(Calendar.DAY_OF_MONTH);
        int mesDevolucion = fechaDevolucion.get(Calendar.MONTH);
        int anioDevolucion = fechaDevolucion.get(Calendar.YEAR);

        // Mostrar fecha de devolucion

        System.out.println("Fecha de devolucion: " + diaDevolucion + "/" + mesDevolucion + "/" + anioDevolucion);

        // Actualizar la cantidad del libro

        libro.setCantidad(libro.getCantidad() - 1);


    }

    public void Comprar(int isbnCompra, ArrayList<Libros> libros){ // ESTO SERA UN POLIMORFISMO



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
