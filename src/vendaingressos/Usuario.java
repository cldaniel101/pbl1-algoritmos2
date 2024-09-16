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

public class Usuario {
    private String usuario;
    private String senha;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private boolean isAdmin;
    private List<Ingresso> ingressos;

    public Usuario(String usuario, String senha, String nomeCompleto, String cpf, String email, boolean isAdmin) {
        this.usuario = usuario;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
        this.isAdmin = isAdmin;
        this.ingressos = new ArrayList<>();
    }

    public String getLogin() {
        return usuario;
    }

    public String getNome() {
        return nomeCompleto;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setLogin(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean login(String usuario, String senha) {
        return this.usuario.equals(usuario) && this.senha.equals(senha);
    }

    public void adicionarIngresso(Ingresso ingresso) {
        ingressos.add(ingresso);
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

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
