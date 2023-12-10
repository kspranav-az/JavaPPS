class Film {
    protected String title;
    protected String lang;
    protected String actor;
    protected String category;
    protected int duration;

    public Film() {
        // Default constructor
    }

    public Film(String title, String lang, String actor, String category, int duration) {
        this.title = title;
        this.lang = lang;
        this.actor = actor;
        this.category = category;
        this.duration = duration;
    }

    public static void englishArnold(Film[] films) {
        int shortestDuration = Integer.MAX_VALUE;
        Film shortestFilm = null;

        for (Film film : films) {
            if (film.lang.equalsIgnoreCase("English") && film.actor.equalsIgnoreCase("Arnold")) {
                if (film.duration < shortestDuration) {
                    shortestDuration = film.duration;
                    shortestFilm = film;
                }
            }
        }

        if (shortestFilm != null) {
            System.out.println("English film(s) with Arnold as lead actor and shortest duration:");
            System.out.println("Title: " + shortestFilm.title);
            System.out.println("Duration: " + shortestFilm.duration + " minutes");
        } else {
            System.out.println("No English film found with Arnold as lead actor.");
        }
    }

    public static void tamilRajini(Film[] films) {
        System.out.println("Tamil film(s) with Rajini as lead actor:");
        for (Film film : films) {
            if (film.lang.equalsIgnoreCase("Tamil") && film.actor.equalsIgnoreCase("Rajini")) {
                System.out.println("Title: " + film.title);
            }
        }
    }

    public static void comedyFilms(Film[] films) {
        System.out.println("All comedy movies:");
        for (Film film : films) {
            if (film.category.equalsIgnoreCase("Comedy")) {
                System.out.println("Title: " + film.title);
            }
        }
    }
}

public class FilmMain {
    public static void main(String[] args) {
        Film[] films = new Film[10]; // Create an array of Film objects

        films[0] = new Film("Terminator", "English", "Arnold", "Action", 120);
        films[1] = new Film("Sivaji", "Tamil", "Rajini", "Comedy", 150);
        films[2] = new Film("The Dark Knight", "English", "Christian", "Action", 152);
        films[3] = new Film("Mersal", "Tamil", "Vijay", "Action", 169);
        films[4] = new Film("Hera Pheri", "Hindi", "Akshay", "Comedy", 136);
        films[5] = new Film("Inception", "English", "Leonar", "SciFi", 148);
        films[6] = new Film("Kabali", "Tamil", "Rajini", "Drama", 153);
        films[7] = new Film("Golmaal", "Hindi", "Ajay", "Comedy", 140);
        films[8] = new Film("The Matrix", "English", "Keanu", "SciFi", 136);
        films[9] = new Film("Bahubali", "Telug", "Prabha", "Action", 159);

        Film.englishArnold(films);
        Film.tamilRajini(films);
        Film.comedyFilms(films);
    }
}
