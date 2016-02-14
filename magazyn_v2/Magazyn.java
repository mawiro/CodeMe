package pl.codeme.jse1.magazyn;

import java.util.Scanner;

import pl.codeme.jse1.magazyn.Produkt;

public class Magazyn {

	public static Produkt stan_magazyn[] = new Produkt[30];
	public static int magazyn = stan_magazyn.length;

	public static void stan_magazynu() {
		System.out.println("asortyment magazynu");
		boolean magazyn_pusty = true;
		for (int i = 0; i < 30; i++) {
			if (stan_magazyn[i] != null) {
				// System.out.println(stan_magazyn[i]);
				System.out.println("Pozycja " + i + " produkt " + stan_magazyn[i].pelnaNazwaProduktu());
				magazyn_pusty = false;
			} else {
				// System.out.println("Pozycja " + i + " jest pusta");
			}

		}
		if (magazyn_pusty == true) {
			System.out.println("Magazyn jest pusty");
		}
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("\nObsluga magazynu. Wybierz opcje:\n1 asortyment \n2 dostawa \n3 kupno \n4 end");
			String komenda = scanner.nextLine();

			if (komenda.equals("4")) {
				System.out.println("Zakonczyles program komenda - end");
				break;
			}

			if (komenda.equals("1")) {
				stan_magazynu();
			}

			if (komenda.equals("2")) {
				System.out.println("dostawa magazynu");

				boolean magazyn_pelny = true;
				for (int i = 0; i < 30; i++) {
					if (stan_magazyn[i] == null) {
						magazyn_pelny = false;
					}
				}
				if (magazyn_pelny == true) {
					System.out.println("\nMagazyn jest pelny - brak miejsc w magazynie");
				}

				System.out.println("Podaj nazwe produktu, który dodajesz do magazynu NAZWA ILOSC JEDNOSTKA");
				String dodaj_produkt = scanner.nextLine();
				String[] produkt = dodaj_produkt.split("\\s+");
				double ilosc = Double.parseDouble(produkt[1]);
		
				for(int i=0; i<30;i++){
					if ((stan_magazyn[i] != null) &&  (stan_magazyn[i].getNazwaProduktu().equals(produkt[0]))){
						stan_magazyn[i].setIlosc(stan_magazyn[i].getIlosc() + ilosc);
						System.out.println(
								"Zwiekszono ilosc produktu o nazwie " + dodaj_produkt + " na pozycji " + i + " w magazynie");
						stan_magazynu();
						break;
					}
					
					if (stan_magazyn[i] == null) {
						stan_magazyn[i] = new Produkt();
						stan_magazyn[i].setNazwaProduktu(produkt[0]);
						stan_magazyn[i].setIlosc(ilosc);
						stan_magazyn[i].setJednostka(produkt[2]);
						System.out.println(
								"Dodano produkt o nazwie " + dodaj_produkt + " na pozycje " + i + " w magazynie");
						stan_magazynu();
						break;
					}

				}

			}

			if (komenda.equals("3")) {
				System.out.println("kupno z magazynu");
				System.out.println("Podaj nazwe produktu oraz ilosc jaką chcesz kupic NAZWA ILOSC JEDNOSTKA");
				String kup_produkt = scanner.nextLine();
				String[] produkt = kup_produkt.split("\\s+");
				double ilosc = Double.parseDouble(produkt[1]);
				boolean brak_w_magazynie = true;
				
				

				for (int i = 0; i < 30; i++) {
					if ((stan_magazyn[i] != null) && (stan_magazyn[i].getNazwaProduktu().equals(produkt[0]))) {
						if (ilosc <= stan_magazyn[i].getIlosc()){
							stan_magazyn[i].setIlosc(stan_magazyn[i].getIlosc() - ilosc);
							System.out.println("Kupiles produkt " + kup_produkt);
							brak_w_magazynie = false;
							
							if(stan_magazyn[i].getIlosc() == 0) {
								stan_magazyn[i] = null;
							}
						}
						else{
							System.out.println("Brak wystarczajacej ilosci w magazynie. W magazynie znajduje sie obecnie " + stan_magazyn[i].getIlosc() + "produktu " + stan_magazyn[i].getNazwaProduktu());
							System.out.println(" w magazynie znajduje sie" + stan_magazyn[i].pelnaNazwaProduktu());
							brak_w_magazynie = false;
						}
					
					}
					
				}
				if (brak_w_magazynie == true){
					System.out.println("Brak produktu '" +kup_produkt + "' w magazynie - brak mozliwosi zakupu produktu ");
				}
			}

		} while (true);

		scanner.close();
	}

}
