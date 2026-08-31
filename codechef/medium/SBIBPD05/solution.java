import java.util.ArrayList;

class Codechef {
    public static void main(String[] args) {

        // 1. Create an ArrayList
        ArrayList<String> playlist = new ArrayList<>();

        // 2. Add three initial songs
        playlist.add("Bohemian Rhapsody");
        playlist.add("Imagine");
        playlist.add("Stairway to Heaven");

        // 3. Print the initial playlist
        System.out.println("Music Playlist:");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println(i + ": " + playlist.get(i));
        }

        // 4. Insert "Hotel California" at index 1
        playlist.add(1, "Hotel California");

        // 5. Remove the song at index 2
        playlist.remove(2);

        // 6. Print the updated playlist
        System.out.println();
        System.out.println("Updated Music Playlist:");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println(i + ": " + playlist.get(i));
        }
    }
}