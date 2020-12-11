package practice02;

public class CurrencyConverter {
	private static double rate;

	public static double toDallor(double won) {
		// 한국 원화를 달러로 변환
		return won/rate;
	}

	public static double toKWR(double dollar) {
		// 달러를 한국 원화로 변환
		return dollar*rate;
	}

	public static void setRate(double r) {
		// 환율 설정. KWR/$1
		rate = r;		
	}
}
