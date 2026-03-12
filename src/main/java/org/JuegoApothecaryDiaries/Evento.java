public class Evento{
    //cada tipo de evento, por ejemplo "Quest", "Hallazgo" tiene un id que lo identifica y una descripcion y los "participantes" como una referencia a objetos
    
    private enum Tipo{
        HALLAZGO_ITEM, DIALOGO, ENEMIGO, COMBATE, VIAJE, DIAGNOSTICO 
    }

    private boolean TRIGGERED;
    private TipoEvento tipo;
    private String descripcion;
    private Set<Personaje> participantes;
  
    public Evento (TipoEvento tipo, String descripcion, Set<Personaje> participantes){
        TRIGGERED = FALSE;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.participantes = participantes;
    }

    public void activarEvento (){
        TRIGGERED = TRUE;
    }

    public void desactivarEvento (){
        TRIGGERED = FALSE;
    }

    public void agregarParticipante (Personaje p){
        participantes.insert (p);
    }

    public boolean estaActivado (){
        return TRIGGERED;
    }

    public enum tipoEvento (){
        return tipo;
    }

    public String getDescripcion (){
        return descripcion;
    }

    public Set<Personaje> getParticipantes (){
        return participantes;
    }

    public boolean estaParticipante (Personaje p){
        return participantes.get (p);
    }
    
}
