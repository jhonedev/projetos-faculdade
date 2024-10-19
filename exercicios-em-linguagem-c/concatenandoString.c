#include <stdio.h>
#include <string.h>

int main() {
    char stringUm[10] = "Coruripe-";
    char stringDois[10] = "AL";

    strcat(stringUm, stringDois);
    printf("%s", stringUm);
}