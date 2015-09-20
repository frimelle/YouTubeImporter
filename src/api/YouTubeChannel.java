package api;

/**
 * This class represents YouTube channels which represent user accounts on YouTube
 */
public class YouTubeChannel {
	
   	private String id;
   	private String title;
    private ContentDetails contentDetails;

    
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}	
	
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
	 * @return String The ID of the play list containing the videos "liked" by the channel owner, null if no such play list exists
	 */
	public String getLikedVideosPlaylistId() {
		if (contentDetails != null) {
			return contentDetails.getLikedVideos();
		} else {
			return null;
		}
	}
	
	/**
	 * @return String The ID of the play list containing the channel uploads, null if no such play list exists
	 */
	public String getUploadedVideosPlaylistId() {
		if (contentDetails != null) {
			return contentDetails.getUploadedVideos();
		} else {
			return null;
		}
	}
	
	/**
	 * @return String The ID of the play list containing the favorited videos by the channel owner, null if no such play list exists
	 */
	public String getFavoritedVideosPlaylistId() {
		if (contentDetails != null) {
			return contentDetails.getFavoriteVideos();
		} else {
			return null;
		}
	}
	
    /**
     * ContentDetails sub class for YouTubeChannel
     * Used to easily parse data with GSON
     */
    public static class ContentDetails {
    	
        private String googlePlusUserId;
        private RelatedPlaylists relatedPlaylists;

		public String getGooglePlusUserId() {
			return googlePlusUserId;
		}		
		
		public void setGooglePlusUserId(String googlePlusUserId) {
			this.googlePlusUserId = googlePlusUserId;
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
	     * RelatedPlaylists sub class for YouTubeChannel/ContentDetails
	     * Used to easily parse data with GSON
	     */
	    public static class RelatedPlaylists {
	    		private String likes;
	    		private String favorites;
	    		private String uploads;
	    		
				public String getLikes() {
					return likes;
				}
				
				public void setLikes(String likes) {
					this.likes = likes;
				}
				
				public String getFavorites() {
					return favorites;
				}
				
				public void setFavorites(String favorites) {
					this.favorites = favorites;
				}
				
				public String getUploads() {
					return uploads;
				}
				
				public void setUploads(String uploads) {
					this.uploads = uploads;
				}
	    }
    }
}