#include <stdio.h>
#include <stdlib.h>
#define TAM 2

struct livro {
    int codigo;
    char titulo[50];
    char autor[50];
    char area[50];
    int ano;
    char editora[50];
};

int main() {
    struct livro listaLivros[TAM];
    struct livro trocarLivro;
    int pesquisarPorCodigo, escolherOpcao, encontrouLivro;

    escolherOpcao = 0;

    while (escolherOpcao != 5) {
        printf("1 - Cadastrar os livros\n");
        printf("2 - Imprimir os livros cadastrados\n");
        printf("3 - Pesquisar livros por codigo\n");
        printf("4 - Ordenar livros por ano\n");
        printf("5 - Sair\n");

        printf("Digite a opcao desejada: \n");
        scanf("%d", &escolherOpcao);
        fflush(stdin);

        if (escolherOpcao == 1) {
            system("cls");

            for (int i = 0; i < TAM; i++) {
                printf("Digite o código do livro da posição %d: ", i+1);
                scanf("%d", &listaLivros[i].codigo);
                fflush(stdin);

                printf("Digite o título do livro: ");
                scanf("%[^\n]s", listaLivros[i].titulo);  // Removido o &
                fflush(stdin);

                printf("Digite o nome do autor: ");
                scanf("%[^\n]s", listaLivros[i].autor);   // Removido o &
                fflush(stdin);

                printf("Digite a área do livro: ");
                scanf("%[^\n]s", listaLivros[i].area);    // Removido o &
                fflush(stdin);

                printf("Digite o ano: ");
                scanf("%d", &listaLivros[i].ano);
                fflush(stdin);

                printf("Digite o nome da editora: ");
                scanf("%[^\n]s", listaLivros[i].editora); // Removido o &
                fflush(stdin);
            }
        } else if (escolherOpcao == 2) {
            system("cls");

            for (int i = 0; i < TAM; i++) {
                printf("\nCódigo: %d\n", listaLivros[i].codigo);
                printf("Título: %s\n", listaLivros[i].titulo);
                printf("Autor: %s\n", listaLivros[i].autor);
                printf("Área: %s\n", listaLivros[i].area);
                printf("Ano: %d\n", listaLivros[i].ano);
                printf("Editora: %s\n", listaLivros[i].editora);
            }
        } else if (escolherOpcao == 3) {
            system("cls");

            printf("Digite o código que deseja buscar: ");
            scanf("%d", &pesquisarPorCodigo);

            int i = 0;
            encontrouLivro = 0;

            while ((i < TAM) && (encontrouLivro == 0)) {
                if (listaLivros[i].codigo == pesquisarPorCodigo) {
                    encontrouLivro = 1;
                } else {
                    i++;
                }
            }

            if (encontrouLivro == 1) {
                printf("\nCódigo: %d\n", listaLivros[i].codigo);
                printf("Título: %s\n", listaLivros[i].titulo);
                printf("Autor: %s\n", listaLivros[i].autor);
                printf("Área: %s\n", listaLivros[i].area);
                printf("Ano: %d\n", listaLivros[i].ano);
                printf("Editora: %s\n", listaLivros[i].editora);
            } else {
                printf("\nRegistro não encontrado\n");
            }
        } else if (escolherOpcao == 4) {
            system("cls");

            for (int i = 0; i < TAM - 1; i++) {
                for (int j = i + 1; j < TAM; j++) {
                    if (listaLivros[i].ano > listaLivros[j].ano) {
                        trocarLivro = listaLivros[i];
                        listaLivros[i] = listaLivros[j];
                        listaLivros[j] = trocarLivro;
                    }
                }
            }

            for (int i = 0; i < TAM; i++) {
                printf("\nCódigo: %d, Título: %s, Ano: %d\n", listaLivros[i].codigo, listaLivros[i].titulo, listaLivros[i].ano);
            }
        }
    }
    return 0;
}
