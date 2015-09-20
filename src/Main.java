import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

import api.YouTubeAPI;
import api.YouTubeChannel;
import api.YouTubePlaylist;
import api.YouTubeVideo;

public class Main {
    public static void main(String[] args)  {
    	String apiKey = "AIzaSyBZBT-ij4JblHC_HS5gv7tiJoLpwHlWjY8";
    	YouTubeAPI api = new YouTubeAPI(apiKey);
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
    		System.out.println(video.getUrl()); 
    		
    		System.out.println("\n\n--------Returning Channel Test Data--------");
    		YouTubeChannel channel = api.getChannelByName("PewDiePie");
    		System.out.println(channel.getId());
    		System.out.println(channel.getTitle());
    		System.out.println(channel.getCountryCode());
    		System.out.println(channel.getPublishedAt());
    		System.out.println(channel.getDescription());
    		System.out.println(channel.getThumbnailUrl());
    		System.out.println(channel.getGooglePlusUserId());
    		System.out.println(channel.getFavoritedVideosPlaylistId());
    		System.out.println(channel.getLikedVideosPlaylistId());
    		System.out.println(channel.getUploadedVideosPlaylistId());
    		System.out.println(channel.getUrl());
    		
//    		System.out.println("\n\n--------Returning Playlist Test Data (May take a while for large playlists)--------");
//    		YouTubePlaylist playlist = api.getPlaylistById(channel.getFavoritedVideosPlaylistId());
//    		System.out.println(playlist.getTitle());
//    		System.out.println(playlist.getId());
//    		System.out.println(playlist.getChannelId());
//    		System.out.println(playlist.getChannelTitle());
//    		System.out.println(playlist.getDescription());
//    		System.out.println(playlist.getThumbnailUrl());
//    		System.out.println(playlist.getUrl());
//    		int counter = 1;
//    		for (String videoId: playlist.getVideoIds()) {
//    			System.out.println(counter + ": "+ videoId);
//    			counter++;
//    		}
    		
    		Scanner scanner = new Scanner(System.in);
    		System.out.println("Please enter a Video ID:");
    		String vidID = scanner.nextLine();
    		YouTubeKnowledgeBase ytkb = new YouTubeKnowledgeBase();
    		SharkImporter si = new SharkImporter(ytkb, apiKey);
    		SharkVideo sv = new SharkVideo(video, ytkb);
    		//use MDIUreSo0gI
    		sv.importVideo();
    	    System.out.println(si.importVideo(vidID));
    	    scanner.close();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
