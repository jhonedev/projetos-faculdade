#include <stdio.h>

int main () {

    float calorias = 0;
    int escolha;

    printf("Escolha a opcão:\n");
    printf("\nPratos\n1 - Italiano: 750 cal\n2 - Japonês: 324 cal\n3 - Salvadorenho: 545 cal\n");
    scanf("%d", &escolha);

    switch (escolha)
    {
    case 1:
        calorias = 750;
        break;
    case 2:
        calorias = 324;
        break;

    case 3:
        calorias = 545;
        break;
    default:
        printf("Informe um valor válido.");
    }

    printf("\nBebidas\n1 - Chá: 30cal\n2 - Suco de maracujá: 80 cal\n3 - Refrigerante: 90 cal\n");
    scanf("%d", &escolha);

    switch (escolha)
    {
    case 1:
        calorias += 30;
        break;
    case 2:
        calorias += 80;
        break;
    case 3:
        calorias += 90;
        break;
    default:
        printf("Escolha um valor válido.");
        break;
    }

    printf("O total de calorias é de: %.2f", calorias);
    return 0;
}