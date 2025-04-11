package execicio2;

public class ContaBancaria {
    double saldo;
    double chequeEspecial;

    public ContaBancaria(double saldo, double chequeEspecial) {
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
    }

    public void depositar(double valor) throws Exception {
        if (valor <= 0) {
            throw new Exception("Valor inválido");
        }
        saldo = saldo + valor;
    }

    public void sacar(double valor) throws Exception {
        if (valor <= 0) {
            throw new Exception("Valor inválido");
        }

        if (valor <= saldo) {
            saldo = saldo - valor;
        } else {
            double valorFaltando = valor - saldo;
            if (valorFaltando <= chequeEspecial) {
                saldo = 0;
                chequeEspecial = chequeEspecial - valorFaltando;
            } else {
                throw new Exception("Limite do cheque especial atingido");
            }
        }
    }

    public double verificarSaldo() {
        return saldo;
    }
}

class Teste {
    public static void main(String[] args) {
        try {
            ContaBancaria conta = new ContaBancaria(100, 200);

            //conta.depositar(-50); Isso deve dar valor inválido

            System.out.println("Saldo: " + conta.verificarSaldo());

            conta.depositar(50);
            System.out.println("Depois do depósito: " + conta.verificarSaldo());

            conta.sacar(120);
            System.out.println("Depois do saque de 120: " + conta.verificarSaldo());

            conta.sacar(150);
            System.out.println("Depois do saque de 150 (com cheque especial): " + conta.verificarSaldo());

            conta.sacar(200); // Isso deve dar erro

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
