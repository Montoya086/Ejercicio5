/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Juego.java
Lenguaje: Java
Creación: 24/09/2021
Modificacion: 16/10/2021
*/
import java.util.ArrayList;
public class Juego {
    ArrayList<Combatiente> combatientes;
    int nenemigos;
    String hab_raid;
    public Juego(String[] clase, String[] nombre, int numero){
        combatientes = new ArrayList<Combatiente>();
        for(int i=0;i<numero;i++){
            combatientes.add(new Jugador(nombre[i], clase[i]));
        }
        nenemigos=(int)(Math.random()*3+1);//numero de enemigos
        int jefe = (int)(Math.random()*100);//posibilidad de ser jefe
        if(jefe>=50){//generar jefe
            nenemigos--;
            int tipo =(int)(Math.random()*3);//tipo de jefe
            if(tipo==0){
                combatientes.add(new Jefe("Slime"));
            }
            if(tipo==1){
                combatientes.add(new Jefe("Undead"));
            }
            if(tipo==2){
                combatientes.add(new Jefe("Goblin"));
            }
        }
        for(int i=0;i<nenemigos;i++){//elegir enemigo
            int tipo =(int)(Math.random()*3);//tipo de enemigo
            if(tipo==0){
                combatientes.add(new Enemigo("Slime"));
            }
            if(tipo==1){
                combatientes.add(new Enemigo("Undead"));
            }
            if(tipo==2){
                combatientes.add(new Enemigo("Goblin"));
            }
        }
        combatientes.add(new Raidboss("Borg"));
        int nhab=0;
        for(int i=0;i<combatientes.size();i++){
            if(combatientes.get(i).getTipo().equals("Jefe")){
                nhab=combatientes.get(i).cantidad_habilidades();
                int nhabrand= (int)(Math.random()*nhab);
                hab_raid=combatientes.get(i).getHabilidad(nhabrand);
            }
        }
        
    }
    
    /** 
     * @param atacante
     */
    public void atacar(int atacante, int objetivo){//atacar
        combatientes.get(objetivo).disminuir_vida(combatientes.get(atacante).getAtq());
    }
    
    /** 
     * @return boolean
     */
    public boolean verificar_vivo(int index){//verificar si un combatiente está vivo
        if(combatientes.get(index).getVida()<=0){
            return false;
        }else{
            return true;
        }
    }

    public void eliminar_combatiente(int index){//eliminar combatiente
        combatientes.remove(index);
    }
    
    /** 
     * @return String
     */
    public String mostrar_combatientes(){//mostrar lista de combatientes
        String lista="\n";
        for(int i=0;i<combatientes.size();i++){
            lista=lista+i+". "+combatientes.get(i).getNombre()+"\t HP: "+combatientes.get(i).getVida()+"\t ATQ: "+combatientes.get(i).getAtq()+"\n";
        }
        return lista;
    }
    
    /** 
     * @return int
     */
    public int ncombatientes(){//mostrar cantidad de combatientes
        return combatientes.size();
    }
    
    /** 
     * @return String
     */
    public String getNombre(int index){//mostrar nombre del combatiente
        return combatientes.get(index).getNombre();
    }
    
    /** 
     * @return String
     */
    public String getMsgInicio(int index){//mostrar mensaje de inicio de un combatiente
        return combatientes.get(index).getMsgInicio();
    }
    
    /** 
     * @return String
     */
    public String getMsgMuerte(int index){//mostrar mensaje de muerte de un combatiente
        return combatientes.get(index).getMsgMuerte();
    }
    
    /** 
     * @return String
     */
    public String getMsgVictoria(int index){//mostrar mensaje de victoria de un combatiente
        return combatientes.get(index).getMsgVictoria();
    }
    
    /** 
     * @return boolean
     */
    public boolean verificar_win(){//verificar si el jugador ganó
        boolean win=true;
        for(int i=0;i<combatientes.size();i++){
            if(combatientes.get(i).getTipo().equals("Jefe")){
                win=false;
            }
        }
        return win;
    }
    
