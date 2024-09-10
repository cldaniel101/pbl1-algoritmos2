package vendaingressos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evento {
    private String nome;
    private String descricao;
    private Date data;
    private boolean ativo;
    private List<Ingresso> ingressos = new ArrayList<>();
    private String status;
    private List<String> assentosDisponiveis = new ArrayList<>();

    public Evento(String nome, String descricao, Date data, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.status = status;
    }

    // Sobrecarga do construtor para compatibilidade com o teste
    public Evento(String nome, String descricao, Date data) {
        this(nome, descricao, data, "ativo");
    }

    // Metodo para adicionar assentos
    public void adicionarAssento(String assento) {
        assentosDisponiveis.add(assento);
    }

    // Metodo para remover assentos
    public void removerAssento(String assento) {
        assentosDisponiveis.remove(assento);
    }

    // Metodo para obter assentos disponíveis
    public List<String> getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    // Metodo para verificar se o evento está ativo
    public boolean isAtivo() {
        Date hoje = new Date();
        return !hoje.after(data);
    }

    // Getters e Setters
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public Ingresso criarIngresso(String assento, float preco) {
        if (assentosDisponiveis.contains(assento)) {
            Ingresso ingresso = new Ingresso(this, preco, assento);
            ingressos.add(ingresso); // Adiciona o ingresso à lista de ingressos do evento
            removerAssento(assento); // Remove o assento da lista de assentos disponíveis
            return ingresso;
        } else {
            System.out.println("Assento não disponível.");
            return null;
        }
    }
}

