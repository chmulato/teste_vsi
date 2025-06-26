/**
 * Exercicio 7 - Consultas SQL sobre tabelas Vendedor, Cliente e Pedidos
 *
 * Apresenta soluções SQL para cenários práticos envolvendo seleção, atualização, deleção e agregação
 * com base em tabelas fictícias fornecidas no desafio. Cada consulta é comentada para facilitar o entendimento.
 *
 * Autor: Christian Vladimir Uhdre Mulato
 * Data: 26 de Junho de 2025
 */
package exercicios;

/**
 * Exercicio 7 - Consultas SQL sobre tabelas Vendedor, Cliente e Pedidos
 *
 * Apresenta soluções SQL para cenários práticos envolvendo seleção, atualização, deleção e agregação
 * com base em tabelas fictícias fornecidas no desafio. Cada consulta é comentada para facilitar o entendimento.
 *
 * Autor: Christian Vladimir Uhdre Mulato
 * Data: 26 de Junho de 2025
 */
public class Exercicio07 {

    /**
     * Imprime as consultas SQL padrão para uso pelo Main.java
     */
    public static void printExemploPadrao() {
        System.out.println("a) Nomes de todos os vendedores que não possuem nenhum pedido com Samsonic:");
        System.out.println(
            "SELECT v.Nome\n" +
            "FROM Vendedor v\n" +
            "WHERE v.ID NOT IN (\n" +
            "  SELECT p.id_vendedor\n" +
            "  FROM Pedidos p\n" +
            "  JOIN Cliente c ON p.id_cliente = c.ID\n" +
            "  WHERE c.Nome = 'Samsonic'\n" +
            ");\n"
        );

        System.out.println("b) Atualiza os nomes dos vendedores que possuem 2 ou mais pedidos (adiciona '*'):");
        System.out.println(
            "UPDATE Vendedor\n" +
            "SET Nome = CONCAT(Nome, '*')\n" +
            "WHERE ID IN (\n" +
            "  SELECT id_vendedor\n" +
            "  FROM Pedidos\n" +
            "  GROUP BY id_vendedor\n" +
            "  HAVING COUNT(*) >= 2\n" +
            ");\n"
        );

        System.out.println("c) Deleta todos os vendedores que fizeram pedidos para a cidade de Jackson:");
        System.out.println(
            "DELETE FROM Vendedor\n" +
            "WHERE ID IN (\n" +
            "  SELECT p.id_vendedor\n" +
            "  FROM Pedidos p\n" +
            "  JOIN Cliente c ON p.id_cliente = c.ID\n" +
            "  WHERE c.Cidade = 'Jackson'\n" +
            ");\n"
        );

        System.out.println("d) Valor total de vendas para cada vendedor (mostrar zero se não vendeu nada):");
        System.out.println(
            "SELECT v.Nome, COALESCE(SUM(p.Valor), 0) AS TotalVendas\n" +
            "FROM Vendedor v\n" +
            "LEFT JOIN Pedidos p ON v.ID = p.id_vendedor\n" +
            "GROUP BY v.Nome;\n"
        );
    }

    /**
     * Método principal para teste isolado (opcional)
     */
    public static void main(String[] args) {
        printExemploPadrao();
    }
}