    /** 
     * @return boolean
     */
    public boolean verificar_derrota(){//verificar derrota
        boolean loose=true;
        for(int i=0;i<combatientes.size();i++){
            if(combatientes.get(i).getTipo().equals("Guerrero")||combatientes.get(i).getTipo().equals("Explorador")||combatientes.get(i).getTipo().equals("Cazador")){
                loose=false;
            }
        }
        return loose;
    }
    public String mostrar_items(int index){//mostrar items
        return combatientes.get(index).get_habilidades();
    }
    public int numero_items(int index){//mostrar numero de items
        return combatientes.get(0).cantidad_habilidades();
    }
    public String mostrar_habilidades(int index){//mostrar habilidades
        return combatientes.get(index).get_habilidades();
    }
    public int numero_habilidades(int index){//mostrar numero de habilidades
        return combatientes.get(index).cantidad_habilidades();
    }
    public void usar_item(int portador, int item, int objetivo){//utilizar item
        String nombre_item = combatientes.get(portador).getHabilidad(item);//devolver el nombre del item
        switch (nombre_item) {//items:
            case "Filo de la noche":
                int vida_disminuida=combatientes.get(portador).getAtq()+100;
                combatientes.get(objetivo).disminuir_vida(vida_disminuida);
                combatientes.get(portador).eliminar_habilidad(item);
                break;
            case "Posion de fuerza":
                combatientes.get(objetivo).aumentar_atq(50);
                combatientes.get(portador).eliminar_habilidad(item);
                break;
            case "Varita de vida":
                combatientes.get(objetivo).aumentar_vida(150);
                combatientes.get(portador).eliminar_habilidad(item);
                break;
            case "Varita de rayo":
                combatientes.get(objetivo).disminuir_vida(150);
                combatientes.get(portador).eliminar_habilidad(item);
                break;
            default:
                break;
        }
    }
    public void usar_habilidad(int portador, int habilidad, int objetivo){//usar habilidades
        String nombre_habilidad = combatientes.get(portador).getHabilidad(habilidad);//buscar el nombre de la habilidad
        switch (nombre_habilidad) {//habilidades normales:
            case "Veneno":
                combatientes.get(objetivo).disminuir_vida(80);
                break;
            case "Fuerza":
                combatientes.get(objetivo).aumentar_atq(25);
                break;
            case "Curacion":
                combatientes.get(objetivo).aumentar_vida(50);
                break;//habilidades de jefe: (1 uso)
            case "Veneno refinado":
                combatientes.get(objetivo).disminuir_vida(160);
                combatientes.get(portador).eliminar_habilidad(habilidad);
                break;
            case "Fuerza de la muerte":
                combatientes.get(objetivo).aumentar_atq(75);
                combatientes.get(portador).eliminar_habilidad(habilidad);
                break;
            case "Curacion ancestral":
                combatientes.get(objetivo).aumentar_vida(175);
                combatientes.get(portador).eliminar_habilidad(habilidad);
                break;
            case "Robar alma":
                combatientes.get(objetivo).disminuir_vida(150);
                combatientes.get(portador).aumentar_vida(50);
                break;
            case "Destruir alma":
                combatientes.get(objetivo).disminuir_vida(200);
                break;
            case "Mordida":
                combatientes.get(objetivo).disminuir_vida(combatientes.get(portador).getAtq());
                break;
            default:
                break;
        }
    }
    public String getTipocombatiente(int index){
        return combatientes.get(index).getTipo();
    }
    public void lanzar_acompañante(int turno,int index){
        combatientes.add(combatientes.get(turno).getAcompanante(index));
    }
    public boolean acompañante_lanzado(int turno,int index){
        boolean lanzado=false;
        if(combatientes.get(turno).numeroAcompanantes()!=0){
            for(int i=0;i<combatientes.size();i++){
                if(combatientes.get(i).equals(combatientes.get(turno).getAcompanante(index))){
                    lanzado=true;
                }
            }
        }
        return lanzado;
    }
    public int turno_acompañante(int turno,int index){
        int indice=-1;
        if(combatientes.get(turno).numeroAcompanantes()!=0){
            for(int i=0;i<combatientes.size();i++){
                if(combatientes.get(i).equals(combatientes.get(turno).getAcompanante(index))){
                    indice=i;
                }
            }
        }
        return indice;
    }
    public boolean verificar_mascota(int index){
        boolean mascota=false;
        if(combatientes.get(index).getTipo().equals("Mascota")){
            mascota=true;
        }
        return mascota;
    }
    public void reiniciar(int index){
        combatientes.get(index).reiniciar_atq();
        combatientes.get(index).reiniciar_vida();
    }
    public void setEfecto(int index,int rondas){
        combatientes.get(index).setEfecto(rondas);
    }
    public int getEfecto(int index){
        return combatientes.get(index).getAcompanante(0).getEfecto();
    }
    public void reducirEfecto(int index){
        combatientes.get(index).getAcompanante(0).reducirEfecto();
    }
    public int numeroAcompanantes(int index){
        return combatientes.get(index).numeroAcompanantes();
    }
    public void eliminar_acompañantes(int index){
        for(int i=0;i<combatientes.get(index).numeroAcompanantes();i++){
            for(int j=0;j<combatientes.size();j++){
                if(combatientes.get(index).getAcompanante(i).equals(combatientes.get(j))){
                    combatientes.remove(j);
                }
            }
        }
        combatientes.get(index).clear_acompañantes();
    }
    public void cambiar_habraid(int habilidad, int portador){
        String nombre_habilidad = combatientes.get(portador).getHabilidad(habilidad);
        hab_raid=nombre_habilidad;
    }
    public void clonar(int objetivo, int portador){
        String nombre= "Clon de "+combatientes.get(objetivo).getNombre();
        String habilidad = hab_raid;
        int atq = combatientes.get(objetivo).getAtq();
        int vida= combatientes.get(objetivo).getVida();
        combatientes.get(portador).setAcompanante(new Acompanante_enemigo(nombre, habilidad, atq, vida));
    }
    public String getHabraid(){
        return hab_raid;
    }
}
