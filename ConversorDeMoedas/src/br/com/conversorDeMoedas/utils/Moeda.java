package br.com.conversorDeMoedas.utils;

public class Moeda {
    private String moedaBase;
    private String moedaAlvo;
    private double cotacao;
    private double resultadoDaConversao;
    private double valor;

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Moeda(MoedaOmdb moedaOmdb) {
        this.moedaBase = moedaOmdb.base_code();
        this.moedaAlvo = moedaOmdb.target_code();
        this.cotacao = moedaOmdb.conversion_rate();
        this.resultadoDaConversao = moedaOmdb.conversion_result();
    }

    public void ExibeMoeda(){
        System.out.println("\n\nO valor de: " + valor + " " + moedaBase + " corresponde ao valor final de: " + resultadoDaConversao + " " + moedaAlvo +
                "\nUsando a Cotação: " + cotacao + "\n\n");
    }

    @Override
    public String toString() {
        return valor + " " + moedaBase + " para " + resultadoDaConversao + " " + moedaAlvo + ". Usando a Cotação: " + cotacao + "\n\n";
    }
}
