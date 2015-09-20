package api;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

public class YouTubeVideo {

	private String id;
	private Snippet snippet;
	private RecordingDetails recordingDetails;

	public String getId() {
		return id;
	}

	public String getThumbnailUrl() {
		if (snippet != null) {
			return snippet.getThumbnailUrl();
		} else {
			return null;
		}
	}

	public List<String> getTags() {
		if (snippet != null) {
			return snippet.getTags();
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

	public String getCategoryId() {
		if (snippet != null) {
			return snippet.getCategoryId();
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

	public Location getLocation() {
		if (recordingDetails != null) {
			return recordingDetails.getLocation();
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

	/**
	 * Snippet sub class for YouTubeVideo Used to easily parse data with GSON
	 */
	public static class Snippet {

		private String channelId;
		private String channelTitle;
		private String categoryId;
		private String title;
		private String description;
		private String publishedAt;
		private List<String> tags;

		public String getChannelId() {
			return channelId;
		}

		public String getChannelTitle() {
			return channelTitle;
		}

		public String getCategoryId() {
			return categoryId;
		}

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

		public List<String> getTags() {
			return tags;
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

	/**
	 * RecordingDetails sub class for YouTubeVideo Used to easily parse data
	 * with GSON
	 */
	public static class RecordingDetails {
		private Location location;

		public Location getLocation() {
			return location;
		}
	}

}
