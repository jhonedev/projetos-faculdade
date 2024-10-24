#include <stdio.h>
#define TAM 5

/*Faça um programa que leia dois vetores A e B, com 20 números inteiros. Efetue a
soma dos dois vetores em um vetor C e imprima o vetor C em ordem crescente.*/

int main() {
    int vetorA[20], vetorB[20], vetorC[20], trocaNumero;

    for (int i = 0; i < TAM; i++) {
        printf("Digite o elementor %d do vetor A: ", i+1);
        scanf("%d", &vetorA[i]);
        printf("Digite o elemento %d do vetor B: ", i+1);
        scanf("%d", &vetorB[i]);

        vetorC[i] = vetorA[i] + vetorB[i];
    }

    for (int i = 1; i < TAM; i++) {
        for (int j = 0; j < TAM -1; j++) {
            if (vetorC[i] < vetorC[j]) {
                trocaNumero = vetorC[i];
                vetorC[i] = vetorC[j];
                vetorC[j] = trocaNumero;
            }
        }
    }

    for (int i = 0; i < TAM; i++){
        printf("%d\n", vetorC[i]);
    }
    
}