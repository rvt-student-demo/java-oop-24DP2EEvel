package rvt.Studentu_Registracija;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Studentu> studenti = FailuApstradataajs.ieladetNoFaila();
        while (true) {
            System.out.println("\n--- STUDENTU REGISTRACIJAS SISTEMA ---");
            System.out.println("Izvelieties darbibu (register, show, remove, edit, exit): ");
            System.out.print("Darbiba: ");
            String izvele = scanner.nextLine().trim().toLowerCase();

            if (izvele.equals("register")) {
                izpilditRegistraciju(scanner, studenti);
            } else if (izvele.equals("show")) {
                raditStudentus(studenti);
            } else if (izvele.equals("remove")) {
                dzestStudentu(scanner, studenti);
            } else if (izvele.equals("edit")) {
                redigetStudentu(scanner, studenti);
            } else if (izvele.equals("exit")) {
                break;
            } else {
                System.out.println("Kļūda: Nepareiza komanda. Komandu nosaukiem jābūt precīziem.");
            }
        }
        scanner.close();
    }

    private static void izpilditRegistraciju(Scanner scanner, List<Studentu> studenti) {
        System.out.print("Vārds: ");
        String vards = scanner.nextLine().trim();
        if (!Parbauditajs.irPareizsVards(vards)) {
            System.out.println("Kļūda: Nederīgs vārds!");
            return;
        }

        System.out.print("Uzvārds: ");
        String uzvards = scanner.nextLine().trim();
        if (!Parbauditajs.irPareizsVards(uzvards)) {
            System.out.println("Kļūda: Nederīgs uzvārds!");
            return;
        }

        System.out.print("E-pasts: ");
        String epasts = scanner.nextLine().trim();
        if (!Parbauditajs.irPareizsEpasts(epasts)) {
            System.out.println("Kļūda: Neatbilstošs epasta formats.");
            return;
        }
        if (Parbauditajs.vaiEpastsEksiste(epasts, studenti)) {
            System.out.println("Kļūda: E-pasts jau aizņemts!");
            return;
        }

        System.out.print("Personas kods: ");
        String pk = scanner.nextLine().trim();
        if (!Parbauditajs.irPareizsPersonasKods(pk)) {
            System.out.println("Kļūda: Nepareizs personas kods!");
            return;
        }
        if (Parbauditajs.vaiPersonasKodsEksiste(pk, studenti)) {
            System.out.println("Kļūda: Personas kods jau eksistē!");
            return;
        }

        String regLaiks = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        studenti.add(new Studentu(vards, uzvards, epasts, pk, regLaiks));
        FailuApstradataajs.saglabatFaila(studenti);
        System.out.println("Reģistrēts!");
    }

    private static void raditStudentus(List<Studentu> studenti) {
        if (studenti.isEmpty()) {
            System.out.println("Atrasti 0 lietotaji.");
            return;
        }
        System.out.println(
                "\n=====================================================================================================");
        System.out.printf("| %-15s | %-15s | %-25s | %-15s | %-20s |\n", "VARDS", "UZVARDS", "E-PASTS", "PERSONAS KODS",
                "REGISTRACIJAS LAIKS");
        System.out.println(
                "=====================================================================================================");
        for (Studentu s : studenti) {
            System.out.printf("| %-15s | %-15s | %-25s | %-15s | %-20s |\n", s.getVards(), s.getUzvards(),
                    s.getEpasts(), s.getPersonasKods(), s.getRegistracijasLaiks());
        }
        System.out.println(
                "=====================================================================================================");
    }

    private static void dzestStudentu(Scanner scanner, List<Studentu> studenti) {
        System.out.print("Ievadiet dzēšamā studenta personas kodu: ");
        String pk = scanner.nextLine().trim();
        for (int i = 0; i < studenti.size(); i++) {
            if (studenti.get(i).getPersonasKods().equals(pk)) {
                studenti.remove(i);
                FailuApstradataajs.saglabatFaila(studenti);
                System.out.println("Izdzests!");
                return;
            }
        }
        System.out.println("Netika atrasts!");
    }

    private static void redigetStudentu(Scanner scanner, List<Studentu> studenti) {
        System.out.print("Ievadiet studenta personsas kodu rediģēšānai: ");
        String pk = scanner.nextLine().trim();
        for (Studentu s : studenti) {
            if (s.getPersonasKods().equals(pk)) {
                System.out.print("Jaunais vārds (vai Enter): ");
                String v = scanner.nextLine().trim();
                if (!v.isEmpty() && Parbauditajs.irPareizsVards(v))
                    s.setVards(v);

                System.out.print("Jaunais uzvārds (vai Enter): ");
                String u = scanner.nextLine().trim();
                if (!u.isEmpty() && Parbauditajs.irPareizsVards(u))
                    s.setUzvards(u);

                System.out.print("Jaunais e-pasts (vai Enter): ");
                String e = scanner.nextLine().trim();
                if (!e.isEmpty() && Parbauditajs.irPareizsEpasts(e) && !Parbauditajs.vaiEpastsEksiste(e, studenti))
                    s.setEpasts(e);

                FailuApstradataajs.saglabatFaila(studenti);
                System.out.println("Atjauninats!");
                return;
            }
        }
        System.out.println("Netika atrasts!");
    }
}
