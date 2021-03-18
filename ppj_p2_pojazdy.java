
public class S18311_p02 {

	public static void main(String[] args) {
		
		int moce[] = {82, 110, 160, 180, 200, 220};
		long pojemnosci[] = {1000, 1200, 1600, 2000, 2400, 3000};		
		char audi[] = { 'A', 'u', 'd', 'i', ' ' };
		char subaru[] = { 'S', 'u', 'b', 'a', 'r', 'u', ' ' };
		char ford[] = { 'F', 'o', 'r', 'd', ' ' };
		char opel[] = { 'O', 'p', 'e', 'l', ' ' };
		char honda[] = { 'H', 'o', 'n', 'd', 'a' , ' '};
		char toyota[] = { 'T', 'o', 'y', 'o', 't', 'a', ' ' };		
		char nazwy[][] = { audi, subaru, ford, opel, honda, toyota};
		int iloscMiejsc[] = { 2, 3, 4, 5, 7, 10 };		
		PojazdMechaniczny pojazdy[] = new PojazdMechaniczny[100];
		
		for(int i = 0; i<100 ; i++) {
			pojazdy[i] = new PojazdMechaniczny(
					nazwy[(int) (Math.random() * (0 - 6) +6)],
					new Silnik(moce[(int) (Math.random() * (0 - 6) +6)], pojemnosci[(int) (Math.random() * (0 - 6) +6)]),
					iloscMiejsc[(int) (Math.random() * (0 - 6) +6)]
					);
		}
		
		sortowanko(pojazdy);
		drukuj(pojazdy);
	}
	
	public static int getCharArrLength(char tab[]) {
		int val = 0;
		while(tab[val] != ' ') {
			val++;
		}
		return val;
			
	}
	
	public static int porownaj(char nazwa1[], char nazwa2[]) {		
		int rozmiar1 = getCharArrLength(nazwa1);
		int rozmiar2 = getCharArrLength(nazwa2);

        int val = dajMniejsza(rozmiar1, rozmiar2);
        int i = 0;
        while (i < val) {
            
        	char znak1 = nazwa1[i];
            char znak2 = nazwa2[i];
            
            if (znak1 != znak2) {
                return znak1 - znak2;
            }
            
            i++;
        }
        return rozmiar1 - rozmiar2;
		
	}
	
	public static void zamien(PojazdMechaniczny tab[], int index1, int index2) {
		PojazdMechaniczny tmp;
		tmp = tab[index1];
		tab[index1] = tab[index2];
		tab[index2] = tmp;
	}
	
	public static void sortowanko(PojazdMechaniczny pojazdy[]) {			
		for(int i = 0; i<100; i++) {
			for(int j = i+1; j<100; j++) {
				if(pojazdy[j].getMoc() > pojazdy[i].getMoc()) {
					zamien(pojazdy, i, j);
				} else if(pojazdy[j].getMoc() == pojazdy[i].getMoc()) {
					if(pojazdy[j].getPojemnosc() > pojazdy[i].getPojemnosc()) {
						zamien(pojazdy, i, j);
					} else if(pojazdy[j].getPojemnosc() == pojazdy[i].getPojemnosc()) {
						if(pojazdy[j].getIloscMiejsc() > pojazdy[i].getIloscMiejsc()) {
							zamien(pojazdy, i, j);
						} else if(pojazdy[j].getIloscMiejsc() == pojazdy[i].getIloscMiejsc()) {
							if(porownaj(pojazdy[i].getSortNazwa() ,pojazdy[j].getSortNazwa()) > 0) {
								zamien(pojazdy, i, j);
							}
						}
					}
				}
			}
		}
		
	}
	
	public static void drukuj(PojazdMechaniczny pojazdy[]) {
		for(int j = 0; j<100; j++) {
			System.out.println(pojazdy[j]);
		}
	}
	
	public static int dajMniejsza(int a, int b) {
		if(a>b) {
			return b;
		} else if(a<b) {
			return a;
		} else {
			return a;
		}
	}

}



class Silnik {
	
	private int moc;
	private long pojemnosc;
	
	public Silnik(int moc, long poj) {
		this.moc = moc;
		this.pojemnosc = poj;
	}
	
	public int getMoc() {
		return this.moc;
	}
	
	public long getPojemnosc() {
		return this.pojemnosc;
	}
	
	@Override 
	public String toString() {
		return " | MOC SILNIKA: " + this.moc + "KM " + " | POJEMNOSC: " + this.pojemnosc + "cm3 ";
	}
}

class PojazdMechaniczny {
	private char sortNazwa[];
	private String nazwa;
	private Silnik silnik;
	private int iloscMiejsc;
	
	
	public PojazdMechaniczny(char nazwa[], Silnik silnik, int miejsca) {
		this.sortNazwa = nazwa;
		this.nazwa = new String(nazwa);
		this.silnik = silnik;
		this.iloscMiejsc = miejsca;
	}
	
	public char[] getSortNazwa() {
		return this.sortNazwa;
	}
	
	public String getNazwa() {
		return this.nazwa;
	}
	
	public int getIloscMiejsc() {
		return this.iloscMiejsc;
	}
	
	public int getMoc() {
		return this.silnik.getMoc();
	}
	
	public long getPojemnosc() {
		return this.silnik.getPojemnosc();
	}
	
	@Override 
	public String toString() {
		return "Marka: " + nazwa + this.silnik.toString() + " | Ilosc miejsc: " + this.iloscMiejsc;
	}

}
