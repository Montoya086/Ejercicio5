/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Acompañante.java
Lenguaje: Java
Creación: 10/10/2021
Modificacion: 16/10/2021
*/
import java.util.ArrayList;
public abstract class Acompanante extends Combatiente{
    protected ArrayList<String> habilidad;
    public Acompanante(String nombre){
        super(nombre);
        habilidad=new ArrayList<String>();
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
