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
            System.out.println("3.Cazador");
            return Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            return 0;
        }
    }

    public int numero_jugadores(){
        try{
            System.out.println("Ingrese el numero de jugadores (1-3):");
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
    
    public void objetivo(){// mensaje de elegir objetivo
        System.out.println("Elige tu objetivo:");
    }
    
    public void item(){// mensaje de elegir item
        System.out.println("Elige tu item:");
    }

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
            System.out.println("3.Lanzar mascota");
            System.out.println("4.Saltar turno");
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
    /** 
     * @return int
     */
    public int menu_boss(){//menu de los enemigos
        try{
            System.out.println("Ingrese la opcion a ejectuar:");
            System.out.println("1.Atacar");
            System.out.println("2.Usar habilidad");
            System.out.println("3.Lanzar acompañante");
            System.out.println("4.Clonar");
            System.out.println("5.Variar");
            System.out.println("6.Liberar");
            System.out.println("7.Saltar turno");
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
    public void noItems(){//mensaje de perder
        System.out.println("No hay items disponibles");
    }
    public void nomascota(){//mensaje de perder
        System.out.println("Solo los cazadores pueden usar mascotas");
    }
    public void noacompanante(){//mensaje de perder
        System.out.println("No hay acompañantes disponibles");
    }
    public void lanzado(){//mensaje de perder
        System.out.println("El acompañante está en el campo de batalla");
    }
    public void lanzado2(){//mensaje de perder
        System.out.println("Algunos acompañantes ya estan en el campo de batalla, lanzando a los que no lo esten");
    }
    public void ataque_acompañante(){//mensaje de perder
        System.out.println("El acompañante ha atacado con su dueño");
    }
    public void mascota_recuperandose(int rondas){
        System.out.println("La mascota ha muerto y se esta recuperando. Rondas restantes: "+rondas);
    }
    public void noclonable(){
        System.out.println("El objetivo seleccionado no es clonable");
    }
    public void nohabilidades(){
        System.out.println("Al tener clones no es posible lanzar habilidades");
    }
    public void clonado(){
        System.out.println("El objetivo ha sido clonado");
    }
    public void liberado(){
        System.out.println("Los acompañantes han sido liberados");
    }
    public void habilidad_compartida(String habilidad){
        System.out.println("La habilidad compartida del Raidboss ha sido cambiada a: "+habilidad);
    }
}
