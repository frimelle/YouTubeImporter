package api;

public class YouTubeCategory {

	private String id;
	private Snippet snippet;
	
	public String getId() {
		return id;
	}
	
	public String getTitle() {
		if (snippet != null) {
			return snippet.getTitle();
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
	
    /**
     * Snippet sub class for YouTubeCategory
     * Used to easily parse data with GSON
     */
    private static class Snippet {
    	
    	private String channelId;
    	private String title;
    	
    	public String getChannelId() {
			return channelId;
		}
    	
    	public String getTitle() {
			return title;
		}
    	
    }
    	
}
