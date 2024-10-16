#include <stdio.h>

int main() {
    char nome [30];
    int i = 0;

    printf("Digite seu nome: ");
    scanf("\n%s", nome);

    do {
        printf("\n %d - %s", i, nome);
        i++;
    } while (i != 10);
        return 0;
}