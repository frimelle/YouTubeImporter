public class Main {
    public static void main(String[] args)  {
    	YouTubeAPI api = new YouTubeAPI("AIzaSyBZBT-ij4JblHC_HS5gv7tiJoLpwHlWjY8");
    	try {    		
    		System.out.println("--------Returning Video Test Data--------");
    		YouTubeVideo video = api.getVideoById("MDIUreSo0gI");
    		System.out.println(video.getTitle());
    		System.out.println(video.getId());
    		System.out.println(video.getChannelId());
    		System.out.println(video.getChannelTitle());
    		System.out.println(video.getDescription());
    		System.out.println(video.getThumbnailUrl());
    		System.out.println(video.getTags());
    		System.out.println(video.getPublishedAt());    		
    		System.out.println(api.getCategoryById(video.getCategoryId()).getTitle());
    		if (video.getLocation() != null) {
    			//Not many videos actually have location data attached to them
	    		System.out.println("Latitude:" + video.getLocation().getLatitude());
	    		System.out.println("Longitude:" + video.getLocation().getLongitude());
	    		System.out.println("Altitude:" + video.getLocation().getAltitude());
    		}
    		
    		System.out.println("\n\n--------Returning Channel Test Data--------");
    		YouTubeChannel channel = api.getChannelByName("PewDiePie");
    		System.out.println(channel.getId());
    		System.out.println(channel.getTitle());
    		System.out.println(channel.getGooglePlusUserId());
    		System.out.println(channel.getFavoritedVideosPlaylistId());
    		System.out.println(channel.getLikedVideosPlaylistId());
    		System.out.println(channel.getUploadedVideosPlaylistId());
    		
    		System.out.println("\n\n--------Returning Playlist Test Data--------");
    		YouTubePlaylist playlist = api.getPlaylistById(channel.getLikedVideosPlaylistId());
    		System.out.println(playlist.getTitle());
    		System.out.println(playlist.getId());
    		System.out.println(playlist.getChannelId());
    		System.out.println(playlist.getChannelTitle());
    		System.out.println(playlist.getDescription());
    		System.out.println(playlist.getThumbnailUrl());
    		
    		SharkImporter yt = new SharkImporter();
    		yt.importVideo("MDIUreSo0gI");//add scanner
    		yt.printTags();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
