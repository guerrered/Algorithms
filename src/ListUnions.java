
public class ListUnions {
	public static void main(String[] args){
		int[] l1 = new int[10];
		int[] l2 = new int[15];
		int i = 0;
		while( i < l1.length){
			l1[i] = 2 * ++i;
		}
		i = 0;
		while(i < l2.length){
			l2[i] = (2 * ++i) -1;
		}
		int[] l3 = Unionize(l1, l2);
		printList(l1);
		printList(l2);
		printList(l3);
		int lists = 4;
		int width = 9;
		int[][] manyL = new int[lists][width];
		i = 0;
		int j = 0;
		
		int count = 0;
		while( i < lists){
			j = 0;
			while(j <width){
				manyL[i][j++] = count++;
			}
			i++;
		}
		int[] mL = unionMany(manyL, lists, width);
		printList(mL);
	}
	
	public static int[] Unionize(int[] l1, int[] l2){
		int[] l3 = new int[l1.length + l2.length];
		int i =0;
		int l1Ind = 0;
		int l2Ind = 0;
		while( i < l3.length){// algorithm takes n1 + n2 time 
			if(l2Ind < l2.length && l1Ind < l1.length){
				if(l2[l2Ind] > l1[l1Ind]){
					l3[i] = l1[l1Ind++];
				}
				else{
					l3[i] = l2[l2Ind++];
				}
			}
			else if(l1Ind >= l1.length){
				l3[i] = l2[l2Ind++];
			}
			else if(l2Ind >= l2.length){
				l3[i] = l1[l1Ind++];
			}
			
			i++;
		}
		return l3;
	}
	
	public static int[] unionMany(int[][] x, int lists,int elements){
		int i = 0;
		int[] temp1 = new int[1];
		int[] temp2;//temp1 ultimately gets returned it will be the output of comparisons
		   				  //temp2 will be the new list being created at each step
		while( i < lists){//go through k lists
				int j = 0,l1Ind = 0,l2Ind = 0;
				if( i > 0){
					temp2 = new int[x[i].length + temp1.length];
					while( j < temp2.length){
						if(l2Ind < temp1.length && l1Ind < x[i].length){
							if(temp1[l2Ind] > x[i][l1Ind]){
								temp2[j] = x[i][l1Ind++];
							}
							else{
								temp2[j] = temp1[l2Ind++];
							}
						}
						else if(l1Ind >= x[i].length){
							temp2[j] = temp1[l2Ind++];
						}
						else if(l2Ind >= temp1.length){
							temp2[j] = x[i][l1Ind++];
						}
						j++;
					}
					i++;
				}
				else{
					temp2 = new int[x[0].length + x[1].length];//l1 and l2 lengths
					while( j < temp2.length){
						if(l2Ind < x[1].length && l1Ind < x[0].length){
							if(x[1][l2Ind] > x[0][l1Ind]){
								temp2[j] = x[0][l1Ind++];
							}
								else{
								temp2[j] = x[1][l2Ind++];
							}
						}
						else if(l1Ind >= x[0].length){
							temp2[j] = x[1][l2Ind++];
						}
						else if(l2Ind >= x[1].length){
							temp2[j] = x[0][l1Ind++];
						}
					}
					i = 2;//moves to 3rd list since algo is slightly different after first comparison
				}
				temp1 = temp2;
			
		}
		return temp1;
	}
	
	public static void printList(int[] l1){
		int i = 0;
		while( i < l1.length){
			System.out.print(l1[i++] + ", ");
		}
		System.out.println();
	}
}
