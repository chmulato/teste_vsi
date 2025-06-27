package src.test.exercicios;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import exercicios.Exercicio03;
import exercicios.Exercicio03.LoggerService;
import exercicios.Exercicio03.Log4jAdapter;
import exercicios.Exercicio03.SLF4JAdapter;
import exercicios.Exercicio03.UsuarioService;

/**
 * Exercicio 3 - Testes Unitários para Padrão de Projeto (Desacoplamento)
 *
 * Este arquivo contém testes unitários para a classe Exercicio03,
 * que demonstra o uso do padrão Adapter para desacoplar código de 
 * bibliotecas de terceiros.
 *
 * Os testes cobrem:
 * - Funcionamento correto dos adapters Log4j e SLF4J
 * - Comportamento do UsuarioService com diferentes implementações
 * - Tratamento de erros e casos de borda
 * - Execução do método de demonstração
 * - Polimorfismo através da interface LoggerService
 *
 * Autor: Christian Vladimir Uhdre Mulato
 * Data: 26 de Junho de 2025
 */
public class Exercicio03Test {

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @Before
    public void setUp() {
        // Capturar saída do console para verificar logs
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testLog4jAdapterInfo() {
        // Teste do adapter Log4j - método info
        LoggerService logger = new Log4jAdapter();
        logger.info("Teste de informação");
        
        String output = outputStream.toString();
        assertTrue("Deve conter prefixo LOG4J-INFO", output.contains("[LOG4J-INFO]"));
        assertTrue("Deve conter a mensagem", output.contains("Teste de informação"));
    }

    @Test
    public void testLog4jAdapterError() {
        // Teste do adapter Log4j - método error
        LoggerService logger = new Log4jAdapter();
        Exception testException = new RuntimeException("Erro de teste");
        logger.error("Erro ocorreu", testException);
        
        String output = outputStream.toString();
        assertTrue("Deve conter prefixo LOG4J-ERROR", output.contains("[LOG4J-ERROR]"));
        assertTrue("Deve conter a mensagem de erro", output.contains("Erro ocorreu"));
        assertTrue("Deve conter a mensagem da exceção", output.contains("Erro de teste"));
    }

    @Test
    public void testLog4jAdapterDebug() {
        // Teste do adapter Log4j - método debug
        LoggerService logger = new Log4jAdapter();
        logger.debug("Debug info");
        
        String output = outputStream.toString();
        assertTrue("Deve conter prefixo LOG4J-DEBUG", output.contains("[LOG4J-DEBUG]"));
        assertTrue("Deve conter a mensagem de debug", output.contains("Debug info"));
    }

    @Test
    public void testSLF4JAdapterInfo() {
        // Teste do adapter SLF4J - método info
        LoggerService logger = new SLF4JAdapter();
        logger.info("Teste SLF4J");
        
        String output = outputStream.toString();
        assertTrue("Deve conter prefixo SLF4J-INFO", output.contains("[SLF4J-INFO]"));
        assertTrue("Deve conter a mensagem", output.contains("Teste SLF4J"));
    }

    @Test
    public void testSLF4JAdapterError() {
        // Teste do adapter SLF4J - método error
        LoggerService logger = new SLF4JAdapter();
        Exception testException = new IllegalArgumentException("Argumento inválido");
        logger.error("Erro SLF4J", testException);
        
        String output = outputStream.toString();
        assertTrue("Deve conter prefixo SLF4J-ERROR", output.contains("[SLF4J-ERROR]"));
        assertTrue("Deve conter a mensagem de erro", output.contains("Erro SLF4J"));
        assertTrue("Deve conter a exceção", output.contains("Argumento inválido"));
    }

    @Test
    public void testSLF4JAdapterDebug() {
        // Teste do adapter SLF4J - método debug
        LoggerService logger = new SLF4JAdapter();
        logger.debug("Debug SLF4J");
        
        String output = outputStream.toString();
        assertTrue("Deve conter prefixo SLF4J-DEBUG", output.contains("[SLF4J-DEBUG]"));
        assertTrue("Deve conter a mensagem de debug", output.contains("Debug SLF4J"));
    }

    @Test
    public void testUsuarioServiceComLog4j() {
        // Teste do UsuarioService usando Log4j
        LoggerService logger = new Log4jAdapter();
        UsuarioService service = new UsuarioService(logger);
        
        service.criarUsuario("João Silva");
        
        String output = outputStream.toString();
        assertTrue("Deve logar início da criação", output.contains("Iniciando criação do usuário: João Silva"));
        assertTrue("Deve logar sucesso", output.contains("Usuário criado com sucesso: João Silva"));
        assertTrue("Deve conter logs do Log4j", output.contains("[LOG4J-INFO]"));
    }

    @Test
    public void testUsuarioServiceComSLF4J() {
        // Teste do UsuarioService usando SLF4J
        LoggerService logger = new SLF4JAdapter();
        UsuarioService service = new UsuarioService(logger);
        
        service.criarUsuario("Maria Santos");
        
        String output = outputStream.toString();
        assertTrue("Deve logar início da criação", output.contains("Iniciando criação do usuário: Maria Santos"));
        assertTrue("Deve logar sucesso", output.contains("Usuário criado com sucesso: Maria Santos"));
        assertTrue("Deve conter logs do SLF4J", output.contains("[SLF4J-INFO]"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUsuarioServiceComNomeVazio() {
        // Teste de tratamento de erro - nome vazio
        LoggerService logger = new Log4jAdapter();
        UsuarioService service = new UsuarioService(logger);
        
        service.criarUsuario("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUsuarioServiceComNomeNull() {
        // Teste de tratamento de erro - nome null
        LoggerService logger = new SLF4JAdapter();
        UsuarioService service = new UsuarioService(logger);
        
        service.criarUsuario(null);
    }

    @Test
    public void testUsuarioServiceLogaErro() {
        // Teste se erro é logado corretamente
        LoggerService logger = new Log4jAdapter();
        UsuarioService service = new UsuarioService(logger);
        
        try {
            service.criarUsuario("");
            fail("Deveria ter lançado exceção");
        } catch (IllegalArgumentException e) {
            String output = outputStream.toString();
            assertTrue("Deve logar o erro", output.contains("[LOG4J-ERROR]"));
            assertTrue("Deve conter mensagem de erro", output.contains("Erro ao criar usuário"));
        }
    }

    @Test
    public void testPolimorfismoInterface() {
        // Teste do polimorfismo - mesma interface, comportamentos diferentes
        LoggerService[] loggers = {
            new Log4jAdapter(),
            new SLF4JAdapter()
        };
        
        for (LoggerService logger : loggers) {
            UsuarioService service = new UsuarioService(logger);
            service.criarUsuario("Teste Polimorfismo");
        }
        
        String output = outputStream.toString();
        assertTrue("Deve conter logs de ambas as implementações", 
                   output.contains("[LOG4J-INFO]") && output.contains("[SLF4J-INFO]"));
    }

    @Test
    public void testDesacoplamentoCompleto() {
        // Teste que demonstra o desacoplamento total
        // UsuarioService não precisa saber qual implementação está usando
        LoggerService logger1 = new Log4jAdapter();
        LoggerService logger2 = new SLF4JAdapter();
        
        UsuarioService service1 = new UsuarioService(logger1);
        UsuarioService service2 = new UsuarioService(logger2);
        
        // Mesmo código, diferentes implementações
        service1.criarUsuario("Usuário 1");
        service2.criarUsuario("Usuário 2");
        
        String output = outputStream.toString();
        assertTrue("Deve funcionar com ambas implementações", 
                   output.contains("Usuário 1") && output.contains("Usuário 2"));
        assertTrue("Deve usar diferentes bibliotecas", 
                   output.contains("[LOG4J-") && output.contains("[SLF4J-"));
    }

    @Test
    public void testPrintExemploPadraoExecuta() {
        // Teste se o método de demonstração executa sem erros
        try {
            Exercicio03.printExemploPadrao();
            String output = outputStream.toString();
            
            assertTrue("Deve conter título", output.contains("PADRÃO ADAPTER PARA DESACOPLAMENTO"));
            assertTrue("Deve conter problemas", output.contains("PROBLEMA:"));
            assertTrue("Deve conter solução", output.contains("SOLUÇÃO"));
            assertTrue("Deve conter vantagens", output.contains("VANTAGENS:"));
            assertTrue("Deve conter limitações", output.contains("LIMITAÇÕES:"));
            assertTrue("Deve executar exemplo prático", output.contains("DEMONSTRAÇÃO PRÁTICA:"));
            
        } catch (Exception e) {
            fail("O método printExemploPadrao() não deveria lançar exceção: " + e.getMessage());
        }
    }

    @Test
    public void testMainExecutesWithoutException() {
        // Teste do método main
        try {
            Exercicio03.main(new String[]{});
        } catch (Exception e) {
            fail("O método main não deveria lançar exceção: " + e.getMessage());
        }
    }

    @Test
    public void testInterfaceLoggerServiceContratoCorreto() {
        // Teste se a interface tem os métodos corretos
        LoggerService logger = new Log4jAdapter();
        
        // Testa se todos os métodos da interface existem e funcionam
        logger.info("teste");
        logger.debug("teste");
        logger.error("teste", new RuntimeException("teste"));
        
        // Se chegou até aqui, a interface está implementada corretamente
        assertTrue("Interface implementada corretamente", true);
    }

    // Método tearDown para restaurar System.out
    @org.junit.After
    public void tearDown() {
        System.setOut(originalOut);
    }
}