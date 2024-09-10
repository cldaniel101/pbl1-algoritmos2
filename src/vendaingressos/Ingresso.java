package vendaingressos;

import java.util.Objects;

public class Ingresso {
    private String id;
    private Evento evento;
    private float preco;
    private double valor;
    private String assento;
    private String status;  // "disponível" ou "vendido"
    private boolean ativo;

    // Construtor
    public Ingresso(Evento evento, double valor, String assento) {
        this.id = generateId();
        this.evento = evento;
        this.valor = valor;
        this.assento = assento;
        this.status = "disponível"; // O ingresso é criado como disponível
        this.ativo = true; // O ingresso é ativo ao ser criado
    }

    // Metodo para gerar um ID único (pode ser aprimorado)
    private String generateId() {
        return "ING-" + System.currentTimeMillis();
    }

    // Metodo para cancelar o ingresso
    public boolean cancelar() {
        if (evento.isAtivo()) {  // Verifica se o evento ainda está ativo
            this.ativo = false;
            this.status = "cancelado";
            return true;
        }
        return false;
    }

    // Metodo para reativar o ingresso
    public void reativar() {
        if (evento.isAtivo()) {  // Só pode reativar se o evento ainda está ativo
            this.ativo = true;
            this.status = "disponível";
        }
    }

    // Metodos para verificar se o ingresso está ativo ou obter o ID
    public boolean isAtivo() {
        return ativo;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    // Metodo setStatus
    public void setStatus(String status) {
        this.status = status;
    }

    // Getters e Setters
    public Evento getEvento() {
        return evento;
    }

    public float getPreco() {
        return preco;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    // Sobrescrita de equals e hashCode para verificar duplicação de ingressos
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ingresso ingresso = (Ingresso) obj;
        return assento.equals(ingresso.assento) && evento.equals(ingresso.evento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assento, evento);
    }
}

