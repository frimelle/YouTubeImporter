package api;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.joda.time.DateTime;

public class YouTubePlaylist {

    static final String URL_PREFIX = "https://www.youtube.com/playlist?list=";

    private String id;
    private Snippet snippet;
    private Collection<YouTubePlaylistItems> playListItems = new ArrayList<YouTubePlaylistItems>();
    private Collection<YouTubeVideo> videos;

    public String getId() {
        return id;
    }

    public Collection<String> getVideoIds() {
        Collection<String> videoIds = new ArrayList<String>();
        for (YouTubePlaylistItems playListItemsCollection : this.playListItems) {
            videoIds.addAll(playListItemsCollection.getVideoIds());
        }
        return videoIds;
    }

    public void addPlayListItems(YouTubePlaylistItems playListItems) {
        this.playListItems.add(playListItems);
    }

    public void addPlayListItems(Collection<YouTubePlaylistItems> playListItems) {
        this.playListItems.addAll(playListItems);
    }

    public String getThumbnailUrl() {
        if (snippet != null) {
            return snippet.getThumbnailUrl();
        } else {
            return null;
        }
    }

    public String getChannelId() {
        if (snippet != null) {
            return snippet.getChannelId();
        } else {
            return null;
        }
    }

    public String getTitle() {
        if (snippet != null) {
            return snippet.getTitle();
        } else {
            return null;
        }
    }

    public String getDescription() {
        if (snippet != null) {
            return snippet.getDescription();
        } else {
            return null;
        }
    }

    public String getChannelTitle() {
        if (snippet != null) {
            return snippet.getChannelTitle();
        } else {
            return null;
        }
    }

    public String getUrl() {
        if (getId() != null) {
            return URL_PREFIX + getId();
        } else {
            return null;
        }
    }

    /**
     * @return String Formatted representation of published date
     */
    public String getPublishedAt() {
        if (snippet != null) {
            Date date = new Date(snippet.getPublishedAt());
            Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.format(date);
        } else {
            return null;
        }
    }

    public long getPublishedAtTimestamp() {
        if (snippet != null) {
            return snippet.getPublishedAt();
        } else {
            return 0;
        }
    }

    public void addYouTubeVideo(YouTubeVideo video) {
        videos.add(video);
    }

    public Collection<YouTubeVideo> getVideos() {
        return videos;
    }

    /**
     * Snippet sub class for YouTubePlaylist Used to easily parse data with GSON
     */
    private static class Snippet {

        private String channelId;
        private String channelTitle;
        private String title;
        private String description;
        private String publishedAt;

        public String getChannelId() {
            return channelId;
        }

        public String getChannelTitle() {
            return channelTitle;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        private Thumbnails thumbnails;

        public long getPublishedAt() {
            if (publishedAt != null) {
                try {
                    DateTime dt = new DateTime(publishedAt);
                    return dt.getMillis();
                } catch (Exception e) {
                    return 0;
                }
            }
            return 0;
        }

        /**
         * @return String Thumbnail with the highest resolution available
         */
        private String getThumbnailUrl() {
            if (thumbnails == null) {
                return null;
            } else if (thumbnails.getMaxres() != null) {
                return thumbnails.getMaxres().getUrl();
            } else if (thumbnails.getStandard() != null) {
                return thumbnails.getStandard().getUrl();
            } else if (thumbnails.getHigh() != null) {
                return thumbnails.getHigh().getUrl();
            } else if (thumbnails.getMedium() != null) {
                return thumbnails.getMedium().getUrl();
            } else {
                return null;
            }
        }
    }

}
