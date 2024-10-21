#include <stdio.h>
#include <string.h>

int main() {
    struct produto {
        int id;
        char nome[50];
        float valor;
    };

    struct produto lista[3];

    for (int i = 0; i < 3; i++) {
        lista[i].id = i;

        printf("Digite o valor do produto %d: \n", i+1);
        scanf("%f", &lista[i].valor);
        printf("\n");

        printf("Digite o nome do produto %d: \n", i+1);
        scanf("%s", lista[i].nome);
        printf("\n");
    }

    for (int i = 0; i < 3; i++)
    {
        printf("Produto %d\n", i+1);
        printf("ID %d: \n", lista[i].id);
        printf("Nome do produto %s: \n", lista[i].nome);
        printf("Valor do produto %f: \n", lista[i].valor);
        printf("\n");
    }
    
}