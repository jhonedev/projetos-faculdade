#include <stdio.h>

int main() {
    int numero, maior, menor, i;

    printf("Digite 5 numeros:\n");
    scanf("%d", &numero);
    maior = menor = numero;

    for ( i = 0; i < 5; i++) {
        scanf("%d", &numero);

        if (numero > maior) {
            maior = numero;
        }
        if (numero < menor) {
            menor = numero;
        }
    }
    
    printf("O numero maior foi: %d\n", maior);
    printf("O menor numero foi: %d\n", menor);
     
}