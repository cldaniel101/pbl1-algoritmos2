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

public class Evento {
    private final String nome;
    private final Date data;
    private final String descricao;
    private final List<String> assentos;

    public Evento(String nome, String descricao, Date data) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.assentos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getData() {
        return data;
    }

    public void adicionarAssento(String assento) {
        assentos.add(assento);
    }

    public List<String> getAssentosDisponiveis() {
        return assentos;
    }

    public void removerAssento(String assento) {
        assentos.removeIf(a -> a.equals(assento));
    }

    public boolean isAtivo() {
        return !data.before(new Date());
    }
}
