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

	YouTubeKnowledgeBase ytkb = new YouTubeKnowledgeBase();
	YouTubeAPI api = new YouTubeAPI("AIzaSyBZBT-ij4JblHC_HS5gv7tiJoLpwHlWjY8");	
	
	/**
	 * Get and store information from API Videos calls in Shark Knowledgebase 
	 */
	public void importVideo(String vid){
		
		PeerSemanticTag originatorVid;
		PeerSemanticTag peerVid;
		PeerSemanticTag remotePeerVid;
		SemanticTag topicVid;
		TimeSemanticTag timeVid;
		SpatialSemanticTag locationVid;
		
		try {
			//take videoID from console
			YouTubeVideo video = api.getVideoById(vid);//would be great if URL
			
			originatorVid = ytkb.createYTPeerSemanticTag(video.getChannelId(), "URL", null);
			peerVid = 		ytkb.createYTPeerSemanticTag(video.getChannelId(), "URL", null);
			remotePeerVid = ytkb.createYTPeerSemanticTag(video.getChannelId(), "URL", null);
			topicVid = 		ytkb.createYTSemanticTag(video.getDescription(), "URL");
			timeVid = 		ytkb.createYTTimeSemanticTag(video.getPublishedAtTimestamp(), 0);
			if (video.getLocation() != null){
				locationVid =	ytkb.createYTSpatialSemanticTag(video.getLocation().getLongitude(), video.getLocation().getLatitude());
			}else{
				locationVid = null;
			}		
			//not done
			ContextCoordinates coco;
			ContextPoint copo;
			
			coco = ytkb.createContextCoordinates(topicVid, originatorVid, peerVid, remotePeerVid, timeVid, locationVid);			
			copo = ytkb.createContextPoint(coco);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Get and store information from API Channel calls in Shark Knowledgebase 
	 */
	public void importChannel(){
		
		PeerSemanticTag originatorCh;
		PeerSemanticTag peerCh;
		PeerSemanticTag remotePeerCh;
		SemanticTag topicCh;
		TimeSemanticTag timeCh;
		SpatialSemanticTag locationCh;
		
		try {
			YouTubeChannel channel = api.getChannelByName("PewDiePie");
			
			originatorCh = 	ytkb.createYTPeerSemanticTag(channel.getGooglePlusUserId(), "URL", null);
			peerCh = 		ytkb.createYTPeerSemanticTag(channel.getId(), "URL", null);
			remotePeerCh = 	ytkb.createYTPeerSemanticTag(channel.getId(), "URL", null);
			topicCh = 		ytkb.createYTSemanticTag(channel.getTitle(), "URL");
			//timeCh = 		ytkb.createYTTimeSemanticTag(channel.getPublishedAtTimeStamp(), 0);
			//locationCh =		ytkb.createYTSpatialSemanticTag(country);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get and store information from API Playlist calls in Shark Knowledgebase 
	 */
	public void importPlaylist(){
		
		PeerSemanticTag originatorPl;
		PeerSemanticTag peerPl;
		PeerSemanticTag remotePeerPl;
		SemanticTag topicPl;
		TimeSemanticTag timePl;
		SpatialSemanticTag locationPl;
		
		try {
			YouTubeChannel channel = api.getChannelByName("PewDiePie");
			YouTubePlaylist playlist = api.getPlaylistById(channel.getLikedVideosPlaylistId());
			
			originatorPl = 	ytkb.createYTPeerSemanticTag(playlist.getChannelTitle(), "URL", null); 
			peerPl = 		ytkb.createYTPeerSemanticTag(playlist.getChannelId(), "URL", null);
			remotePeerPl = 	ytkb.createYTPeerSemanticTag(playlist.getChannelId(), "URL", null);
			topicPl = 		ytkb.createYTSemanticTag(playlist.getTitle(), "URL");
			//timePl = 		ytkb.createYTTimeSemanticTag(playlist.getPublishedAtTimeStamp(), 0); //not written yet
			locationPl =		null;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
