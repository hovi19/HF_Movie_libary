package src;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class Commands {
	public static Collection<Movie> cmd(String[] cmd, Collection<Movie> movies) throws IOException {
		if (cmd[0].equals("add"))
			cmdAdd(cmd, movies);
		else if (cmd[0].equals("list"))
			cmdList(cmd, movies);
		else if (cmd[0].equals("search"))
			cmdSearch(cmd, movies);
		else if (cmd[0].equals("seen"))
			cmdSeen(cmd, movies);
		else if (cmd[0].equals("save"))
			cdmSave(movies);
		return movies;
	}

	private static void cmdAdd(String[] cmd, Collection<Movie> movies) {
		try {
			if (cmd.length == 7)
				movies.add(new Movie(cmd[1], cmd[2], Integer.parseInt(cmd[3]), Integer.parseInt(cmd[4]),
						Integer.parseInt(cmd[5]), Boolean.parseBoolean(cmd[6])));
			if (cmd.length == 8)
				movies.add(new Documentary(cmd[1], cmd[2], Integer.parseInt(cmd[3]), Integer.parseInt(cmd[4]),
						Integer.parseInt(cmd[5]), Boolean.parseBoolean(cmd[6]), cmd[7]));
			if (cmd.length == 9)
				movies.add((new Series(cmd[1], cmd[2], Integer.parseInt(cmd[3]), Integer.parseInt(cmd[4]),
						Integer.parseInt(cmd[5]), Boolean.parseBoolean(cmd[6]), Integer.parseInt(cmd[7]),
						Integer.parseInt(cmd[8]))));
			System.out.println("Sikeres hozzáadás!");
		} catch (Exception e) {
			System.out.println("hibás input");
			System.out.println(e);
		}
	}

	private static void cmdList(String[] cmd, Collection<Movie> movies) {

		try {
			if (cmd[1].equals("Series")) {
				movies.forEach((n) -> {
					if (n instanceof Series) {
						System.out.println(n);
					}
				});
			}
			if (cmd[1].equals("Movie")) {
				movies.forEach((n) -> {
					if (n instanceof Movie) {
						System.out.println(n);
					}
				});
			}
			if (cmd[1].equals("Documentary")) {
				movies.forEach((n) -> {
					if (n instanceof Documentary) {
						System.out.println(n);
					}
				});
			}
			if (cmd[1].equals("seen")) {
				movies.forEach((n) -> {
					if (n.isSeen()) {
						System.out.println(n);
					}
				});
			}
			if (cmd[1].equals("not seen")) {
				movies.forEach((n) -> {
					if (!n.isSeen()) {
						System.out.println(n);
					}
				});
			}
		} catch (Exception e) {
			movies.forEach((n) -> {
				System.out.println(n);
			});

		}

	}

	
	private static void cmdSearch(String[] cmd, Collection<Movie> movies) {
		try{
			if(cmd[1].equals("genre")) {
				movies.forEach(n ->{
					if(n.getGenre().contains(cmd[2])) {
						System.out.println(n);
					}
				});
			}
			if(cmd[1].equals("ageRating")) {
				movies.forEach(n ->{
					if(n.getAgeRating()<= Integer.parseInt(cmd[2])) {
						System.out.println(n);
					}
				});
			}
			else {
				movies.forEach(n ->{
					if(n.getTitle().toLowerCase().contains(cmd[1].toLowerCase())) {
						System.out.println(n);
					}
				});
			}	
		}
		catch(Exception e) {
			System.out.println("hibás keresés");
		}
	}

	private static void cmdSeen(String[] cmd, Collection<Movie> movies) {
		movies.forEach(n ->{
			if(n.getTitle().toLowerCase().contains(cmd[1].toLowerCase())) {
				n.setSeen(true);
				System.out.println(n.getTitle() + " megtekintve");
			}
		});

	}

	private static void cdmSave(Collection<Movie> movies) throws IOException {
		FileWriter fw = new FileWriter("Movies.txt");
		PrintWriter pw = new PrintWriter(fw);
		movies.forEach((n) -> {
			pw.println(n);
		});
		pw.close();
	}
}
