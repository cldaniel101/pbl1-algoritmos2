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

/**
 * A classe Ingresso representa um ingresso para um evento, contendo informações sobre o evento,
 * preço, assento e o status de ativação do ingresso.
 */
public class Ingresso {
    private final Evento evento;
    private final double preco;
    private final String assento;
    private boolean status;

    /**
     * Construtor que cria um ingresso com preço padrão (zero).
     *
     * @param evento o evento ao qual o ingresso pertence.
     * @param assento o assento relacionado ao ingresso.
     */
    public Ingresso(Evento evento, String assento) {
        this(evento, 0.0, assento);  // Reuso do construtor completo
    }

    /**
     * Construtor que cria um ingresso com um preço específico.
     *
     * @param evento o evento ao qual o ingresso pertence.
     * @param preco o preço do ingresso.
     * @param assento o assento relacionado ao ingresso.
     */
    public Ingresso(Evento evento, double preco, String assento) {
        this.evento = evento;
        this.preco = preco;
        this.assento = assento;
        this.status = true;  // O ingresso começa ativo
    }

    /**
     * Retorna o evento associado ao ingresso.
     *
     * @return o evento do ingresso.
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     * Retorna o preço do ingresso.
     *
     * @return o preço do ingresso.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Retorna o assento relacionado ao ingresso.
     *
     * @return o assento do ingresso.
     */
    public String getAssento() {
        return assento;
    }

    /**
     * Verifica se o ingresso está ativo.
     *
     * @return true se o ingresso estiver ativo, false caso contrário.
     */
    public boolean isAtivo() {
        return status;
    }

    /**
     * Cancela o ingresso se o evento ainda estiver ativo.
     *
     * @return true se o ingresso foi cancelado com sucesso, false caso contrário.
     */
    public boolean cancelar() {
        if (evento.isAtivo()) {
            this.status = false;
            return true;
        }
        return false;
    }

    /**
     * Reativa o ingresso, alterando seu status para ativo.
     */
    public void reativar() {
        this.status = true;
    }

    @Override
    public int hashCode() {
        final int numeroPrimo = 31;
        int hash = 1;
        hash = numeroPrimo * hash + ((evento == null) ? 0 : evento.hashCode());
        hash = numeroPrimo * hash + Double.hashCode(preco);
        hash = numeroPrimo * hash + ((assento == null) ? 0 : assento.hashCode());
        hash = numeroPrimo * hash + (status ? 1231 : 1237);
        return hash;
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
