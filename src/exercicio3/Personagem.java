package exercicio3;

public class Personagem {
    private String nome;
    private int saude;
    private int experiencia;

    public Personagem(String nome) {
        this.nome = nome;
        this.saude = 100;
        this.experiencia = 0;
    }

    public void sofrerDano() {
        int dano = 10 - (experiencia / 100);
        if (dano < 1) {
            dano = 1;
        }

        saude = saude - dano;
        if (saude < 0) {
            saude = 0;
        }
    }

    public void recuperarSaude(int valor) {
        saude = saude + valor;
        if (saude > 100) {
            saude = 100;
        }
    }

    public void ganharExperiencia() {
        if (experiencia < 1000) {
            experiencia = experiencia + 100;
        }
        if (experiencia > 1000) {
            experiencia = 1000;
        }
    }

    public int getSaude() {
        return saude;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public String getNome() {
        return nome;
    }
}


class Teste {
    public static void main(String[] args) {
        Personagem p = new Personagem("Herói");

        p.sofrerDano();
        System.out.println("Saúde: " + p.getSaude());

        p.ganharExperiencia();
        p.sofrerDano();
        System.out.println("Saúde: " + p.getSaude());

        p.recuperarSaude(10);
        System.out.println("Saúde: " + p.getSaude());

        p.ganharExperiencia();
        p.ganharExperiencia();
        p.ganharExperiencia();
        System.out.println("Experiência: " + p.getExperiencia());

        p.sofrerDano();
        System.out.println("Saúde: " + p.getSaude());
    }
}
