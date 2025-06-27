/**
 * Exercicio 5 - Testes Unitários para Técnicas de Prevenção de SQL Injection
 *
 * Este arquivo contém testes unitários para a classe Exercicio05,
 * que explica e demonstra técnicas para prevenir ataques de SQL Injection
 * em aplicações web.
 *
 * O teste garante que o método main executa sem lançar exceções.
 *
 * Autor: Christian Vladimir Uhdre Mulato
 * Data: 26 de Junho de 2025
 */

package exercicios;

import org.junit.Test;

public class Exercicio05Test {

    @Test
    public void testMainExecutesWithoutException() {
        Exercicio05.main(new String[]{});
    }
}