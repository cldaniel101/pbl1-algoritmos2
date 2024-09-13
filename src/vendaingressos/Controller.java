package vendaingressos;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Controller {
    private List<Evento> eventos = new ArrayList<>();

    public Usuario cadastrarUsuario(String username, String senha, String nome, String cpf, String email, boolean ativo) {
        return new Usuario(username, senha, nome, cpf, email, ativo);
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
        System.out.println("Evento não encontrado.");
        return null;
    }

    public void adicionarAssentoEvento(String nomeEvento, String assento) {
        Evento evento = procuraEvento(nomeEvento);
        if (evento != null) {
            evento.adicionarAssento(assento);
        } else {
            System.out.println("Evento não encontrado. Assento não adicionado.");
        }
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

    public List<Evento> listarEventosDisponiveis() {
        return eventos;
    }
}
