/**
 * Exercicio 9 - Testes Unitários para Estratégia de Testes do Cadastro de Usuário
 *
 * Este arquivo contém testes unitários para a classe Exercicio09,
 * que descreve estratégias e cenários de teste para o cadastro de usuário.
 * O teste garante que o método main executa sem lançar exceções.
 *
 * Autor: Christian Vladimir Uhdre Mulato
 * Data: 26 de Junho de 2025
 */
package src.test.exercicios;

import org.junit.Test;
import exercicios.Exercicio09;

public class Exercicio09Test {

    @Test
    public void testMainExecutesWithoutException() {
        Exercicio09.main(new String[]{});
    }
}