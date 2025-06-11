public class Audio extends Media {
    private int duration;
    private String artist;


    // GETS
    public int getDuration() {
        return duration;
    }

    public String getArtist() {
        return artist;
    }


    // SETS
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }


    // ABSTRACTS
    @Override
    void play() {
        System.out.println("Playing audio '" + this.getName() + "' using audio player software");
    }

    @Override
    String getDescription() {
        return "\tName:\t\t\t" + this.getName() + "\n\tDuration:\t\t" + this.duration + "\n\tArtist:\t\t" + this.artist;
    }
}
