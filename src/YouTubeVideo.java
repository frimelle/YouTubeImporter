import java.util.List;

public class YouTubeVideo {

	private String id;
	private Snippet snippet;
	
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
	
	
	
    /**
     * Snippet sub class for YouTubePlaylist
     * Used to easily parse data with GSON
     */
    public static class Snippet {
    	
    	private String channelId;
    	private String channelTitle;
    	private String title;
    	private String description;
    	private List<String> tags;
    	
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
    		} else if(thumbnails.getMaxres() != null) {
    			return thumbnails.getMaxres().getUrl();
    		} else if(thumbnails.getStandard() != null) {
    			return thumbnails.getStandard().getUrl();
    		} else if(thumbnails.getHigh() != null) {
    			return thumbnails.getHigh().getUrl();
    		} else if(thumbnails.getMedium() != null) {
    			return thumbnails.getMedium().getUrl();
    		} else {
    			return null;
    		}
    	}
    	
        /**
         * Thumbnails sub class for YouTubePlaylist/Snippet
         * Used to easily parse data with GSON
         */
    	public static class Thumbnails {
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
             * Thumbnail sub class for YouTubePlaylist/Snippet/Thumbnails, represents a single thumbnail and its attributes
             * Used to easily parse data with GSON
             */
    		private static class Thumbnail {
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
    }
    	
}
