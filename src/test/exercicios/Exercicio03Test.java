/**
 * Exercicio 3 - Testes Unitários para Experiência com Angular
 *
 * Este arquivo contém testes unitários para a classe Exercicio03,
 * que demonstra experiência com Angular e exemplos de comunicação entre componentes.
 *
 * Os testes cobrem:
 * - Execução do método main sem exceções, garantindo que os exemplos de código são válidos
 *
 * Autor: Christian Vladimir Uhdre Mulato
 * Data: 26 de Junho de 2025
 */
package src.test.exercicios;

import org.junit.Test;
import exercicios.Exercicio03;

public class Exercicio03Test {

    @Test
    public void testMainExecutesWithoutException() {
        Exercicio03.main(new String[]{});
    }
}