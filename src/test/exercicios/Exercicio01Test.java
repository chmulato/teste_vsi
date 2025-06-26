/**
 * Exercicio 1 - Testes Unitários de Geração de Anagramas
 *
 * Este arquivo contém os testes unitários para a classe Exercicio01,
 * responsável por gerar todos os anagramas possíveis de um grupo de letras distintas.
 *
 * Os testes cobrem:
 * - Geração correta de anagramas para diferentes entradas
 * - Tratamento de casos de borda e entradas inválidas
 *
 * Autor: Christian Vladimir Uhdre Mulato
 * Data: 26 de Junho de 2025
 */

package src.test.exercicios;

import org.junit.Test;
import org.junit.Assert;
import exercicios.Exercicio01;
import java.util.*;

/**
 * Testes unitários para a classe Exercicio01.
 * Cada método testa um cenário diferente de geração de anagramas.
 */
public class Exercicio01Test {
    /**
     * Testa se a função gera corretamente todos os anagramas para a entrada "abc".
     */
    @Test
    public void testAnagramasNormais() {
        List<String> esperado = Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba");
        List<String> resultado = Exercicio01.generateAnagrams("abc");
        Assert.assertTrue(resultado.containsAll(esperado) && esperado.containsAll(resultado));
    }

    /**
     * Testa o caso de entrada com apenas uma letra.
     */
    @Test
    public void testAnagramaUmaLetra() {
        List<String> esperado = Collections.singletonList("a");
        List<String> resultado = Exercicio01.generateAnagrams("a");
        Assert.assertEquals(esperado, resultado);
    }

    /**
     * Testa se a função lança exceção ao receber entrada vazia.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testEntradaVazia() {
        Exercicio01.generateAnagrams("");
    }

    /**
     * Testa se a função lança exceção ao receber entrada com caracteres não permitidos.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testEntradaComNumero() {
        Exercicio01.generateAnagrams("a1b");
    }
}
