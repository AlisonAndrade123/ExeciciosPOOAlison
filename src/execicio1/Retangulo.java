package execicio1;

public class Retangulo {

    private double largura;
    private double altura;

    public Retangulo(double largura, double altura){
        this.largura = largura;
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double calcularArea(){
        return largura * altura;
    }

    public double calcularPerimetro(){
        return  2 * (largura + altura);
    }

    public boolean cabe(Retangulo outroRetangulo){
        return this.largura >= outroRetangulo.getLargura() &&
                this.altura >= outroRetangulo.getAltura();
    }

}


class Teste {
    public static void main(String[] args) {
        Retangulo retangulo1 = new Retangulo(10, 5); // 4, 3
        Retangulo retangulo2 = new Retangulo(4, 3); // 10, 5


        if (retangulo1.cabe(retangulo2)){
            System.out.println("O retangulo2 cabe dentro do retangulo1.");
        } else {
            System.out.println("O retangulo2 não cabe dentro do retangulo1.");
        }


        System.out.println("");


        if (retangulo2.cabe(retangulo1)){
            System.out.println("O retangulo1 cabe dentro do retangulo2.");
        } else {
            System.out.println("O retangulo1 não cabe dentro do retangulo2.");
        }


        System.out.println("");


        System.out.println("Aréa do retângulo 1: " + retangulo1.calcularArea());
        System.out.println("Perímetro do retângulo 1: "  + retangulo1.calcularPerimetro());


        System.out.println("");


        System.out.println("Aréa do retângulo 2: " + retangulo2.calcularArea());
        System.out.println("Perímetro do retângulo 2: "  + retangulo2.calcularPerimetro());
    }
}
