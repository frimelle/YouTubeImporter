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
		PeerSemanticTag originator = 	ytkb.createYTPeerSemanticTag(video.getId(), video.getUrl(), video.getUrl());
		PeerSemanticTag peer = 			ytkb.createYTPeerSemanticTag(video.getChannelId(), video.getUrl(), video.getUrl());
		PeerSemanticTag remotePeer = 	ytkb.createYTPeerSemanticTag(video.getChannelId(), video.getUrl(), video.getUrl());
		SemanticTag topic = 			ytkb.createYTSemanticTag(video.getDescription(), video.getUrl());
		TimeSemanticTag time = 			ytkb.createYTTimeSemanticTag(video.getPublishedAtTimestamp(), 0); //TODO replace duration with getRecordingTime()
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
		PeerSemanticTag originator = 	ytkb.createYTPeerSemanticTag(channel.getGooglePlusUserId(), channel.getUrl(), channel.getUrl());
		PeerSemanticTag peer = 			ytkb.createYTPeerSemanticTag(channel.getId(), channel.getUrl(), channel.getUrl());
		PeerSemanticTag remotePeer = 	ytkb.createYTPeerSemanticTag(channel.getId(), channel.getUrl(), channel.getUrl());
		SemanticTag topic = 			ytkb.createYTSemanticTag(channel.getTitle(), channel.getUrl());
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
		PeerSemanticTag originator = 	ytkb.createYTPeerSemanticTag(playlist.getChannelTitle(), playlist.getUrl(), playlist.getUrl());
		PeerSemanticTag peer = 			ytkb.createYTPeerSemanticTag(playlist.getChannelId(), playlist.getUrl(), playlist.getUrl());
		PeerSemanticTag remotePeer = 	ytkb.createYTPeerSemanticTag(playlist.getChannelId(), playlist.getUrl(), playlist.getUrl());
		SemanticTag topic = 			ytkb.createYTSemanticTag(playlist.getTitle(), playlist.getUrl());
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
