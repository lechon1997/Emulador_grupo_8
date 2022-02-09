package Logica;

public class CPU implements ICPU{
    private static CPU instance;

    private CPU(){

    }

    public static CPU getInstance() {
        if (instance == null) {
            instance = new CPU();
        }
        return instance;
    }

    @Override
    public void hola() {
        System.out.println("hola mundo :s");
    }

    @Override
    public void MOV(int Rxx, int Ryy) {

    }

    @Override
    public void MOV(float d, int Rxx) {

    }
}
