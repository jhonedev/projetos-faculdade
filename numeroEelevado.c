#include <stdio.h>
#include <math.h>

int main () {
	float n1, n2, numeroElevado;
	
	printf("Digite o primeiro numero:\n");
	scanf("%f", &n1);
	
	printf("Digite o segundo numero:\n");
	scanf("%f", &n2);
	
	numeroElevado = pow(n1, n2);
	printf("\n %.2f elevado a %.2f é: %.2f", n1, n2, numeroElevado);
	return 0;
}
