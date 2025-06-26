package exercicios;

/**
 * Exercicio 9 - Estratégia de Testes para Cadastro de Usuário
 *
 * Descreve uma abordagem abrangente para garantir a qualidade da funcionalidade de cadastro de usuário,
 * incluindo tipos de testes (unitário, integração, E2E), cenários, casos de borda e exemplos de código.
 * Foco em cobertura, robustez e validação de regras de negócio.
 *
 * Autor: Christian Vladimir Uhdre Mulato
 * Data: 26 de Junho de 2025
 */
public class Exercicio09 {

    /**
     * Imprime o exemplo padrão de estratégia de testes para cadastro de usuário para uso pelo Main.java
     */
    public static void printExemploPadrao() {
        System.out.println("=== Estratégia de Testes para Cadastro de Usuário ===\n");

        System.out.println("Tipos de Testes:");
        System.out.println("- Testes Unitários: Validam regras de negócio isoladamente (ex: validação de e-mail, obrigatoriedade de campos).");
        System.out.println("- Testes de Integração: Garantem que a funcionalidade interage corretamente com banco de dados e outros módulos.");
        System.out.println("- Testes End-to-End (E2E): Simulam o fluxo completo do usuário na interface, incluindo permissões de administrador.\n");

        System.out.println("Cenários a serem testados:");
        System.out.println("- Cadastro de usuário com dados válidos.");
        System.out.println("- Tentativa de cadastro com e-mail já existente (deve ser rejeitado).");
        System.out.println("- Cadastro sem nome ou e-mail (deve ser rejeitado).");
        System.out.println("- Atualização de dados de usuário existente.");
        System.out.println("- Deleção de usuário por administrador.");
        System.out.println("- Tentativa de deleção por usuário não administrador (deve ser rejeitada).");
        System.out.println("- Validação de formato de e-mail.");
        System.out.println("- Inserção de telefone e endereço opcionais.");
        System.out.println("- Inserção de e-mail inválido (deve ser rejeitado).\n");

        System.out.println("Casos de borda:");
        System.out.println("- Nome ou e-mail em branco ou apenas espaços.");
        System.out.println("- E-mail com caracteres especiais inválidos.");
        System.out.println("- Telefone com caracteres não numéricos.");
        System.out.println("- Endereço muito longo.\n");

        System.out.println("Exemplo de caso de teste em pseudocódigo:");
        System.out.println("Teste: Cadastro de usuário com e-mail duplicado");
        System.out.println("1. Cadastrar usuário com e-mail 'teste@exemplo.com'.");
        System.out.println("2. Tentar cadastrar outro usuário com o mesmo e-mail.");
        System.out.println("3. Esperar mensagem de erro: 'E-mail já cadastrado'.\n");

        System.out.println("Exemplo de teste unitário em Java (JUnit):");
        System.out.println("public void testCadastroUsuarioEmailDuplicado() {");
        System.out.println("    UsuarioService service = new UsuarioService();");
        System.out.println("    service.cadastrar(\"João\", \"joao@email.com\", \"Rua 1\", \"1234\");");
        System.out.println("    Exception ex = assertThrows(EmailDuplicadoException.class, () -> {");
        System.out.println("        service.cadastrar(\"Maria\", \"joao@email.com\", \"Rua 2\", \"5678\");");
        System.out.println("    });");
        System.out.println("    assertEquals(\"E-mail já cadastrado\", ex.getMessage());");
        System.out.println("}");
    }

    /**
     * Método principal para teste isolado (opcional)
     */
    public static void main(String[] args) {
        printExemploPadrao();
    }
}