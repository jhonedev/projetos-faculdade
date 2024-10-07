#include <stdio.h>
#include <math.h>

int main() {
    float salario, novoSalario, valorAumento;
    int codigo;
    int codigoValido = 1;
    char profissao[30];

    printf("Digite o valor do seu salario:\n");
    scanf("%f", &salario);

    printf("1- Servente\n2- Pedreiro\n3- Mestre de obras\n4- Tecnico de seguranca\n");
    printf("Digite o codigo do cargo:\n");
    scanf("%d", &codigo);
    
    switch (codigo) {
    case 1:
        sprintf(profissao, "Servente");
        novoSalario = salario + (salario * 0.4);
        valorAumento = salario * 0.4;
        break;
    case 2:
        sprintf(profissao, "Pedreiro");
        novoSalario = salario + (salario * 0.35);
        valorAumento = salario * 0.35;
        break;
    case 3:
        sprintf(profissao, "Mestre de obras");
        novoSalario = salario + (salario * 0.2);
        valorAumento = salario * 0.2;
        break;
    case 4:
        sprintf(profissao, "Tecnico de seguranca");
        novoSalario = salario + (salario * 0.1);
        valorAumento = salario * 0.1;
        break;
    default:
        printf("Digite um valor valido!");
        codigoValido = 0;
        break;
    }

    if (codigoValido) {
        printf("Cargo: %s\n", profissao);
        printf("Valor do aumento: %.2f\n", valorAumento);
        printf("Novo salario: %.2f\n", novoSalario);  
    }
    return 0;
}