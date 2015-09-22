package api;

import java.util.ArrayList;
import java.util.Collection;

public class YouTubePlaylistItems {

    /**
     * If a list contains more results than "resultsPerPage", a nextPageToken is
     * provided until the end of the playlist has been reached
     */
    private String nextPageToken;

    /**
     * Collection of items holding a video id
     */
    private Collection<Items> items;

    public Collection<String> getVideoIds() {
        Collection<String> videoCollection = new ArrayList<String>();
        for (Items item : items) {
            videoCollection.add(item.getVideoId());
        }
        return videoCollection;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    /**
     * Items sub class for YouTubePlaylistItems Used to easily parse data with GSON
     */
    private static class Items {
        private ContentDetails contentDetails;

        public String getVideoId() {
            if (contentDetails != null) {
                return contentDetails.getVideoId();
            } else {
                return null;
            }
        }

        private static class ContentDetails {
            private String videoId;

            public String getVideoId() {
                return videoId;
            }
        }
    }

}
