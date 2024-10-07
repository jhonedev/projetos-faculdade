#include <stdio.h>

int main() {
    int numero;

    printf("Digite um numero:\n");
    scanf("%d", &numero);

    if (numero % 7 == 0 && numero % 3 == 0) {
        printf("Divisivel por 7 e 3");
    } else {
        printf("Nao e divisivel por 7 e 3");
    }

    return 0;
    
}