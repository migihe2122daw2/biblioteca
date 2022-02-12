
import java.util.*;

public class main {

    public static void main(String[] args) {

        // Main class for all the biblio-related stuff

        // Primero creamos libros

        // Creamos un libro

        ArrayList<Libros> libros = new ArrayList<Libros>();

        Libros Libro1 = new Libros("El camino de los reyes", "Brandon Sanderson", 1212, 3, 30);
        Libros Libro2 = new Libros("Indigno de ser humano", "Osamu Dazai", 0313, 1, 19);
        Libros Libro3 = new Libros("Dime quien soy", "Julia Navarro", 0002, 5, 20);
        Libros Libro4 = new Libros("La chica del tren", "Paula Hawkins", 0200, 2, 16);
        Libros Libro5 = new Libros("Los renglones torcidos de Dios", "Torcuato Luca de Tena", 2010, 10, 15);
        Libros Libro6 = new Libros("Tan poca vida", "Hanya Yanagihara", 0003, 20, 17);
        Libros Libro7 = new Libros("1984", "George Orwell", 0010, 4, 15);

        // Añadimos los libros al arraylist

        libros.add(Libro1);
        libros.add(Libro2);
        libros.add(Libro3);
        libros.add(Libro4);
        libros.add(Libro5);
        libros.add(Libro6);
        libros.add(Libro7);

        // Swwitch case para el menu

        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Escoge un libro");
            // Iterator para recorrer el arraylist

            Iterator<Libros> it = libros.iterator();
            while (it.hasNext()) {
                Libros libro = it.next();
                System.out.println(libro.getIsbn() + " " + libro.getTitulo() + " " + libro.getAutor());
            }
            System.out.println("Escribe el isbn del libro");
            // Con el isbn buscamos el libro en el arraylist y lo pasamos a la clase libros al metodo PrestadoOno
            opcion = sc.nextInt();
            for (Libros libro : libros) {
                if (opcion == libro.getIsbn()) {
                    libro.PrestadoOno(libros);
                }
            }
        }while (opcion != 0);

        // Llamaos al metodo PrestadoOno

        Libros libro = new Libros();
        libro.PrestadoOno(libros);


    }
}
