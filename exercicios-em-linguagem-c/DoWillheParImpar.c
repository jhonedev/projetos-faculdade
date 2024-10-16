#include <stdio.h>

int main() {
    int par, impar, numero;

    par = 0;
    impar = 0;

    do {
        printf("Digite o numero:\n");
        scanf("%d", &numero);

        if (numero % 2 == 0) {
            par++;
        }else {
            impar++;
        }
        
    } while (numero != 0);
    printf("A quantidade numero pares foi: %d\n", par);
    printf("A quantidade numero impares foi: %d\n", impar);
    return 0;
}