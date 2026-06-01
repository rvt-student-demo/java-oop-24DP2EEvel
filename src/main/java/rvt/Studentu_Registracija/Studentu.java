package rvt.Studentu_Registracija;

public class Studentu {
    private String vards;
    private String uzvards;
    private String epasts;
    private String personasKods;
    private String registracijasLaiks;

    public Studentu(String vards, String uzvards, String epasts, String personasKods, String registracijasLaiks) {
        this.vards = vards;
        this.uzvards = uzvards;
        this.epasts = epasts;
        this.personasKods = personasKods;
        this.registracijasLaiks = registracijasLaiks;
    }

    public String getVards() { return vards; }
    public String getUzvards() { return uzvards; }
    public String getEpasts() { return epasts; }
    public String getPersonasKods() { return personasKods; }
    public String getRegistracijasLaiks() { return registracijasLaiks; }

    public void setVards(String vards) { this.vards = vards; }
    public void setUzvards(String uzvards) { this.uzvards = uzvards; }
    public void setEpasts(String epasts) { this.epasts = epasts; }

    public String toCsvRow() {
        return vards + "," + uzvards + "," + epasts + "," + personasKods + "," + registracijasLaiks;
    }
}
