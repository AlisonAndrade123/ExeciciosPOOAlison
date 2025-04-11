package exercicio4;

public class Usuario {
    private String email;
    private String senhaCriptografada;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senhaCriptografada = criptografarSenha(senha);
    }

    public String getSenha() {
        return senhaCriptografada;
    }

    public void setSenha(String novaSenha) {
        this.senhaCriptografada = criptografarSenha(novaSenha);
    }

    private String criptografarSenha(String senha) {
        String senhaNova = "";
        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);
            senhaNova += (char) (c + 1);
        }
        return senhaNova;
    }

    public boolean login(String emailInformado, String senhaInformada) {
        String senhaCripto = criptografarSenha(senhaInformada);
        return this.email.equals(emailInformado) && this.senhaCriptografada.equals(senhaCripto);
    }
}

class Teste {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("joao@email.com", "senha123");

        System.out.println("Senha criptografada: " + usuario.getSenha());

        System.out.println("Login correto? " + usuario.login("joao@email.com", "senha123"));

        System.out.println("Login com email errado: " + usuario.login("teste@email.com", "senha123"));

        System.out.println("Login com senha errada: " + usuario.login("joao@email.com", "senha321"));

        usuario.setSenha("nova123");

        System.out.println("Nova senha criptografada: " + usuario.getSenha());
        System.out.println("Login com nova senha: " + usuario.login("joao@email.com", "nova123"));
    }
}

