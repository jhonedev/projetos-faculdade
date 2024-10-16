#include <stdio.h>

int main() {
    char nome [30];
    int i;

    printf("Qual seu nome:");
    scanf("%s", nome);
    i = 0;

    while (i != 10)
    {
        printf("\n %s", nome);
        i++;
    }
    return 0;
    
}