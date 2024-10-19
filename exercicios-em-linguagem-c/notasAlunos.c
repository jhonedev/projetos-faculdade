#include <stdlib.h>
#include <stdio.h>

int main() {
    float notas[4];
    int i = 0;

    for ( i = 0; i < 4; i++)
    {
        printf("Digite a primeira nota %d: ", i+1);
        scanf("%f", &notas[i]);
    }

    for ( i = 0; i < 4; i++)
    {
        printf("Nota %d: %.2f\n", i+1, notas[i]);
    }
    return 0;
}