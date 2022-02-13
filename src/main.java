
import java.util.*;

public class main {

    public static void main(String[] args) {

        // Main class for all the biblio-related stuff

        // Primero creamos libros

        // Creamos un libro A

        ArrayList<Libros> libros = new ArrayList<Libros>();

        Libros Libro1 = new Libros("El camino de los reyes", "Brandon Sanderson", 1212, 3, 30);
        Libros Libro2 = new Libros("Indigno de ser humano", "Osamu Dazai", 5626, 1, 19);
        Libros Libro3 = new Libros("Dime quien soy", "Julia Navarro", 8233, 5, 20);
        Libros Libro4 = new Libros("La chica del tren", "Paula Hawkins", 9024, 2, 16);
        Libros Libro5 = new Libros("Los renglones torcidos de Dios", "Torcuato Luca de Tena", 2010, 10, 15);
        Libros Libro6 = new Libros("Tan poca vida", "Hanya Yanagihara", 1256, 20, 17);
        Libros Libro7 = new Libros("1984", "George Orwell", 9983, 4, 15);

        // Añadimos los libros al arraylist

        libros.add(Libro1);
        libros.add(Libro2);
        libros.add(Libro3);
        libros.add(Libro4);
        libros.add(Libro5);
        libros.add(Libro6);
        libros.add(Libro7);

        // Creamos una de vinilos

        // Creamos los vinilos
        ArrayList<Vinilos> vinilos = new ArrayList<Vinilos>();

        Vinilos vinilos1 = new Vinilos("Fine line", 12, 01, "03/05/2018");
        Vinilos vinilos2 = new Vinilos("evermore", 10, 02, "20/05/2012");
        Vinilos vinilos3 = new Vinilos("Nevermind", 12, 03, "08/03/1991");
        Vinilos vinilos4 = new Vinilos("The doors", 11, 04, "19/10/2010");
        Vinilos vinilos5 = new Vinilos("Morrison Hotel", 11, 05, "21/09/2015");

        vinilos.add(vinilos1);
        vinilos.add(vinilos2);
        vinilos.add(vinilos3);
        vinilos.add(vinilos4);
        vinilos.add(vinilos5);

        // Swwitch case para el menu

        Scanner sc = new Scanner(System.in);
        int opcion;
        do {

            // Hacer login para acceder al menu

            System.out.println("Indica que tipo de usuario eres: ");
            System.out.println("1. Usuario Privado");
            System.out.println("2. Usuario Escuela de musica");
            System.out.println("3. Administrador");
            System.out.println("4. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    do {
                        System.out.println("Escoge un libro");

                        // Iterator para recorrer el arraylist
                        Iterator<Libros> it = libros.iterator();
                        while (it.hasNext()) {
                            Libros libro = it.next();
                            System.out.println("ISBN: " + libro.getIsbn() + "\n Titulo: " + libro.getTitulo() + "\n Autor: " + libro.getAutor() + "\n");
                        }
                        System.out.println("Escribe el isbn del libro que quiere o 99 para salir: ");

                        // Con el isbn buscamos el libro en el arraylist y lo pasamos a la clase libros al metodo PrestadoOno
                        int isbn = sc.nextInt();
                        if (isbn == 99) {
                            break;
                        }

                        // Comprobar que el isb esta en el ArrayList
                        boolean encontrado = false;
                        Iterator<Libros> it2 = libros.iterator();
                        while (it2.hasNext()) {
                            Libros libro = it2.next();
                            if (libro.getIsbn() == isbn) {
                                encontrado = true;
                            }
                        }

                        for (Libros libro : libros) {

                            if (libro.getIsbn() == isbn) {


                            // Si el libro no esta prestado, se le puede presta
                            if (libro.getCantidad() >= 1) {

                                int numeroEscape = 0;

                                do {

                                    System.out.println("\nHay " + libro.getCantidad() + " libros disponibles");
                                    System.out.println("Quieres prestar el libro? (1. Si, 2. No)");
                                    int opcion2 = sc.nextInt();
                                    if (opcion2 == 1) {
                                        libro.Prestar(libro.getIsbn(), libros);
                                        sc.nextLine();
                                        System.out.println("Pulsa cualquier tecla para continuar");
                                        sc.nextLine();
                                        numeroEscape = 1;
                                    }else if(opcion2 == 2){
                                        int numeroEscape2 = 0;
                                        do {
                                            System.out.println("Quieres comprar el libro? (1. Si, 2. No)");
                                            int opcion3 = sc.nextInt();
                                            if (opcion3 == 1) {
                                                libro.Comprar(libro.getIsbn(), libros);
                                            }
                                            else if(opcion3 == 2){
                                                System.out.println("No se ha realizado ninguna accion");
                                                numeroEscape2 = 1;
                                            }
                                        } while (numeroEscape2 == 0);
                                        numeroEscape = 1;

                                    }


                                } while (numeroEscape == 0);

                                break;
                            }else if(libro.getCantidad() == 0){
                                System.out.println("No hay libros disponibles");
                                // Limpiar el buffer
                                sc.nextLine();
                                System.out.println("Pulsa cualquier tecla para continuar");
                                sc.nextLine();
                            }

                        }
                    }
                    } while (opcion != 4);
                    break;
                case 2:
                    do {

                        System.out.println("Escoge un vinilo: ");
                        // Iterator para recorrer el arraylist

                        Iterator<Vinilos> ite = vinilos.iterator();
                        while (ite.hasNext()) {
                            Vinilos vinilo = ite.next();
                            System.out.println("ID: " + vinilo.getId() + "\n Nombre: " + vinilo.getNombre() + "\n Numero de canciones: " + vinilo.getCanciones() + "\n\n");
                        }
                        System.out.println("Escribe el ID del vinilo que quiere o 99 para salir: ");

                        // Con el isbn buscamos el libro en el arraylist y lo pasamos a la clase libros al metodo PrestadoOno
                        int id = sc.nextInt();
                        if (id == 99) {
                            break;
                        }

                        // Comprobar que el id esta en el ArrayList
                        boolean encontrado = false;
                        Iterator<Vinilos> ite2 = vinilos.iterator();
                        while (ite2.hasNext()) {
                            Vinilos vinilo = ite2.next();
                            if (vinilo.getId() == id) {
                                encontrado = true;
                            }
                        }

                        for (Vinilos vinilo : vinilos) {
                            if (vinilo.getId() == id) {
                                System.out.println("El vinilo seleccionado es: " + vinilo.getNombre());
                                System.out.println("El vinilo tiene " + vinilo.getCanciones() + " canciones");
                                System.out.println("El vinilo salio a la venta el dia: " + vinilo.getFechaLanzamiento());

                                int numeroEscape = 0;
                                do {
                                    System.out.println("Quieres ver prestar el vinilo? (1. Si, 2. No)");
                                    int opcion2 = sc.nextInt();
                                    if (opcion2 == 1) {
                                        vinilo.Prestar(vinilo.getId(), vinilos);
                                        System.out.println("Pulsa cualquier tecla para continuar");
                                        sc.nextLine();
                                        numeroEscape = 1;
                                    }else if(opcion2 == 2){
                                        System.out.println("No se ha realizado ninguna accion");
                                        numeroEscape = 1;
                                    }
                                } while (numeroEscape == 0);
                                break;
                            }
                        }

                    }while (opcion != 4);
                    break;
                case 3:
                    System.out.println("Administrador");
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    opcion = 0;
                    break;
                default:
                    // Limpiamos la pantalla con ProcessBuilder
                    ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                    try {
                        pb.inheritIO().start().waitFor();

                    }
                    catch (Exception e) {
                        System.out.println("Error");
                    }

                    System.out.println("\nOpcion no valida");
                    break;
            }

        } while (opcion != 0);

        // Llamaos al metodo PrestadoOno




    }
}
