package exercicios;

/**
 * Exercicio 8 - Caso de Uso para Cadastro e Gerenciamento de Plantas no Sistema XYZ
 *
 * Apresenta um caso de uso completo para cadastro, atualização, deleção e pesquisa de plantas,
 * detalhando regras de negócio, validações, premissas e sugestões de testes, com foco em segurança e integridade.
 *
 * Autor: Christian Vladimir Uhdre Mulato
 * Data: 26 de Junho de 2025
 */
public class Exercicio08 {

    /**
     * Imprime o exemplo padrão de caso de uso e explicações para uso pelo Main.java
     */
    public static void printExemploPadrao() {
        System.out.println("=== Caso de Uso: Gerenciamento de Plantas no Sistema XYZ ===\n");

        System.out.println("User Story:");
        System.out.println("Como usuário do sistema XYZ, desejo cadastrar, atualizar, deletar e pesquisar plantas");
        System.out.println("para que o sistema possa gerenciar as informações necessárias para as próximas fases do projeto.\n");

        System.out.println("Regras de Negócio e Premissas:");
        System.out.println("- O código da planta deve ser numérico, obrigatório e único.");
        System.out.println("- A descrição é opcional, alfanumérica e limitada a 10 caracteres.");
        System.out.println("- Não pode haver duplicidade de códigos de plantas.");
        System.out.println("- Apenas usuários administradores podem deletar plantas.\n");

        System.out.println("Validações e Medidas de Segurança:");
        System.out.println("- Validar se o código é numérico e único antes de cadastrar.");
        System.out.println("- Validar tamanho e caracteres da descrição.");
        System.out.println("- Restringir a deleção de plantas a usuários com perfil administrador.");
        System.out.println("- Implementar tratamento de erros e mensagens claras ao usuário.");
        System.out.println("- Prevenir ataques de SQL Injection e garantir autenticação/autorização.\n");

        System.out.println("Sugestão de Testes (incluindo casos de borda):");
        System.out.println("- Cadastro de planta com código válido e descrição dentro do limite.");
        System.out.println("- Tentativa de cadastro com código duplicado (deve ser rejeitado).");
        System.out.println("- Cadastro com descrição maior que 10 caracteres (deve ser rejeitado).");
        System.out.println("- Cadastro com código não numérico (deve ser rejeitado).");
        System.out.println("- Deleção de planta por usuário não administrador (deve ser rejeitado).");
        System.out.println("- Pesquisa de plantas por código e por descrição.");
        System.out.println("- Atualização de planta existente.");
        System.out.println("- Cadastro de planta sem descrição (campo opcional).\n");

        System.out.println("Exemplo de Caso de Uso (formato resumido):");
        System.out.println("Ator: Usuário autenticado (administrador ou comum)");
        System.out.println("Pré-condição: Usuário autenticado no sistema");
        System.out.println("Fluxo principal:");
        System.out.println("  1. Usuário acessa tela de plantas.");
        System.out.println("  2. Usuário preenche código e (opcionalmente) descrição.");
        System.out.println("  3. Sistema valida dados e cadastra planta se estiver tudo correto.");
        System.out.println("  4. Usuário pode pesquisar, atualizar ou (se administrador) deletar plantas.");
        System.out.println("Fluxos alternativos:");
        System.out.println("  - Código duplicado: sistema exibe mensagem de erro.");
        System.out.println("  - Usuário comum tenta deletar: sistema bloqueia ação.");
    }

    /**
     * Método principal para teste isolado (opcional)
     */
    public static void main(String[] args) {
        printExemploPadrao();
    }
}