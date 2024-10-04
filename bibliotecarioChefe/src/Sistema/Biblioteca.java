package Sistema;
import java.util.*;

public class Biblioteca {
    private String nome;
    private String endereco;
    private List<Livro> catalogoLivros;
    private List<Bibliotecario> funcionarios;
    private List<Emprestimo> emprestimos;
    private List<Usuario> usuarios;

    public Biblioteca(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.catalogoLivros = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public List<Livro> getCatalogoLivros() {
        return catalogoLivros;
    }

    public void visualizarCatalogoLivros() {
        for (Livro livro : catalogoLivros) {
            livro.exibirInformacoesLivro();
            System.out.println("======================================================================================================");
        }
    }

    public void registrarBibliotecario(Bibliotecario bibliotecario) {
        funcionarios.add(bibliotecario);
        System.out.println("Bibliotecário " + bibliotecario.getNome() + " registrado na biblioteca.");
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário " + usuario.getNome() + " registrado na biblioteca.");
    }

    // Método para visualizar todos os usuários cadastrados
    public List<Usuario> visualizarUsuariosCadastrados() {
        return new ArrayList<>(usuarios); // Retorna uma cópia da lista de usuários
    }

    // Método para excluir um usuário da lista de usuários
    public boolean excluirUsuarioCadastrado(Usuario usuario) {
        return usuarios.remove(usuario);
    }

    public boolean livroJaExiste(Livro livro) {
        for (Livro l : catalogoLivros) {
            if (l.getIsbn().equals(livro.getIsbn())) {
                return true; // O livro já existe com o mesmo ISBN
            }
        }
        return false;
    }

    public void adicionarNovoLivroNoCatalogo(Livro livro) {
        catalogoLivros.add(livro);
    }

    public boolean removerLivroDoCatalogo(Livro livro) {
         return catalogoLivros.remove(livro);
    }
}
