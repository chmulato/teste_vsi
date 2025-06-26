package exercicios;

/**
 * Exercicio 5 - Técnicas de Prevenção de SQL Injection
 *
 * Explica e demonstra, com exemplos práticos, as principais técnicas para prevenir ataques de SQL Injection
 * em aplicações Java. Aborda o uso de queries parametrizadas, ORMs, validação de entrada e outras recomendações
 * de segurança para proteger a camada de banco de dados.
 *
 * Autor: Christian Vladimir Uhdre Mulato
 * Data: 26 de Junho de 2025
 */
public class Exercicio05 {

    /**
     * Imprime o exemplo padrão de explicação e código de prevenção de SQL Injection para uso pelo Main.java
     */
    public static void printExemploPadrao() {
        System.out.println("Técnicas para prevenir SQL Injection em aplicações web:\n");

        System.out.println("1. Uso de queries parametrizadas (PreparedStatement):");
        System.out.println("Exemplo em Java JDBC:");
        System.out.println("Connection conn = ...;");
        System.out.println("String sql = \"SELECT * FROM usuarios WHERE usuario = ? AND senha = ?\";");
        System.out.println("PreparedStatement stmt = conn.prepareStatement(sql);");
        System.out.println("stmt.setString(1, usuario);");
        System.out.println("stmt.setString(2, senha);");
        System.out.println("ResultSet rs = stmt.executeQuery();\n");

        System.out.println("2. Utilização de ORMs (ex: Hibernate, JPA):");
        System.out.println("Exemplo com JPA:");
        System.out.println("TypedQuery<Usuario> query = em.createQuery(");
        System.out.println("  \"SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.senha = :senha\", Usuario.class);");
        System.out.println("query.setParameter(\"usuario\", usuario);");
        System.out.println("query.setParameter(\"senha\", senha);");
        System.out.println("List<Usuario> usuarios = query.getResultList();\n");

        System.out.println("3. Validação e sanitização de entrada:");
        System.out.println("- Validar tipos, tamanhos e formatos dos dados recebidos do usuário.");
        System.out.println("- Rejeitar caracteres suspeitos ou comandos SQL em campos de texto.\n");

        System.out.println("4. Princípio do menor privilégio:");
        System.out.println("- Usuário do banco de dados deve ter apenas os privilégios necessários.");
        System.out.println("- Evitar uso de contas administrativas para conexões da aplicação.\n");

        System.out.println("5. Outras medidas:");
        System.out.println("- Uso de stored procedures seguras.");
        System.out.println("- Monitoramento e logs de acessos e erros.");
        System.out.println("- Utilização de Web Application Firewall (WAF).");
    }

    /**
     * Método principal para teste isolado (opcional)
     */
    public static void main(String[] args) {
        printExemploPadrao();
    }
}