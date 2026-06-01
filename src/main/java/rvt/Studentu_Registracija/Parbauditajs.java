package rvt.Studentu_Registracija;

import java.util.List;

public class Parbauditajs {

    public static boolean irPareizsVards(String teksts) {
        return teksts.matches("^[a-zA-ZāčēģīķļņōŗšūžĀČĒĢĪĶĻŅŌŖŠŪŽ]{3,}$");
    }

    public static boolean irPareizsEpasts(String epasts) {
        return epasts.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    }

    public static boolean irPareizsPersonasKods(String pk) {
        return pk.matches("^\\d{6}-\\d{5}$");
    }

    public static boolean vaiPersonasKodsEksiste(String pk, List<Studentu> studenti) {
        for (Studentu s : studenti) {
            if (s.getPersonasKods().equals(pk)) {
                return true;
            }
        }
        return false;
    }

    public static boolean vaiEpastsEksiste(String epasts, List<Studentu> studenti) {
        for (Studentu s : studenti) {
            if (s.getEpasts().equalsIgnoreCase(epasts)) {
                return true;
            }
        }
        return false;
    }
}
