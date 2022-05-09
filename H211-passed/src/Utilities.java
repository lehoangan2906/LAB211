
import java.util.Scanner;


public class Utilities {
	Scanner sc = new Scanner(System.in);

	public String inputStr(String msg, String input){
		String data;
		do{
			System.out.print(msg);
			data = sc.nextLine().trim();
		}while(!data.matches(input));

		return data;
	}

	public static int inputInt(String msg, int min, int max){
		int data;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.print(msg);
			String input = sc.nextLine();
			try{
				data = Integer.parseInt(input);
				if (min <= data && data <= max){
					return data;
				}
			}catch(Exception e){	
				System.out.println("Invalid value. Enter the input again");
			}
		}while(true);
	}

	// input non blank string
	public String inputNonBlankStr(String msg){
		String data;
		do {
			System.out.print(msg);
			data = sc.nextLine().trim();
		}while(data.length() < 1);

		return data;
	}
}
