//Estudantes: Pedro B. de Quadros, Lukas J. Barboza, Thiago K.
import java.util.concurrent.Semaphore;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("PBL_02");

        char letra;
        int  i = 0;

        for(letra = 'A'; letra <= 'Z'; ++letra){
            Alfabeto.alfabeto[i] = letra;
            i++;
        }

        for(letra = 'a'; letra <= 'z'; ++letra){
            Alfabeto.alfabeto[i] = letra;
            i++;
        }

        Semaphore semaphore_1 = new Semaphore(1);
        Semaphore semaphore_2 = new Semaphore(0);
        Semaphore semaphore_3 = new Semaphore(1);
        Semaphore semaphore_4 = new Semaphore(0);

        Gerador t1 = new Gerador(semaphore_2, semaphore_1);
        Padronizador t2   = new Padronizador(semaphore_2, semaphore_1, semaphore_4, semaphore_3);
        Contador t3 = new Contador(semaphore_4, semaphore_3);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join(); // espera a thread t1 terminar
            t2.join(); // espera a thread t2 terminar
            t3.join(); // espera a thread t2 terminar
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
