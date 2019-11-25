import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

class Main
{
	public static void main ( String [] args )
	{
		try {
			File file = new File(args[0]);
			Scanner sc = new Scanner(file).useDelimiter("[^\\p{Alpha}]+");

			ArrayList<String> s = new ArrayList<String>();

			while (sc.hasNext()) {
				String temp = sc.next();
				s.add(temp);
			}

			int max_diff = 0;
			ArrayList<String> answer = new ArrayList<String>();

			for (int i = 0; i < s.size(); i++) {
				for (int j = i; j < s.size(); j++) {
					int d = diff(s.get(i), s.get(j));
					if (d > max_diff) {
						answer.clear();
						max_diff = d;
					}
					if (d == max_diff) {
						answer.add(s.get(i));
						answer.add(s.get(j));
					}
				}
			}

			System.out.print(answer.toString());

			sc.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File is not found.");
		}
	}

	public static int diff (String a, String b) {
		int answer = 0;
		for (int i = (a.length() < b.length() ? a.length() : b.length()) - 1; i >= 0; i--) {
			answer += a.charAt(i) == b.charAt(i) ? 0 : 1;
		}
		return answer;
	}
}