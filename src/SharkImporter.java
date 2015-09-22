import java.util.ArrayList;
import java.util.Collection;

import api.YouTubeChannel;
import api.YouTubePlaylist;
import api.YouTubeVideo;
import net.sharkfw.knowledgeBase.ContextCoordinates;
import net.sharkfw.knowledgeBase.ContextPoint;
import net.sharkfw.knowledgeBase.Information;
import net.sharkfw.knowledgeBase.PeerSemanticTag;
import net.sharkfw.knowledgeBase.SemanticTag;
import net.sharkfw.knowledgeBase.SpatialSemanticTag;
import net.sharkfw.knowledgeBase.TimeSemanticTag;


/**
 * Class to add information to the Shark knowledge base
 * @version 1.0
 */

public class SharkImporter {
	
	private YouTubeKnowledgeBase ytkb;

	/**
	 * Constructor  
	 */
	public SharkImporter(YouTubeKnowledgeBase ytkb) {
		this.ytkb = ytkb;
	}

	/**
	 * Get and store information from API Videos calls in Shark Knowledgebase 
	 */
	public ContextPoint importVideo(YouTubeVideo video) {
		if (video == null) {
			throw new NullPointerException("Video is null.");
		}
		PeerSemanticTag originator = 	ytkb.createYTPeerSemanticTag(video.getChannelId(), video.getUrl(), video.getId());
		PeerSemanticTag peer = 			originator;
		PeerSemanticTag remotePeer = 	peer;
		SemanticTag topic = 			ytkb.createYTSemanticTag(video.getYouTubeCategory().getTitle(), video.getId());
		TimeSemanticTag time = 			ytkb.createYTTimeSemanticTag(video.getPublishedAtTimestamp(), 0); 
		SpatialSemanticTag location = 	null;
		if (video.getLocation() != null){
			location =	ytkb.createYTSpatialSemanticTag(video.getLocation().getLongitude(), video.getLocation().getLatitude());
		}	
		ContextCoordinates contextCoordinates = ytkb.createContextCoordinates(topic, originator, peer, remotePeer, time, location);			
		ContextPoint contextPoint = ytkb.createContextPoint(contextCoordinates);
		return contextPoint;
	}
	
	public ContextPoint importVideo(YouTubeVideo video, String playlistId) {
		if (video == null) {
			throw new NullPointerException("Video is null.");
		}
		PeerSemanticTag originator = 	ytkb.createYTPeerSemanticTag(video.getChannelId(), video.getUrl(), video.getId());
		PeerSemanticTag peer = 			ytkb.createYTPeerSemanticTag(playlistId, video.getUrl(), video.getId());
		PeerSemanticTag remotePeer = 	peer;
		SemanticTag topic = 			ytkb.createYTSemanticTag(video.getYouTubeCategory().getTitle(), video.getId());
		TimeSemanticTag time = 			ytkb.createYTTimeSemanticTag(video.getPublishedAtTimestamp(), 0); 
		SpatialSemanticTag location = 	null;
		if (video.getLocation() != null){
			location =	ytkb.createYTSpatialSemanticTag(video.getLocation().getLongitude(), video.getLocation().getLatitude());
		}	
		ContextCoordinates contextCoordinates = ytkb.createContextCoordinates(topic, originator, peer, remotePeer, time, location);			
		ContextPoint contextPoint = ytkb.createContextPoint(contextCoordinates);
		return contextPoint;
	}
	
	/**
	 * Get and store information from API Videos calls in Shark Knowledgebase 
	 */
	public Collection<ContextPoint> importVideo(Collection<YouTubeVideo> videos) {
		if (videos == null) {
			throw new NullPointerException("Video is null.");
		}
		Collection<ContextPoint> contextPointCollection = new ArrayList<ContextPoint>();
		for(YouTubeVideo video : videos) {
			contextPointCollection.add(this.importVideo(video));
		}
		return contextPointCollection;
	}
	

	/**
	 * Get and store information from API Channel calls in Shark Knowledgebase 
	 */
	public ContextPoint importChannel(YouTubeChannel channel){
		if (channel == null) {
			throw new NullPointerException("Channel is null.");
		}
		
		PeerSemanticTag originator = 	ytkb.createYTPeerSemanticTag(channel.getId(), channel.getUrl(), channel.getId());
		PeerSemanticTag peer = 			originator;
		PeerSemanticTag remotePeer = 	peer;
		SemanticTag topic = 			ytkb.createYTSemanticTag(channel.getTitle(), channel.getId());
		TimeSemanticTag time = 			ytkb.createYTTimeSemanticTag(channel.getPublishedAtTimestamp(), 0);
		SpatialSemanticTag location = 	null;
		
		ContextCoordinates contextCoordinates = ytkb.createContextCoordinates(topic, originator, peer, remotePeer, time, location);
		ContextPoint contextPoint = ytkb.createContextPoint(contextCoordinates);
		return contextPoint;
	}

	/**
	 * Get and store information from API Playlist calls in Shark Knowledgebase 
	 * 
	 * @param YouTubePlaylist playlist
	 * @return ContextPoint contextPoint
	 */
	public ContextPoint importPlaylist(YouTubePlaylist playlist){
		if (playlist == null) {
			throw new NullPointerException("Playlist is null.");
		}
		PeerSemanticTag originator = 	ytkb.createYTPeerSemanticTag(playlist.getChannelId(), playlist.getUrl(), playlist.getId());
		PeerSemanticTag peer = 			ytkb.createYTPeerSemanticTag(playlist.getChannelId(), playlist.getUrl(), playlist.getId());
		PeerSemanticTag remotePeer = 	peer;
		SemanticTag topic = 			ytkb.createYTSemanticTag(playlist.getTitle(), playlist.getId());
		TimeSemanticTag time = 			ytkb.createYTTimeSemanticTag(playlist.getPublishedAtTimestamp(), 0);
		SpatialSemanticTag location =	null;
		
		ContextCoordinates contextCoordinates = ytkb.createContextCoordinates(topic, originator, peer, remotePeer, time, location);			
		ContextPoint contextPoint = ytkb.createContextPoint(contextCoordinates);
		//create Information for each video a playlist has and store in the playlists contextPoint
		for (String videoId: playlist.getVideoIds()) {
			if(videoId != null) {
				Information info = ytkb.createInfo(videoId, ".txt");//issue
				contextPoint.addInformation(info);
			}
		}
		return contextPoint;
	}
}
