package exercicios;

/**
 * Exercicio 3 - Padrão de Projeto para Desacoplamento de Bibliotecas de Terceiros
 *
 * ENUNCIADO:
 * Explique como você usaria um padrão de projeto para desacoplar seu código de uma 
 * biblioteca de terceiros que pode ser substituída no futuro. Descreva as vantagens 
 * e limitações da abordagem escolhida e forneça um pequeno trecho de código 
 * ilustrando sua aplicação.
 *
 * SOLUÇÃO IMPLEMENTADA:
 * Esta classe demonstra o uso do padrão ADAPTER para desacoplar código de 
 * bibliotecas de terceiros, especificamente bibliotecas de logging (Log4j, SLF4J).
 * 
 * ARQUITETURA DA SOLUÇÃO:
 * 1. LoggerService (Interface) - Define contrato padronizado para logging
 * 2. Adapters Específicos - Implementam interface adaptando APIs de terceiros
 * 3. Aplicação Cliente - Usa apenas nossa interface, independente da biblioteca
 *
 * PADRÃO UTILIZADO: ADAPTER PATTERN
 * - Permite que interfaces incompatíveis trabalhem juntas
 * - Converte interface de uma classe em outra interface esperada
 * - Facilita integração de código legado ou bibliotecas externas
 *
 * CASOS DE USO DEMONSTRADOS:
 * - Logging com Log4j (adaptando métodos logInfo, logError, logDebug)
 * - Logging com SLF4J (adaptando métodos info, error, debug)
 * - Serviço de usuário que funciona com qualquer implementação
 * - Tratamento de erros consistente entre diferentes bibliotecas
 *
 * VANTAGENS DA ABORDAGEM:
 * ✓ Desacoplamento total: Aplicação não conhece biblioteca específica
 * ✓ Flexibilidade: Troca de biblioteca sem alteração do código cliente
 * ✓ Padronização: Interface única para diferentes implementações
 * ✓ Testabilidade: Facilita criação de mocks e testes unitários
 * ✓ Manutenibilidade: Mudanças isoladas nos adapters
 *
 * LIMITAÇÕES DA ABORDAGEM:
 * ✗ Complexidade adicional: Camada extra de abstração
 * ✗ Overhead de performance: Chamadas indiretas (mínimo)
 * ✗ Funcionalidades específicas: Pode limitar recursos únicos das bibliotecas
 * ✗ Manutenção de múltiplos adapters: Cada biblioteca precisa de seu adapter
 * ✗ Curva de aprendizado: Desenvolvedores precisam entender o padrão
 *
 * OUTROS PADRÕES APLICÁVEIS:
 * - Strategy Pattern: Para algoritmos intercambiáveis
 * - Bridge Pattern: Para separar abstração da implementação
 * - Facade Pattern: Para simplificar APIs complexas de terceiros
 *
 * EXEMPLO PRÁTICO:
 * O código simula cenário real onde aplicação precisa fazer logging, mas
 * a biblioteca de logging pode mudar (Log4j para SLF4J, por exemplo).
 * Com os adapters, a mudança é transparente para o código da aplicação.
 *
 * Autor: Christian Vladimir Uhdre Mulato
 * Data: 26 de Junho de 2025
 * Teste: DSE Java Developer
 */
public class Exercicio03 {

    // ===========================================
    // INTERFACE DE ABSTRAÇÃO (NOSSA CAMADA)
    // ===========================================
    
    /**
     * Interface que define o contrato para logging em nossa aplicação.
     * Esta interface abstrai qualquer biblioteca de logging específica.
     */
    public interface LoggerService {
        void info(String message);
        void error(String message, Exception e);
        void debug(String message);
    }

    // ===========================================
    // ADAPTADORES PARA BIBLIOTECAS ESPECÍFICAS
    // ===========================================
    
    /**
     * Adapter para Log4j - biblioteca de terceiros
     */
    public static class Log4jAdapter implements LoggerService {
        // Simulação da biblioteca Log4j
        private Log4jLogger log4jLogger;
        
        public Log4jAdapter() {
            this.log4jLogger = new Log4jLogger(); // Biblioteca externa
        }
        
        @Override
        public void info(String message) {
            log4jLogger.logInfo(message); // Adaptando para método específico do Log4j
        }
        
        @Override
        public void error(String message, Exception e) {
            log4jLogger.logError(message + " - " + e.getMessage());
        }
        
        @Override
        public void debug(String message) {
            log4jLogger.logDebug(message);
        }
    }
    
    /**
     * Adapter para SLF4J - outra biblioteca de terceiros
     */
    public static class SLF4JAdapter implements LoggerService {
        // Simulação da biblioteca SLF4J
        private SLF4JLogger slf4jLogger;
        
        public SLF4JAdapter() {
            this.slf4jLogger = new SLF4JLogger(); // Biblioteca externa
        }
        
        @Override
        public void info(String message) {
            slf4jLogger.info(message); // Método direto do SLF4J
        }
        
        @Override
        public void error(String message, Exception e) {
            slf4jLogger.error(message, e); // SLF4J aceita Exception diretamente
        }
        
