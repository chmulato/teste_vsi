/**
 * Exercicio 2 - Sobrescrita de equals() e hashCode()
 *
 * Demonstra, de forma prática e didática, a importância de sobrescrever corretamente os métodos equals() e hashCode()
 * em Java, utilizando o cenário de comparação de objetos Pessoa por CPF.
 * 
 * Aborda:
 * - Consistência entre equals() e hashCode().
 * - Impacto em coleções como HashSet.
 * - Boas práticas para implementação e testes.
 *
 * Autor: Christian Vladimir Uhdre Mulato
 * Data: 26 de Junho de 2025
 */
package exercicios;

/**
 * Exemplo de sobrescrita dos métodos equals() e hashCode() em Java.
 * 
 * Cenário: Comparação de objetos Pessoa por CPF.
 */
public class Exercicio02 {

    static class Pessoa {
        private String nome;
        private String cpf;

        public Pessoa(String nome, String cpf) {
            this.nome = nome;
            this.cpf = cpf;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pessoa other = (Pessoa) obj;
            return cpf != null && cpf.equals(other.cpf);
        }

        @Override
        public int hashCode() {
            return cpf != null ? cpf.hashCode() : 0;
        }

        @Override
        public String toString() {
            return nome + " (" + cpf + ")";
        }
    }

    /**
     * Imprime o exemplo padrão de uso de equals() e hashCode() para uso pelo Main.java
     */
    public static void printExemploPadrao() {
        Pessoa p1 = new Pessoa("Ana", "123");
        Pessoa p2 = new Pessoa("João", "123");
        Pessoa p3 = new Pessoa("Maria", "456");

        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true (mesmo CPF)
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // false

        java.util.Set<Pessoa> pessoas = new java.util.HashSet<>();
        pessoas.add(p1);
        pessoas.add(p2); // Não será adicionado, pois CPF é igual ao de p1
        pessoas.add(p3);

        System.out.println("Pessoas no Set: " + pessoas);
    }

    /**
     * Método principal para teste isolado (opcional)
     */
    public static void main(String[] args) {
        printExemploPadrao();
    }
}