import java.util.concurrent.Semaphore;

public class Padronizador extends Thread {

    private Semaphore mutex_1;
    private Semaphore mutex_0;
    private Semaphore mutex_realease_1;
    private Semaphore mutex_realease_0;

    public Padronizador(Semaphore mutex_0, Semaphore mutex_1, Semaphore mutex_realease_0, Semaphore mutex_realease_1) {
        this.mutex_0 = mutex_0;
        this.mutex_1 = mutex_1;
        this.mutex_realease_0 = mutex_realease_0;
        this.mutex_realease_1 = mutex_realease_1;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                mutex_0.acquire(); // esperar
                mutex_realease_1.acquire(); // esperar
                for(int i = 0; i < Alfabeto.VETOR.length; i++){
                    Alfabeto.VETOR[i] = Character.toUpperCase(Alfabeto.VETOR[i]);
                }
                mutex_1.release(); // sinalizar
                mutex_realease_0.release(); // sinalizar
                
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
}
