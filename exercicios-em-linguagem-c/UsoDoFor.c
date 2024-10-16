#include <stdio.h>

int main() {
    char nome [30];
    int i;

    printf("Digite o nome:");
    scanf("%s", nome);

    for ( i = 0; i < 10; i++)
    {
        printf("\n %s", nome);
    }
    return 0;
    
}