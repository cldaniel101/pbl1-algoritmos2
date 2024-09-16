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

public class Controller {
    private final List<Evento> eventos = new ArrayList<>();

    public Usuario cadastrarUsuario(String usuario, String senha, String nome, String cpf, String email, boolean ativo) {
        return new Usuario(usuario, senha, nome, cpf, email, ativo);
    }

    public Evento cadastrarEvento(Usuario admin, String nome, String descricao, Date data) throws SecurityException {
        if (admin.isAdmin()) {
            Evento evento = new Evento(nome, descricao, data);
            eventos.add(evento);
            return evento;
        } else {
            throw new SecurityException("Somente administradores podem cadastrar eventos.");
        }
    }

    public Evento procuraEvento(String nomeEvento) {
        for (Evento evento : eventos) {
            if (evento.getNome().equalsIgnoreCase(nomeEvento)) {
                return evento;
            }
        }
        System.out.println("Este evento não foi encontrado.");
        return null;
    }

    public void adicionarAssentoEvento(String nomeEvento, String assento) {
        Evento evento = procuraEvento(nomeEvento);
        if (evento != null) {
            evento.adicionarAssento(assento);
        } else {
            System.out.println("Este evento não foi encontrado. Assento não adicionado.");
        }
    }

    public List<Evento> listarEventosDisponiveis() {
        return eventos;
    }

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

    public boolean cancelarCompra(Usuario usuario, Ingresso ingresso) {
        if (usuario.removeIngresso(ingresso)) {
            ingresso.cancelar();
            return true;
        }
        return false;
    }

    public List<Ingresso> listarIngressosComprados(Usuario usuario) {
        return usuario.getIngressos();
    }
}