/**
 * Exercicio 2 - Testes Unitários de equals() e hashCode()
 *
 * Este arquivo contém testes unitários para a classe Exercicio02,
 * demonstrando a importância de sobrescrever corretamente os métodos equals() e hashCode().
 *
 * Os testes cobrem:
 * - Comparação de objetos Pessoa com mesmo CPF (devem ser considerados iguais)
 * - Comparação de objetos Pessoa com CPFs diferentes (devem ser diferentes)
 * - Uso de HashSet para garantir que objetos duplicados (mesmo CPF) não sejam adicionados
 *
 * Autor: Christian Vladimir Uhdre Mulato
 * Data: 26 de Junho de 2025
 */
package src.test.exercicios;

import org.junit.Test;
import org.junit.Assert;
import exercicios.Exercicio02;
import java.util.HashSet;
import java.util.Set;

public class Exercicio02Test {

    @Test
    public void testEqualsMesmoCPF() {
        Exercicio02.Pessoa p1 = new Exercicio02.Pessoa("Ana", "123");
        Exercicio02.Pessoa p2 = new Exercicio02.Pessoa("João", "123");
        Assert.assertTrue(p1.equals(p2));
    }

    @Test
    public void testEqualsCPFdiferente() {
        Exercicio02.Pessoa p1 = new Exercicio02.Pessoa("Ana", "123");
        Exercicio02.Pessoa p2 = new Exercicio02.Pessoa("Maria", "456");
        Assert.assertFalse(p1.equals(p2));
    }

    @Test
    public void testHashSetNaoAdicionaDuplicado() {
        Set<Exercicio02.Pessoa> pessoas = new HashSet<>();
        pessoas.add(new Exercicio02.Pessoa("Ana", "123"));
        pessoas.add(new Exercicio02.Pessoa("João", "123")); // mesmo CPF
        pessoas.add(new Exercicio02.Pessoa("Maria", "456"));
        Assert.assertEquals(2, pessoas.size());
    }
}