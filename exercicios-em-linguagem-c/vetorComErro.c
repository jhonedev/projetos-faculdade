#include <stdio.h>
int main() {
    int vetorA[10];
    int i;

    /*Vetor com erro na numeracao, onde o for é ate 15 e o vetor é até 10*/
    for (i=0; i<15; i++) {
    printf("\nDigite o %d elemento: ", i);
    scanf("%d", &vetorA[i]);
    }

    printf ("Vetor preenchido.\n");

    for (i=0; i<15 ;i++) {
    printf("%d - ", vetorA[i]);
    }
    return (0);
}