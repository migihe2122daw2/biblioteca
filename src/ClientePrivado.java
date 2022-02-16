import java.util.ArrayList;

public class ClientePrivado extends Cliente {
    private int CodigoPostal;

    // Constructor

    public ClientePrivado() {
        this.CodigoPostal = CodigoPostal;
    }

    public ClientePrivado(String nombre5, String apellidos5, String dni5, String email5, String codigoPostal5) {
        super(nombre5, apellidos5, dni5, email5);
        CodigoPostal = Integer.parseInt(codigoPostal5);
    }

    public ClientePrivado(String nombre, String apellido, String dni) {
        super(nombre, apellido, dni);
    }




    // Getters y Setters

    public int getCodigoPostal() {
        return CodigoPostal;
    }

    public void setCodigoPostal(int CodigoPostal) {
        this.CodigoPostal = CodigoPostal;
    }
    ArrayList<Integer> libros = new ArrayList<>();
    // Guardar isbn del libro prestado
    public void guardarLibro(Libros libro){
        libros.add(libro.getIsbn());
        System.out.println("Libro guardado");
    }

    // Comparar isbn
    public boolean comprobarLibro(int isbn){
        if(libros.contains(isbn)){
            return true;
        }
        return false;
    }

    // Devolver libro

    public Integer devolverLibro(int isbn){
        libros.removeIf(i -> i == isbn);
        return null;
    }


    }

