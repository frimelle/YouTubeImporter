package api;

import java.util.Collection;

public class YouTubePlaylist {
	
	static final String URL_PREFIX = "https://www.youtube.com/playlist?list=";
	
	private String id;
	private Snippet snippet;
	private Collection<String> videoIds;

	public Collection<String> getVideoIds() {
		return videoIds;
	}
	
	public void setVideoIds(Collection<String> videoIds) {
		this.videoIds = videoIds;
	}

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
	 * Snippet sub class for YouTubePlaylist Used to easily parse data with GSON
	 */
	private static class Snippet {

		private String channelId;
		private String channelTitle;
		private String title;
		private String description;

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
