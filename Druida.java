public class Druida extends Personaje implements Hechicero, Sanador{
    private int mana;
    private int poderCuracion;
    private int vinculoAnimal;

    public Druida(String nombre, int nivel, int puntosVida, int mana, int poderCuracion, int vinculoAnimal) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.vinculoAnimal = vinculoAnimal;
    }
    public void atacar() throws RpgException{
        if(!isEstaVivo()){
            throw new PersonajeDerrotadoException(getNombre());
        }
        else if (mana>=10){
            throw new RecursoInsuficienteException("mana", mana);
        }
        else{ 
            mana-=10;
            System.out.println(nombre + " ataca con fuerzas de la naturaleza.");

        }
    }
    public int calcularDanio() {
        int danio = getNivel() * 10 + vinculoAnimal * 5; // Daño base según nivel y vínculo animal
        System.out.println(nombre + " inflige " + danio + " puntos de daño.");
        return danio;
    }
    public void lanzarHechizo() {
        if (mana >= 10) {
            mana -= 10;
            System.out.println(nombre + " lanza un hechizo poderoso. Mana restante: " + mana);
        } else {
            System.out.println(nombre + " no tiene suficiente mana para lanzar un hechizo.");
        }
    }
    public int obtenerNivelMagia() {
        return getNivel();
    }
    public void curarAliado(Personaje aliado) throws RpgException {
        if (aliado==null){
            throw new PersonajeNuloException("curarAliado");
        }
        else if (!isEstaVivo()){
            throw new AccionInvalidaException("curarAliado", "No se puede curar a un personaje derrotado");

        }
        else{
            aliado.recibirDanio(-poderCuracion); // Curar al aliado
            System.out.println("Aliado " + aliado.getNombre() + " curado.");
        }
        
    }
    //Getters
    public int getMana() {
        return mana;
    }
    public int getPoderCuracion() {
        return poderCuracion;
    }
    public int getVinculoAnimal() {
        return vinculoAnimal;
    }

}