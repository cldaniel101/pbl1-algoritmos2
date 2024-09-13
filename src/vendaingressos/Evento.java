package vendaingressos;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Evento {
    private String nome;
    private String descricao;
    private Date data;
    private List<String> assentos;

    public Evento(String nome, String descricao, Date data) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.assentos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getData() {
        return data;
    }

    public void adicionarAssento(String assento) {
        assentos.add(assento);
    }

    public List<String> getAssentosDisponiveis() {
        return assentos;
    }

    public void removerAssento(String assento) {
        assentos.removeIf(a -> a.equals(assento));
    }

    public boolean isAtivo() {
        return !data.before(new Date());
    }
}
