import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String frase = "Esta es la frase frase frase frase que va procesar";
        //System.out.println(limpiador("a    ,n.....ge,,,,, l"));
        CantVecesPalabra cvp = Main::procesar;
        System.out.println(cvp.procesar(frase));
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
    public static Map<String,Integer> procesar(String str){
        String masRepetida = "";
        String sigPalabra = "";
        Integer cant = 0;
        Integer max = 0;
        Map<String,Integer> palMap = new HashMap<>();
        Map<String,Integer> result = new HashMap<>();
        String[] palabras = str.toLowerCase().split(" ");
        for(String p:palabras){
            if(palMap.containsKey(p)) palMap.put(p,palMap.get(p)+1);
            else palMap.put(p,1);
        }
        System.out.println(palMap);
        Iterator<String> llaves = palMap.keySet().iterator();
        while(llaves.hasNext()){
            sigPalabra = llaves.next();
            cant = palMap.get(sigPalabra);
            if(cant>max){
                max = cant;
                masRepetida = sigPalabra;
            }
        }
        result.put(masRepetida,max);
        return result;
    }
}