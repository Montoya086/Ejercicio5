/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Combatiente.java
Lenguaje: Java
Creación: 24/09/2021
Modificacion: 27/09/2021
*/
public abstract class Combatiente {
    protected String nombre;
    protected int vida;
    protected int atq;
    protected String msg_victoria;
    protected String msg_inicio;
    protected String msg_muerte;
    public Combatiente(String nombre){
        this.nombre = nombre;
        vida=0;
        atq=0;
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
    abstract String get_habilidades();
    abstract int cantidad_habilidades();
    abstract String getHabilidad(int index);
    abstract void eliminar_habilidad(int index);
}
