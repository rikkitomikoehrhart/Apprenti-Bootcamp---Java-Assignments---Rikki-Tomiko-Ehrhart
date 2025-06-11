public class Video extends Media {
    private int duration;
    private String resolution;

    public int getDuration() {
        return this.duration;
    }

    public String getResolution() {
        return this.resolution;
    }


    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }


    @Override
    void play() {
        System.out.println("Playing video '" + this.getName() + "' using video player software");
    }

    @Override
    String getDescription() {
        return "\tName:\t\t\t" + this.getName() + "\n\tDuration:\t\t" + this.duration + "\n\tResolution:\t\t" + this.resolution;
    }

}
