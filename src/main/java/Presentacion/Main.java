package Presentacion;

import     Logica.Fabrica;
import Logica.ICPU;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Fabrica fabrica = Fabrica.getInstance();
        ICPU Cpu = fabrica.getICPU();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la subrutina: ");
        String entrada = scanner.nextLine();
        



        //String[] subrutina = scanner.nextLine();

    }


}
