package pl.codeme.jse1.magazyn;


public class Produkt {

	private String nazwaProduktu;
	private double ilosc;
	private String jednostka;
	public String getNazwaProduktu() {
		return nazwaProduktu;
	}
	public void setNazwaProduktu(String nazwaProduktu) {
		this.nazwaProduktu = nazwaProduktu;
	}
	public String getJednostka() {
		return jednostka;
	}
	public void setJednostka(String jednostka) {
		this.jednostka = jednostka;
	}
	public double getIlosc() {
		return ilosc;
	}
	public void setIlosc(double ilosc) {
		this.ilosc = ilosc;
	}
	
	public String pelnaNazwaProduktu(){
		return getNazwaProduktu() + " " + getIlosc() + " " + getJednostka();
		
	}
	
}
