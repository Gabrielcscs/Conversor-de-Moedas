package br.com.conversorDeMoedas.utils;

public record MoedaOmdb(String result, String base_code, String target_code, double conversion_rate, double conversion_result ) {
}
