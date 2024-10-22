public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

        int length = matrix[0].length;
        for(int i = 0; i < length - 1; i++){
            for(int j = i + 1; j < length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int s = 0;
        int e = length - 1;
        while(s < e){
            for(int i = 0; i < length; i++){
                int temp = matrix[i][s];
                matrix[i][s] = matrix[i][e];
                matrix[i][e] = temp;
            }
            s++;
            e--;
        }

        for (int[] is : matrix) {
            for(int i = 0; i < is.length; i++){
                System.out.print(is[i] + " ");
            }
            System.out.println();
        }

    }
}
