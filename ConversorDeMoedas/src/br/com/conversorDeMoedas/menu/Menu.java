package br.com.conversorDeMoedas.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public void TextoMenu(){
    System.out.println(
            "################################################################\n" +
            "Qual conversão você quer fazer?\n" +
            "\n" +
            "===== MENU =====\n" +
            "1) Real Brasileiro --> Dólar\n" +
            "2) Dólar --> Real Brasileiro\n" +
            "3) Dólar --> Peso Argentino\n" +
            "4) Peso Argentino --> Dólar\n" +
            "5) Peso colombiano --> Peso Chileno\n" +
            "6) Real Brasileiro --> Peso Colombiano\n" +
            "7) Euro --> Real Brasileiro\n" +
            "8) Sair\n" +
            "Escolha uma opção:"
            );
    }

    public int ValidaOpcao(Scanner leitura) {
        int key = 0;
        while (true) {
            try {
                key = leitura.nextInt();
                if (key < 1 || key > 8) {
                    System.out.println("Opção inválida! Por favor, insira um número entre 1 e 8.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número entre 1 e 8!\n");
                leitura.nextLine();
            }
        }
        return key;
    }
}
