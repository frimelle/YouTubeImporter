import java.util.Scanner;

import net.sharkfw.system.L;
import api.YouTubeAPI;
import api.YouTubeChannel;
import api.YouTubePlaylist;
import api.YouTubeVideo;

public class Main {
    public static void main(String[] args)  {
    	String apiKey = "AIzaSyBZBT-ij4JblHC_HS5gv7tiJoLpwHlWjY8";
    	String videoID = "MDIUreSo0gI";
    	String channelName = "PewDiePie";
    	YouTubeAPI api = new YouTubeAPI(apiKey);
		YouTubeKnowledgeBase ytkb = new YouTubeKnowledgeBase();
		
		YouTubePlaylist playlist = null;
		YouTubeChannel channel = null;
		YouTubeVideo video = null;
		
    	try {    		
    		System.out.println("--------Returning Video Test Data--------");
    		video = api.getVideoById(videoID);
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
//    		
//    		System.out.println("\n\n--------Returning Channel Test Data--------");
//    		channel = api.getChannelByName(channelName);
//    		System.out.println(channel.getId());
//    		System.out.println(channel.getTitle());
//    		System.out.println(channel.getCountryCode());
//    		System.out.println(channel.getPublishedAt());
//    		System.out.println(channel.getDescription());
//    		System.out.println(channel.getThumbnailUrl());
//    		System.out.println(channel.getGooglePlusUserId());
//    		System.out.println(channel.getFavoritedVideosPlaylistId());
//    		System.out.println(channel.getLikedVideosPlaylistId());
//    		System.out.println(channel.getUploadedVideosPlaylistId());
//    		System.out.println(channel.getUrl());
//    		
//    		System.out.println("\n\n--------Returning Playlist Test Data (May take a while for large playlists)--------");
//    		playlist = api.getPlaylistById(channel.getFavoritedVideosPlaylistId());
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
//    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * Properly creating video, channel and playlist
		 */
		SharkImporter importer = new SharkImporter(ytkb);
		importer.importVideo(video);
//		importer.importChannel(channel);
//		importer.importPlaylist(playlist);
		
		
		/*
		 * for presentation creating the video, channel and playlist object and printing them
		 */
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Please enter a Video ID:");
//		String videoURLUser = scanner.nextLine();

//		try {
//			// Video
//			video = api.getVideoById(videoURLUser); //example: 5vrXKlO2Jbw
//			SharkVideo sharkVideo = new SharkVideo();
//			sharkVideo.importVideo(video, ytkb);	
//		    System.out.println("Video:" + '\n' + sharkVideo.toString());
//		    // Channel
//		    channel = api.getChannelByName(channelName);
//		    SharkChannel sharkChannel = new SharkChannel();
//		    sharkChannel.importChannel(channel, ytkb);
//		    System.out.println("Channel" + '\n' + sharkChannel.toString());
//		    // Playlist
//		    playlist = api.getPlaylistById(channel.getFavoritedVideosPlaylistId());
//		    SharkPlaylist sharkPlaylist = new SharkPlaylist();
//		    sharkPlaylist.importPlaylist(playlist, ytkb);
//		    System.out.println("Playlist:" + '\n' + sharkPlaylist.toString());
//		    scanner.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 

		L.cp2String(importer.importVideo(video));
		L.cp2String(importer.importChannel(channel));
		L.cp2String(importer.importPlaylist(playlist));


    }
}
