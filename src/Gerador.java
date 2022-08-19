import java.util.Random;
import java.util.concurrent.Semaphore;

public class Gerador extends Thread {

    private Semaphore semaphore_2;
    private Semaphore semaphore_1;

    public Gerador(Semaphore semaphore_2, Semaphore semaphore_1) {
        this.semaphore_2 = semaphore_2;
        this.semaphore_1 = semaphore_1;
    }

    public void run() {
        while (true) {
            try {
                Random r = new Random();
    
                int i = 0;

                Thread.sleep(100);
                semaphore_1.acquire(); // esperar
                while(i < 10) {
                    int v = r.nextInt(52);
                    Alfabeto.VETOR[i] = Alfabeto.alfabeto[v];
                    i++;
                }
                semaphore_2.release(); // sinalizar
    
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
}
