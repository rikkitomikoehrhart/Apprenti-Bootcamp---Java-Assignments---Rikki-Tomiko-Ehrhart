import java.util.ArrayList;
import java.util.List;

public class MediaService {
    public static ArrayList<Media> mediaList = new ArrayList<>();


    public static void addMedia(Media media) {
        mediaList.add(media);
    }

    public static boolean removeMedia(String name) {
        for (int i = 0; i < getMediaCount(); i++) {
            if(mediaList.get(i).getName() == name) {
                mediaList.remove(i);
                return true;
            }
        }
        return false;
    }

    public static Media findMediaByName(String name) {
        int index = -1;

        for (int i = 0; i < getMediaCount(); i++) {
            if (mediaList.get(i).getName() == name) {
                index = i;
            }
        }

        if (index >= 0) {
            return mediaList.get(index);
        } else {
            return null;
        }
    }

    public static List<Media> getAllMedia() {
        return mediaList;
    }

    public static int getMediaCount() {
        return mediaList.size();
    }

    public static boolean isEmpty() {
        return getMediaCount() == 0 ? true : false;
    }
}
