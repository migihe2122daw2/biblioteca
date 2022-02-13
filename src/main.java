
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

        // Crear usuario administrador
        ArrayList<Administrador> administradores = new ArrayList<Administrador>();
        Administrador admin1 = new Administrador("admin", "admin");
        administradores.add(admin1);

        // Crear cliente Privado
        ArrayList<ClientePrivado> clientesPrivados = new ArrayList<ClientePrivado>();
        ClientePrivado clientePrivado1 = new ClientePrivado("Juan", "Perez", "2131231", "juan1989@gmail.com", "1989");
        ClientePrivado clientePrivado2 = new ClientePrivado("Felipe", "Armadillo", "257239", "ArmadilloGOD@gmail.com", "1182");
        ClientePrivado clientePrivado3 = new ClientePrivado("Amanda", "Flores", "654932", "floresitamanda@gmail.com", "1009");

        clientesPrivados.add(clientePrivado1);
        clientesPrivados.add(clientePrivado2);
        clientesPrivados.add(clientePrivado3);

        // Crear cliente escuela privada
        ArrayList<ClienteEscolaMusica> clienteEscuelaM = new ArrayList<ClienteEscolaMusica>();
        ClienteEscolaMusica clienteEscola1 = new ClienteEscolaMusica("Tania", "Torres", "231312", "taniaat@gmail.com", "Clot");
        ClienteEscolaMusica clienteEscola2 = new ClienteEscolaMusica("Manolo", "Lopez", "987123", "manolin@gmail.com", "Clot");
        ClienteEscolaMusica clienteEscola3 = new ClienteEscolaMusica("Mariola", "Serrano", "561209", "mariiola1@gmail.com", "Clot");

        clienteEscuelaM.add(clienteEscola1);
        clienteEscuelaM.add(clienteEscola2);
        clienteEscuelaM.add(clienteEscola3);

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
                                        } else if (opcion2 == 2) {
                                            int numeroEscape2 = 0;
                                            do {
                                                System.out.println("Quieres comprar el libro? (1. Si, 2. No)");
                                                int opcion3 = sc.nextInt();
                                                if (opcion3 == 1) {
                                                    libro.Comprar(libro.getIsbn(), libros);
                                                } else if (opcion3 == 2) {
                                                    System.out.println("No se ha realizado ninguna accion");
                                                    numeroEscape2 = 1;
                                                }
                                            } while (numeroEscape2 == 0);
                                            numeroEscape = 1;

                                        }


                                    } while (numeroEscape == 0);

                                    break;
                                } else if (libro.getCantidad() == 0) {
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
                                    } else if (opcion2 == 2) {
                                        System.out.println("No se ha realizado ninguna accion");
                                        numeroEscape = 1;
                                    }
                                } while (numeroEscape == 0);
                                break;
                            }
                        }

                    } while (opcion != 4);
                    break;
                case 3:
                    int oportunidades = 3;
                    do {

                        // Pedir usuario y contraseña
                        System.out.println("Introduce tu usuario: ");
                        sc.nextLine();
                        String usuario = sc.nextLine();
                        System.out.println("Introduce tu contraseña: ");
                        String contraseña = sc.nextLine();

                        // Comprobar que el usuario y contraseña son correctos
                        boolean encontrado = false;
                        for (Administrador admin : administradores) {
                            if (admin.getUsuario().equals(usuario) && admin.getContra().equals(contraseña)) {
                                encontrado = true;
                            }
                        }

                        // Si falla la contraseña o el usuario se repite hasta 3 veces
                        if (encontrado == false) {
                            System.out.println("Usuario o contraseña incorrectos");
                            oportunidades--;
                        }


                        if (encontrado == true) {
                            System.out.println("Bienvenido " + usuario);
                            opcion = 0;
                            do {

                                // Menu de opciones
                                System.out.println("1. Gestión de libros");
                                System.out.println("2. Gestión discos de vinilo: ");
                                System.out.println("3. Gestión de clientes: ");
                                System.out.println("4. Gestión de trabajadores: ");
                                System.out.println("5. Gestión de prestamos: ");
                                System.out.println("6. Salir");

                                opcion = sc.nextInt();
                                sc.nextLine();

                                switch (opcion) {
                                    case 1:
                                        int opcion2 = 0;
                                        do {
                                            System.out.println("1. Añadir libro");
                                            System.out.println("2. Eliminar libro");
                                            System.out.println("3. Modificar libro");
                                            System.out.println("4. Ver libros");
                                            System.out.println("5. Salir");

                                            opcion2 = sc.nextInt();
                                            sc.nextLine();

                                            switch (opcion2) {
                                                case 1:
                                                    System.out.println("Introduce el titulo del libro: ");
                                                    String titulo = sc.nextLine();
                                                    System.out.println("Introduce el autor del libro: ");
                                                    String autor = sc.nextLine();
                                                    System.out.println("Introduce el isbn del libro: ");
                                                    int isbn = sc.nextInt();
                                                    System.out.println("Introduce la cantidad de libros: ");
                                                    int cantidad = sc.nextInt();
                                                    sc.nextLine();
                                                    System.out.println("Introduce el precio del libro: ");
                                                    int precio = sc.nextInt();
                                                    sc.nextLine();

                                                    libros.add(new Libros(titulo, autor, isbn, cantidad, precio));
                                                    break;
                                                case 2:
                                                    System.out.println("Introduce el isbn del libro que quieres eliminar: ");
                                                    int isbn2 = sc.nextInt();
                                                    sc.nextLine();
                                                    libros.removeIf(libro -> libro.getIsbn() == isbn2);
                                                    break;
                                                case 3:
                                                    System.out.println("Introduce el isbn del libro que quieres modificar: ");
                                                    int isbn3 = sc.nextInt();
                                                    sc.nextLine();
                                                    for (Libros libro : libros) {
                                                        if (libro.getIsbn() == isbn3) {
                                                            System.out.println("Introduce el nuevo titulo del libro: ");
                                                            String titulo2 = sc.nextLine();
                                                            System.out.println("Introduce el nuevo autor del libro: ");
                                                            String autor2 = sc.nextLine();
                                                            System.out.println("Introduce el nuevo isbn del libro: ");
                                                            int isbn4 = sc.nextInt();
                                                            System.out.println("Introduce la nueva cantidad de libros: ");
                                                            int cantidad2 = sc.nextInt();
                                                            sc.nextLine();
                                                            System.out.println("Introduce el nuevo precio del libro: ");
                                                            int precio2 = sc.nextInt();
                                                            sc.nextLine();
                                                            libro.setTitulo(titulo2);
                                                            libro.setAutor(autor2);
                                                            libro.setIsbn(isbn4);
                                                            libro.setCantidad(cantidad2);
                                                            libro.setPrecio(precio2);
                                                        }
                                                    }
                                                    break;
                                                case 4:
                                                    System.out.println("Introduce el isbn del libro que quieres consultar: ");
                                                    int isbn5 = sc.nextInt();
                                                    sc.nextLine();
                                                    for (Libros libro : libros) {
                                                        if (libro.getIsbn() == isbn5) {
                                                            System.out.println("Titulo: " + libro.getTitulo());
                                                            System.out.println("Autor: " + libro.getAutor());
                                                            System.out.println("ISBN: " + libro.getIsbn());
                                                        }
                                                    }
                                                    break;
                                                case 5:
                                                    break;
                                                default:
                                                    System.out.println("Opcion incorrecta");
                                                    break;
                                            }
                                        } while (opcion2 != 5);
                                        break;
                                    case 2:
                                        int opcion3;
                                        do {
                                            System.out.println("1. Añadir un vinilo");
                                            System.out.println("2. Modificar un vinilo");
                                            System.out.println("3. Consultar un vinilo");
                                            System.out.println("4. Eliminar un vinilo");
                                            System.out.println("5. Salir");
                                            opcion3 = sc.nextInt();
                                            sc.nextLine();
                                            switch (opcion3) {
                                                case 1:
                                                    System.out.println("Introduce el nombre del vinilo: ");
                                                    String nombre3 = sc.nextLine();
                                                    System.out.println("Introduce numero de canciones del vinilo: ");
                                                    int numero3 = sc.nextInt();
                                                    sc.nextLine();
                                                    System.out.println("Introduce el id del vinilo: ");
                                                    int id3 = sc.nextInt();
                                                    sc.nextLine();
                                                    System.out.println("Introduce la fecha de lanzamiento del vinilo: ");
                                                    String fecha3 = sc.nextLine();

                                                    Vinilos vinilo = new Vinilos(nombre3, numero3, id3, fecha3);
                                                    vinilos.add(vinilo);
                                                    break;
                                                case 2:
                                                    System.out.println("Introduce el id del vinilo que quieres modificar: ");
                                                    int id4 = sc.nextInt();
                                                    sc.nextLine();
                                                    for (Vinilos vinilo2 : vinilos) {
                                                        if (vinilo2.getId() == id4) {
                                                            System.out.println("Introduce el nuevo nombre del vinilo: ");
                                                            String nombre4 = sc.nextLine();
                                                            System.out.println("Introduce el nuevo numero de canciones del vinilo: ");
                                                            int numero4 = sc.nextInt();
                                                            sc.nextLine();
                                                            System.out.println("Introduce la nueva fecha de lanzamiento del vinilo: ");
                                                            String fecha4 = sc.nextLine();
                                                            vinilo2.setNombre(nombre4);
                                                            vinilo2.setCanciones(numero4);
                                                            vinilo2.setFechaLanzamiento(fecha4);

                                                        }
                                                    }
                                                    break;
                                                case 3:
                                                    System.out.println("Introduce el id del vinilo que quieres consultar: ");
                                                    int id5 = sc.nextInt();
                                                    sc.nextLine();
                                                    for (Vinilos vinilo3 : vinilos) {
                                                        if (vinilo3.getId() == id5) {
                                                            System.out.println("Nombre del vinilo: " + vinilo3.getNombre());
                                                            System.out.println("Numero de canciones del vinilo: " + vinilo3.getCanciones());
                                                            System.out.println("Fecha de lanzamiento del vinilo: " + vinilo3.getFechaLanzamiento());
                                                        }
                                                    }
                                                    break;
                                                case 4:
                                                    System.out.println("Introduce el id del vinilo que quieres eliminar: ");
                                                    int id6 = sc.nextInt();
                                                    sc.nextLine();
                                                    for (Vinilos vinilo4 : vinilos) {
                                                        if (vinilo4.getId() == id6) {
                                                            vinilos.removeIf(vinilo5 -> vinilo5.getId() == id6);
                                                        }
                                                    }
                                                    break;
                                                case 5:
                                                    break;
                                                default:
                                                    System.out.println("Opcion incorrecta");
                                                    break;
                                            }
                                        } while (opcion3 != 5);
                                        break;
                                    case 3:
                                        int opcion4;
                                        do {
                                            System.out.println("Indica que tipo de cliente quieres gestionar: ");
                                            System.out.println("1. Cliente Privado");
                                            System.out.println("2. Cliente escuela música");
                                            System.out.println("3. Salir");
                                            opcion4 = sc.nextInt();
                                            sc.nextLine();
                                            switch (opcion4) {
                                                case 1:
                                                    int opcion5 = 0;
                                                    do {
                                                        System.out.println("1. Añadir un nuevo cliente");
                                                        System.out.println("2. Modificar un cliente");
                                                        System.out.println("3. Consultar un cliente");
                                                        System.out.println("4. Eliminar un cliente");
                                                        System.out.println("5. Salir");
                                                        opcion4 = sc.nextInt();
                                                        sc.nextLine();
                                                        switch (opcion5) {
                                                            case 1:
                                                                System.out.println("Introduce el nombre del cliente: ");
                                                                String nombre5 = sc.nextLine();
                                                                System.out.println("Introduce los apellidos del cliente: ");
                                                                String apellidos5 = sc.nextLine();
                                                                System.out.println("Introduce el DNI del cliente: ");
                                                                String dni5 = sc.nextLine();
                                                                System.out.println("Introduce el email del cliente: ");
                                                                String email5 = sc.nextLine();
                                                                System.out.println("Introduce el codigo postal del cliente: ");
                                                                String codigoPostal5 = sc.nextLine();

                                                                ClientePrivado clientePrivado = new ClientePrivado(nombre5, apellidos5, dni5, email5, codigoPostal5);
                                                                clientesPrivados.add(clientePrivado);
                                                                break;
                                                            case 2:
                                                                System.out.println("Introduce el DNI del cliente que quieres modificar: ");
                                                                String dni6 = sc.nextLine();
                                                                for (ClientePrivado clientePrivado4 : clientesPrivados) {
                                                                    if (clientePrivado4.getDni().equals(dni6)) {
                                                                        System.out.println("Introduce el nombre del cliente: ");
                                                                        String nombre6 = sc.nextLine();
                                                                        System.out.println("Introduce los apellidos del cliente: ");
                                                                        String apellidos6 = sc.nextLine();
                                                                        System.out.println("Introduce el email del cliente: ");
                                                                        String email6 = sc.nextLine();
                                                                        System.out.println("Introduce el codigo postal del cliente: ");
                                                                        int codigoPostal6 = sc.nextInt();
                                                                        clientePrivado4.setNombre(nombre6);
                                                                        clientePrivado4.setApellidos(apellidos6);
                                                                        clientePrivado4.setEmail(email6);
                                                                        clientePrivado4.setCodigoPostal(codigoPostal6);

                                                                    }
                                                                }
                                                                break;
                                                            case 3:
                                                                System.out.println("Introduce el DNI del cliente que quieres eliminar: ");
                                                                String dni7 = sc.nextLine();
                                                                for (ClientePrivado clientePrivado5 : clientesPrivados) {
                                                                    if (clientePrivado5.getDni().equals(dni7)) {
                                                                        clientesPrivados.removeIf(clientePrivado6 -> clientePrivado6.getDni() == dni7);
                                                                    }
                                                                }
                                                                break;
                                                            case 4:
                                                                System.out.println("Introduce el DNI del cliente que quieres buscar: ");
                                                                String dni8 = sc.nextLine();
                                                                for (ClientePrivado clientePrivado6 : clientesPrivados) {
                                                                    if (clientePrivado6.getDni().equals(dni8)) {
                                                                        System.out.println(clientePrivado6);
                                                                    }

                                                                }
                                                                break;
                                                            case 5:
                                                                break;
                                                            default:
                                                                System.out.println("Opcion incorrecta");
                                                                break;
                                                        }
                                                    } while (opcion5 != 5);
                                                    break;
                                                case 2:
                                                    int opcion6;
                                                    do {
                                                        System.out.println("1. Añadir cliente");
                                                        System.out.println("2. Eliminar cliente");
                                                        System.out.println("3. Buscar cliente");
                                                        System.out.println("4. Mostrar cliente");
                                                        System.out.println("5. Salir");
                                                        opcion6 = sc.nextInt();
                                                        sc.nextLine();
                                                        switch (opcion6) {
                                                            case 1:
                                                                System.out.println("Introduce el DNI del cliente que quieres añadir: ");
                                                                String dni9 = sc.nextLine();
                                                                System.out.println("Introduce el nombre del cliente que quieres añadir: ");
                                                                String nombre9 = sc.nextLine();
                                                                System.out.println("Introduce los apellidos del cliente  que quieres añadir: ");
                                                                String apellidos9 = sc.nextLine();
                                                                System.out.println("Introduce el email del cliente que quieres añadir: ");
                                                                String email9 = sc.nextLine();
                                                                System.out.println("Introduce el nombre de la escuela del cliente que quieres añadir: ");
                                                                String escuela9 = sc.nextLine();

                                                                ClienteEscolaMusica clienteEscolaMusica = new ClienteEscolaMusica(dni9, nombre9, apellidos9, email9, escuela9);
                                                                clienteEscuelaM.add(clienteEscolaMusica);
                                                                break;
                                                            case 2:
                                                                System.out.println("Introduce el DNI del cliente que quieres eliminar: ");
                                                                String dni10 = sc.nextLine();
                                                                for (int i = 0; i < clienteEscuelaM.size(); i++) {
                                                                    if (clienteEscuelaM.get(i).getDni().equals(dni10)) {
                                                                        clientesPrivados.remove(i);
                                                                    }
                                                                }

                                                                break;
                                                            case 3:
                                                                System.out.println("Introduce el DNI del cliente que quieres buscar: ");
                                                                String dni11 = sc.nextLine();
                                                                for (int i = 0; i < clienteEscuelaM.size(); i++) {
                                                                    if (clienteEscuelaM.get(i).getDni().equals(dni11)) {
                                                                        System.out.println(clienteEscuelaM.get(i));
                                                                    }
                                                                }
                                                                break;
                                                            case 4:
                                                                System.out.println("Introduce el DNI del cliente que quieres modificar: ");
                                                                String dni12 = sc.nextLine();
                                                                for (int i = 0; i < clienteEscuelaM.size(); i++) {
                                                                    if (clienteEscuelaM.get(i).getDni().equals(dni12)) {
                                                                        System.out.println("Introduce el nuevo DNI del cliente que quieres modificar: ");
                                                                        String dni13 = sc.nextLine();
                                                                        System.out.println("Introduce el nuevo nombre del cliente que quieres modificar: ");
                                                                        String nombre13 = sc.nextLine();
                                                                        System.out.println("Introduce el nuevo apellidos del cliente que quieres modificar: ");
                                                                        String apellidos13 = sc.nextLine();
                                                                        System.out.println("Introduce el nuevo email del cliente que quieres modificar: ");
                                                                        String email13 = sc.nextLine();
                                                                        System.out.println("Introduce el nuevo nombre de la escuela del cliente que quieres modificar: ");
                                                                        String escuela13 = sc.nextLine();

                                                                        clienteEscuelaM.get(i).setDni(dni13);
                                                                        clienteEscuelaM.get(i).setNombre(nombre13);
                                                                        clienteEscuelaM.get(i).setApellidos(apellidos13);
                                                                        clienteEscuelaM.get(i).setEmail(email13);
                                                                        clienteEscuelaM.get(i).setNombreEscuela(escuela13);
                                                                    }
                                                                }
                                                                break;
                                                            case 5:
                                                                break;
                                                            default:
                                                                System.out.println("Introduce una opción correcta");
                                                                break;
                                                        }
                                                        break;
                                                    } while (opcion6 != 5);
                                                    break;
                                                case 3:
                                                    break;
                                                default:
                                                    System.out.println("Introduce una opción correcta");
                                                    break;
                                            }
                                        } while (opcion4 != 3);
                                        break;
                                    case 4:
                                        break;
                                    case 5:
                                        break;
                                    case 6:
                                        oportunidades = 0;
                                        break;
                                    default:
                                        System.out.println("Introduce una opción correcta");
                                        break;
                                }
                            } while (opcion != 6);
                        }
                    } while (oportunidades != 0);
                case 4:
                    break;
                default:
                    System.out.println("Introduce una opción correcta");
                    break;

            }
        } while (opcion != 4);
    }
}
