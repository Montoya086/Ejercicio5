/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Controlador.java
Lenguaje: Java
Creación: 24/09/2021
Modificacion: 27/09/2021
*/
public class Controlador {
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        Vista v = new Vista();
        String nombre="";
        while(nombre==""){//elegir nombre
            nombre=v.ingreso_nombre();
        }
        int nclase=0;
        while(nclase!=1 && nclase!=2){//Seleccion de clase
            nclase=v.seleccion_clase();
        }
        String clase="";
        if(nclase==1){//clase guerrero
            clase="Guerrero";
        }else if(nclase==2){//clase explorador
            clase="Explorador";
        }
        Juego juego = new Juego(clase, nombre);
        v.separador();
        for(int i=0;i<juego.ncombatientes();i++){//mensajes de inicio
            v.mostrar_mensaje(juego.getNombre(i), juego.getMsgInicio(i));
        }
        v.separador();
        boolean salir=false;
        int turno=0;
        while(salir==false){//ciclo de turnos
            v.separador();
            v.mostrar_combatientes(juego.mostrar_combatientes());//mostrar combatientes
            v.separador();
            v.mostrar_turno(juego.getNombre(turno));//mostrar turno
            if(turno==0){//turno del jugador
                int r=0;
                while(r!=1&&r!=2&&r!=3){
                    r=v.menu_jugador();
                    switch (r) {
                        case 1://atacar
                            v.objetivo();
                            int r2=-1;
                            while(r2<0||r2>juego.ncombatientes()){//elegir objetivo
                                r2=v.elegir_objetivo(juego.mostrar_combatientes());
                            }
                            juego.atacar(turno, r2);//ataque
                            break;
                        case 2://usar item
                            v.item();
                            int r_item=-1;
                            while(r_item<0||r_item>juego.numero_items()-1){//elegir item
                                r_item=v.elegir_item(juego.mostrar_items());
                            }
                            v.objetivo();
                            int r_objetivo=-1;
                            while(r_objetivo<0||r_objetivo>juego.ncombatientes()){//elegir objetivo
                                r_objetivo=v.elegir_objetivo(juego.mostrar_combatientes());
                            }
                            juego.usar_item(0,r_item,r_objetivo);//usar item en objetivo
                            break;
                        case 3://saltar turno
                            
                            break;
                        default:
                            break;
                    }
                }
            }else{//turno de los enemigos
                int r=0;
                while(r!=1&&r!=2&&r!=3){
                    r=v.menu_enemigo();//menu
                    switch (r) {
                        case 1:// atacar
                            v.objetivo();
                            int r2=-1;
                            while(r2<0||r2>juego.ncombatientes()){//elegir objetivo
                                r2=v.elegir_objetivo(juego.mostrar_combatientes());
                            }
                            juego.atacar(turno, r2);//atacar objetivo
                            break;
                        case 2://usar habilidad
                            v.habilidad();
                            int r_habilidad=-1;
                            while(r_habilidad<0||r_habilidad>juego.numero_habilidades(turno)-1){//mostrar habilidades
                                r_habilidad=v.elegir_habilidad(juego.mostrar_habilidades(turno));
                            }
                            v.objetivo();
                            int r_objetivo=-1;
                            while(r_objetivo<0||r_objetivo>juego.ncombatientes()){// mostrar objetivos
                                r_objetivo=v.elegir_objetivo(juego.mostrar_combatientes());
                            }
                            juego.usar_habilidad(turno,r_habilidad,r_objetivo);//usar habilidad en objetivo
                            break;
                        case 3://saltar turno
                            
                            break;
                        default:
                            break;
                    }
                }
            }
            for(int i=0;i<juego.ncombatientes();i++){//verificar muertes
                if(!juego.verificar_vivo(i)){
                    v.separador();
                    v.mostrar_mensaje(juego.getNombre(i), juego.getMsgMuerte(i));//mensaje de muerte
                    v.separador();
                    juego.eliminar_combatiente(i);
                }
            }
            if(juego.verificar_win(nombre)){//verificar victoria
                v.separador();
                v.win();
                v.mostrar_mensaje(juego.getNombre(0), juego.getMsgVictoria(0));//mensaje de Victoria
                v.separador();
                salir=true;

            }
            if(juego.verificar_derrota(nombre)){//verificar derrota
                v.separador();
                v.lose();
                for(int i=0;i<juego.ncombatientes();i++){
                    v.mostrar_mensaje(juego.getNombre(i), juego.getMsgVictoria(i));//mensaje de Victoria
                }
                v.separador();
                salir=true;
            }
            turno++;//cambia el turno
            if(turno>juego.ncombatientes()-1){//verificar si los turnos ya dieron una vuelta
                turno=0;//regresar al inicio
            }
        }
    }
}
