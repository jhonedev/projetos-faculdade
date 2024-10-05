#include <stdio.h>

int main() {

    int idade;
    char nome[50];

    printf("Nome: ");
    scanf("%s", nome);

    printf("Idade: ");
    scanf("%d", &idade);

    if (idade <= 18) {
        printf("O valor a ser pago é: R$50,00\n");
    } else if (idade <= 29) {
        printf("O valor a ser pago é: R$70,00\n");
    } else if (idade <= 45) {
        printf("O valor a ser pago é: R$90,00\n");
    } else if (idade <= 65) {
        printf("O valor a ser pago é: R$130,00\n");
    } else {
        printf("O valor a ser pago é: R$170,00\n");
    }

    return 0;
}
