package sistema;
import java.util.ArrayList;
import java.util.List;

public class Bibliotecario extends Usuario {

    public Bibliotecario(String nome, String email, String senha) {
        super(nome, email, senha);
        this.isAdmin = true;
        // Bibliotecário pode ter permissões de admin
    }

    public static Bibliotecario criarContaBibliotecario(String nome, String email, String senha) {
        if (nome != null && !nome.isEmpty() && 
            senha != null && !senha.isEmpty() && 
            email != null && !email.isEmpty()) {
            return new Bibliotecario(nome, email, senha);
        }
        return null;
    }

    public void adicionarNovoLivro(Livro livro, Biblioteca biblioteca) {
        if (biblioteca.livroJaExiste(livro)) {
            System.out.println("O livro " + livro.getTitulo() + " já está na biblioteca. Não é possível adicionar um livro duplicado.");
        } else {
            biblioteca.adicionarNovoLivroNoCatalogo(livro);
            System.out.println("Livro adicionado com sucesso ao catálogo.");
            enviarEmailConfirmacaoAdicaoLivro(livro);
        }
    }

    public void atualizarLivro(Livro livro, Biblioteca biblioteca) {
        enviarEmailConfirmacaoAtualizacaoLivro(livro);
        
    }

    public void removerLivro(Livro livro, Biblioteca biblioteca) {
        if (biblioteca.removerLivroDoCatalogo(livro)) {
            livro.setDisponibilidade(false);
            System.out.println("Livro removido com sucesso!");
            enviarEmailConfirmacaoRemocaoLivro(livro);
        } else {
            System.out.println("Erro ao remover o livro. Talvez ele não esteja no catálogo.");
        }
    }
    
    // Método para listar todos os usuários cadastrados na biblioteca
    public void listarUsuariosCadastrados(Biblioteca biblioteca) {
        List<Usuario> usuarios = biblioteca.visualizarUsuariosCadastrados();
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado na biblioteca.");
        } else {
            System.out.println("Usuários cadastrados na biblioteca:");
            for (Usuario usuario : usuarios) {
                System.out.println("- " + usuario.getNome());
            }
        }
    }

    // Método para excluir um usuário da biblioteca
    public void excluirUsuario(Usuario usuario, Biblioteca biblioteca) {
        if (biblioteca.excluirUsuarioCadastrado(usuario)) {
            System.out.println("Usuário " + usuario.getNome() + " foi removido da biblioteca.");
        } else {
            System.out.println("Falha ao remover o usuário " + usuario.getNome() + ". Ele pode não estar cadastrado.");
        }
    }

    public void visualizarUsuario(Usuario usuario) {
        System.out.println("Informações do usuário:");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Email: " + usuario.getEmail());

        // Exibir os empréstimos do usuário
        List<Emprestimo> emprestimos = usuario.getHistoricoEmprestimos();
        if (emprestimos.isEmpty()) {
            System.out.println("O usuário não possui empréstimos.");
        } else {
            System.out.println("Empréstimos do usuário:");
            for (Emprestimo emprestimo : emprestimos) {
                System.out.println("Livro: " + emprestimo.getLivro().getTitulo());
                System.out.println("Data de Retirada: " + emprestimo.getDataRetirada());
                System.out.println("Data de Devolução: " + emprestimo.getDataDevolucao());
                System.out.println("--------------------------");
            }
        }
    }

    public void suspenderUsuario(Usuario usuario, int dias) {
        usuario.setSuspensao(dias);
        System.out.println("A conta do usuário " + usuario.getNome() + " foi suspensa por " + dias + " dias.");
    }
    
    // Método para monitorar os empréstimos
    public void monitorarEmprestimos(Usuario usuario) {
        List<Emprestimo> listaDeEmprestimos = montarListaDeEmprestimos(usuario);
        
        // Exemplo: exibir a lista de empréstimos
        for (Emprestimo emprestimo : listaDeEmprestimos) {
            System.out.println("Emprestimo: " + emprestimo);
        }
    }

    private List<Emprestimo> montarListaDeEmprestimos(Usuario usuario) {
        List<Emprestimo> listaDeEmprestimos = new ArrayList<>();
        listaDeEmprestimos.addAll(usuario.getHistoricoEmprestimos());
        return listaDeEmprestimos;
    }

    public void enviarEmailConfirmacaoAdicaoLivro(Livro livro) {
        System.out.println("Email de confirmação enviado para " + this.getEmail() +
                           ": O livro '" + livro.getTitulo() + "' foi adicionado ao catálogo.");
    }

    public void enviarEmailConfirmacaoAtualizacaoLivro(Livro livro) {
        System.out.println("Email de confirmação enviado para " + this.getEmail() +
                           ": O livro '" + livro.getTitulo() + "' foi atualizado no catálogo.");
    }

    public void enviarEmailConfirmacaoRemocaoLivro(Livro livro) {
        System.out.println("Email de confirmação enviado para " + this.getEmail() +
                            ": O livro'" + livro.getTitulo() + "' foi removido do catálogo.");
    }
}
