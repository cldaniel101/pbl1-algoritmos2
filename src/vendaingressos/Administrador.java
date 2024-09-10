package vendaingressos;

import java.util.ArrayList;
import java.util.List;

class Administrador extends Usuario {
    private static List<Evento> eventosCadastrados = new ArrayList<>();

    public Administrador(String login, String senha, String nome, String CPF, String email) {
        super(login, senha, nome, CPF, email, true); // `true` porque é um administrador
    }

    // Metodo para cadastrar um evento
    public void cadastrarEvento(Evento evento) {
        eventosCadastrados.add(evento);
        adicionarEvento(evento); // Adiciona o evento à lista de eventos disponíveis para todos os usuários
        System.out.println("Evento cadastrado com sucesso.");
    }

    // Metodo para modificar um evento
    public void modificarEvento(Evento evento, String novoNome, String novaDescricao, boolean ativo) {
        if (eventosCadastrados.contains(evento)) {
            evento.setNome(novoNome);
            evento.setDescricao(novaDescricao);
            evento.setAtivo(ativo); // Usando o Metodo setAtivo para ativar/desativar o evento
            System.out.println("Evento modificado com sucesso.");
        } else {
            System.out.println("Evento não encontrado.");
        }
    }

    // Metodo para excluir um evento
    public void excluirEvento(Evento evento) {
        if (eventosCadastrados.contains(evento)) {
            eventosCadastrados.remove(evento);
            System.out.println("Evento excluído com sucesso.");
        } else {
            System.out.println("Evento não encontrado.");
        }
    }

    // Metodo estático para listar os eventos cadastrados (opcional, para verificação)
    public static void listarEventosCadastrados() {
        if (eventosCadastrados.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
        } else {
            System.out.println("Eventos cadastrados:");
            for (Evento evento : eventosCadastrados) {
                System.out.println("- " + evento.getNome() + " | Ativo: " + evento.isAtivo());
            }
        }
    }
}
