package sistema;
import java.util.*;

public class Usuario {
    private String nome;
    private String senha;
    private String email;
    protected boolean isAdmin;
    private List<Emprestimo> historicoEmprestimos;
    private List<Livro> historicoReservas;
    private List<Double> historicoMultas;
    private boolean isSuspenso;
    private Date dataTerminoSuspensao;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.isAdmin = false;
        this.historicoEmprestimos = new ArrayList<>();
        this.historicoReservas = new ArrayList<>();
        this.historicoMultas = new ArrayList<>();
    }

    public void setSuspensao(int dias) {
        this.isSuspenso = true;
        // Calcula a data de término da suspensão
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, dias);
        this.dataTerminoSuspensao = calendar.getTime();
        System.out.println("Usuário " + nome + " foi suspenso até " + dataTerminoSuspensao);
    }

    public boolean isSuspenso() {
        return isSuspenso;
    }

    public Date getDataTerminoSuspensao() {
        return dataTerminoSuspensao;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean validarInformacoesUsuario(String nome, String senha, String email) {
        return nome != null && !nome.isEmpty() &&
               senha != null && !senha.isEmpty() &&
               email != null && !email.isEmpty();
    }

    public static Usuario criarContaUsuario(String nome, String email, String senha) {
        if (nome != null && !nome.isEmpty() && 
            senha != null && !senha.isEmpty() && 
            email != null && !email.isEmpty()) {
            return new Usuario(nome, email, senha);
        }
        return null;
    }

    public void enviarEmailConfirmacaoCadastro() {
        System.out.println("Email de confirmação enviado para " + this.email);
    }

    public boolean login(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

    public void logout() {
        System.out.println("Logout efetuado com sucesso!");
    }

    public void pesquisarLivroTitulo(String titulo, Biblioteca biblioteca) {
        List<Livro> livrosPorTitulo = new ArrayList<>();
        for (Livro livro : biblioteca.getCatalogoLivros()) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livrosPorTitulo.add(livro);
            }
        }
        exibirInformacoesLivros(livrosPorTitulo);
    }

    public void pesquisarLivroAutor(String autor, Biblioteca biblioteca) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        for (Livro livro : biblioteca.getCatalogoLivros()) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                livrosPorAutor.add(livro);
            }
        }
        exibirInformacoesLivros(livrosPorAutor);
    }

    public void pesquisarLivroGenero(String genero, Biblioteca biblioteca) {
        List<Livro> livrosPorGenero = new ArrayList<>();
        for (Livro livro : biblioteca.getCatalogoLivros()) {
            if (livro.getGenero().equalsIgnoreCase(genero)) {
                livrosPorGenero.add(livro);
            }
        }
        exibirInformacoesLivros(livrosPorGenero);
    }

    public void pesquisarLivroIsbn(String isbn, Biblioteca biblioteca) {
        for (Livro livro : biblioteca.getCatalogoLivros()) {
            if (livro.getIsbn().equals(isbn)) {
                livro.exibirInformacoesLivro();
                return;
            }
        }
        System.out.println("Livro com ISBN " + isbn + " não encontrado.");
    }

    private void exibirInformacoesLivros(List<Livro> livros) {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
            return;
        }
        for (Livro livro : livros) {
            livro.exibirInformacoesLivro();
            System.out.println("======================================================================================================");
        }
    }

    public void visualizarDetalhesDoLivro(Livro livro) {
        if (livro != null) {
            System.out.println("Exibindo detalhes do livro: " + livro.getTitulo());
            livro.exibirInformacoesLivro();
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public void fazerEmprestimoLivro(Livro livro, Date dataRetirada) {
        if (livro.isDisponibilidade()) {
            Date dataDevolucao = calcularDataDevolucao(dataRetirada);
            Emprestimo novoEmprestimo = new Emprestimo(this, livro, dataRetirada, dataDevolucao, 1.50);
            historicoEmprestimos.add(novoEmprestimo);
            livro.setDisponibilidade(false);
            System.out.println("Livro reservado com sucesso!");
            novoEmprestimo.enviarEmailConfirmacaoEmprestimo();
        } else {
            System.out.println("Desculpe, o livro " + livro.getTitulo() + " não está disponível para reserva.");
        }
    }

    private Date calcularDataDevolucao(Date dataRetirada) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataRetirada);
        calendar.add(Calendar.DAY_OF_MONTH, 14); // Período padrão de 14 dias
        return calendar.getTime();
    }

    public void renovarEmprestimoLivro(Livro livro) {
        // Verifica se o livro está emprestado a outro usuário
        boolean livroEmprestado = false;
        for (Emprestimo emprestimo : historicoEmprestimos) {
            if (emprestimo.getLivro().equals(livro)) {
                livroEmprestado = true;
                // Adiciona 14 dias à data de devolução do empréstimo
                Calendar novaDataDevolucao = Calendar.getInstance();
                novaDataDevolucao.setTime(emprestimo.getDataDevolucao());
                novaDataDevolucao.add(Calendar.DAY_OF_MONTH, 14); // Adiciona 14 dias
                emprestimo.setDataDevolucao(novaDataDevolucao.getTime());
                System.out.println("Empréstimo do livro " + livro.getTitulo() + " renovado até: " + novaDataDevolucao.getTime());
                return;
            }
        }
        if (!livroEmprestado) {
            System.out.println("Empréstimo do livro " + livro.getTitulo() + " não encontrado no histórico.");
        }
    }

    public void finalizarEmprestimo(Livro livro) {
        boolean emprestimoEncontrado = false;
        Iterator<Emprestimo> iterator = historicoEmprestimos.iterator();
        while (iterator.hasNext()) {
            Emprestimo emprestimo = iterator.next();
            if (emprestimo.getLivro().equals(livro)) {
                // Remover o empréstimo do histórico
                iterator.remove();
                // Atualizar a disponibilidade do livro
                livro.setDisponibilidade(true);
                System.out.println("Empréstimo do livro '" + livro.getTitulo() + "' finalizado com sucesso.");

                // Calcular e exibir a multa
                double multa = emprestimo.calcularMulta();
                if (multa > 0) {
                    System.out.println("Multa por atraso: R$ " + multa);
                    historicoMultas.add(multa);
                } else {
                    System.out.println("Sem multa para o livro '" + livro.getTitulo() + "'.");
                }

                emprestimoEncontrado = true;
                break;
            }
        }
        if (!emprestimoEncontrado) {
            System.out.println("O livro '" + livro.getTitulo() + "' não está emprestado por este usuário.");
        }
    }
    
    public void visualizarCatalogoLivros(Biblioteca biblioteca) {
        biblioteca.visualizarCatalogoLivros();
    }

    public void exibirHistoricoEmprestimos() {
        if (historicoEmprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo encontrado no histórico.");
            return;
        }
        
        System.out.println("Histórico de Empréstimos:");
        for (Emprestimo emprestimo : historicoEmprestimos) {
            System.out.println("Título do Livro: " + emprestimo.getLivro().getTitulo());
            System.out.println("Data de Retirada: " + emprestimo.getDataRetirada());
            System.out.println("Data de Devolução: " + emprestimo.getDataDevolucao());
            System.out.println("--------------------------------------------------");
        }
    }

    public void exibirHistoricoMultas() {
        if (historicoMultas.isEmpty()) {
            System.out.println("Nenhuma multa registrada.");
        } else {
            for (Double multa : historicoMultas) {
                System.out.println("R$ " + multa);
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<Emprestimo> getHistoricoEmprestimos() {
        return historicoEmprestimos;
    }

    public List<Livro> getHistoricoReservas() {
        return historicoReservas;
    }

    public List<Double> getHistoricoMultas() {
        return historicoMultas;
    }
}
