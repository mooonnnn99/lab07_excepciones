public class Arquero extends Personaje{
    private String tipoArco;
    private int flechasDisponibles;

    public Arquero(String nombre, int nivel, int puntosVida, String tipoArco, int flechasDisponibles){
        super(nombre, nivel, puntosVida);
        this.tipoArco = tipoArco;
        this.flechasDisponibles = flechasDisponibles;
    }
    public String getTipoArco(){
        return tipoArco;
    }
    public int getflechasDisponibles(){
        return flechasDisponibles;
    }

    @Override 
    public int calcularDanio(){
        return flechasDisponibles > 0 ? getNivel() * 10 : 0;
    }

    @Override
public void atacar() throws RpgException {

    if (!isEstaVivo()) {
        throw new PersonajeDerrotadoException(getNombre());
    }

    if (flechasDisponibles <= 0) {
        throw new RecursoInsuficienteException("flechas", flechasDisponibles);
    }

    flechasDisponibles--;
    System.out.println("[" + getNombre() + "] dispara una flecha. " +
                       "Flechas restantes: " + flechasDisponibles);
}
    @Override
    public String toString(){
        return super.toString() + " (Tipo de Arco: " + tipoArco + ", Flechas Disponibles: " + flechasDisponibles + ")";
    }
}
