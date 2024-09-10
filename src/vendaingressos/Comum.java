package vendaingressos;

import java.util.ArrayList;
import java.util.List;

class Comum extends Usuario {
    private List<Ingresso> ingressosComprados = new ArrayList<>();

    public Comum(String login, String senha, String nome, String CPF, String email) {
        super(login, senha, nome, CPF, email, false); // `false` porque é um usuário comum, não administrador
    }

    // Metodo para comprar ingresso
    public void comprarIngresso(Ingresso ingresso) {
        if (ingresso.isAtivo()) {
            ingressosComprados.add(ingresso);
            ingresso.cancelar(); // Considerando que a compra torna o ingresso inativo
            System.out.println("Ingresso comprado com sucesso.");
        } else {
            System.out.println("Ingresso indisponível.");
        }
    }

    // Metodo para listar ingressos comprados
    public void listarIngressosComprados() {
        if (ingressosComprados.isEmpty()) {
            System.out.println("Você ainda não comprou ingressos.");
        } else {
            System.out.println("Ingressos comprados:");
            for (Ingresso ingresso : ingressosComprados) {
                System.out.println("- Assento: " + ingresso.getAssento() + " | Valor: " + ingresso.getPreco() + " | Ativo: " + ingresso.isAtivo());
            }
        }
    }

    // Metodo para cancelar a compra de um ingresso
    public void cancelarCompraIngresso(Ingresso ingresso) {
        if (ingressosComprados.contains(ingresso)) {
            ingressosComprados.remove(ingresso);
            ingresso.reativar(); // Reativando o ingresso
            System.out.println("Compra cancelada com sucesso.");
        } else {
            System.out.println("Ingresso não encontrado entre os comprados.");
        }
    }

    // Getter para ingressos comprados
    public List<Ingresso> getIngressosComprados() {
        return ingressosComprados;
    }
}

