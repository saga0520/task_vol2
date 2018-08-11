import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 世界都市の時差を求めるクラス
 * @author saga
 * @version 1.0
 */
public class TimeDifference {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> ary = new ArrayList<>();
		//表示する都市数の変数number_of_citesを用意
		int number_of_cites = 0;
		try {
			number_of_cites = sc.nextInt();
			for (int i = 0; i < number_of_cites + 1; i++) {
				if (number_of_cites >= 1 && 100 >= number_of_cites) {
					Scanner sr = new Scanner(System.in);
					String line = sr.nextLine();
					//都市名と時差を半角スペースで区切って配列に分割する
					String[] strs = line.split(" ");
					for (String s : strs) {
						ary.add(s);
					}
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("上限を超えています");
		}
		//各都市の時差を出力するメソッドを呼び出す
		city(ary, number_of_cites);
	}

	/**
	 * 各都市の時差を出力するメソッド
	 * @param aryCts 入力都市と時差
	 * @param cts 表示都市の数
	 */
	public static void city(ArrayList<String> aryCts, int cts) {
		//表示時刻の形式をHH:mmとする
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		Calendar cal = Calendar.getInstance();
		System.out.println();
		System.out.println(cts);
		try {
			for (int n = 0; n < cts; n++) {
				if (n < cts) {
					//各都市の時差をセット
					String time = aryCts.get(n * 2 + 1);
					int numtime = Integer.parseInt(time);
					//基準都市の時刻をセット
					String tm = aryCts.get(cts * 2 + 1);
					try {
						Date date = df.parse(tm);
						cal.setTime(date);
						//時差を加算、減算して各都市の時刻を求める
						cal.add(cal.HOUR_OF_DAY, numtime);
					} catch (ParseException e) {
						System.out.print("\n" + "入力時刻が不適切です");
						break;
					}
				}
				if (n > 0) {
					//二番目以降に入力した都市と時刻を出力
					System.out.print("\n");
					System.out.print(aryCts.get(n + n) + " " + df.format(cal.getTime()));
				} else {
					//最初に入力した都市と時刻を出力
					System.out.print(aryCts.get(n) + " " + df.format(cal.getTime()));
				}
			}
		} catch (Exception e) {
			System.out.println("\n" + "入力が不適切です");
		}
	}
}
