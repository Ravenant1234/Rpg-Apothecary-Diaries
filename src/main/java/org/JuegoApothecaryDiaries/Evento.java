public class Evento{
    private enum Tipo{
        HALLAZGO_ITEM, DIALOGO, ENEMIGO, COMBATE, VIAJE 
    }

    private boolean TRIGGERED;
    private Tipo tipoEvento;
  
    public Evento (Tipo tipoEvento){
        TRIGGERED = FALSE;
        this.tipoEvento = tipoEvento;
    }

    public void activarEvento (){
        TRIGGERED = TRUE;
    }

    public void desactivarEvento (){
        TRIGGERED = FALSE;
    }

    public boolean estaActivado (){
        return TRIGGERED;
    }

    public enum tipoEvento (){
        return tipoEvento
    }

}
