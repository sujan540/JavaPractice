package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EOF {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		List<String> inputs = new ArrayList<>();
		while (scan.hasNext()) {
			String line = scan.nextLine();
			inputs.add(line);

			if (line.contains("end-of-file"))
				break;

		}

		for (int i = 1; i <= inputs.size(); i++) {
			System.out.println(i + " " + inputs.get(i - 1));
		}

	}
}