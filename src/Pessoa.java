public class Pessoa {
    private String primeiroNome;
    private String segundoNome;
    private int numeroContribuinte;
    private double salarioBruto;

    public Pessoa() {
    }

    public Pessoa(String primeiroNome, String segundoNome, int numeroContribuinte, double salarioBruto) {
        this.primeiroNome = primeiroNome;
        this.segundoNome = segundoNome;
        this.numeroContribuinte = numeroContribuinte;
        this.salarioBruto = salarioBruto;
    }

    public void definirPrimeiroNome(String novoPrimeiroNome) {
        this.primeiroNome = novoPrimeiroNome;
    }

    public void definirSegundoNome(String novoSegundoNome) {
        this.segundoNome = novoSegundoNome;
    }

    public String obterNome() {
        return primeiroNome + " " + segundoNome;
    }

    public void definirNumeroContribuinte(int novoNumeroContribuinte) {
        this.numeroContribuinte = novoNumeroContribuinte;
    }

    public void definirSalarioBruto(double novoSalarioBruto) {
        this.salarioBruto = novoSalarioBruto;
    }

    public String obterDadosPessoais() {
        return String.format("Nome: %s%nNIF: %d%nSalário Bruto: %.2f€%nSalário Líquido: %.2f€", 
                obterNome(), numeroContribuinte, salarioBruto, calcularSalarioLiquido());
    }

    public double calcularSalarioLiquido() {
        double taxaDesconto = determinarTaxaDesconto(salarioBruto);
        return salarioBruto * (1 - taxaDesconto);
    }
    
    private double determinarTaxaDesconto(double salarioBruto) {
        if (salarioBruto < 1550) {
            return 0;
        } else if (salarioBruto == 1550) {
            return 50 / salarioBruto;
        } else if (salarioBruto > 1550 && salarioBruto < 2050) {
            return 0.035;
        } else if (salarioBruto >= 2050 && salarioBruto < 2100) {
            return 0.038;
        } else if (salarioBruto >= 2100 && salarioBruto < 2150) {
            return 0.041;
        } else if (salarioBruto >= 2150 && salarioBruto < 2500) {
            return 0.06;
        } else if (salarioBruto >= 2500 && salarioBruto < 3500) {
            return 0.08;
        } else if (salarioBruto >= 3500 && salarioBruto < 4200) {
            return 0.09;
        } else {
            return 0.10;
        }
    }
}
