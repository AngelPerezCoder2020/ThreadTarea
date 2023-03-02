public class AlfanumericoTarea implements Runnable{
    private Tipo tipo;
    public AlfanumericoTarea(Tipo tipo){
        this.tipo=tipo;
    }
    @Override
    public void run(){
        for(int x=0;x<5;x++){
            if(this.tipo==Tipo.NUMERO) System.out.println("1 2 3 4 5 6 7 8 9");
            else System.out.println("a b c d e f g h i j k l m n ñ o p q r s t u v w x y z");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}