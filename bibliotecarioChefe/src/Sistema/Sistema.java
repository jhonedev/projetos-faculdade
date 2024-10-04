package sistema;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Sistema {
    public static void main(String[] args) {
        // Criando uma nova biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Av. Principal, 123");

        // Criando um bibliotecário
        Bibliotecario bibliotecario = Bibliotecario.criarContaBibliotecario("Ana Silva", "ana@biblioteca.com", "12345");
        biblioteca.registrarBibliotecario(bibliotecario);

        // Criando um novo usuário
        Usuario usuario1 = Usuario.criarContaUsuario("Carlos Souza", "carlos@exemplo.com", "senha123");
        biblioteca.registrarUsuario(usuario1);

        Usuario usuario2 = Usuario.criarContaUsuario("Jonathan Borges", "jonathan@exemplo.com", "senha123");
        biblioteca.registrarUsuario(usuario2);

        // Livros
        Livro livro1 = new Livro("Java Programming", "Fernando", "Tecnologia", "123-456-789", 500, true);
        Livro livro2 = new Livro("Fred", "Jhon", "Terror", "1325-5154", 210, true);
        Livro livro3 = new Livro("Pinóquio", "Fernando", "Fantasia", "1555-5548", 125, true);
        Livro livro4 = new Livro("Panda", "Marley", "Infantil", "1325-5154", 154, true);

        // Bibliotecario faz login e adiciona livros ao catálogo
        if (bibliotecario.login("ana@biblioteca.com", "12345")) {
            System.out.println("Login bem-sucedido!");

            System.out.println("======================================================================================================");
            bibliotecario.adicionarNovoLivro(livro1, biblioteca);
            
            System.out.println("======================================================================================================");
            bibliotecario.adicionarNovoLivro(livro2, biblioteca);
            
            System.out.println("======================================================================================================");
            bibliotecario.adicionarNovoLivro(livro3, biblioteca);

            System.out.println("======================================================================================================");
            bibliotecario.adicionarNovoLivro(livro4, biblioteca);

            // Simulação de atualização de livro
            System.out.println("======================================================================================================");
            System.out.println("Atualizando o livro: " + livro2.getTitulo());
            livro2.setTitulo("A naconda");
            bibliotecario.atualizarLivro(livro2, biblioteca);
            System.out.println("Livro atualizado com sucesso!");

            // Simulação de exclusao de livro
            System.out.println("======================================================================================================");
            System.out.println("Excluindo o livro: " + livro2.getTitulo());
            bibliotecario.removerLivro(livro2, biblioteca);
        } else {
            System.out.println("Falha no login.");
        }

        // Usuário1 faz login
        if (usuario1.login("carlos@exemplo.com", "senha123")) {
            System.out.println("======================================================================================================");
            System.out.println("Login bem-sucedido!");

            // Usuário1 visualiza o catálogo de livros
            usuario1.visualizarCatalogoLivros(biblioteca);
            System.out.println("======================================================================================================");

            // Criar uma data específica para a retirada
            Calendar calendar = Calendar.getInstance();
            calendar.set(2024, Calendar.AUGUST, 01);
            Date dataRetirada = calendar.getTime();

            livro3.adicionarReservaLivro(usuario1);
            // Usuário1 reserva dois livro
            usuario1.fazerEmprestimoLivro(livro1, dataRetirada);
            // usuario1.reservarEmprestimoLivro(livro3, dataRetirada);

            // Usuario finaliza o emprestimo e se tiver multa mostra o valor
            usuario1.finalizarEmprestimo(livro1);
            System.out.println("======================================================================================================");

            // Usuário exibi seu historico de emprestimos de livros
            usuario1.exibirHistoricoEmprestimos();
            System.out.println("======================================================================================================");

            // Usuario visualiza detalhes de livro
            usuario1.visualizarDetalhesDoLivro(livro3);
            System.out.println("======================================================================================================");
            
            // Usuario1 pesquisa livro por autor, genero,titulo e isbn
            usuario1.pesquisarLivroAutor("Fernando", biblioteca);
            usuario1.pesquisarLivroGenero("Tecnologia", biblioteca);
            // usuario1.pesquisarLivroTitulo("Fred", biblioteca);
            usuario1.pesquisarLivroIsbn("123-456-789", biblioteca);

            // usuario1.renovarEmprestimoLivro(livro3);

            // Simular término do empréstimo de Usuário 1
            // usuario1.finalizarEmprestimo(livro1);
        } else {
            System.out.println("Falha no login.");
        }

        // Usuário2 faz login
        if (usuario2.login("jonathan@exemplo.com", "senha123")) {
            System.out.println("Login bem-sucedido!");
            System.out.println("======================================================================================================");

            // Usuário visualiza o catálogo de livros
            // usuario2.visualizarCatalogoLivros(biblioteca);

            // Criar uma data específica para a retirada
            Calendar calendar = Calendar.getInstance();
            calendar.set(2024, Calendar.AUGUST, 21); // Data: 25 de agosto de 2024
            Date dataRetirada = calendar.getTime();

            // Usuário verifica se o livro esta disponível e tenta reservar um livro indisponível
            // livro3.adicionarReserva(usuario2);
            usuario2.fazerEmprestimoLivro(livro3, dataRetirada);
            livro3.getUsuariosReservados();

            // Usuário faz logout
            // usuario1.logout();
        } else {
            System.out.println("Falha no login.");
        }

        if (bibliotecario.login("ana@biblioteca.com", "12345")) {
            System.out.println("Login bem-sucedido!");

            bibliotecario.monitorarEmprestimos(usuario1);
            bibliotecario.monitorarEmprestimos(usuario2);

            bibliotecario.visualizarUsuario(usuario1);

            bibliotecario.listarUsuariosCadastrados(biblioteca);

            bibliotecario.suspenderUsuario(usuario2, 5);

            bibliotecario.excluirUsuario(usuario2, biblioteca);
            bibliotecario.listarUsuariosCadastrados(biblioteca);
        } else {
            System.out.println("Falha no login.");
        }
    }
}
