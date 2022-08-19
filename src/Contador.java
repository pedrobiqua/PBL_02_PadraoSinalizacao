import java.util.concurrent.Semaphore;

public class Contador extends Thread {

    private Semaphore semaphore_4;
    private Semaphore semaphore_3;

    public Contador(Semaphore semaphore_4, Semaphore semaphore_3) {
        this.semaphore_4 = semaphore_4; 
        this.semaphore_3 = semaphore_3; 
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                semaphore_4.acquire(); // esperar
                int cont = 0;
                for(int i = 0; i < Alfabeto.VETOR.length; i++){
                    if(Alfabeto.VETOR[i] == 'A' || Alfabeto.VETOR[i] == 'E' || Alfabeto.VETOR[i] == 'I'
                            || Alfabeto.VETOR[i] == 'O' || Alfabeto.VETOR[i] == 'U'){
                        cont++;
                    }
                }
                System.out.println("Número de vogais = " + cont);
                System.out.println(Alfabeto.VETOR);
                semaphore_3.release(); // sinalizar
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
}