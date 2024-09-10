package vendaingressos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller {
        private List<Usuario> usuarios = new ArrayList<>();
        private List<Evento> eventos = new ArrayList<>();

        // Cadastrar usuário
        public Usuario cadastrarUsuario(String login, String senha, String nome, String CPF, String email, boolean isAdmin) {
            Usuario usuario;
            if (isAdmin) {
                usuario = new Administrador(login, senha, nome, CPF, email);
            } else {
                usuario = new Comum(login, senha, nome, CPF, email);
            }
            usuarios.add(usuario);
            return usuario;
        }

        // Cadastrar evento, somente por administradores
        public Evento cadastrarEvento(Usuario usuario, String nome, String descricao, Date data) {
            if (usuario instanceof Administrador) {
                Evento evento = new Evento(nome, descricao, data, "disponível");
                ((Administrador) usuario).cadastrarEvento(evento);
                eventos.add(evento);
                return evento;
            } else {
                throw new SecurityException("Somente administradores podem cadastrar eventos.");
            }
        }

        // Adicionar assento (ingresso) a um evento
        public void adicionarAssentoEvento(String nomeEvento, String idAssento) {
            Evento evento = buscarEventoPorNome(nomeEvento);
            if (evento != null) {
                evento.criarIngresso(idAssento, 100.0f); // Valor de exemplo
            }
        }

        // Comprar ingresso
        public Ingresso comprarIngresso(Usuario usuario, String nomeEvento, String idAssento) {
            Evento evento = buscarEventoPorNome(nomeEvento);
            if (evento != null) {
                for (Ingresso ingresso : evento.getIngressos()) {
                    if (ingresso.getId().equals(idAssento) && ingresso.getStatus().equals("disponível")) {
                        if (usuario instanceof Comum) {
                            ((Comum) usuario).comprarIngresso(ingresso);
                        }
                        return ingresso;
                    }
                }
            }
            return null;
        }

        // Cancelar compra de ingresso
        public boolean cancelarCompra(Usuario usuario, Ingresso ingresso) {
            if (usuario instanceof Comum) {
                ((Comum) usuario).cancelarCompraIngresso(ingresso);
                return true;
            }
            return false;
        }

        // Listar eventos disponíveis
        public List<Evento> listarEventosDisponiveis() {
            List<Evento> eventosDisponiveis = new ArrayList<>();
            for (Evento evento : eventos) {
                if (evento.getStatus().equals("disponível")) {
                    eventosDisponiveis.add(evento);
                }
            }
            return eventosDisponiveis;
        }

        // Listar ingressos comprados por um usuário
        public List<Ingresso> listarIngressosComprados(Usuario usuario) {
            if (usuario instanceof Comum) {
                Comum comum = (Comum) usuario;
                return comum.getIngressosComprados();
            }
            return new ArrayList<>();
        }

        // Metodo auxiliar para buscar evento pelo nome
        private Evento buscarEventoPorNome(String nome) {
            for (Evento evento : eventos) {
                if (evento.getNome().equals(nome)) {
                    return evento;
                }
            }
            return null;
        }
}
