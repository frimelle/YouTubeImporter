package api;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.joda.time.DateTime;

/**
 * This class represents YouTube channels which represent user accounts on
 * YouTube
 */
public class YouTubeChannel {

    static final String URL_PREFIX = "https://www.youtube.com/channel/";

    private String id;
    private ContentDetails contentDetails;
    private Snippet snippet;

    private Collection<YouTubePlaylist> playlists;

    public String getId() {
        return id;
    }

    public String getGooglePlusUserId() {
        if (contentDetails != null) {
            return contentDetails.getGooglePlusUserId();
        } else {
            return null;
        }
    }

    /**
     * @return String The ID of the play list containing the videos "liked" by
     *         the channel owner, null if no such play list exists
     */
    public String getLikedVideosPlaylistId() {
        if (contentDetails != null) {
            return contentDetails.getLikedVideos();
        } else {
            return null;
        }
    }

    /**
     * @return String The ID of the play list containing the channel uploads,
     *         null if no such play list exists
     */
    public String getUploadedVideosPlaylistId() {
        if (contentDetails != null) {
            return contentDetails.getUploadedVideos();
        } else {
            return null;
        }
    }

    /**
     * @return String The ID of the play list containing the favorited videos by
     *         the channel owner, null if no such play list exists
     */
    public String getFavoritedVideosPlaylistId() {
        if (contentDetails != null) {
            return contentDetails.getFavoriteVideos();
        } else {
            return null;
        }
    }

    public String getThumbnailUrl() {
        if (snippet != null) {
            return snippet.getThumbnailUrl();
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

    public String getCountryCode() {
        if (snippet != null) {
            return snippet.getCountry();
        } else {
            return null;
        }
    }

    public void addYouTubePlaylist(YouTubePlaylist playlist) {
        playlists.add(playlist);
    }

    public Collection<YouTubePlaylist> getPlaylists() {
        return playlists;
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

    public String getUrl() {
        if (getId() != null) {
            return URL_PREFIX + getId();
        } else {
            return null;
        }
    }

    /**
     * ContentDetails sub class for YouTubeChannel Used to easily parse data
     * with GSON
     */
    private static class ContentDetails {

        private String googlePlusUserId;
        private RelatedPlaylists relatedPlaylists;

        public String getGooglePlusUserId() {
            return googlePlusUserId;
        }

        public String getLikedVideos() {
            if (relatedPlaylists != null) {
                return relatedPlaylists.getLikes();
            } else {
                return null;
            }
        }

        public String getFavoriteVideos() {
            if (relatedPlaylists != null) {
                return relatedPlaylists.getFavorites();
            } else {
                return null;
            }
        }

        public String getUploadedVideos() {
            if (relatedPlaylists != null) {
                return relatedPlaylists.getUploads();
            } else {
                return null;
            }
        }

        /**
         * RelatedPlaylists sub class for YouTubeChannel/ContentDetails Used to
         * easily parse data with GSON
         */
        private static class RelatedPlaylists {
            private String likes;
            private String favorites;
            private String uploads;

            public String getLikes() {
                return likes;
            }

            public String getFavorites() {
                return favorites;
            }

            public String getUploads() {
                return uploads;
            }
        }
    }

    /**
     * Snippet sub class for YouTubeChannel used to easily parse data with GSON
     */
    private static class Snippet {
        private String title;
        private String description;
        private String publishedAt;
        private String country;

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

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

        public String getCountry() {
            return country;
        }

        private Thumbnails thumbnails;

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
