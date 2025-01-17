package br.com.conversorDeMoedas.aplicacao;

import br.com.conversorDeMoedas.menu.Menu;
import br.com.conversorDeMoedas.service.ConsumoAPI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Menu menu = new Menu();
        ConsumoAPI converte = new ConsumoAPI();

        var chave = 0;

        while (chave != 8) {
            menu.TextoMenu();
            chave = menu.ValidaOpcao(leitura);

            double valor = 0;
            if (chave != 8) {
                try {
                    System.out.println("\nQual o valor que deseja converter?");
                    valor = leitura.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Por favor, tente novamente!\n\n");
                    leitura.nextLine();
                    continue;
                }
            }

            switch (chave) {
                case 1:
                    converte.obterDados("BRL", "USD", valor);
                    break;
                case 2:
                    converte.obterDados("USD", "BRL", valor);
                    break;
                case 3:
                    converte.obterDados("USD", "ARS", valor);
                    break;
                case 4:
                    converte.obterDados("ARS", "USD", valor);
                    break;
                case 5:
                    converte.obterDados("COP", "GBP", valor);
                    break;
                case 6:
                    converte.obterDados("BRL", "COP", valor);
                    break;
                case 7:
                    converte.obterDados("EUR", "BRL", valor);
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        leitura.close();


    }
}
