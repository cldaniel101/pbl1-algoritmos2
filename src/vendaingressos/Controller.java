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
 * A classe Controller é responsável por gerenciar os eventos, usuários e suas interações
 * dentro do sistema de venda de ingressos.
 */
public class Controller {
    private final List<Evento> eventos = new ArrayList<>();

    /**
     * Cadastra um novo usuário no sistema.
     *
     * @param usuario o nome de login do usuário.
     * @param senha a senha do usuário.
     * @param nome o nome completo do usuário.
     * @param cpf o CPF do usuário.
     * @param email o endereço de e-mail do usuário.
     * @param ativo indica se o usuário está ativo.
     * @return o objeto Usuario recém-cadastrado.
     */
    public Usuario cadastrarUsuario(String usuario, String senha, String nome, String cpf, String email, boolean ativo) {
        return new Usuario(usuario, senha, nome, cpf, email, ativo);
    }

    /**
     * Cadastra um novo evento no sistema, verificando se o usuário é um administrador.
     *
     * @param admin o usuário que está tentando cadastrar o evento.
     * @param nome o nome do evento.
     * @param descricao a descrição do evento.
     * @param data a data do evento.
     * @return o objeto Evento recém-cadastrado.
     * @throws SecurityException se o usuário não for um administrador.
     */
    public Evento cadastrarEvento(Usuario admin, String nome, String descricao, Date data) throws SecurityException {
        if (admin.isAdmin()) {
            Evento evento = new Evento(nome, descricao, data);
            eventos.add(evento);
            return evento;
        } else {
            throw new SecurityException("Somente administradores podem cadastrar eventos.");
        }
    }

    /**
     * Procura um evento pelo nome no sistema.
     *
     * @param nomeEvento o nome do evento a ser procurado.
     * @return o objeto Evento encontrado ou null se não for encontrado.
     */
    public Evento procuraEvento(String nomeEvento) {
        for (Evento evento : eventos) {
            if (evento.getNome().equalsIgnoreCase(nomeEvento)) {
                return evento;
            }
        }
        System.out.println("Este evento não foi encontrado.");
        return null;
    }

    /**
     * Adiciona um assento a um evento existente no sistema.
     *
     * @param nomeEvento o nome do evento ao qual o assento será adicionado.
     * @param assento o assento a ser adicionado.
     */
    public void adicionarAssentoEvento(String nomeEvento, String assento) {
        Evento evento = procuraEvento(nomeEvento);
        if (evento != null) {
            evento.adicionarAssento(assento);
        } else {
            System.out.println("Este evento não foi encontrado. Assento não adicionado.");
        }
    }

    /**
     * Retorna uma lista de eventos disponíveis no sistema.
     *
     * @return a lista de eventos.
     */
    public List<Evento> listarEventosDisponiveis() {
        return eventos;
    }

    /**
     * Realiza a compra de um ingresso para um determinado evento e assento.
     *
     * @param usuario o usuário que está comprando o ingresso.
     * @param nomeEvento o nome do evento.
     * @param assento o assento a ser comprado.
     * @return o objeto Ingresso comprado ou null se o evento não for encontrado.
     */
    public Ingresso comprarIngresso(Usuario usuario, String nomeEvento, String assento) {
        Evento evento = procuraEvento(nomeEvento);
        if (evento != null) {
            Ingresso ingresso = new Ingresso(evento, assento);
            usuario.adicionarIngresso(ingresso);
            return ingresso;
        } else {
            System.out.println("Evento não encontrado. Compra não realizada.");
            return null;
        }
    }

    /**
     * Cancela a compra de um ingresso de um usuário.
     *
     * @param usuario o usuário que deseja cancelar a compra.
     * @param ingresso o ingresso a ser cancelado.
     * @return true se a compra foi cancelada com sucesso, false caso contrário.
     */
    public boolean cancelarCompra(Usuario usuario, Ingresso ingresso) {
        if (usuario.removeIngresso(ingresso)) {
            ingresso.cancelar();
            return true;
        }
        return false;
    }

    /**
     * Lista todos os ingressos comprados por um determinado usuário.
     *
     * @param usuario o usuário cujos ingressos serão listados.
     * @return a lista de ingressos comprados.
     */
    public List<Ingresso> listarIngressosComprados(Usuario usuario) {
        return usuario.getIngressos();
    }
}
