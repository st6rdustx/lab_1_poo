import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduza quantas pessoas deseja criar: ");
        int numeroPessoas = scanner.nextInt();
        scanner.nextLine();

        Pessoa[] pessoas = new Pessoa[numeroPessoas];

        for(int i = 0; i < numeroPessoas; i++) {
            System.out.println("\nPessoa #" + (i + 1));
            System.out.print("Primeiro Nome: ");
            String primeiroNome = scanner.nextLine();

            System.out.print("Segundo Nome: ");
            String segundoNome = scanner.nextLine();

            System.out.print("Número de Contribuinte: ");
            int numeroContribuinte = scanner.nextInt();

            System.out.print("Salário Bruto: ");
            double salarioBruto = scanner.nextDouble();
            scanner.nextLine();

            Pessoa pessoa = new Pessoa();
            pessoa.definirPrimeiroNome(primeiroNome);
            pessoa.definirSegundoNome(segundoNome);
            pessoa.definirNumeroContribuinte(numeroContribuinte);
            pessoa.definirSalarioBruto(salarioBruto);

            pessoas[i] = pessoa;
        }

        System.out.println("\n========== Dados das Pessoas Introduzidas ==========");
        for (Pessoa p : pessoas) {
            System.out.print("\n");
            System.out.println(p.obterDadosPessoais());
            System.out.print("\n");
            System.out.println("====================================================");
        }
    }
}