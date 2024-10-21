// #include <stdio.h>

// int main() {
//     int matrizA[3][3] = {{1,2,3}, {4,5,6}, {7,8,9}};

//     for (int i = 0; i < 3; i++) {
//         for (int j = 0; j < 3; j++) {
//             printf("%d", matrizA[i][j]);
//         }
//         printf("\n");
//     }  
// }


int main() {
    int matrizB [3][3];

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("Digite o valor para a posição [%d][%d]: ", i + 1, j + 1);
            scanf("%d", &matrizB[i][j]);
        }
        // printf("\n");
    }

    for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++) {
            printf("%d", matrizB[i][j]);
        }
        printf("\n");
    }
    
}