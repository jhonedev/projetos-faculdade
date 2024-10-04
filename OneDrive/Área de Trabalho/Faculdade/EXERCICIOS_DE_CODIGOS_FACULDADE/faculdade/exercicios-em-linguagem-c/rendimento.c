#include <stdio.h>
int main() {
	float valorDeposito, valorTaxaJuros, valorRendimento, valorTotal;
	
	printf("Digite o valor de depósito:\n");
	scanf("%f", &valorDeposito);
	
	printf("Digite o valor da taxa de juros:\n");
	scanf("%f", &valorTaxaJuros);
	
	valorRendimento = valorDeposito * (valorTaxaJuros / 100);
	valorTotal = valorDeposito + valorRendimento;
	
	printf("\n O valor do rendimento foi %.2f: ", valorRendimento);
	printf("\n O valor do rendimento + valor depositado foi %.2f:", valorTotal);
}