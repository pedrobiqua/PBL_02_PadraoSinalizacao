import java.util.Random;
import java.util.concurrent.Semaphore;

public class Gerador extends Thread {

    private Semaphore mutex_0;
    private Semaphore mutex_1;

    public Gerador(Semaphore mutex_0, Semaphore mutex_1) {
        this.mutex_0 = mutex_0;
        this.mutex_1 = mutex_1;
    }

    public void run() {
        while (true) {
            try {
                Random r = new Random();
    
                int i = 0;

                Thread.sleep(100);
                mutex_1.acquire(); // esperar
                while(i < 10) {
                    int v = r.nextInt(52);
                    Alfabeto.VETOR[i] = Alfabeto.alfabeto[v];
                    i++;
                }
                mutex_0.release(); // sinalizar
    
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
}
