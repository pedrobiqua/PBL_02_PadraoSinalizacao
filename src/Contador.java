import java.util.concurrent.Semaphore;

public class Contador extends Thread {

    private Semaphore mutex_realease_0;
    private Semaphore mutex_realease_1;

    public Contador(Semaphore mutex_realease_0, Semaphore mutex_realease_1) {
        this.mutex_realease_0 = mutex_realease_0; 
        this.mutex_realease_1 = mutex_realease_1; 
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                mutex_realease_0.acquire(); // esperar
                int cont = 0;
                for(int i = 0; i < Alfabeto.VETOR.length; i++){
                    if(Alfabeto.VETOR[i] == 'A' || Alfabeto.VETOR[i] == 'E' || Alfabeto.VETOR[i] == 'I'
                            || Alfabeto.VETOR[i] == 'O' || Alfabeto.VETOR[i] == 'U'){
                        cont++;
                    }
                }
                System.out.println("Número de vogais = " + cont);
                System.out.println(Alfabeto.VETOR);
                mutex_realease_1.release(); // sinalizar
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
}