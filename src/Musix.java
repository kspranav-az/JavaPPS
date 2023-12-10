import java.util.Arrays;
import java.util.Scanner;

class Musix {
    private String albumName;
    private String[] songs;
    private String composer;
    private double rating;

    public Musix() {
        // Default constructor
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Album Name: ");
        this.albumName = scanner.nextLine();

        System.out.print("Enter Composer: ");
        this.composer = scanner.nextLine();

        System.out.print("Enter Rating (out of 5): ");
        this.rating = scanner.nextDouble();

        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter number of songs: ");
        int numSongs = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        this.songs = new String[numSongs];
        for (int i = 0; i < numSongs; i++) {
            System.out.print("Enter Song " + (i + 1) + ": ");
            this.songs[i] = scanner.nextLine();
        }
    }

    public void display() {
        System.out.println("Album Name: " + albumName);
        System.out.println("Composer: " + composer);
        System.out.println("Rating: " + rating);
        System.out.println("Songs: " + Arrays.toString(songs));
        System.out.println();
    }

    public boolean search(String keyword) {
        for (String song : songs) {
            if (song.contains(keyword) || albumName.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSameComposer(String otherComposer) {
        return composer.equalsIgnoreCase(otherComposer);
    }

    public static void sortByRating(Musix[] albums) {
        Arrays.sort(albums, (a1, a2) -> Double.compare(a2.rating, a1.rating));
    }

    public static void popularAlbums(Musix[] albums) {
        System.out.println("Popular Albums (Rating > 4):");
        for (Musix album : albums) {
            if (album.rating > 4.0) {
                album.display();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of albums: ");
        int n = scanner.nextInt();

        Musix[] albums = new Musix[n];

        for (int i = 0; i < n; i++) {
            albums[i] = new Musix();
            System.out.println("Enter details for Album " + (i + 1) + ":");
            albums[i].read();
        }

        System.out.println("\nAlbums Information:");
        for (Musix album : albums) {
            album.display();
        }

        System.out.print("Enter a keyword to search for a song or album: ");
        String searchKeyword = scanner.nextLine();

        System.out.println("Search Results:");
        for (Musix album : albums) {
            if (album.search(searchKeyword)) {
                album.display();
            }
        }

        System.out.print("Enter a composer to find similar songs: ");
        String composerToSearch = scanner.next();

        System.out.println("Similar Songs by " + composerToSearch + ":");
        for (Musix album : albums) {
            if (album.isSameComposer(composerToSearch)) {
                album.display();
            }
        }

        sortByRating(albums);

        System.out.println("Albums sorted by Rating:");
        for (Musix album : albums) {
            album.display();
        }

        popularAlbums(albums);

        scanner.close();
    }
}
