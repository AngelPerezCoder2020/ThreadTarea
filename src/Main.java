public class Main {
    public static void main(String[] args) {
        Thread hilo1 = new Thread(new AlfanumericoTarea(Tipo.NUMERO));
        Thread hilo2 = new Thread(new AlfanumericoTarea(Tipo.LETRA));
        Thread hilo3 = new Thread(()->{
            System.out.println("ja");
            System.out.println(Thread.currentThread().getName());
        });
        hilo1.start();
        hilo3.start();
        hilo2.start();
    }
}