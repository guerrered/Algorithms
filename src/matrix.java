
public class matrix {

	public static void main(String[] args){
		int n = 4;
/*		int[][] matrix = formMatrix(n);
		printMat(matrix, n);
		int[][] mat = matrixAlgorithm(matrix, n);
		System.out.println();
		printMat(mat,n);
*/
		int[][] example = new int[n][n];
		example[0][0] = 3;
		example[1][1] = 2;
		example[2][2] = 4;
		example[3][3] = 3;
		printMat(example, n);
		example = matrixAlgorithm(example, n);
		System.out.println();
		printMat(example, n);
		
	}
	
	public static int[][] formMatrix(int n){
		int[][] mat = new int[n][n];
		int i = 0;
		while(i < n){
			mat[i][i] = (int) (Math.random() * 10) + 1;
			i++;
		}
		return mat;
	}
	
	public static void printMat(int[][] mat, int n){
		int i = 0;
		while(i < n){
			int j = 0;
			while(j < n){
				System.out.print(mat[i][j] + "  ");
				j++;
			}
			System.out.println();
			i++;
		}
	}
	
	public static int[][] matrixAlgorithm(int[][] matrix, int n){
		//staring at 0, 1
		int iterator = 1;
		int i, j;
		while(iterator < n){
			i = 0;
			j = iterator;
			while(j < n){
				matrix[i][j] = matrix[i][i] * matrix[j][j];
				int s = j - i;
				if( s >= 2){
					int r = 1;
					while(r < s){
						matrix[i][j] += matrix[i][ i+ r] * matrix[j-r][j];
						r++;
					}
				}
				i++;j++;
			}
			iterator++;
		}
		
		return matrix;
	}
}
