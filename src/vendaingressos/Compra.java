package vendaingressos;

import java.util.Date;

class Compra {
    private Usuario usuario;
    private Ingresso ingresso;
    private Date data;

    public Compra(Usuario usuario, Ingresso ingresso) {
        this.usuario = usuario;
        this.ingresso = ingresso;
        this.data = new Date(); // A data da compra é definida como a data atual
    }

    // Metodo para realizar a compra
    public void realizarCompra() {
        if (ingresso.getStatus().equals("disponível")) {
            ingresso.setStatus("vendido");
            System.out.println("vendaingressos.Compra realizada com sucesso pelo usuário: " + usuario.getNome());
            System.out.println("vendaingressos.Ingresso ID: " + ingresso.getId() + " | Valor: " + ingresso.getValor());
        } else {
            System.out.println("vendaingressos.Ingresso não disponível para compra.");
        }
    }

    // Getters para os atributos
    public Usuario getUsuario() {
        return usuario;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public Date getData() {
        return data;
    }
}
