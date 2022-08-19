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

        Semaphore mutex_1 = new Semaphore(1);
        Semaphore mutex_0 = new Semaphore(0);
        Semaphore mutex_realease_1 = new Semaphore(1);
        Semaphore mutex_realease_0 = new Semaphore(0);

        Gerador t1 = new Gerador(mutex_0, mutex_1);
        Padronizador t2   = new Padronizador(mutex_0, mutex_1, mutex_realease_0, mutex_realease_1);
        Contador t3 = new Contador(mutex_realease_0, mutex_realease_1);

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
