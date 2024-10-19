#include <stdio.h>
#include <string.h>

int main() {

    char strOrigem[10], strDestino[10];
    strcpy(strOrigem, "Teste");
    strcpy(strDestino, strOrigem);

    printf(strOrigem);
    printf(strDestino);
}