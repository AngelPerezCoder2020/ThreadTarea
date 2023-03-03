public class Main {
    public static void main(String[] args) {
        System.out.println(limpiador("a    ,n.....ge,,,,, l"));
    }
    private static void hilos(){
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
    private static String limpiador(String str){
        Limpiador l = Main::clean;
        return l.limpiar(str);
    }
    public static String clean(String str){
        String result = str.replace(",","")
                .replace(" ","")
                .replace(".","");
        return result.toUpperCase();
    }
}