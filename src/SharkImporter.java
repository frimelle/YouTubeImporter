import api.YouTubeAPI;
import api.YouTubeChannel;
import api.YouTubePlaylist;
import api.YouTubeVideo;
import net.sharkfw.knowledgeBase.ContextCoordinates;
import net.sharkfw.knowledgeBase.ContextPoint;
import net.sharkfw.knowledgeBase.PeerSemanticTag;
import net.sharkfw.knowledgeBase.SemanticTag;
import net.sharkfw.knowledgeBase.SpatialSemanticTag;
import net.sharkfw.knowledgeBase.TimeSemanticTag;

/**
 * Class to add information to the Shark knowledge base
 * @version 1.0
 */

public class SharkImporter {
	
	private YouTubeAPI api;
	private YouTubeKnowledgeBase ytkb;

	/**
	 * Constructor  
	 */
	public SharkImporter(YouTubeKnowledgeBase ytkb, String apiKey) {
		this.ytkb = ytkb;		
		this.api = new YouTubeAPI(apiKey);
	}
	
	/**
	 * Get and store information from API Videos calls in Shark Knowledgebase 
	 */
	public ContextPoint importVideo(String videoID){
		
		YouTubeVideo video = null;
		ContextPoint copo = null;
		try {
			video = api.getVideoById(videoID);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (video != null){
			SharkVideo sv = new SharkVideo(video, ytkb);
			copo = sv.importVideo();
		}	
		return copo;
	}
	
	/**
	 * Get and store information from API Channel calls in Shark Knowledgebase 
	 */
	public ContextPoint importChannel(String channelName){
		
		YouTubeChannel channel = null;
		ContextPoint copo = null;
				
		try{			
			channel = api.getChannelByName(channelName);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (channel != null){
			SharkChannel sc = new SharkChannel(channel, ytkb);
			copo = sc.importChannel();
		}
		return copo;
	}
	
	/**
	 * Get and store information from API Playlist calls in Shark Knowledgebase 
	 */
	public ContextPoint importPlaylist(String channelName){

		YouTubePlaylist playlist = null;
		YouTubeChannel channel = null;
		ContextPoint copo = null;
		
		try {
			channel = api.getChannelByName(channelName);
			playlist = api.getPlaylistById(channel.getFavoritedVideosPlaylistId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (playlist != null){
			SharkPlaylist sp = new SharkPlaylist(playlist, ytkb);
			copo = sp.importPlaylist();
		}
		return copo;
	}
}
