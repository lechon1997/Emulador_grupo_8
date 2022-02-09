package Logica;

public class Fabrica {
    private static Fabrica instance;

    private Fabrica(){

    }

    //Singleton
    public static Fabrica getInstance(){
        if(instance == null){
            instance = new Fabrica();
        }
        return instance;
    }

    public ICPU getICPU() {
        return CPU.getInstance();
    }
}
