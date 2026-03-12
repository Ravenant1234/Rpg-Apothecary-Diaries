public class Evento{
    //cada tipo de evento, por ejemplo "Quest", "Hallazgo" tiene un id que lo identifica y una descripcion y los "participantes" como una referencia a objetos
    
    private enum Tipo{
        HALLAZGO_ITEM, DIALOGO, ENEMIGO, COMBATE, VIAJE 
    }

    private boolean TRIGGERED;
    private Tipo tipoEvento;
    private String descripcion;
    private Set<Personaje> participantes;
  
    public Evento (Tipo tipoEvento, String descripcion, Set<Personaje> participantes){
        TRIGGERED = FALSE;
        this.tipoEvento = tipoEvento;
        this.descripcion = descripcion;
        this.participantes = participantes;
    }

    public void activarEvento (){
        TRIGGERED = TRUE;
    }

    public void desactivarEvento (){
        TRIGGERED = FALSE;
    }

    public void agregarParticipante (Participante p){
        participantes.insert (p);
    }

    public boolean estaActivado (){
        return TRIGGERED;
    }

    public enum tipoEvento (){
        return tipoEvento;
    }

    public String getDescripcion (){
        return descripcion;
    }

    public Set<Personaje> getParticipantes (){
        return participantes;
    }

    public boolean estaParticipante (Participante p){
        return participantes.get (p);
    }
    
}
