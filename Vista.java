/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Vista.java
Lenguaje: Java
Creación: 24/09/2021
Modificacion: 27/09/2021
*/
import java.util.Scanner;
public class Vista {
    Scanner sc = new Scanner(System.in);
    
    /** 
     * @return String
     */
    public String ingreso_nombre(){//ingresar el nombre
        try{
            System.out.println("Ingrese el nombre de su heroe:");
            return sc.nextLine();
        }catch(Exception e){
            return "";
        }
    }
    
    /** 
     * @return int
     */
    public int seleccion_clase(){//seleccion de clases
        try{
            System.out.println("Ingrese la clase de su jugador");
            System.out.println("1.Guerrero");
            System.out.println("2.Explorador");
            return Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            return 0;
        }
    }
    
    /** 
     * @param lista
     */
    public void mostrar_combatientes(String lista){//mostrar lista de combatientes
        System.out.println("Combatientes:");
        System.out.println(lista);
    }
    
    /** 
     * @param lista
     * @return int
     */
    public int elegir_objetivo(String lista){//elegir objetivo
        try{
            System.out.println("Combatientes:");
            System.out.println(lista);
            return Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            return -1;
        }
    }
    
    /** 
     * @param lista
     */
    public void objetivo(){// mensaje de elegir objetivo
        System.out.println("Elige tu objetivo:");
    }
    
    /** 
     * @param lista
     */
    public void item(){// mensaje de elegir item
        System.out.println("Elige tu item:");
    }
    
    /** 
     * @param lista
     */
    public void habilidad(){// mesnaje de elegir habilidad
        System.out.println("Elige tu habilidad:");
    }
    
    /** 
     * @param lista
     * @return int
     */
    public int elegir_item(String lista){//elegir item
        try{
            System.out.println(lista);
            return Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            return -1;
        }
    }
    
    /** 
     * @param lista
     * @return int
     */
    public int elegir_habilidad(String lista){//elegir habilidad
        try{
            System.out.println(lista);
            return Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            return -1;
        }
    }
    
    /** 
     * @return int
     */
    public int menu_jugador(){//menu del jugador
        try{
            System.out.println("Ingrese la opcion a ejectuar:");
            System.out.println("1.Atacar");
            System.out.println("2.Usar item");
            System.out.println("3.Saltar turno");
            return Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            return 0;
        }
        
    }
    
    /** 
     * @return int
     */
    public int menu_enemigo(){//menu de los enemigos
        try{
            System.out.println("Ingrese la opcion a ejectuar:");
            System.out.println("1.Atacar");
            System.out.println("2.Usar habilidad");
            System.out.println("3.Saltar turno");
            return Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            return 0;
        }
    }
    public void mostrar_turno(String n){//mostrar de quien es el turno
        System.out.println("Truno de: "+n);
    }
    public void mostrar_mensaje(String nombre, String mensaje){//mostrar mensajes de cada combatiente
        System.out.println("-"+nombre+": "+mensaje);
    }
    public void separador(){//separador
        System.out.println("\n*************************************\n");
    }
    public void win(){//mensaje de ganador
        System.out.println("Todos los enemigos han sido derrotados");
    }
    public void lose(){//mensaje de perder
        System.out.println("Los heroes han sido derrotados...");
    }
}
