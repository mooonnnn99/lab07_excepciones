public class Nigromante extends Personaje implements Hechicero {
    private int mana;
    private int almasAbsorbidas;

    public Nigromante(String nombre, int nivel, int puntosVida, int mana) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.almasAbsorbidas = 0;
    }

    public void atacar() throws RpgException{
        if (isEstaVivo()){
            throw new PersonajeDerrotadoException(getNombre());
        }
        else if (mana<15){
            throw new RecursoInsuficienteException("mana", mana);
        }
        else{
            mana-=15;
                    System.out.println(nombre + " ataca con magia oscura.");

        }
    }
    public int calcularDanio() {
        int danio = getNivel() * 12 + almasAbsorbidas * 3; // Daño base según nivel y almas absorbidas
        System.out.println(nombre + " inflige " + danio + " puntos de daño.");
        return danio;
    }
    public void lanzarHechizo() {
        if (mana >= 15) {
            mana -= 15;
            System.out.println(nombre + " lanza un hechizo de necromancia. Mana restante: " + mana);
        } else {
            System.out.println(nombre + " no tiene suficiente mana para lanzar un hechizo.");
        }
    }
    public int obtenerNivelMagia() {
        return getNivel();
    }
    public void absorberAlma() {
        almasAbsorbidas++;
        System.out.println(nombre + " ha absorbido un alma. Total de almas absorbidas: " + almasAbsorbidas);
    }
    public int getMana() {
        return mana;
    }

}
