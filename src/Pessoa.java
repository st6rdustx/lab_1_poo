public class Pessoa {
    String primeiroNome;
    String segundoNome;
    int numeroContribuinte;
    double salarioBruto;

    public void definirPrimeiroNome(String novoPrimeiroNome) {
        primeiroNome = novoPrimeiroNome;
    }

    public void definirSegundoNome(String novoSegundoNome) {
        segundoNome = novoSegundoNome;
    }

    public String obterNome() {
        return primeiroNome + " " + segundoNome;
    }

    public void definirNumeroContribuinte(int novoNumeroContribuinte) {
        numeroContribuinte = novoNumeroContribuinte;
    }

    public void definirSalarioBruto(double novoSalarioBruto) {
        salarioBruto = novoSalarioBruto;
    }

    public String obterDadosPessoais() {
        return "Nome: " + obterNome() + "\n" +
                "NIF: " + numeroContribuinte + "\n" +
                "Salário Bruto: " + salarioBruto + "€\n" +
                "Salário Líquido: " + calcularSalarioLiquido() + "€";
    }

    public double calcularSalarioLiquido() {
        double desconto;

        if (salarioBruto < 1550) {
            desconto = 0;
        } else if (salarioBruto == 1550) {
            desconto = 50;
        } else if (salarioBruto > 1550 && salarioBruto < 2050) {
            desconto = salarioBruto * 0.035;
        } else if (salarioBruto >= 2050 && salarioBruto < 2100) {
            desconto = salarioBruto * 0.038;
        } else if (salarioBruto >= 2100 && salarioBruto < 2150) {
            desconto = salarioBruto * 0.041;
        } else if (salarioBruto >= 2150 && salarioBruto < 2500) {
            desconto = salarioBruto * 0.06;
        } else if (salarioBruto >= 2500 && salarioBruto < 3500) {
            desconto = salarioBruto * 0.08;
        } else if (salarioBruto >= 3500 && salarioBruto < 4200) {
            desconto = salarioBruto * 0.09;
        } else {
            desconto = salarioBruto * 0.10;
        }

        return salarioBruto - desconto;
    }
}
