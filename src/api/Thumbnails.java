package api;
/**
 * Thumbnails sub class for YouTubePlaylist/Snippet Used to easily parse data
 * with GSON
 */
class Thumbnails {
	private Thumbnail medium;

	public Thumbnail getMedium() {
		return medium;
	}

	public Thumbnail getHigh() {
		return high;
	}

	public Thumbnail getStandard() {
		return standard;
	}

	public Thumbnail getMaxres() {
		return maxres;
	}

	private Thumbnail high;
	private Thumbnail standard;
	private Thumbnail maxres;

	/**
	 * Thumbnail sub class for Snippet/Thumbnails, represents a single thumbnail
	 * and its attributes Used to easily parse data with GSON
	 */
	class Thumbnail {
		private String url;

		public String getUrl() {
			return url;
		}

		public String getWidth() {
			return width;
		}

		public String getHeight() {
			return height;
		}

		private String width;
		private String height;
	}
}