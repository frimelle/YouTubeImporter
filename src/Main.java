
public class Main {
    public static void main(String[] args)  {
    	YouTubeAPI api = new YouTubeAPI("AIzaSyBZBT-ij4JblHC_HS5gv7tiJoLpwHlWjY8");
    	try {
    		System.out.println("--------Returning Channel Test Data--------");
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
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}