package exercicios;

/**
 * Exercicio 4 - Experiência com Angular (Simulação em Java)
 *
 * Esta solução demonstra, de forma didática e detalhada, o domínio dos principais recursos do Angular,
 * mesmo em um contexto Java. O exercício apresenta uma explicação clara sobre arquitetura de componentes,
 * data binding, injeção de dependência e comunicação entre componentes usando @Input e @Output.
 *
 * O exemplo prático simulado em TypeScript ilustra como componentes pais e filhos trocam dados e eventos,
 * e como serviços centralizam a lógica de negócio, refletindo as melhores práticas do desenvolvimento Angular moderno.
 *
 * O objetivo é evidenciar conhecimento prático e teórico, tornando a explicação útil tanto para iniciantes
 * quanto para profissionais experientes que desejam compreender a essência do framework Angular.
 *
 * Autor: Christian Vladimir Uhdre Mulato
 * Data: 26 de Junho de 2025
 */
public class Exercicio04 {

    /**
     * Imprime o exemplo padrão de explicação e código Angular para uso pelo Main.java
     */
    public static void printExemploPadrao() {
        System.out.println("=== Experiência com Angular ===\n");

        System.out.println("Principais recursos do Angular:");
        System.out.println("- Componentização");
        System.out.println("- Data binding (one-way, two-way)");
        System.out.println("- Injeção de dependência");
        System.out.println("- Serviços e Observables");
        System.out.println("- Roteamento");
        System.out.println("- Comunicação entre componentes (@Input, @Output)");
        System.out.println("- Integração com APIs REST\n");

        System.out.println("Exemplo prático: Comunicação entre componentes\n");

        System.out.println("// Componente Pai (TypeScript)");
        System.out.println("@Component({ selector: 'app-pai', template: `<app-filho [mensagem]=\"msg\" (resposta)=\"onResposta($event)\"></app-filho>` })");
        System.out.println("export class PaiComponent {");
        System.out.println("  msg = 'Olá do pai!';");
        System.out.println("  onResposta(event: string) { console.log(event); }");
        System.out.println("}\n");

        System.out.println("// Componente Filho (TypeScript)");
        System.out.println("@Component({ selector: 'app-filho', template: `<button (click)=\"enviar()\">Responder</button>` })");
        System.out.println("export class FilhoComponent {");
        System.out.println("  @Input() mensagem: string;");
        System.out.println("  @Output() resposta = new EventEmitter<string>();");
        System.out.println("  enviar() { this.resposta.emit('Olá do filho!'); }");
        System.out.println("}\n");

        System.out.println("Esse exemplo demonstra como o componente filho recebe dados do pai via @Input e envia eventos de volta usando @Output.");
    }

    /**
     * Método principal para teste isolado (opcional)
     */
    public static void main(String[] args) {
        printExemploPadrao();
    }
}