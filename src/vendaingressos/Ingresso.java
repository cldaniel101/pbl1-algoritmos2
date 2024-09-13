package vendaingressos;

public class Ingresso {
    private Evento evento;
    private double preco;
    private String assento;
    private boolean status;

    // Construtor com preço padrão
    public Ingresso(Evento evento, String assento) {
        this(evento, 0.0, assento);  // Reuso do construtor completo
    }

    // Construtor com preço definido
    public Ingresso(Evento evento, double preco, String assento) {
        this.evento = evento;
        this.preco = preco;
        this.assento = assento;
        this.status = true;  // Ingresso começa ativo
    }

    public Evento getEvento() {
        return evento;
    }

    public double getPreco() {
        return preco;
    }

    public String getAssento() {
        return assento;
    }

    public boolean isAtivo() {
        return status;
    }

    public boolean cancelar() {
        if (evento.isAtivo()) {
            this.status = false;
            return true;
        }
        return false;
    }

    public boolean reativar() {
        this.status = true;
        return status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((evento == null) ? 0 : evento.hashCode());
        long temp = Double.doubleToLongBits(preco);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((assento == null) ? 0 : assento.hashCode());
        result = prime * result + (status ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Ingresso other = (Ingresso) obj;
        if (evento == null) {
            if (other.evento != null)
                return false;
        } else if (!evento.equals(other.evento))
            return false;
        if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
            return false;
        if (assento == null) {
            if (other.assento != null)
                return false;
        } else if (!assento.equals(other.assento))
            return false;
        return status == other.status;
    }
}
