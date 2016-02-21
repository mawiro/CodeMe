package rzymskie;

import java.util.Scanner;

import  java.util.Arrays;

/*Sprawdzić poprawność i zamienić podane przez użytkownika liczbę rzymską na arabską,
zakres liczb rzymskich w przedziale I - XX. 
Program ma być ciągły przerywa się na słowo "end".*/

public class ZamianaCyfrRzymskieArabskie {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// String[] rzymskie = new String[20];
		String[] rzymskie = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
				"XV", "XVI", "XVII", "XVIII", "XIX", "XX" };
		int[] arabskie = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

		do {
			System.out.println("\nWpisz cyfre Rzymską by uzyskać cyfrę Arabska \n wpisz end by zakończyć program ");
			String cyfra = scanner.nextLine();
			
			if (cyfra.equals("end")) {
				break;
			}
			
			String cyfraUpper = cyfra.toUpperCase();
			
			int indexRzymskie = (Arrays.asList(rzymskie).indexOf(cyfraUpper));
		
			if (indexRzymskie < 0 ){
				System.out.println("\nCzy to napewno liczba rzymska z zakresu I do XX ?? ");
				continue;
			}
			
			System.out.println(arabskie[indexRzymskie]);


		} while (true);
		scanner.close();

	}

}
