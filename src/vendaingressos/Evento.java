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

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * A classe Evento representa um evento dentro do sistema de venda de ingressos, contendo informações
 * sobre nome, descrição, data e assentos disponíveis.
 */
public class Evento {
    private final String nome;
    private final Date data;
    private final String descricao;
    private final List<String> assentos;

    /**
     * Construtor para criar um novo evento.
     *
     * @param nome o nome do evento.
     * @param descricao a descrição do evento.
     * @param data a data do evento.
     */
    public Evento(String nome, String descricao, Date data) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.assentos = new ArrayList<>();
    }

    /**
     * Retorna o nome do evento.
     *
     * @return o nome do evento.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a descrição do evento.
     *
     * @return a descrição do evento.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Retorna a data do evento.
     *
     * @return a data do evento.
     */
    public Date getData() {
        return data;
    }

    /**
     * Adiciona um assento ao evento.
     *
     * @param assento o assento a ser adicionado.
     */
    public void adicionarAssento(String assento) {
        assentos.add(assento);
    }

    /**
     * Retorna a lista de assentos disponíveis para o evento.
     *
     * @return a lista de assentos disponíveis.
     */
    public List<String> getAssentosDisponiveis() {
        return assentos;
    }

    /**
     * Remove um assento específico do evento.
     *
     * @param assento o assento a ser removido.
     */
    public void removerAssento(String assento) {
        assentos.removeIf(a -> a.equals(assento));
    }

    /**
     * Verifica se o evento ainda está ativo, baseado na data atual.
     *
     * @return true se o evento estiver ativo (ainda não ocorreu), false caso contrário.
     */
    public boolean isAtivo() {
        return !data.before(new Date());
    }
}
