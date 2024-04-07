import java.util.ArrayList;

interface IBackup{  
    void backup();
}

// Define the base Artist class
class Artist{
    public String name;

    Artist(String name) {    // Create a constructor to set the name
        this.name = name;
    }
    public String  getname(){   // Add a method to get the name
        return name;
    }
}

// Define the MainSinger class, which is a type of Artist
class MainSinger extends Artist{
    MainSinger(String name){     // Create a constructor to set the name
        super(name);
    }
    public void sing(){       // Add a sing method to MainSinger
        System.out.println("Calling the sing() methd in MainSinger class ");
        System.out.println(getname() + " is Singing");
    }
}

// Define the BackupSinger class, which is a type of MainSinger and implements the IBackup interface
class BackupSinger extends MainSinger implements IBackup{

    static  int no_BackupSinger;   // Add a static counter to keep track of the number of BackupSingers

    BackupSinger(String name) {    // Create a constructor to set the name and increment the counter
        super(name);
        no_BackupSinger++;
    }


    public void backup(){       // Implement the backup method from the IBackup interface
        System.out.println("Calling the backup() method in BackupSinger class");
        System.out.println("Backup Singer " + getname()+ " is backing up the main artist by singing.");
    }

    public void sing(){       // Override the sing method to include the fact that this is a BackupSinger
        System.out.println("Calling the sing() method in BackupSinger class");
        System.out.println("Backup Singer " + getname() + " is singing.");
    }

    public String toString(){    // Override the toString method to return the name of the BackupSinger
        return this.name;
    }


}

// Define the BackupDancer class, which is a type of Artist and implements the IBackup interface
class BackupDancer extends Artist implements IBackup{
    static  int no_BackupDancer;   // Add a static counter to keep track of the number of BackupDancers

    BackupDancer(String name) {    // Create a constructor to set the name and increment the counter
        super(name);
        no_BackupDancer++;

    }

    public void backup(){      // Implement the backup method from the IBackup interface
        System.out.println("Calling the backup() method in BackupDancer class");
        System.out.println("Backup dancer " + getname() + " is backing up the main artist by dancing.");
    }
    public String toString(){    // Override the toString method to return the name of the BackupDancer
        return this.name;
    }


}

class MusicTrack {    // Define the MusicTrack class
    private String name;
    private int duration;

    public MusicTrack(String name, int duration) {      // Create a constructor to set the name and duration
        this.name = name;
        this.duration = duration;
    }

    public String getName() {   // Add a method to get the name of the track
        return name;
    }

    public int getDuration() {     // Add a method to get the duration of the track
        return duration;
    }
}

abstract class Performance {      // Define the abstract Performance class
    private String mainArtist;
    private String performanceName;
    private final int year;
    private final String venue;
    private ArrayList<MusicTrack> trackList;
    private ArrayList<BackupSinger> backupSingers;
    private ArrayList<BackupDancer> backupDancers;



    // Create a constructor to set the main artist, performance name, year, venue, track list, backup singers, and backup dancers
    public Performance(String mainArtist, String performanceName, int year, String venue, ArrayList<MusicTrack> trackList, ArrayList<BackupSinger> backupSingers, ArrayList<BackupDancer> backupDancers) {
        this.mainArtist = mainArtist;
        this.performanceName = performanceName;
        this.year = year;
        this.venue = venue;
        this.trackList = new ArrayList<>();
        this.backupSingers = new ArrayList<>();
        this.backupDancers = new ArrayList<>();


        // Print a welcome message and list the backup singers and dancers

        System.out.println("Welcome to the Performance " + this.performanceName + " by " + this.mainArtist + "!");
        System.out.println(mainArtist + " Sings");
        for(int i = 0; i < backupSingers.size(); i++ ){
            backupSingers.get(i).sing();
            backupSingers.get(i).backup();
            System.out.println(backupSingers.get(i) + " is backing her up by singing ");
        }
        for(int i = 0; i < backupDancers.size(); i++ ){
            backupDancers.get(i).backup();
            System.out.println(backupDancers.get(i) + " is backing her up by dancing ");
        }

    }


