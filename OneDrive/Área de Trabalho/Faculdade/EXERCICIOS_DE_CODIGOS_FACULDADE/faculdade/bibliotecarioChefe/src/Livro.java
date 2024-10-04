import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private String genero;
    private String isbn;
    private String sinopse;
    private int numeroPaginas;
    private boolean disponibilidade;
    private List<Usuario> usuariosComReserva;

    public Livro(String titulo, String autor, String genero, String isbn, int numeroPaginas, boolean disponibilidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
        this.disponibilidade = disponibilidade;
        this.usuariosComReserva = new ArrayList<>(); // Lista de usuários que reservaram o livro
    }

    public boolean adicionarReservaLivro(Usuario usuario) {
        if (disponibilidade) {
            usuariosComReserva.add(usuario);
            // setDisponibilidade(false); // O livro fica indisponível após a reserva
            return true;
        }
        return false;
    }

    public boolean removerReserva(Usuario usuario) {
        if (usuariosComReserva.remove(usuario)) {
            // Se a lista de reservas estiver vazia, o livro pode ser marcado como disponível novamente
            if (usuariosComReserva.isEmpty()) {
                setDisponibilidade(true);
            }
            return true;
        }
        return false;
    }
    
    public List<Usuario> getUsuariosReservados() {
        if (usuariosComReserva.isEmpty()) {
            System.out.println("Nenhum usuário reservou este livro.");
        } else {
            System.out.println("Usuários que reservaram o livro:");
            for (Usuario usuario : usuariosComReserva) {
                System.out.println(usuario.getNome()); // Supondo que a classe Usuario tenha o método getNome()
            }
        }
        return usuariosComReserva;
    }
    

    public void exibirInformacoesLivro() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Gênero: " + genero);
        System.out.println("ISBN: " + isbn);
        System.out.println("Número de Páginas: " + numeroPaginas);
        System.out.println("Disponibilidade: " + (disponibilidade ? "Disponível" : "Indisponível"));
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    // public void setAutor(String autor) {
    //     this.autor = autor;
    // }

    public String getGenero() {
        return genero;
    }

    // public void setGenero(String genero) {
    //     this.genero = genero;
    // }

    public String getIsbn() {
        return isbn;
    }

    // public void setIsbn(String isbn) {
    //     this.isbn = isbn;
    // }

    public String getSinopse() {
        return sinopse;
    }

    // public void setSinopse(String sinopse) {
    //     this.sinopse = sinopse;
    // }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    // public void setNumeroPaginas(int numeroPaginas) {
    //     this.numeroPaginas = numeroPaginas;
    // }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
