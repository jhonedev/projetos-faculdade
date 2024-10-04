#include <stdio.h>
#include <math.h>
int main() {
	int n1, raizQuadrada, quadradoNumero;
	printf("Digite um numero inteiro:\n");
	scanf("%d", &n1);
	
	raizQuadrada = sqrt(n1);
	quadradoNumero = pow(n1, 2);
	
	printf("O quadrado do numero %d é %d: ", n1, quadradoNumero);
	printf("A raiz quadrada do numero %d é %d: ", n1, raizQuadrada);	
}
