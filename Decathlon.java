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
        Map<Integer, String> atletas = new HashMap<>();
        int[][] tiempos = new int[3][3];
        //filas = atletas
        //columnas = tiempos o carreras
        boolean open = false;
        int media = 0;
        int mejor_tiempo = 999;
        int suma = 0;

        do {
            open = false;
            System.out.println("Bienvenido al sistema de control de carrera. Por favor elija una opción: ");
            System.out.println("   ");
            System.out.println("1. Introducir atleta con dorsal.");
            System.out.println("2. Introducir tiempos. ");
            System.out.println("3. Ver tiempos de una carrera.  ");
            System.out.println("4. Mejor tiempo de cada atleta. ");
            System.out.println("5. Indicar si han mejorado la marca en una carrera. ");
            System.out.println("6. Tiempo medio en una carrera. ");
            System.out.println("7. Ver atletas que han superado la media. ");
            System.out.println("8. Salir. ");
            int eleccion = sc.nextInt();

            if (eleccion == 1) {
                System.out.println("Introduce el dorsal del atleta: ");
                int dorsal = sc.nextInt();
                System.out.println("Introduce el nombre del atleta: ");
                String nombre = sc2.nextLine();
                atletas.put(dorsal, nombre);
                System.out.println(" ");
                System.out.println("Se ha creado el atleta " + nombre + " con el dorsal " + dorsal);
                open = true;
            }
            if (eleccion == 2) {
                System.out.println("Introduce el dorsal del atleta: ");
                int dorsal = sc.nextInt();
                System.out.println("Introduce carrera:  ");
                int carrera = sc.nextInt();
                System.out.println("Introduce el tiempo que ha hecho: ");
                int tiempo = sc.nextInt();
                tiempos[dorsal][carrera] = tiempo;
                open = true;
            }
            if (eleccion == 3) {
                System.out.println("Introduce la carrera a mostrar: ");
                int carrera = sc.nextInt();
                for (int dorsal = 0; dorsal < 3; dorsal++) {
                    System.out.println("El tiempo para el atleta " + atletas.get(dorsal) + " es de " + tiempos[dorsal][carrera]);

                }
                open = true;
            }
            if (eleccion == 4) {
                System.out.println("Introduce el dorsal del atleta: ");
                int dorsal = sc.nextInt();
                for (int carrera = 0; carrera < 3; carrera++) {
                    if (tiempos[dorsal][carrera] < mejor_tiempo) {
                        mejor_tiempo = tiempos[dorsal][carrera];
                    }
                }
                System.out.println("El mejor tiempo para el atleta " + atletas.get(dorsal) + " es de " + mejor_tiempo + " segundos");
                open = true;
            }
            if (eleccion == 5) {
                System.out.println("Introduzca el dorsal del atleta: ");
                int dorsal = sc.nextInt();
                System.out.println("Introduzca la primera carrera a comparar: ");
                int carrera1 = sc.nextInt();
                System.out.println("Introduzca la segunda carrera a comparar: ");
                int carrera2 = sc.nextInt();
                if (tiempos[dorsal][carrera1] < tiempos[dorsal][carrera2]) {
                    System.out.println("El atleta NO ha mejorado su marca. ");
                } else {
                    System.out.println("El atleta SÍ ha mejorado su marca. ");
                }
                open = true;
            }
               
                if(eleccion == 6){
                    System.out.println("Introduce la carrera a mostrar: ");
                    int carrera = sc.nextInt();
                    for(int dorsal=0;dorsal<3;dorsal++){
                        suma = tiempos[dorsal][carrera] + suma;
                        media = suma / tiempos[0].length;
                        
                    }
                    System.out.println("La media de la carrera es: "+media);
                    open=true;
                    
                }
                if(eleccion == 7){
                    System.out.println("Introduce la carrera a mostrar: ");
                    int carrera = sc.nextInt();
                    for(int dorsal=0;dorsal<3;dorsal++){
                        suma = tiempos[dorsal][carrera] + suma;
                        media = suma / tiempos[0].length;
                        
                    }
                    System.out.println("La media es: "+media);
                    for(int dorsal=0;dorsal<3;dorsal++){
                        if(tiempos[dorsal][carrera]>media){
                            System.out.println("El atleta "+atletas.get(dorsal)+" ha superado la media.");
                        }
                    }
                    open = true;
                }
            if(eleccion == 8){
                System.out.println("Gracias por utilizar nuestro programa. ");
                open = false;
            }
            
            
            
            

        } while (open);



    }
}
