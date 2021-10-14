/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Enemigo.java
Lenguaje: Java
Creación: 24/09/2021
Modificacion: 27/09/2021
*/
import java.util.ArrayList;
public class Enemigo extends Combatiente{
    protected ArrayList<String> habilidad;
    public Enemigo(String nombre){
        super(nombre);
        habilidad=new ArrayList<String>();
        if(nombre=="Slime"){
            habilidad.add("Veneno");
            vida=300;
            atq=30;
            msg_inicio="blublublublub";
            msg_muerte="blub...";
            msg_victoria="blub bl!";
        }
        if(nombre=="Undead"){
            habilidad.add("Fuerza");
            vida=200;
            atq=60;
            msg_inicio="Grrrrr";
            msg_muerte="Ujjjj...";
            msg_victoria="Grrrr!";
        }
        if(nombre=="Goblin"){
            habilidad.add("Curacion");
            vida=500;
            atq=15;
            msg_inicio="Nuevos muñecos de prueba...";
            msg_muerte="Esto...No debio pasar...";
            msg_victoria="Tan fragiles como pense";
        }
    }
    
    /** 
     * @param index
     */
    public void eliminar_habilidad(int index){
        habilidad.remove(index);
    }
    
    /** 
     * @param index
     * @return String
     */
    public String getHabilidad(int index){
        return habilidad.get(index);
    }
    
    /** 
     * @param i=0;i<habilidad.size();i++
     * @return String
     */
    public String get_habilidades(){//desplegar lista de habilidades
        String list_items="\n";
        for(int i=0;i<habilidad.size();i++){
            list_items=list_items+i+". "+habilidad.get(i)+"\n";
        }
        return list_items;
    }
    
    /** 
     * @return int
     */
    public int cantidad_habilidades(){
        return habilidad.size();
    }
}
