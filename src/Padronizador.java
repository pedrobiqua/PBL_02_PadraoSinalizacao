import java.util.concurrent.Semaphore;

public class Padronizador extends Thread {

    private Semaphore semaphore_1;
    private Semaphore semaphore_2;
    private Semaphore semaphore_3;
    private Semaphore semaphore_4;

    public Padronizador(Semaphore semaphore_2, Semaphore semaphore_1, Semaphore semaphore_4, Semaphore semaphore_3) {
        this.semaphore_2 = semaphore_2;
        this.semaphore_1 = semaphore_1;
        this.semaphore_4 = semaphore_4;
        this.semaphore_3 = semaphore_3;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                semaphore_2.acquire(); // esperar
                semaphore_3.acquire(); // esperar
                for(int i = 0; i < Alfabeto.VETOR.length; i++){
                    Alfabeto.VETOR[i] = Character.toUpperCase(Alfabeto.VETOR[i]);
                }
                semaphore_1.release(); // sinalizar
                semaphore_4.release(); // sinalizar
                
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
}
