package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
	public static Collection<Movie> movies = new ArrayList<Movie>();

	public static void main(String[] args) throws IOException {
		listCmds();
		loadIn();
		readIn();
		

	}

	private static void loadIn() throws IOException {
		try {
			FileReader fr = new FileReader("Movies.txt");
			BufferedReader br = new BufferedReader(fr);
			while (true) {
				String l = br.readLine();
				if (l == null)
					break;
				String[] line = l.split(",");
				if (line.length == 6)
					movies.add(new Movie(line[0], line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]),
							Integer.parseInt(line[4]), Boolean.parseBoolean(line[5])));
				if (line.length == 7)
					movies.add(new Documentary(line[0], line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]),
							Integer.parseInt(line[4]), Boolean.parseBoolean(line[5]), line[6]));
				if (line.length == 8)
					movies.add((new Series(line[0], line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]),
							Integer.parseInt(line[4]), Boolean.parseBoolean(line[5]), Integer.parseInt(line[6]),
							Integer.parseInt(line[7]))));
			}
			fr.close();
		}catch (IOException e) {
			//ha m�g nem l�tezik a f�jl, ne dobjon hib�t.
		}
	}

	private static void listCmds() {
		System.out.println("Filmt�r");
		System.out.println("haszn�lhat� parancsok:");
		System.out.println("\tadd + a film/sorozat adatai: a be�rt adatokkal �j rekord hozz�ad�sa a list�hoz");
		System.out.println("\tlist: az elt�rolt filmek/sorozatok ki�r�sa");
		System.out.println(
				"\tsearch + a keres�s t�pusa + a keresett elem, ha nem ad meg t�pust akkor c�m szerinti keres�s");
		System.out.println("\tseen + a film c�me: ha az adott film a list�ban van, megtekintett� �ll�thatjuk");
		System.out.println("\tsave: a lista ment�se f�jlba �r�ssal");
	}

	private static void readIn() throws IOException {
		String[] line;
		Scanner input = new Scanner(System.in);
		while (true) {
			line = input.nextLine().split(",");
			if (line[0].equals("exit"))
				break;
			else
				movies = Commands.cmd(line, movies);
		}

	}
}
