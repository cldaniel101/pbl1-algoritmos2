package vendaingressos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private String login;
    private String senha;
    private String nome;
    private String CPF;
    private String email;
    private boolean isAdmin;

    private static List<Usuario> usuariosCadastrados = new ArrayList<>();
    private static List<Evento> eventosDisponiveis = new ArrayList<>();

    // Construtor da classe vendaingressos.Usuario
    public Usuario(String login, String senha, String nome, String CPF, String email, boolean isAdmin) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    // Metodo para cadastrar um usuário
    public void cadastrarUsuario() {
        for (Usuario usuario : usuariosCadastrados) {
            if (usuario.login.equals(this.login)) {
                System.out.println("Usuário já cadastrado.");
                return;
            }
        }
        usuariosCadastrados.add(this);
        System.out.println("Usuário cadastrado com sucesso.");
    }

    // Metodo para realizar login
    public boolean fazerLogin(String login, String senha) {
        for (Usuario usuario : usuariosCadastrados) {
            if (usuario.login.equals(login) && usuario.senha.equals(senha)) {
                System.out.println("Login realizado com sucesso.");
                return true;
            }
        }
        System.out.println("Login ou senha incorretos.");
        return false;
    }

    // Metodo para listar eventos disponíveis
    public void listarEventosDisponiveis() {
        if (eventosDisponiveis.isEmpty()) {
            System.out.println("Nenhum evento disponível no momento.");
        } else {
            System.out.println("Eventos disponíveis:");
            for (Evento evento : eventosDisponiveis) {
                System.out.println("- " + evento.getNome() + " | Data: " + evento.getData() + " | Status: " + evento.getStatus());
            }
        }
    }

    // Getters e Setters para os atributos
    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String novaSenha) {
        this.senha = novaSenha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCpf(String novoCpf) {
        this.CPF = novoCpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String novoEmail) {
        this.email = novoEmail;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    // Sobrescrevendo equals e hashCode para comparação entre objetos Usuario
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(login, usuario.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    // Metodo para adicionar um evento à lista de eventos disponíveis
    public static void adicionarEvento(Evento evento) {
        eventosDisponiveis.add(evento);
    }

//    public boolean login(String usuario, String senha) {
//        return false;
//    }
}