    // Define the setters and getters for the class variables
    public void setMainArtist(String mainArtist) {
        this.mainArtist = mainArtist;
    }

    public String getMainArtist() {
        return mainArtist;
    }

    public String getPerformanceName() {
        return performanceName;
    }

    public void setPerformanceName(String performanceName) {
        this.performanceName = performanceName;
    }


    public int getYear() {
        return year;
    }


    public String getVenue() {
        return venue;

    }

    public void setTrackList(ArrayList<MusicTrack> trackList) {
        this.trackList = trackList;
    }

    public ArrayList<MusicTrack> getTrackList() {
        return trackList;
    }

    public void setBackupSingers(ArrayList<BackupSinger> backupSingers) {
        this.backupSingers = backupSingers;
    }

    public ArrayList<BackupSinger> getBackupSingers() {
        return this.backupSingers;
    }

    public void setBackupDancers(ArrayList<BackupDancer> backupDancers) {
        this.backupDancers = backupDancers;
    }

    public ArrayList<BackupDancer> getbackupDancers() {
        return backupDancers;
    }

    public abstract void recording();    // Define an abstract recording method


}


// Define the LivePerformance class that extends the Performance class
class LivePerformance extends Performance {

    // Define the constructor for the LivePerformance class
    public LivePerformance(String mainArtist, String performanceName, int year, String venue, ArrayList<MusicTrack> trackList, ArrayList<BackupSinger> backupSingers, ArrayList<BackupDancer> backupDancers) {
        super(mainArtist, performanceName, year, venue, trackList, backupSingers, backupDancers);
        // Call the superclass constructor to set the class variables
    }

    public void interaction() {     // Define a method for LivePerformance called interaction
        System.out.println("Artist is interacting with audience");
    }

    public void recording() {      // Define a method for LivePerformance called recording
        System.out.println("This is a Live Recording");
    }




}

// Define a class Studioperformances which extends the Performance class
class Studioperformances extends Performance {


    // Define the constructor for the Studioperformances class
    public Studioperformances(String mainArtist, String performanceName, int year, String venue, ArrayList<MusicTrack> trackList, ArrayList<BackupSinger> backupSingers, ArrayList<BackupDancer> backupDancers) {
        super(mainArtist, performanceName, year, venue, trackList, backupSingers, backupDancers);
    }

    public void recording() {      // Define a method for Studioperformances called recording
        System.out.println("This is a Studio Recording");
    }

    public void AudioProcess() {     // Define a method for Studioperformances called AudioProcess
        System.out.println("Audio is processing in studio");

    }

}

// Define a public class called musicale to innitiate the consert
public class musicale {
    public static void main(String[] args) {

        // Create  ArrayLists of BackupSinger objects called backupSingers,BackupDancer objects called backupDancers,MusicTrack objects called trackList
        ArrayList<BackupSinger> backupSingers = new ArrayList<BackupSinger>();
        ArrayList<BackupDancer> backupDancers = new ArrayList<BackupDancer>();
        ArrayList<MusicTrack> trackList = new ArrayList<MusicTrack>();

        // Create two BackupSinger objects and add them to the backupSingers ArrayList
        backupSingers.add(new BackupSinger("Jeslyn"));
        backupSingers.add(new BackupSinger("Melanie"));



        // Create two BackupDancer objects and add them to the backupDancers ArrayList
        backupDancers.add(new BackupDancer("Stephanie"));
        backupDancers.add(new BackupDancer("Jake"));


        // Create an ArrayList of MusicTrack objects called trackList
        trackList.add(new MusicTrack("Lavender Haze", 5));
        trackList.add(new MusicTrack("All Too Well", 10));
        trackList.add(new MusicTrack("the lakes", 15));
        trackList.add(new MusicTrack("The Man", 20));
        trackList.add(new MusicTrack("Love Story", 25));

        // Create a LivePerformance object called show
        LivePerformance show = new LivePerformance("Taylor Swift", "Eras Tour", 2023, "Glendale", trackList, backupSingers, backupDancers);


    }
}
