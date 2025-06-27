# Teste Java Developer - VSI

Projeto de teste prático para vaga de Desenvolvedor Java na VSI, contendo soluções para 9 exercícios que abrangem diferentes aspectos do desenvolvimento Java.

**Autor:** Christian Vladimir Uhdre Mulato  
**Data:** 26 de Junho de 2025

---

## Descrição

Este projeto implementa soluções para o teste prático DSE Java Developer, demonstrando conhecimentos em:

- Algoritmos e estruturas de dados
- Programação orientada a objetos
- Padrões de projeto (Design Patterns)
- Desenvolvimento web com Angular
- Segurança em aplicações (SQL Injection)
- Otimização de performance
- Consultas SQL
- Testes unitários
- Casos de uso e modelagem de sistemas

---

## Tecnologias Utilizadas

- **Java 8+** – Linguagem principal
- **Maven** – Gerenciamento de dependências e build
- **JUnit 4** – Framework de testes unitários
- **Apache PDFBox** – Geração de documentos PDF
- **SQL** – Consultas e modelagem de dados

---

## Estrutura do Projeto

```text
teste_vsi/
├── src/
│   ├── main/java/exercicios/
│   │   ├── Exercicio01.java    # Geração de anagramas
│   │   ├── Exercicio02.java    # Sobrescrita equals/hashCode
│   │   ├── Exercicio03.java    # Padrões de projeto (Adapter)
│   │   ├── Exercicio04.java    # Exemplos Angular
│   │   ├── Exercicio05.java    # Prevenção SQL Injection
│   │   ├── Exercicio06.java    # Otimização de performance
│   │   ├── Exercicio07.java    # Consultas SQL
│   │   ├── Exercicio08.java    # Caso de uso - Sistema XYZ
│   │   ├── Exercicio09.java    # Estratégia de testes
│   │   └── Main.java           # Classe principal
│   └── test/java/exercicios/       # Testes unitários
│       ├── Exercicio01Test.java    # Testes para geração de anagramas
│       ├── Exercicio02Test.java    # Testes para equals/hashCode
│       ├── Exercicio03Test.java    # Testes para padrões de projeto
│       ├── Exercicio04Test.java    # Testes para exemplos Angular
│       ├── Exercicio05Test.java    # Testes para SQL Injection
│       ├── Exercicio06Test.java    # Testes para performance
│       ├── Exercicio07Test.java    # Testes para consultas SQL
│       ├── Exercicio08Test.java    # Testes para caso de uso
│       ├── Exercicio09Test.java    # Testes para estratégia de testes
│       └── MainTest.java           # Testes para classe principal
├── doc/                        # Documentação do teste
├── target/                     # Arquivos compilados
│   ├── classes/                # Classes compiladas
│   ├── test-classes/           # Classes de teste compiladas
│   └── teste_vsi-1.0-SNAPSHOT.jar
├── pom.xml                     # Configuração Maven
├── .gitignore                  # Arquivos ignorados pelo Git
└── README.md                   # Este arquivo
```

---

## Como Executar

### Pré-requisitos

- Java 8 ou superior
- Maven 3.6 ou superior

### Compilando e Executando

1. **Clone ou baixe o projeto**
2. **No diretório raiz, execute:**

```bash
# Compilar o projeto
mvn clean compile

# Executar todos os exercícios e gerar o PDF de saída
mvn exec:java -Dexec.mainClass=exercicios.Main
ou
mvn exec:java -D.mainClass=exercicios.Main

# Ou executar diretamente com Java
java -cp target/classes exercicios.Main
```

### Executando os testes

```bash
# Executar todos os testes
mvn test

# Executar teste específico
mvn test -Dtest=Exercicio01Test
```

### Gerando o JAR

```bash
# Gerar JAR executável
mvn clean package

# Executar o JAR
java -jar target/teste_vsi-1.0-SNAPSHOT.jar
```

---

## Geração do Relatório PDF

O arquivo PDF é gerado automaticamente na pasta `doc/` sempre que o projeto é executado, com o nome no formato `YYYY_MM_DD_Christian_Mulato_Resultado.pdf` (exemplo: `2025_06_26_Christian_Mulato_Resultado.pdf`). Este PDF contém:

- Saídas de todos os 9 exercícios
- Resultados formatados e organizados
- Demonstrações práticas de cada solução

Para regenerar o PDF, basta executar o projeto novamente com qualquer um dos comandos de execução acima.

---

## Exercícios Implementados

### 1. **Geração de Anagramas**

- Algoritmo recursivo para gerar todos os anagramas de letras distintas
- Validação de entrada e tratamento de casos especiais

### 2. **Sobrescrita de equals() e hashCode()**

- Implementação correta dos métodos em classe Pessoa
- Demonstração de contratos e boas práticas

### 3. **Padrões de Projeto**

- Implementação do padrão Adapter para desacoplamento de bibliotecas de terceiros
- Exemplo prático e análise de vantagens/limitações

### 4. **Experiência com Angular**

- Exemplos de componentes, services e routing
- Boas práticas de desenvolvimento frontend

### 5. **Prevenção de SQL Injection**

- Técnicas de sanitização de dados
- Uso de PreparedStatements

### 6. **Otimização de Performance**

- Análise de gargalos em processos batch
- Estratégias de otimização de FTP

### 7. **Consultas SQL**

- Queries complexas com JOINs
- Otimização de consultas

### 8. **Caso de Uso - Sistema XYZ**

- Modelagem de cadastro de plantas
- Regras de negócio e validações

### 9. **Estratégia de Testes**

- Plano de testes para cadastro de usuários
- Testes unitários, integração e aceitação

---

## Testes

O projeto inclui testes unitários completos para todos os exercícios:

- **Cobertura:** Todos os métodos principais testados
- **Casos de borda:** Validação de entradas inválidas
- **Assertivas:** Verificação de resultados esperados
- **Mocks:** Simulação de dependências externas quando necessário

Execute `mvn test` para ver todos os testes passando.

---

## Documentação

A documentação completa do teste está disponível em:

- `doc/dse_test_java_developer.md` – Enunciado original
- `doc/YYYY_MM_DD_Christian_Mulato_Resultado.pdf` – Relatório de saída gerado automaticamente

---

## Configuração do Ambiente

### Maven Dependencies

```xml
<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.apache.pdfbox</groupId>
        <artifactId>pdfbox</artifactId>
        <version>2.0.30</version>
    </dependency>
</dependencies>
```

### Configurações

- **Java Version:** 1.8+
- **Maven Compiler:** 1.8
- **Encoding:** UTF-8
- **Main Class:** exercicios.Main

---

## Contribuição

Este é um projeto de teste individual desenvolvido para avaliação técnica.  
Sugestões e melhorias são bem-vindas via issues ou pull requests.

---

## Licença

Projeto desenvolvido exclusivamente para fins educacionais e de avaliação técnica profissional.

---

**Contato:** Christian Vladimir Uhdre Mulato  
**Data de Desenvolvimento:** 26 de Junho de 2025.