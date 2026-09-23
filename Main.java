public class Main {
    public static void main(String[] args) throws RpgException{
        System.out.println("\t---RPG - Sistema con Manejo de Excepciones---\n");

        Druida druida = new Druida("Sacerdote", 5, 80, 100, 25, 2);
        Nigromante nigromante = new Nigromante("Nigromante", 4, 70, 50);
        
        System.out.println("\nEscenario 1 - Turno normal sin excepción:");
        MotorCombate motor = new MotorCombate();
        motor.ejecutarTurno(druida, nigromante);

        System.out.println("\nEscenario 2 - Personaje derrotado intenta atacar:");
        druida.recibirDanio(99999); //primero derrota al druida
        motor.ejecutarTurno(druida, nigromante); // captura PersonajeDerrotadoException
        
        Druida druida2 = new Druida("Sacerdote", 5, 80, 100, 25, 2);

        System.out.println("\nEscenario 3 - Arquero sin flechas:");
        Arquero sinFlechas=new Arquero("Legolas", 6, 150, "Arco Largo", 0);
        motor.ejecutarTurno(sinFlechas, nigromante);  // captura RecursoInsuficienteException

        System.out.println("\nEscenario 4 - Curar aliado derrotado:");
        try {
            druida2.curarAliado(druida);
        } catch (RpgException e) {
            System.out.println("No se pudo curar: " + e.getMessage());
        }
        
    System.out.println("\nEscenario 5 - Daño negativo con finally");
        try {
            nigromante.recibirDanio(-50);
        } catch (AccionInvalidaException e) {
            System.out.println("Capturado: " + e.getMessage());
        } finally {
            System.out.println("El bloque finally siempre se ejecuta.");
        }
        motor.mostrarBitacora();
    }
}