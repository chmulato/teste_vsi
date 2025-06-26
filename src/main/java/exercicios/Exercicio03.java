package exercicios;

/**
 * Exercicio 3 - Padrão de Projeto para Desacoplamento
 *
 * Explica e exemplifica como utilizar padrões de projeto (como Adapter ou Strategy)
 * para desacoplar o código de bibliotecas de terceiros, facilitando futuras substituições.
 * 
 * Destaques:
 * - Demonstração de flexibilidade e manutenção do código.
 * - Exemplo simulado e comentários sobre vantagens e limitações.
 *
 * Autor: Christian Vladimir Uhdre Mulato
 * Data: 26 de Junho de 2025
 */
public class Exercicio03 {

    /**
     * Imprime o exemplo padrão de explicação e código Angular para uso pelo Main.java
     */
    public static void printExemploPadrao() {
        System.out.println("Principais recursos do Angular:");
        System.out.println("- Componentização");
        System.out.println("- Data binding (one-way, two-way)");
        System.out.println("- Injeção de dependência");
        System.out.println("- Serviços e Observables");
        System.out.println("- Roteamento");
        System.out.println("- Comunicação entre componentes (@Input, @Output)");

        System.out.println("\nExemplo prático (TypeScript):");
        System.out.println("// Componente pai");
        System.out.println("@Component({ selector: 'app-pai', template: `<app-filho [mensagem]=\"msg\" (resposta)=\"onResposta($event)\"></app-filho>` })");
        System.out.println("export class PaiComponent {");
        System.out.println("  msg = 'Olá do pai!';");
        System.out.println("  onResposta(event: string) { console.log(event); }");
        System.out.println("}");

        System.out.println("\n// Componente filho");
        System.out.println("@Component({ selector: 'app-filho', template: `<button (click)=\"enviar()\">Responder</button>` })");
        System.out.println("export class FilhoComponent {");
        System.out.println("  @Input() mensagem: string;");
        System.out.println("  @Output() resposta = new EventEmitter<string>();");
        System.out.println("  enviar() { this.resposta.emit('Olá do filho!'); }");
        System.out.println("}");
    }

    /**
     * Método principal para teste isolado (opcional)
     */
    public static void main(String[] args) {
        printExemploPadrao();
    }
}