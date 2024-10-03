#include <stdio.h>
#include <math.h>
int main() {
	
	int numero;
	float raizQuadrada;	
	
	printf("Digite um numero inteiro:\n");
	scanf("%d", &numero);
	
	if (numero % 2 == 0) {
		raizQuadrada = sqrt(numero);
		printf("A raiz quadrada do numero %d e: %.3f", numero, raizQuadrada);
	}
}