        @Override
        public void debug(String message) {
            slf4jLogger.debug(message);
        }
    }

    // ===========================================
    // SIMULAÇÃO DAS BIBLIOTECAS DE TERCEIROS
    // ===========================================
    
    /**
     * Simulação da biblioteca Log4j (terceiro)
     */
    public static class Log4jLogger {
        public void logInfo(String msg) {
            System.out.println("[LOG4J-INFO] " + msg);
        }
        
        public void logError(String msg) {
            System.out.println("[LOG4J-ERROR] " + msg);
        }
        
        public void logDebug(String msg) {
            System.out.println("[LOG4J-DEBUG] " + msg);
        }
    }
    
    /**
     * Simulação da biblioteca SLF4J (terceiro)
     */
    public static class SLF4JLogger {
        public void info(String msg) {
            System.out.println("[SLF4J-INFO] " + msg);
        }
        
        public void error(String msg, Exception e) {
            System.out.println("[SLF4J-ERROR] " + msg + " | Exception: " + e.getMessage());
        }
        
        public void debug(String msg) {
            System.out.println("[SLF4J-DEBUG] " + msg);
        }
    }

    // ===========================================
    // APLICAÇÃO QUE USA O PADRÃO
    // ===========================================
    
    /**
     * Classe de serviço que usa logging mas não depende de biblioteca específica
     */
    public static class UsuarioService {
        private LoggerService logger;
        
        public UsuarioService(LoggerService logger) {
            this.logger = logger;
        }
        
        public void criarUsuario(String nome) {
            try {
                logger.info("Iniciando criação do usuário: " + nome);
                
                // Simular lógica de negócio
                if (nome == null || nome.trim().isEmpty()) {
                    throw new IllegalArgumentException("Nome não pode ser vazio");
                }
                
                // Simular sucesso
                logger.info("Usuário criado com sucesso: " + nome);
                logger.debug("Detalhes técnicos do processo...");
                
            } catch (Exception e) {
                logger.error("Erro ao criar usuário", e);
                throw e;
            }
        }
    }

    /**
     * Imprime o exemplo padrão de explicação e código para uso pelo Main.java
     */
    public static void printExemploPadrao() {
        System.out.println("=== PADRÃO ADAPTER PARA DESACOPLAMENTO ===");
        System.out.println();
        
        System.out.println("PROBLEMA:");
        System.out.println("- Dependência direta de bibliotecas de terceiros");
        System.out.println("- Dificuldade para trocar bibliotecas no futuro");
        System.out.println("- Código acoplado a APIs específicas");
        System.out.println();
        
        System.out.println("SOLUÇÃO - PADRÃO ADAPTER:");
        System.out.println("1. Criar interface própria (LoggerService)");
        System.out.println("2. Implementar adaptadores para cada biblioteca");
        System.out.println("3. Aplicação usa apenas nossa interface");
        System.out.println();
        
        System.out.println("DEMONSTRAÇÃO PRÁTICA:");
        System.out.println();
        
        // Exemplo com Log4j
        System.out.println("--- Usando Log4j através do Adapter ---");
        LoggerService log4jLogger = new Log4jAdapter();
        UsuarioService service1 = new UsuarioService(log4jLogger);
        service1.criarUsuario("João Silva");
        
        System.out.println();
        
        // Exemplo com SLF4J
        System.out.println("--- Usando SLF4J através do Adapter ---");
        LoggerService slf4jLogger = new SLF4JAdapter();
        UsuarioService service2 = new UsuarioService(slf4jLogger);
        service2.criarUsuario("Maria Santos");
        
        System.out.println();
        
        // Exemplo de erro
        System.out.println("--- Teste de Erro ---");
        try {
            service1.criarUsuario("");
        } catch (Exception e) {
            // Erro já logado pelo adapter
        }
        
        System.out.println();
        
        System.out.println("VANTAGENS:");
        System.out.println("✓ Desacoplamento total da biblioteca específica");
        System.out.println("✓ Facilidade para trocar bibliotecas (só muda o adapter)");
        System.out.println("✓ Código da aplicação permanece inalterado");
        System.out.println("✓ Testes mais fáceis (mocks da interface)");
        System.out.println("✓ Padronização da API interna");
        System.out.println();
        
        System.out.println("LIMITAÇÕES:");
        System.out.println("✗ Camada adicional de abstração");
        System.out.println("✗ Possível perda de funcionalidades específicas");
        System.out.println("✗ Overhead de performance (mínimo)");
        System.out.println("✗ Necessidade de manter múltiplos adapters");
        System.out.println();
        
        System.out.println("OUTROS PADRÕES APLICÁVEIS:");
        System.out.println("- Strategy: Para algoritmos intercambiáveis");
        System.out.println("- Bridge: Para separar abstração da implementação");
        System.out.println("- Facade: Para simplificar APIs complexas");
    }

    /**
     * Método principal para teste isolado (opcional)
     */
    public static void main(String[] args) {
        printExemploPadrao();
    }
}