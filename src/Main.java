
public class Main {
    public static void main(String[] args)  {
    	YouTubeAPI api = new YouTubeAPI("AIzaSyBZBT-ij4JblHC_HS5gv7tiJoLpwHlWjY8");
    	try {
    		YouTubeChannel channel = api.getChannelByName("PewDiePie");
    		System.out.println(channel.getId());
    		System.out.println(channel.getGooglePlusUserId());
    		System.out.println(channel.getEtag());
    		System.out.println(channel.getFavoritedVideosPlaylist());
    		System.out.println(channel.getLikedVideosPlaylist());
    		System.out.println(channel.getUploadedVideosPlaylist());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}