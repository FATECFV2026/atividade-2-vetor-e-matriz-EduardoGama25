import java.util.Arrays;
import java.util.Scanner;
 
public class App {
   
    public static void main(String[] args) throws Exception {
        // TODO: Implementar menu interativo com as seguintes opcoes:
        // 1. Exercicio 01: Progressao Geometrica
        // 2. Exercicio 02: Sequencia Decrescente
        // 3. Exercicio 03: Vetor Dinamico
        // 4. Exercicio 04: Sequencia Crescente com Soma
        // 5. Exercicio 05: Matriz com Valores Incrementais
        // 6. Exercicio 06: Operacao entre Matrizes
        // 0. Sair
       
        // Utilize o método lerValor para validação de entrada
        // Exiba os resultados utilizando Arrays.toString() para vetores
        // Para matrizes, utilize o método exibirMatriz()

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- ATIVIDADE 2: VETORES E MATRIZES ---");
            System.out.println("1. Exercício 01: Progressão Geométrica");
            System.out.println("2. Exercício 02: Sequência Decrescente");
            System.out.println("3. Exercício 03: Vetor Dinâmico");
            System.out.println("4. Exercício 04: Sequência Crescente com Soma");
            System.out.println("5. Exercício 05: Matriz com Valores Incrementais");
            System.out.println("6. Exercício 06: Operação entre Matrizes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    int v1 = lerValor(scanner, "Digite o valor inicial (<= 20): ", -999999, 20);
                    System.out.println(Arrays.toString(progressaoGeometrica(v1)));
                    break;
                case 2:
                    int v2 = lerValor(scanner, "Digite o valor inicial (1 < v < 100): ", 1, 99);
                    System.out.println(Arrays.toString(sequenciaDecrescente(v2)));
                    break;
                case 3:
                    int v3 = lerValor(scanner, "Digite o tamanho (1 < v <= 1000): ", 1, 1000);
                    System.out.println(Arrays.toString(vetorDinamico(v3)));
                    break;
                case 4:
                    int v4 = lerValor(scanner, "Digite o valor inicial (1 < v < 100): ", 1, 99);
                    int[] vet4 = sequenciaCresenteComSoma(v4);
                    System.out.println(Arrays.toString(vet4));
                    System.out.println("Soma: " + calcularSoma(vet4));
                    break;
                case 5:
                    int v5 = lerValor(scanner, "Digite o tamanho (3 < v <= 50): ", 3, 50);
                    exibirMatriz(matrizIncrementais(v5));
                    break;
                case 6:
                    int v6 = lerValor(scanner, "Digite o tamanho (3 < v <= 50): ", 3, 50);
                    int[][][] mats = operacaoEntreMatrizes(v6);
                    System.out.println("\nMatriz N e Z:");
                    exibirMatriz(mats[0]);
                    System.out.println("\nMatriz Soma:");
                    exibirMatriz(mats[2]);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
   
    /**
     * Metodo auxiliar para ler e validar entrada do usuario
     * @param scanner Scanner para leitura
     * @param mensagem Mensagem a ser exibida
     * @param min Valor minimo (exclusivo)
     * @param max Valor maximo (inclusivo)
     * @return Valor valido lido
     */
    private static int lerValor(Scanner scanner, String mensagem, int min, int max) {
        // TODO: Implementar validacao de entrada
        // Deve repetir a leitura ate que o valor seja valido (min < valor <= max)
        int valor;
        while (true) {
            System.out.print(mensagem);
            valor = scanner.nextInt();
            if (valor > min && valor <= max) {
                return valor;
            }
            System.out.println("Entrada inválida! Tente novamente.");
        }
    }
   
    /**
     * Metodo auxiliar para exibir matriz formatada
     * @param matriz Matriz a ser exibida
     */
    private static void exibirMatriz(int[][] matriz) {
        // TODO: Implementar exibicao da matriz
        // Use System.out.printf("%4d ", matriz[i][j]) para formatacao
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%4d ", matriz[i][j]);
            }
            System.out.println();
        }
    }
   
