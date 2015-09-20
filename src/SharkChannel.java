import net.sharkfw.knowledgeBase.ContextCoordinates;
import net.sharkfw.knowledgeBase.ContextPoint;
import net.sharkfw.knowledgeBase.PeerSemanticTag;
import net.sharkfw.knowledgeBase.SemanticTag;
import net.sharkfw.knowledgeBase.SpatialSemanticTag;
import net.sharkfw.knowledgeBase.TimeSemanticTag;
import net.sharkfw.system.L;

/**
 * 
 *
 */
public class SharkChannel {
	private PeerSemanticTag originator;
	private PeerSemanticTag peer;
	private PeerSemanticTag remotePeer;
	private SemanticTag topic;
	private TimeSemanticTag time;
	private SpatialSemanticTag location;
	private ContextCoordinates contextCoordinates;
	private ContextPoint contextPoint;
	
	public SharkChannel(String channelName) {
		YouTubeKnowledgeBase ytkb = new YouTubeKnowledgeBase();
		YouTubeAPI api = new YouTubeAPI("AIzaSyBZBT-ij4JblHC_HS5gv7tiJoLpwHlWjY8");	
		
		YouTubeChannel channel = null;
		try {
			channel = api.getChannelByName(channelName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		originator = 	ytkb.createYTPeerSemanticTag(channel.getGooglePlusUserId(), "URL", null);
		peer = 			ytkb.createYTPeerSemanticTag(channel.getId(), "URL", null);
		remotePeer = 	ytkb.createYTPeerSemanticTag(channel.getId(), "URL", null);
		topic = 			ytkb.createYTSemanticTag(channel.getTitle(), "URL");
//		time = 			ytkb.createYTTimeSemanticTag(s.getPublishedAt(), 0);
//		location = null;
//		if (video.getLocation() != null){
//			locationVid =	ytkb.createYTSpatialSemanticTag(channel.getLocation().getLongitude(), channel.getLocation().getLatitude());
//		}	
		contextCoordinates = ytkb.createContextCoordinates(topic, originator, peer, remotePeer, time, location);			
		contextPoint = ytkb.createContextPoint(contextCoordinates);
	}
	
	/**
	 * return String made of the context point
	 */
	 public String toString() {
		  return L.cp2String(contextPoint);
	}

	/**
	 * @return PeerSemanticTag originator
	 */
	public PeerSemanticTag getOriginator() {
		return originator;
	}

	/**
	 * @param PeerSemanticTag originator
	 */
	public void setOriginator(PeerSemanticTag originator) {
		this.originator = originator;
	}

	/**
	 * @return PeerSemanticTag peer
	 */
	public PeerSemanticTag getPeer() {
		return peer;
	}

	/**
	 * @param PeerSemanticTag peer
	 */
	public void setPeer(PeerSemanticTag peer) {
		this.peer = peer;
	}

	/**
	 * @return PeerSemanticTag remotePeer
	 */
	public PeerSemanticTag getRemotePeer() {
		return remotePeer;
	}

	/**
	 * @param PeerSemanticTag remotePeer
	 */
	public void setRemotePeer(PeerSemanticTag remotePeer) {
		this.remotePeer = remotePeer;
	}

	/**
	 * @return SemanticTag topic
	 */
	public SemanticTag getTopic() {
		return topic;
	}

	/**
	 * @param SemanticTag topic
	 */
	public void setTopic(SemanticTag topic) {
		this.topic = topic;
	}

	/**
	 * @return TimeSemanticTag time
	 */
	public TimeSemanticTag getTime() {
		return time;
	}

	/**
	 * @param TimeSemanticTag time
	 */
	public void setTime(TimeSemanticTag time) {
		this.time = time;
	}

	/**
	 * @return SpatialSemanticTag location
	 */
	public SpatialSemanticTag getLocation() {
		return location;
	}

	/**
	 * @param SpatialSemanticTag location
	 */
	public void setLocation(SpatialSemanticTag location) {
		this.location = location;
	}

	/**
	 * @return ContextCoordinates contextCoordinates
	 */
	public ContextCoordinates getContextCoordinates() {
		return contextCoordinates;
	}

	/**
	 * @param ContextCoordinates contextCoordinates
	 */
	public void setContextCoordinates(ContextCoordinates contextCoordinates) {
		this.contextCoordinates = contextCoordinates;
	}

	/**
	 * @return ContextPoint contextPoint
	 */
	public ContextPoint getContextPoint() {
		return contextPoint;
	}

	/**
	 * @param ContextPoint contextPoint
	 */
	public void setContextPoint(ContextPoint contextPoint) {
		this.contextPoint = contextPoint;
	}
	
}
