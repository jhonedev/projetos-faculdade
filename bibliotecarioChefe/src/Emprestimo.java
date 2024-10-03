import java.util.Date;

public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private Date dataRetirada;
    private Date dataDevolucao;
    private double valorMultaPorDia;

    public Emprestimo(Usuario usuario, Livro livro, Date dataRetirada, Date dataDevolucao, double valorMultaPorDia) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.valorMultaPorDia = valorMultaPorDia;
    }

    public void enviarEmailConfirmacaoEmprestimo() {
        System.out.println("Email de confirmação do empréstimo enviado para " + usuario.getEmail());
    }

    public double calcularMulta() {
        long diasAtraso = (new Date().getTime() - dataDevolucao.getTime()) / (1000 * 60 * 60 * 24);
        return diasAtraso > 0 ? diasAtraso * valorMultaPorDia : 0;
    }

    public void exibirMulta() {
        System.out.println("Multa por atraso: R$ " + calcularMulta());
    }

    @Override
    public String toString() {
        return "Usuário: " + usuario.getNome() +
               "\nLivro: " + livro.getTitulo() +
               "\nData de Retirada: " + dataRetirada +
               "\nData de Devolução: " + dataDevolucao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double getValorMultaPorDia() {
        return valorMultaPorDia;
    }

    public void setValorMultaPorDia(double valorMultaPorDia) {
        this.valorMultaPorDia = valorMultaPorDia;
    }
}