    /**
     * Exercicio 01: Progressao Geometrica
     * @param valorInicial Valor inicial (deve ser <= 20)
     * @return Vetor de 10 elementos com progressao geometrica (dobro) ou null se invalido
     */
    public static int[] progressaoGeometrica(int valorInicial) {
        // TODO: Implementar progressao geometrica
        // Validar se valorInicial <= 20 (retornar null se invalido)
        // Criar vetor de 10 elementos
        // vetor[0] = valorInicial
        // Para i=1 ate 9: vetor[i] = vetor[i-1] * 2
 
        if(valorInicial <= 20) {
            int[] vetor = new int[10];
            vetor[0] = valorInicial;
           
            for (int i = 1; i < 10; i++) {
                vetor[i] = vetor[i-1] * 2;
            }
            return vetor;
        }
        return null; // Remover esta linha apos implementacao
    }
   
    /**
     * Exercicio 02: Sequencia Decrescente
     * @param valorInicial Valor inicial (deve ser > 1)
     * @return Vetor de 10 elementos com sequencia decrescente ou null se invalido
     */
    public static int[] sequenciaDecrescente(int valorInicial) {
        // TODO: Implementar sequencia decrescente
        // Validar se valorInicial > 1 (retornar null se invalido)
        // Criar vetor de 10 elementos
        // vetor[0] = valorInicial
        // Para i=1 ate 9: vetor[i] = vetor[i-1] - 1
 
        if (valorInicial > 1) {
            int[] vetor = new int[10];
            vetor[0] = valorInicial;
 
            for (int i = 1; i < 10; i++) {
                vetor[i] = vetor[i-1] - 1;
            }
            return vetor;
        }
        return null; // Remover esta linha apos implementacao
    }
   
    /**
     * Exercicio 03: Vetor Dinamico
     * @param tamanho Tamanho do vetor (deve ser <= 1000)
     * @return Vetor com sequencia de 1 ate tamanho ou null se invalido
     */
    public static int[] vetorDinamico(int tamanho) {
        // TODO: Implementar vetor dinamico
        // Validar se tamanho <= 1000 (retornar null se invalido)
        // Criar vetor com tamanho especifico
        // Para i=0 ate tamanho-1: vetor[i] = i + 1
 
        if(tamanho <= 1000) {
            int vetor[] = new int[tamanho];
            vetor[tamanho-1] = tamanho;
 
            for(int i = 0; i < (tamanho - 1); i++) {
                vetor[i] = i + 1;
            }
            return vetor;
        }
        return null; // Remover esta linha apos implementacao
    }
   
    /**
     * Exercicio 04: Sequencia Crescente com Soma
     * @param valorInicial Valor inicial
     * @return Vetor de 10 elementos com sequencia crescente
     */
    public static int[] sequenciaCresenteComSoma(int valorInicial) {
        // TODO: Implementar sequencia crescente
        // Criar vetor de 10 elementos
        // vetor[0] = valorInicial
        // Para i=1 ate 9: vetor[i] = vetor[i-1] + 1
 
        if (valorInicial < 100) {
            int[] vetor = new int[10];
            vetor[0] = valorInicial;
 
            for (int i = 1; i < 10; i++) {
                vetor[i] = vetor[i-1] + 1;
            }
            return vetor;
        }
        return null; // Remover esta linha apos implementacao
    }
   
    /**
     * Calcula a soma de todos os elementos do vetor
     * @param vetor Vetor para calcular a soma
     * @return Soma de todos os elementos
     */
    public static int calcularSoma(int[] vetor) {
        // TODO: Implementar calculo da soma
        // Percorrer o vetor e somar todos os elementos
 
        int soma = vetor[0];
 
        for (int i = 1; i < 10; i++) {
            soma += vetor[i];
        }
 
        return soma; // Remover esta linha apos implementacao
    }
   
