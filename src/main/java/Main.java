import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	OperacionesCRUD contacto = new OperacionesCRUD();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        System.out.println("\nMenú de Operaciones CRUD");
        System.out.println("1. Insertar Contacto");
        System.out.println("2. Leer Contactos");
        System.out.println("3. Actualizar Contacto");
        System.out.println("4. Borrar Contacto");
        System.out.print("Seleccione una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        switch (opcion) {
            case 1:
                insertarContacto(contacto, scanner);
                break;
            case 2:
                contacto.leerContactos();
                break;
            case 3:
                actualizarContacto(contacto, scanner);
                break;
            case 4:
                borrarContacto(contacto, scanner);
                break;
            case 5:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }

        DatabaseConnection.cerrarConexion();
        scanner.close();
    }

    private static void insertarContacto(OperacionesCRUD contacto, Scanner scanner) {
        System.out.print("Ingrese Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese Apellidos: ");
        String apellidos = scanner.nextLine();

        System.out.print("Ingrese DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Ingrese Telefono: Será 555-55-55-55");
        String telefono = "555555555";

        System.out.println("Ingrese Ecorreo: será aa@ss.a ");
        String ecorreo = "aa@ss.a";

        System.out.println("Ingrese Fecha de Cumpleaños (YYYY-MM-DD): Será 2001-02-01");
        String fechacumple = "2001-02-011";

        System.out.print("Ingrese Dirección: ");
        String direccion = scanner.nextLine();

        System.out.println("Ingrese Población: será asd");
        String poblacion = "asd";

        System.out.println("Ingrese Provincia (ID): será 0 ");
        int provincia = 0;

        System.out.println("Ingrese Código Postal: será 12121");
        String codigoPostal = "12121";

        System.out.println("Categoría: será CUMP");
        String categoria = "CUMP";

        System.out.print("Ingrese Deuda: ");
        int deuda = scanner.nextInt();
        scanner.nextLine(); 

        Contacto contacto_ = new Contacto(0, nombre, apellidos, dni, telefono, ecorreo, fechacumple, direccion, poblacion, provincia, codigoPostal, categoria, deuda);
        contacto.insertarContacto(contacto_);
    }

    private static void actualizarContacto(OperacionesCRUD contacto, Scanner scanner) {
        System.out.print("Ingrese Id_contacto del contacto a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese nuevo Telefono: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese nuevo Ecorreo: ");
        String ecorreo = scanner.nextLine();

        Contacto contacto_ = new Contacto(id, null, null, null, telefono, ecorreo, null, null, null, 0, null, null, 0);
        contacto.actualizarContacto(contacto_);
    }

    private static void borrarContacto(OperacionesCRUD contacto, Scanner scanner) {
        System.out.print("Ingrese Id_contacto del contacto a borrar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        contacto.borrarContacto(id);
    }
}
