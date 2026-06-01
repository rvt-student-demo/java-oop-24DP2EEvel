package rvt.Studentu_Registracija;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FailuApstradataajs {
    private static final String FILE_NAME = "studenti.csv";

    public static void saglabatFaila(List<Studentu> studenti) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Studentu s : studenti) {
                writer.println(s.toCsvRow());
            }
        } catch (IOException e) {
            System.out.println("Kļūda, saglabājot datus failā: " + e.getMessage());
        }
    }

    public static List<Studentu> ieladetNoFaila() {
        List<Studentu> studenti = new ArrayList<>();
        File fails = new File(FILE_NAME);

        if (!fails.exists()) {
            return studenti;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String rinda;
            while ((rinda = reader.readLine()) != null) {
                if (rinda.trim().isEmpty())
                    continue;

                String[] dati = rinda.split(",");
                if (dati.length == 5) {
                    String vards = dati[0];
                    String uzvards = dati[1];
                    String epasts = dati[2];
                    String personasKods = dati[3];
                    String registracijasLaiks = dati[4];

                    Studentu students = new Studentu(vards, uzvards, epasts, personasKods, registracijasLaiks);
                    studenti.add(students);
                }
            }
        } catch (IOException e) {
            System.out.println("Kļūda, lasot datus no faila: " + e.getMessage());
        }
        return studenti;
    }
}
