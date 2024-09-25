/*******************************
 Autor: Cláudio Daniel Figueredo Peruna
 Componente Curricular: EXA863 - MI - PROGRAMAÇÃO
 Concluído em: 15/09/2024
 Declaro que este código foi elaborado por mim de forma individual e não contêm nenhum
 trecho de código de outro colega ou de outro autor, tais como provindos de livros e
 apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
 de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
 do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
 ********************************/

package vendaingressos;

import java.util.List;
import java.util.ArrayList;

/**
 * Classe Usuario representa um usuário no sistema de venda de ingressos.
 * Cada usuário pode ter um perfil administrativo e possuir uma lista de ingressos.
 */
public class Usuario {
    private String usuario;
    private String senha;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private boolean isAdmin;
    private List<Ingresso> ingressos;

    /**
     * Construtor para a classe Usuario.
     *
     * @param usuario login do usuário.
     * @param senha senha do usuário.
     * @param nomeCompleto nome completo do usuário.
     * @param cpf CPF do usuário.
     * @param email e-mail do usuário.
     * @param isAdmin se o usuário tem perfil administrativo.
     */
    public Usuario(String usuario, String senha, String nomeCompleto, String cpf, String email, boolean isAdmin) {
        this.usuario = usuario;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
        this.isAdmin = isAdmin;
        this.ingressos = new ArrayList<>();
    }

    /**
     * Retorna o login do usuário.
     *
     * @return login do usuário.
     */
    public String getLogin() {
        return usuario;
    }

    /**
     * Retorna o nome completo do usuário.
     *
     * @return nome completo do usuário.
     */
    public String getNome() {
        return nomeCompleto;
    }

    /**
     * Retorna a senha do usuário.
     *
     * @return senha do usuário.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Retorna o CPF do usuário.
     *
     * @return CPF do usuário.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Retorna o e-mail do usuário.
     *
     * @return e-mail do usuário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Verifica se o usuário possui perfil administrativo.
     *
     * @return true se o usuário for administrador, false caso contrário.
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Define o login do usuário.
     *
     * @param usuario o novo login.
     */
    public void setLogin(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Define a senha do usuário.
     *
     * @param senha a nova senha.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Define o nome completo do usuário.
     *
     * @param nomeCompleto o novo nome completo.
     */
    public void setNome(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    /**
     * Define o CPF do usuário.
     *
     * @param cpf o novo CPF.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Define o e-mail do usuário.
     *
     * @param email o novo e-mail.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Define se o usuário tem perfil administrativo.
     *
     * @param isAdmin true se o usuário for administrador.
     */
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * Realiza o login do usuário verificando as credenciais.
     *
     * @param usuario login fornecido.
     * @param senha senha fornecida.
     * @return true se as credenciais estiverem corretas, false caso contrário.
     */
    public boolean login(String usuario, String senha) {
        return this.usuario.equals(usuario) && this.senha.equals(senha);
    }

    /**
     * Adiciona um ingresso à lista de ingressos do usuário.
     *
     * @param ingresso o ingresso a ser adicionado.
     */
    public void adicionarIngresso(Ingresso ingresso) {
        ingressos.add(ingresso);
    }

    /**
     * Retorna a lista de ingressos comprados pelo usuário.
     *
     * @return lista de ingressos.
     */
    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    /**
     * Remove um ingresso da lista de ingressos, se ele for cancelado.
     *
     * @param ingresso o ingresso a ser removido.
     * @return true se o ingresso for removido, false caso contrário.
     */
    public boolean removeIngresso(Ingresso ingresso) {
        if (ingresso.cancelar()) {
            ingressos.remove(ingresso);
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int numeroPrimo = 31;
        int hash = 1;
        hash = numeroPrimo * hash + ((cpf == null) ? 0 : cpf.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (cpf == null) {
            return other.cpf == null;
        } else {
            return cpf.equals(other.cpf);
        }
    }
}
