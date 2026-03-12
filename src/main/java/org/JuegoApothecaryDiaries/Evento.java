import java.util.Set;
public class Evento{
    //cada tipo de evento, por ejemplo "Quest", "Hallazgo" tiene un id que lo identifica y una descripcion y los "participantes" como una referencia a objetos
    
    private enum TipoEvento{
        HALLAZGO_ITEM, DIALOGO, ENEMIGO, COMBATE, VIAJE, DIAGNOSTICO 
    }

    private boolean TRIGGERED;
    private TipoEvento tipo;
    private String descripcion;
    private Set<Personaje> participantes;
    private String id;
  
    public Evento (TipoEvento tipo, String descripcion, Set<Personaje> participantes, String id){
        TRIGGERED = false;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.participantes = participantes;
        this.id = id;

    }

    public void activarEvento (){
        TRIGGERED = true;
    }

    public void desactivarEvento (){
        TRIGGERED = false;
    }

    public void agregarParticipante (Personaje p){
        participantes.add(p);
    }

    public boolean estaActivado (){
        return TRIGGERED;
    }

    public TipoEvento tipoEvento (){
        return tipo;
    }

    public String getDescripcion (){
        return descripcion;
    }

    public Set<Personaje> getParticipantes (){
        return participantes;
    }

    public boolean estaParticipante (Personaje p){
        return participantes.contains(p);
    }

    public String getId() {
        return id;
    }
    
}
