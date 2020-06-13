import java.util.ArrayList;
import java.util.*;
import java.util.List;
public class Main{
	public static void main(String[] args) {
		MessWerte messwerte = new MessWerte();
		System.out.println("median ist : " + messwerte.median());
		System.out.println("max ist : " + messwerte.max());
		System.out.println("min ist : " + messwerte.min());
		System.out.println("mittelwert ist : " + messwerte.mittelwert());
		System.out.println("stabw ist : " + messwerte.stabw());
		System.out.println("absFehler ist : " + messwerte.absFehler());

	}

}

class MessWerte {
	private final double ANZAHL_MESSWERTE = 100;
	private double[] messwerte = new double [(int) ANZAHL_MESSWERTE];
	private List<Double> inOrdnung = new ArrayList<Double>();
	MessWerte() {
		for (int i = 0; i < ANZAHL_MESSWERTE; i++) {
			messwerte[i] = Math.random();
			inOrdnung.add(messwerte[i]);
		}
		Collections.sort(inOrdnung);
	}

	public double mittelwert () {
		double sum = 0;
		for ( int i = 0; i < ANZAHL_MESSWERTE; i++) {
			sum += messwerte[i];
		}
		return (sum / ANZAHL_MESSWERTE);
	}
	public double min() {
		return inOrdnung.get(0);
	}
	public double max() {
		return inOrdnung.get(((int) ANZAHL_MESSWERTE) - 1);
	}
	public double median() {
		return (inOrdnung.get(((int)ANZAHL_MESSWERTE) / 2) + inOrdnung.get((int)ANZAHL_MESSWERTE / 2 + 1)) / 2;
	}
	public double stabw() {
		double sum = 0;
		double mitt = mittelwert();
		double[] numbers = new double[(int)ANZAHL_MESSWERTE];
		for (int i = 0; i < ANZAHL_MESSWERTE; i++) {
			numbers[i] = (messwerte[i] - mittelwert()) * (messwerte[i] - mittelwert());
			sum += numbers[i];
		}
		return  Math.sqrt(1 / (( ANZAHL_MESSWERTE -1)) * sum);
	}
	public double absFehler() {
		return (stabw() / Math.sqrt(ANZAHL_MESSWERTE));
	}
}














