/**
 * Classe Main - Execução dos Exercícios do Teste Java Developer (DSE)
 *
 * Esta classe executa, em sequência, as soluções dos exercícios 1 a 9 do desafio DSE.
 * Cada exercício aborda um tema específico solicitado no teste:
 *  1. Geração de anagramas de letras distintas.
 *  2. Exemplo de sobrescrita de equals() e hashCode().
 *  3. Uso de padrão de projeto para desacoplamento de bibliotecas.
 *  4. Experiência e exemplos práticos com Angular.
 *  5. Técnicas para prevenção de SQL Injection em aplicações web.
 *  6. Diagnóstico e melhoria de performance em processos batch/FTP.
 *  7. Consultas SQL sobre tabelas fornecidas.
 *  8. Caso de uso para cadastro e gerenciamento de plantas no sistema XYZ.
 *  9. Estratégia de testes para cadastro de usuário.
 *
 * Para executar, utilize o Maven com o comando:
 *   mvn exec:java -Dexec.mainClass=exercicios.Main
 *
 * Autor: Christian Vladimir Uhdre Mulato
 * Data: 26 de Junho de 2025
 */

package exercicios;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exercise 01 ===");
        System.out.println("Statement: Generate all possible anagrams from a group of distinct letters.");
        System.out.println("Enunciado: Gere todos os anagramas possíveis de um grupo de letras distintas.");
        System.out.println("Result / Resultado:");
        Exercicio01.printAnagramasPadrao();

        System.out.println("\n=== Exercise 02 ===");
        System.out.println("Statement: Example of overriding equals() and hashCode() in Java.");
        System.out.println("Enunciado: Exemplo de sobrescrita de equals() e hashCode() em Java.");
        System.out.println("Result / Resultado:");
        Exercicio02.printExemploPadrao();

        System.out.println("\n=== Exercise 03 ===");
        System.out.println("Statement: Demonstrate how to decouple code from third-party libraries using a design pattern.");
        System.out.println("Enunciado: Demonstre como desacoplar código de bibliotecas de terceiros usando padrão de projeto.");
        System.out.println("Result / Resultado:");
        Exercicio03.printExemploPadrao();

        System.out.println("\n=== Exercise 04 ===");
        System.out.println("Statement: Explain Angular features and demonstrate component communication.");
        System.out.println("Enunciado: Explique recursos do Angular e demonstre comunicação entre componentes.");
        System.out.println("Result / Resultado:");
        Exercicio04.printExemploPadrao();

        System.out.println("\n=== Exercise 05 ===");
        System.out.println("Statement: Explain techniques to prevent SQL Injection in web applications.");
        System.out.println("Enunciado: Explique técnicas para prevenir SQL Injection em aplicações web.");
        System.out.println("Result / Resultado:");
        Exercicio05.printExemploPadrao();

        System.out.println("\n=== Exercise 06 ===");
        System.out.println("Statement: Diagnose and improve the performance of a batch process with database and FTP.");
        System.out.println("Enunciado: Diagnostique e melhore a performance de um processo batch com banco de dados e FTP.");
        System.out.println("Result / Resultado:");
        Exercicio06.printExemploPadrao();

        System.out.println("\n=== Exercise 07 ===");
        System.out.println("Statement: SQL queries for proposed scenarios with Vendedor, Cliente, and Pedidos tables.");
        System.out.println("Enunciado: Consultas SQL para cenários propostos com tabelas Vendedor, Cliente e Pedidos.");
        System.out.println("Result / Resultado:");
        Exercicio07.printExemploPadrao();

        System.out.println("\n=== Exercise 08 ===");
        System.out.println("Statement: Use case for registering and managing plants in the XYZ system.");
        System.out.println("Enunciado: Caso de uso para cadastro e gerenciamento de plantas no sistema XYZ.");
        System.out.println("Result / Resultado:");
        Exercicio08.printExemploPadrao();

        System.out.println("\n=== Exercise 09 ===");
        System.out.println("Statement: Testing strategy for user registration.");
        System.out.println("Enunciado: Estratégia de testes para cadastro de usuário.");
        System.out.println("Result / Resultado:");
        Exercicio09.printExemploPadrao();

        System.out.println("\n=== Enunciado do Desafio (Resumo) ===\n");
        try {
            java.nio.file.Files.lines(
                java.nio.file.Paths.get("doc/dse_test_java_developer.md"),
                java.nio.charset.StandardCharsets.UTF_8
            ).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Não foi possível exibir o enunciado: " + e.getMessage());
        }

        // Geração do PDF ao final da execução com nome formatado
        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            doc.addPage(page);

            PDPageContentStream content = new PDPageContentStream(doc, page);
            content.setFont(PDType1Font.HELVETICA, 12);
            content.beginText();
            content.setLeading(14.5f);
            content.newLineAtOffset(50, 750);

            content.showText("Resumo das Soluções do Teste Java Developer");
            content.newLine();
            content.newLine();

            // Exemplo: adicionar um resumo de cada exercício
            content.showText("Exercicio 1: Geração de Anagramas - OK");
            content.newLine();
            content.showText("Exercicio 2: equals() e hashCode() - OK");
            content.newLine();
            content.showText("Exercicio 3: Desacoplamento com Padrão de Projeto - OK");
            content.newLine();
            content.showText("Exercicio 4: Angular (simulado) - OK");
            content.newLine();
            content.showText("Exercicio 5: Prevenção de SQL Injection - OK");
            content.newLine();
            content.showText("Exercicio 6: Performance Batch/FTP - OK");
            content.newLine();
            content.showText("Exercicio 7: Consultas SQL - OK");
            content.newLine();
            content.showText("Exercicio 8: Caso de Uso Plantas - OK");
            content.newLine();
            content.showText("Exercicio 9: Estratégia de Testes - OK");
            content.newLine();

            content.endText();
            content.close();

            // Gerar nome do arquivo com data atual
            String dataAtual = java.time.LocalDate.now().toString().replace("-", "_");
            String nomeArquivo = "doc/" + dataAtual + "_Christian_Mulato_Resultado.pdf";
            
            doc.save(nomeArquivo);
            System.out.println("\nPDF gerado em: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao gerar PDF: " + e.getMessage());
        }
    }
}