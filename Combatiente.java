import java.util.ArrayList;

/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Combatiente.java
Lenguaje: Java
Creación: 24/09/2021
Modificacion: 16/10/2021
*/
public abstract class Combatiente {
    protected String nombre;
    protected int vida;
    protected int atq;
    protected int vida_inicial;
    protected int atq_inicial;
    protected String msg_victoria;
    protected String msg_inicio;
    protected String msg_muerte;
    protected String tipo;
    protected int efecto;
    protected ArrayList<Acompanante> acompañantes;
    public Combatiente(String nombre){
        this.nombre = nombre;
        vida=0;
        atq=0;
        vida_inicial=0;
        atq_inicial=0;
        msg_inicio="";
        msg_muerte="";
        msg_victoria="";
    }
    
    /** 
     * @return String
     */
    public String getNombre() {
        return nombre;
    }
    
    /** 
     * @return int
     */
    public int getVida(){
        return vida;
    }
    
    /** 
     * @return int
     */
    public int getAtq(){
        return atq;
    }
    
    /** 
     * @param cant
     */
    public void disminuir_vida(int cant){
        vida=vida-cant;
    }
    
    /** 
     * @return String
     */
    public String getMsgInicio(){
        return msg_inicio;
    }
    
    /** 
     * @return String
     */
    public String getMsgMuerte(){
        return msg_muerte;
    }
    
    /** 
     * @return String
     */
    public String getMsgVictoria(){
        return msg_victoria;
    }
    
    /** 
     * @param a
     */
    public void aumentar_atq(int a){
        atq=atq+a;
    }
    
    /** 
     * @param a
     */
    public void aumentar_vida(int a){
        vida=vida+a;
    }
    public String getTipo(){
        return tipo;
    }
    public void setAcompanante(Acompanante acompanante){
        acompañantes.add(acompanante);
    }
    public Acompanante getAcompanante(int index){
        return acompañantes.get(index);
    }
    public int numeroAcompanantes(){
        return acompañantes.size();
    }
    public void setEfecto(int rondas){
        efecto=rondas;
    }
    public void reducirEfecto(){
        efecto--;
    }
    public int getEfecto(){
        return efecto;
    }
    public void reiniciar_vida(){
        vida=vida_inicial;
    }
    public void reiniciar_atq(){
        atq=atq_inicial;
    }
    public void clear_acompañantes(){
        acompañantes.clear();
    }
    abstract String get_habilidades();
    abstract int cantidad_habilidades();
    abstract String getHabilidad(int index);
    abstract void eliminar_habilidad(int index);
}
