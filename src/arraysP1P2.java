
public class arraysP1P2 {
	/*
	public static void main(String[] args){
		int size = chooseNum();
		int [] arr = createArray(size);
		int toFind = chooseInArr(size);
		System.out.println(toFind + "\n" + size);
		int p1Ind = P1Algo(arr, toFind);
		System.out.println(p1Ind + "\n" + arr[p1Ind]);
		int p2Ind = P2Algo(arr, toFind);
		System.out.println(p2Ind + "\n" + arr[p2Ind]);
	}
	*/
	public static int P1Algo(int[] arr, int toFind){
		int constantUB = 10;//starts ahead
		int constantLB = 0;
		int count = 1;
		while(constantUB < arr.length){
			if(arr[constantUB] < toFind){
				constantLB = constantUB;//should always be fine
				if((constantUB + 10) > arr.length){//resize would be too large
					constantUB = arr.length; 
				}
				else{
					constantUB += 10;
				}
				System.out.println("Policy 2 iteration # " + count++);
			}
			else{
				break;
			}
			
		}
		int retInd = binarySearch(arr, constantLB, constantUB, toFind);
		return retInd;
		//can find using binary using constant - 10 and constant as LB & UB
	}
	
	public static int P2Algo(int[] arr, int toFind){
		int constantUB = 1;
		int constantLB = 0;
		int count = 1;
		while(constantUB < arr.length){
			if(arr[constantUB] < toFind){
				constantLB = constantUB;
				if((constantUB * 2) > arr.length){//resize would be too large
					constantUB = arr.length;
				}
				else{
					constantUB *= 2;
				}
				System.out.println("Policy 2 iteration # " + count++);
			}
			else{
				break;
			}
		}
		int retInd = binarySearch(arr, constantLB, constantUB, toFind);
		//can find using binarySearch using const/2 and const as LB and UB  
		return retInd;
	}
	
	public static int binarySearch(int[] arr, int lb, int ub,int toFind){
		if(lb > ub){
			System.out.println("No such int");
			System.exit(1);
		}
		int mid = (ub + lb) / 2;
		if(arr[mid] == toFind){//to find found
			return mid;
		}
		else if( arr[mid] > toFind){//toFind is in first half
			return binarySearch(arr, lb, mid -1, toFind);
		}
		else{//toFind is in second half
			return binarySearch(arr, mid+1, ub, toFind);
		}
	}
	public static int chooseInArr(int size){
		int ret = (int) Math.random() * 10;
		//ret *= size;
		return 87;
	}
	public static int chooseNum(){
		int rand = (int) Math.random() * 10;
		rand *= 100;
		return 100;
	}
	
	public static int[] createArray(int size){
		int[] ret = new int[size];
		int i = 0;
		while( i < size){
			ret[i] = ++i;
		}
		return ret;
	}
}


/*
 * 
 *Policy 1 resizing takes j/c time to find the jth element + logn time with binary search 
 *
 *Policy 2 resizing takes logn time to find the jth element + logn with binary search
 *
 *Policy 2 is overall better as with larger numbers in larger arrays it is easy to see that 
 *the that way of resizing ends up taking much less as the range being checked is bigger.
 *Although it may create more work for the binary search that search also greatly reduces 
 *the range after each iteration 
 *
 */
 
 
 
 
