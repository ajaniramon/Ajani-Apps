package ejercicio.pkg1;

import java.util.*;

/**
 *
 * @author alumno
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in); //dos scanner porque con el nextline da fallo en ocasiones
        Map<Integer, String> empresa = new HashMap<>();
        boolean open = false; //controla la ejecución del bucle.

        do {
            open = false;
            System.out.println("Bienvenido a su empresa. Por favor, escoja una opción del menú.");
            System.out.println("   ");
            System.out.println("1. Introducir trabajador.");
            System.out.println("2. Buscar trabajador por NIF.");
            System.out.println("3. Buscar trabajador por nombre.");
            System.out.println("4. Modificar trabajador. ");
            System.out.println("5. Borrar trabajador. ");
            System.out.println("6. Salir. ");
            int eleccion = sc.nextInt();

            if (eleccion == 1) {
                System.out.println("Introduce el NIF del trabajador: ");
                int NIF = sc.nextInt();
                System.out.println("Introduce el nombre del trabajador: ");
                String name = sc2.nextLine();
                empresa.put(NIF, name);
                System.out.println("Se ha añadido el trabajador " + name + " con el NIF " + NIF + " .");
                open = true;
            }
            if (eleccion == 2) {

                System.out.println("Introduce el NIF del trabajador a buscar: ");
                int NIF = sc2.nextInt();
                boolean existe = empresa.containsKey(NIF);
                if (existe) {
                    System.out.println("El trabajador con NIF " + NIF + " se llama " + empresa.get(NIF));
                    open = true;
                } else {
                    System.out.println("El trabajador deseado no existe.");
                    open = true;
                }

            }
            if (eleccion == 3) {
                int clave;
                System.out.println("Introduce el nombre del trabajador a buscar: ");
                String name = sc2.nextLine();
                boolean existe = empresa.containsValue(name);
                if (existe) {
                    Iterator<Integer> it = empresa.keySet().iterator();
                    while (it.hasNext()) {
                        Integer key = it.next();
                        if (name.equalsIgnoreCase(empresa.get(key))) {
                            clave = key;
                            System.out.println("El trabajador " + name + " tiene como NIF " + clave);
                            open = true;
                        }
                    }
                        
                } else {
                    System.out.println("   ");
                    System.out.println("El trabajador deseado no existe. ");
                    open = true;
                }
            }
            if (eleccion == 4) {
                System.out.println("Introduce el NIF del trabajador a modificar: ");
                int NIF = sc.nextInt();
                boolean existe = empresa.containsKey(NIF);
                if (existe) {
                    empresa.remove(NIF);
                    System.out.println("Introduce nuevo NIF: ");
                    int nif2 = sc.nextInt();
                    System.out.println("Introduce nuevo nombre: ");
                    String name = sc2.nextLine();
                    empresa.put(nif2, name);
                    System.out.println("Se ha añadido el trabajador con NIF " + nif2 + " con nombre " + name);
                    open = true;
                } else {
                    System.out.println("El trabajador deseado no existe. ");
                    open = true;
                }
            }
            if (eleccion == 5) {
                System.out.println("Introduce el NIF del trabajador a borrar: ");
                int NIF = sc.nextInt();
                boolean existe = empresa.containsKey(NIF);
                if (existe) {
                    empresa.remove(NIF);
                    System.out.println("El trabajador " + NIF + " ha sido eliminado correctamente :)");
                    open = true;
                } else {
                    System.out.println("El trabajador deseado no existe. ");
                    open = true;
                }
            }
            if (eleccion == 6) {
                System.out.println("Gracias por utilizar nuestro programa. ");
                System.out.println("");
                System.out.println("   ");
                System.out.println("");
                open = false;
            }















        } while (open == true);








    }
}
