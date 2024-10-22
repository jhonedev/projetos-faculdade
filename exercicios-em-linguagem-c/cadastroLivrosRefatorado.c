#include <stdio.h>
#include <stdlib.h>
#define TAM 2

struct livro
{
    int codigo, ano;
    char titulo[50], autor[50], area[50], editora[50];
};

void cadastrarLivro(struct livro listaLivros[]) {
    for (int i = 0; i < TAM; i++) {
        printf("\nDigite o código do livro da posição %d: ", i+1);
        scanf("%d", &listaLivros[i].codigo);
        fflush(stdin);

        printf("\nDigite o título do livro: ");
        scanf("%[^\n]", listaLivros[i].titulo);
        fflush(stdin);

        printf("\nDigite o nome do autor: ");
        scanf("%[^\n]", listaLivros[i].autor);
        fflush(stdin);

        printf("\nDigite a área do livro: ");
        scanf("%[^\n]", listaLivros[i].area);
        fflush(stdin);

        printf("\nDigite o ano: ");
        scanf("%d", &listaLivros[i].ano);
        fflush(stdin);
        
        printf("\nDigite o nome da editora: ");
        scanf("%[^\n]", listaLivros[i].editora);
        fflush(stdin);
    }
}

void imprimirLivros(struct livro listaLivros[]) {
    for (int i = 0; i < TAM; i++) {
        printf("\nCódigo: %d\n", listaLivros[i].codigo);
        printf("Título: %s\n", listaLivros[i].titulo);
        printf("Autor: %s\n", listaLivros[i].autor);
        printf("Área: %s\n", listaLivros[i].area);
        printf("Ano: %d\n", listaLivros[i].ano);
        printf("Editora: %s\n", listaLivros[i].editora);
    }
}

void pesquisarPorCodigo(struct livro listaLivros[]) {
    int codigo, encontrouLivro = 0;

    printf("Digite o código do livro que deseja buscar: ");
    scanf("%d", &codigo);

    for (int i = 0; i < TAM; i++) {
        if (listaLivros[i].codigo == codigo) {
            printf("\nCódigo: %d\n", listaLivros[i].codigo);
            printf("Título: %s\n", listaLivros[i].titulo);
            printf("Autor: %s\n", listaLivros[i].autor);
            printf("Área: %s\n", listaLivros[i].area);
            printf("Ano: %d\n", listaLivros[i].ano);
            printf("Editora: %s\n", listaLivros[i].editora);
            encontrouLivro = 1;
            break;
        }
    }

    if (!encontrouLivro){
        printf("\nLivro nao encontrado!");
    }
    
}

void ordenarLivrosPorAno(struct livro listaLivros[]) {
    struct livro trocarLivro;

    for (int i = 0; i < TAM -1; i++) {
        for (int j = i + 1; j < TAM; j++) {
            if (listaLivros[i].ano > listaLivros[j].ano) {
                trocarLivro = listaLivros[i];
                listaLivros[i] = listaLivros[j];
                listaLivros[j] = trocarLivro;
            }
        }
    }

    printf("\nLivros ordenador por ano:\n");
    for (int i = 0; i < TAM; i++) {
        printf("Codigo: %d, Titulo: %s, Ano: %d\n", listaLivros[i].codigo, listaLivros[i].titulo, listaLivros[i].ano);
    } 
}

int main(){
    struct livro listaLivros[TAM];
    int escolherOpcao = 0;

    while (escolherOpcao != 5) {
        printf("\n1 - Cadastrar os livros\n");
        printf("2 - Imprimir os livros cadastrados\n");
        printf("3 - Pesquisar livro por codigo\n");
        printf("4 - Ordenar livros por ano\n");
        printf("5 - Sair\n");
        printf("Digite a opcao desejada: ");
        scanf("%d", &escolherOpcao);
        fflush(stdin);

        switch (escolherOpcao) {
        case 1:
            cadastrarLivro(listaLivros);
            break;
        case 2:
            imprimirLivros(listaLivros);
            break;
        case 3:
            pesquisarPorCodigo(listaLivros);
            break;
        case 4:
            ordenarLivrosPorAno(listaLivros);
            break;
        case 5:
            printf("Saindo...");
            break;
        
        default:
            printf("Opcao invalida! Tente novamente.\n");
        }
    }

    return 0;
}