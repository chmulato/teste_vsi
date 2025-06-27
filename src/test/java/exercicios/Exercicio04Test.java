/**
 * Testes automatizados para o Exercicio04.
 *
 * Este arquivo contém testes unitários para validar a execução e a saída do método main da classe Exercicio04,
 * que apresenta uma explicação simulada sobre recursos do Angular e um exemplo de comunicação entre componentes.
 *
 * Os testes verificam:
 * - Se o método main executa sem lançar exceções.
 * - Se a saída impressa contém as seções esperadas sobre Angular e comunicação entre componentes.
 */
package exercicios;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class Exercicio04Test {

    /**
     * Testa se o método main executa sem exceções
     */
    @Test
    public void testMainExecutesWithoutException() {
        Exercicio04.main(new String[]{});
    }

    /**
     * Testa se o método main imprime todas as seções esperadas do exemplo simulado de Angular
     */
    @Test
    public void testMainOutputContainsExpectedSections() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(outputStream));
            Exercicio04.main(new String[]{});
            String output = outputStream.toString();

            // Verifica se a saída contém as seções esperadas do exemplo Angular simulado
            assertTrue(output.contains("=== Experiência com Angular ==="));
            assertTrue(output.contains("Principais recursos do Angular:"));
            assertTrue(output.contains("Componentização"));
            assertTrue(output.contains("Data binding"));
            assertTrue(output.contains("Injeção de dependência"));
            assertTrue(output.contains("Serviços e Observables"));
            assertTrue(output.contains("Roteamento"));
            assertTrue(output.contains("Comunicação entre componentes"));
            assertTrue(output.contains("Integração com APIs REST"));
            assertTrue(output.contains("Exemplo prático: Comunicação entre componentes"));
            assertTrue(output.contains("@Component({ selector: 'app-pai'"));
            assertTrue(output.contains("@Component({ selector: 'app-filho'"));
            assertTrue(output.contains("@Input() mensagem: string;"));
            assertTrue(output.contains("@Output() resposta = new EventEmitter<string>();"));
            assertTrue(output.contains("Esse exemplo demonstra como o componente filho recebe dados do pai via @Input"));

        } finally {
            System.setOut(originalOut);
        }
    }
}