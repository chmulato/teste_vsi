# Teste Java Developer

**Nome:** [Christian Vladimir Uhdre Mulato]  **Data:** [26/06/2025]

*Responda em português ou inglês.*

1.**Escreva um programa Java para resolver o seguinte problema:**

Você deve criar uma função utilitária para um aplicativo de processamento de texto. A função deve gerar todos os anagramas possíveis a partir de um grupo de letras distintas. Por exemplo, a entrada {a, b, c} deve retornar: abc, acb, bac, bca, cab, cba.

**Requisitos adicionais:**

- O programa deve aceitar qualquer grupo de letras distintas como entrada e produzir o resultado correto.
- Otimize para legibilidade e clareza.
- Inclua validação básica (por exemplo, garantir que a entrada não seja vazia e contenha apenas letras).
- Escreva testes unitários para validar sua função com pelo menos três casos de teste diferentes, incluindo casos de borda (por exemplo, entrada com uma única letra ou entrada vazia).
- Documente claramente seu código, explicando a lógica para gerar os anagramas.

---

2.**Forneça um exemplo de cenário onde sobrescrever o método equals() é necessário em Java. Explique os principais pontos ao implementar esse método, como garantir que ele esteja alinhado com o método hashCode(). Inclua exemplos de código, se possível.**

3.**Explique como você usaria um padrão de projeto para desacoplar seu código de uma biblioteca de terceiros que pode ser substituída no futuro. Descreva as vantagens e limitações da abordagem escolhida e forneça um pequeno trecho de código ilustrando sua aplicação.**

4.**Descreva sua experiência com Angular, incluindo seus recursos principais e casos de uso. Forneça um exemplo de uma aplicação prática onde você utilizou Angular e inclua um trecho de código demonstrando um recurso chave, como comunicação entre componentes, data binding ou integração de serviços.**

5.**Explique as técnicas que você utiliza para prevenir ataques de SQL Injection em aplicações web. Forneça exemplos de código mostrando implementações seguras, como uso de queries parametrizadas ou ORMs. Mencione quaisquer medidas adicionais que você adota para proteger a camada de banco de dados.**

6.**Descreva os passos que você tomaria para diagnosticar e melhorar a performance de um processo batch que interage com banco de dados e servidor FTP. Explique como identificaria gargalos, otimizaria queries, melhoraria a execução da lógica e aumentaria a eficiência da transferência de arquivos. Forneça exemplos de ferramentas ou técnicas que você usaria durante a análise.**

---

**Tabelas:**

## Vendedor

| ID | Nome  | Idade | Salário  |
|----|-------|-------|----------|
| 1  | Abe   | 61    | 140000   |
| 2  | Bob   | 34    | 44000    |
| 5  | Chris | 34    | 40000    |
| 7  | Dan   | 41    | 52000    |
| 8  | Ken   | 57    | 115000   |
| 11 | Joe   | 38    | 38000    |

## Cliente

| ID | Nome     | Cidade    | Tipo de Indústria |
|----|----------|-----------|-------------------|
| 4  | Samsonic | Pleasant  | J                 |
| 6  | Panasung | Oaktown   | J                 |
| 7  | Samony   | Jackson   | B                 |
| 9  | Orange   | Jackson   | B                 |

## Pedidos

| ID | Data     | id_cliente | id_vendedor | Valor |
|----|----------|------------|-------------|-------|
| 10 | 02/08/96 | 4          | 2           | 540   |
| 20 | 30/01/99 | 4          | 8           | 1800  |
| 30 | 14/07/95 | 9          | 1           | 460   |
| 40 | 29/01/98 | 7          | 2           | 2400  |
| 50 | 03/02/98 | 6          | 7           | 600   |
| 60 | 02/03/98 | 6          | 7           | 720   |
| 70 | 06/05/98 | 9          | 7           | 150   |

---

7.**Considerando as tabelas acima, escreva a consulta SQL que:**

- a. Retorna os nomes de todos os vendedores que não possuem nenhum pedido com Samsonic.
- b. Atualiza os nomes dos vendedores que possuem 2 ou mais pedidos. É necessário adicionar um '*' ao final do nome.
- c. Deleta todos os vendedores que fizeram pedidos para a cidade de Jackson.
- d. O valor total de vendas para cada vendedor. Se o vendedor não vendeu nada, mostrar zero.

---

8.**O cliente possui um sistema chamado XYZ e pretende iniciar atualizações divididas em 3 fases. Os requisitos para a primeira fase são:**

   1. Permitir novos cadastros de dados no sistema, que servirão de entrada para a segunda fase.
   2. Implementar funcionalidade para criar, atualizar, deletar e pesquisar plantas.
      - As plantas devem ter os seguintes atributos:
        - Código: apenas numérico, obrigatório e único.
        - Descrição: alfanumérica, até 10 caracteres, opcional.
      - Somente usuários administradores podem deletar plantas.
   3. Garantir que o sistema previna duplicidade de códigos de plantas.

**Tarefa:**
Com base nas informações acima:

- Escreva um caso de uso ou user story para este cenário, garantindo que atenda claramente aos requisitos.
- Destaque quaisquer regras de negócio ou premissas relevantes para a solução.
- Descreva quaisquer validações ou medidas de segurança que você implementaria no sistema.
- Sugira como você testaria essa funcionalidade, incluindo exemplos de casos de borda.

---

9.**Considere a seguinte descrição de uma funcionalidade do sistema: Cadastro de Usuário**

- Uma tela permite inserir, deletar ou atualizar informações de usuários.
- Cada usuário possui os atributos: nome, e-mail, endereço e telefone, sendo nome e e-mail obrigatórios.
- Os e-mails devem ser únicos entre todos os usuários.
- Somente usuários administradores podem deletar outros usuários.

**Tarefa:**

- Descreva os tipos de testes que você implementaria (ex: unitário, integração ou end-to-end) e explique os cenários que testaria para garantir que a funcionalidade funciona como esperado.
- Dê exemplos de casos de borda e como você os trataria.
- Inclua um exemplo de caso de teste em código ou pseudocódigo para um ou mais cenários.
