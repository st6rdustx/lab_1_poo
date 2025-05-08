import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numeroPessoas = obterNumeroPessoas(scanner);

            List<Pessoa> pessoas = criarPessoas(scanner, numeroPessoas);
            exibirDadosPessoas(pessoas);
        } catch (Exception e) {
            System.err.println("Ocorreu um erro durante a execução: " + e.getMessage());
        }
    }

    private static int obterNumeroPessoas(Scanner scanner) {
        int numeroPessoas = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Introduza quantas pessoas deseja criar: ");
                numeroPessoas = scanner.nextInt();
                
                if (numeroPessoas <= 0) {
                    System.out.println("Por favor, introduza um número positivo.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduza um número válido.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        
        return numeroPessoas;
    }

    private static List<Pessoa> criarPessoas(Scanner scanner, int numeroPessoas) {
        List<Pessoa> pessoas = new ArrayList<>(numeroPessoas);

        for (int i = 0; i < numeroPessoas; i++) {
            System.out.println("\nPessoa #" + (i + 1));
            
            System.out.print("Primeiro Nome: ");
            String primeiroNome = scanner.nextLine();

            System.out.print("Segundo Nome: ");
            String segundoNome = scanner.nextLine();

            int numeroContribuinte = obterNumeroContribuinte(scanner);
            double salarioBruto = obterSalarioBruto(scanner);

            Pessoa pessoa = new Pessoa(primeiroNome, segundoNome, numeroContribuinte, salarioBruto);
            pessoas.add(pessoa);
        }

        return pessoas;
    }

    private static int obterNumeroContribuinte(Scanner scanner) {
        int numeroContribuinte = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Número de Contribuinte: ");
                numeroContribuinte = scanner.nextInt();
                
                if (numeroContribuinte <= 0) {
                    System.out.println("O número de contribuinte deve ser positivo.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduza um número válido.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        
        return numeroContribuinte;
    }

    private static double obterSalarioBruto(Scanner scanner) {
        double salarioBruto = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Salário Bruto: ");
                salarioBruto = scanner.nextDouble();
                
                if (salarioBruto < 0) {
                    System.out.println("O salário não pode ser negativo.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduza um valor válido.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        
        return salarioBruto;
    }

    private static void exibirDadosPessoas(List<Pessoa> pessoas) {
        System.out.println("\n========== Dados das Pessoas Introduzidas ==========");
        
        for (Pessoa pessoa : pessoas) {
            System.out.println("\n" + pessoa.obterDadosPessoais());
            System.out.println("\n====================================================");
        }
    }
}