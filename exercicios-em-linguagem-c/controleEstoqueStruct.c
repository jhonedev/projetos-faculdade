#include <stdio.h>
#include <string.h>

/*Considerando uma aplicação de controle de estoque, crie uma struct
para que possa armazenar as seguintes informações sobre um produto:*/

int main() {

    struct produto {
        int codigoProduto;
        char nomeProduto[50];
        int quantidadeProdutoEstoque;
        float valorPagoProduto;
        float valorUnitarioVenda;
    };

    struct produto produto1;

    produto1.codigoProduto = 15;
    produto1.quantidadeProdutoEstoque = 5;
    produto1.valorPagoProduto = 2.45;
    strcpy(produto1.nomeProduto, "Feijao");

    printf("%d - %d - %f - %s \n", produto1.codigoProduto, produto1.quantidadeProdutoEstoque, produto1.valorPagoProduto, produto1.nomeProduto);
}