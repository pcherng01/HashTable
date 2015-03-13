import java.util.Scanner;


public class mainz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean quit = false;
		Scanner sc = new Scanner(System.in);
		while(!quit) {
			System.out.println("Enter the size of the hash table "
					+ "(or type \'quit\' to exit): ");
			String userInput0 = sc.nextLine();
			if(userInput0.equals("quit")) 
				quit = true;
			else {
				int sizeOfArray = Integer.parseInt(userInput0);
				int[] ans = new int[sizeOfArray];
				System.out.println("Enter the probing type - LINEAR or "
						+ "QUADRATIC: ");
				String userInput = sc.nextLine();
				if(userInput.equals("LINEAR"))
					doHash("LINEAR",sc,ans,sizeOfArray);
				else if(userInput.equals("QUADRATIC"))
					doHash("QUADRATIC", sc, ans, sizeOfArray);
			}
		}
	}
	
	public static void doHash(String what, Scanner sc, int[] ans, int sizeOfArray)
	{
		boolean stop = false;
		System.out.println("Enter the value to be inserted into hash table. "
				+ "Type \'stop\' when finished: ");
		while(!stop) {
			String userInput2 = sc.nextLine();
			if(userInput2.equals("stop")) 
				stop = true;
			else {
				int numberInput = Integer.parseInt(userInput2);
				int i = 0;
				if(what.equals("LINEAR")){
					while(ans[numberInput+i%sizeOfArray] != 0) {
						i++;
					}
					ans[numberInput+i%sizeOfArray] = numberInput;
				}
				else {
					while(ans[(numberInput+(i*i))%sizeOfArray] != 0) {
						i++;
					}
					ans[(numberInput+(i*i))%sizeOfArray] = numberInput;
				}
				for(int ii = 0; ii < sizeOfArray; ii++) {
					if(ans[ii] == 0) {
						if( ii == sizeOfArray -1)
							System.out.print("X");
						else 
							System.out.print("X | ");
					}
					else {
						if(ii == sizeOfArray -1)
							System.out.print(ans[ii]);
						else
							System.out.print(ans[ii]+" | ");
					}
				}
			}
			System.out.println();
		}
		stop = false;
		while(!stop) {
			System.out.println("Enter a value to search for in the hash table"
					+ "(or type \'stop\'): ");
			String userInput3 = sc.nextLine();
			if(userInput3.equals("stop"))
				stop = true;
			else {
				int numberToSearch = Integer.parseInt(userInput3);
				int hashValue = numberToSearch % sizeOfArray;
				int i = 0;
				boolean notFound = false;
				if(what.equals("LINEAR")){
					int j = 0;
					while(ans[hashValue+j%sizeOfArray] != numberToSearch) {
						j++;
						if( j > sizeOfArray) {
							System.out.println("Element not in the array.");
							notFound = true;
							break;
						}
					}
				}
				else {
					int j = 0;
					while(ans[(hashValue+(j*j))%sizeOfArray] != numberToSearch) {
						j++;
						if( j > sizeOfArray) {
							System.out.println("Element not in the array.");
							notFound = true;
							break;
						}
					}
				}
				if(!notFound) {
					System.out.println("Value "+numberToSearch+
							" found in index "+(hashValue+i));
				}
			}
		}
	}

}
