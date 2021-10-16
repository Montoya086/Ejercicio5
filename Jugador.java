/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Jugador.java
Lenguaje: Java
Creación: 24/09/2021
Modificacion: 27/09/2021
*/
import java.util.ArrayList;
public class Jugador extends Combatiente{
    String clase;
    ArrayList<String> items;
    public Jugador(String nombre, String clase){
        super(nombre);
        if(clase=="Guerrero"){
            this.clase="Guerrero";
            tipo="Guerrero";
            atq= 200;
            vida= 700;
            items=new ArrayList<String>();
            items.add("Filo de la noche");
            items.add("Posion de fuerza");
            msg_inicio="Ganaremos!";
            msg_muerte="Me vengare...";
            msg_victoria="Mueran criaturas inmundas!";
        }
        if(clase=="Explorador"){
            this.clase="Exlorador";
            tipo="Explorador";
            atq= 70;
            vida= 300;
            items=new ArrayList<String>();
            items.add("Filo de la noche");
            items.add("Posion de fuerza");
            items.add("Varita de vida");
            items.add("Varita de rayo");
            msg_inicio="Esto me dara una buena recompensa";
            msg_muerte="No puede ser...";
            msg_victoria="El gremio me dara una gran recompensa!";
        }
        if(clase=="Cazador"){
            this.clase="Cazador";
            tipo="Cazador";
            atq= 20;
            vida= 600;
            items=new ArrayList<String>();
            items.add("Posion de fuerza");
            acompañantes=new ArrayList<Acompanante>();
            acompañantes.add(new Mascota("Lobo mistico"));
            msg_inicio="Estas bestias seran mias";
            msg_muerte="Las cazare!!...";
            msg_victoria="Nadie se opone al gran cazador!";
        }
    }
    
    /** 
     * @return String
     */
    public String get_habilidades(){//desplegar lista de items
        String list_items="\n";
        for(int i=0;i<items.size();i++){
            list_items=list_items+i+". "+items.get(i)+"\n";
        }
        return list_items;
    }
    
    /** 
     * @return int
     */
    public int cantidad_habilidades(){
        return items.size();
    }
    
    /** 
     * @param index
     * @return String
     */
    public String getHabilidad(int index){
        return items.get(index);
    }
    
    /** 
     * @param index
     */
    public void eliminar_habilidad(int index){
        items.remove(index);
    }
}
