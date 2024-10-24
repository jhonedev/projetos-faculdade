#include <stdio.h>
#include <string.h>

/*Faça um programa que leia um nome e apresente as letras que se encontram
nas posições pares.*/

int main() {
    char palavra[30];
    int tamanho;

    printf("Digite a palavra desejada:\n");
    scanf("%s", palavra);
    
    tamanho = strlen(palavra);

    for (int i = 0; i < tamanho; i++){
        if (i % 2 != 0){
            printf("%c\n", palavra[i]);
        } 
    }
    return 0;
}