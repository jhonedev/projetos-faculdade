#include <stdio.h>

int main() {
    int soma = 0;

    for (int i = 1; i < 10; i++)
    {
        soma += i;
    }
    printf("A soma é: %d", soma);
}