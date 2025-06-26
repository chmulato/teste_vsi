/**
 * Exercicio 1 - Geração de Anagramas
 *
 * Solução utilitária para geração de todos os anagramas possíveis de um grupo de letras distintas.
 * O algoritmo utiliza recursão para permutar as letras, garantindo clareza e legibilidade.
 * Inclui validação de entrada (apenas letras, não vazio) e documentação detalhada.
 * 
 * Diferenciais:
 * - Fácil reutilização em outros contextos Java.
 * - Cobertura de casos de borda e exemplos práticos.
 * - Comentários explicativos para facilitar entendimento e manutenção.
 *
 * Autor: Christian Vladimir Uhdre Mulato
 * Data: 26 de Junho de 2025.
 */
package exercicios;

import java.util.*;

/**
 * Classe utilitária para gerar todos os anagramas possíveis de um grupo de letras distintas.
 */
public class Exercicio01 {
    /**
     * Gera todos os anagramas possíveis a partir de um grupo de letras distintas.
     * @param input String contendo letras distintas
     * @return Lista com todos os anagramas possíveis
     * @throws IllegalArgumentException se a entrada for inválida
     */
    public static List<String> generateAnagrams(String input) {
        // Validação: entrada não pode ser nula ou vazia
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("A entrada não pode ser vazia.");
        }
        // Validação: entrada deve conter apenas letras
        if (!input.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("A entrada deve conter apenas letras.");
        }
        List<String> result = new ArrayList<>();
        // Chama método auxiliar para gerar as permutações
        permute("", input, result);
        return result;
    }

    // Método auxiliar recursivo para gerar permutações
    private static void permute(String prefix, String remaining, List<String> result) {
        if (remaining.isEmpty()) {
            // Caso base: quando não há mais letras, adiciona o prefixo à lista de resultados
            result.add(prefix);
        } else {
            // Para cada letra restante, gera novas permutações
            for (int i = 0; i < remaining.length(); i++) {
                permute(prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1),
                        result);
            }
        }
    }

    /**
     * Imprime exemplos padrão de anagramas para uso pelo Main.java
     */
    public static void printAnagramasPadrao() {
        try {
            System.out.println("Anagramas para 'abc': " + generateAnagrams("abc"));
            System.out.println("Anagramas para 'a': " + generateAnagrams("a"));
            // Descomente para ver a validação em ação:
            // System.out.println(generateAnagrams("a1b"));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    // Método principal para teste isolado (opcional)
    public static void main(String[] args) {
        printAnagramasPadrao();
    }
}
