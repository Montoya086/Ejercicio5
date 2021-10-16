public class Acompanante_enemigo extends Acompanante{
    public Acompanante_enemigo(String nombre, String habilidad){
        super(nombre);
        tipo="Acompanante_enemigo";
        this.habilidad.add(habilidad);
    }
}