    /**
     * Exercicio 05: Matriz com Valores Incrementais
     * @param tamanho Tamanho da matriz quadrada
     * @return Matriz NxN com valores incrementais iniciando em tamanho+1
     */
    public static int[][] matrizIncrementais(int tamanho) {
        // TODO: Implementar matriz com valores incrementais
        // Criar matriz quadrada NxN
        // Contador inicial = tamanho + 1
        // Para cada posicao [i][j]: matriz[i][j] = contador++
 
        int matriz[][] = new int[tamanho][tamanho];
        int contador = tamanho + 1;
 
        for (int i = 0; i < tamanho ;i++) {
            for (int j = 0; j < tamanho; j++ ) {
                matriz[i][j] = contador++;
            }
        }
        return matriz;
    }
   
    /**
     * Exercicio 06: Operacao entre Matrizes
     * @param tamanho Tamanho das matrizes quadradas
     * @return Array com 3 matrizes: [0]=N, [1]=Z, [2]=Soma
     */
    public static int[][][] operacaoEntreMatrizes(int tamanho) {
        // TODO: Implementar operacao entre matrizes
        // Criar 3 matrizes NxN: matrizN, matrizZ, matrizSoma
        // Contador inicial = tamanho + 1
        // Para cada posicao [i][j]:
        //   matrizN[i][j] = contador
        //   matrizZ[i][j] = contador (valores iguais)
        //   matrizSoma[i][j] = matrizN[i][j] + matrizZ[i][j]
        //   contador++
        // Retornar array com as 3 matrizes
 
        if (tamanho > 3 && tamanho <= 50) {
            int[][] matrizN = new int[tamanho][tamanho];
            int[][] matrizZ = new int[tamanho][tamanho];
            int[][] matrizSoma = new int[tamanho][tamanho];
 
            int contador = tamanho + 1;
 
            for (int i = 0; i < tamanho ;i++) {
                for (int j = 0; j < tamanho; j++ ) {
                    matrizN[i][j] = contador;
                    matrizZ[i][j] = contador;
                    matrizSoma[i][j] = matrizN[i][j] + matrizZ[i][j];

                    contador++;
                }
            }

            return new int[][][] { matrizN, matrizZ, matrizSoma };
        }
 
 
        return null; // Remover esta linha apos implementacao
    }
   
    // ========================================
    // METODOS REQUERIDOS PELO AUTOGRADER
    // NAO REMOVER - Necessarios para avaliacao automatica
    // ========================================
   
    /**
     * Metodo ex01 para compatibilidade com autograder
     * @return resultado do exercicio 01
     */
    public static int[] ex01() {
        // TODO: Implementar leitura de entrada e chamar progressaoGeometrica()
        return null; // Remover esta linha apos implementacao
    }
   
    /**
     * Metodo ex02 para compatibilidade com autograder
     * @return resultado do exercicio 02
     */
    public static int[] ex02() {
        // TODO: Implementar leitura de entrada e chamar sequenciaDecrescente()
        return null; // Remover esta linha apos implementacao
    }
   
    /**
     * Metodo ex03 para compatibilidade com autograder
     * @return resultado do exercicio 03
     */
    public static int[] ex03() {
        // TODO: Implementar leitura de entrada e chamar vetorDinamico()
        return null; // Remover esta linha apos implementacao
    }
   
    /**
     * Metodo ex04 para compatibilidade com autograder
     * @return resultado do exercicio 04
     */
    public static int[] ex04() {
        // TODO: Implementar leitura de entrada e chamar sequenciaCresenteComSoma()
        return null; // Remover esta linha apos implementacao
    }
   
    /**
     * Metodo ex05 para compatibilidade com autograder
     * @return resultado do exercicio 05
     */
    public static int[][] ex05() {
        // TODO: Implementar leitura de entrada e chamar matrizIncrementais()
        return null; // Remover esta linha apos implementacao
    }
   
    /**
     * Metodo ex06 para compatibilidade com autograder
     * @return resultado do exercicio 06
     */
    public static int[][][] ex06() {
        // TODO: Implementar leitura de entrada e chamar operacaoEntreMatrizes()
        return null; // Remover esta linha apos implementacao
    }
}
 