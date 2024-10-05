#include <stdio.h>

int main() {
    int numero;

    printf("Digite um numero pra saber se é divisivem por 5:\n");
    scanf("%d", &numero);

    if (numero % 5 == 0)
        printf("O número %d, é divisivel por 5", numero);
    else
        printf("O número %d, não divisível por 5", numero);
}