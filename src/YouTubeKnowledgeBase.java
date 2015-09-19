import net.sharkfw.knowledgeBase.ContextCoordinates;
import net.sharkfw.knowledgeBase.ContextPoint;
import net.sharkfw.knowledgeBase.PeerSemanticTag;
import net.sharkfw.knowledgeBase.SemanticTag;
import net.sharkfw.knowledgeBase.SharkCS;
import net.sharkfw.knowledgeBase.SharkKB;
import net.sharkfw.knowledgeBase.SharkKBException;
import net.sharkfw.knowledgeBase.SpatialSemanticTag;
import net.sharkfw.knowledgeBase.TimeSemanticTag;
import net.sharkfw.knowledgeBase.geom.SharkGeometry;

/**
 * Class to add information to the Shark knowledge base
 * @version 1.0
 */

public class YouTubeKnowledgeBase {

	public String YTKnowledgeBase() {
		return "Context Points";
	}

	private SharkKB knowledgeBase;
	
	// Direction
	private int direction = SharkCS.DIRECTION_OUT;

	/**
	 * create a SemanticTag
	 * 
	 * @param String name
	 * @param address
	 * @return SemanticTag semanticTag
	 */
	public SemanticTag createYTSemanticTag(String name, String si) {
		SemanticTag semanticTag = null;
		try {
			semanticTag = knowledgeBase.createSemanticTag(name, si);

		} catch (SharkKBException e) {
			e.printStackTrace();
		}
		return semanticTag;
	}

	/**
	 * create a PeerSemanticTag
	 * 
	 * @param String name
	 * @param String si
	 * @param address
	 * @return PeerSemanticTag semanticTag
	 */
	public PeerSemanticTag createYTPeerSemanticTag(String name, String si, String address) {
		PeerSemanticTag semanticTag = null;
		try {
			semanticTag = knowledgeBase.createPeerSemanticTag(name, si, address);

		} catch (SharkKBException e) {
			e.printStackTrace();
		}
		return semanticTag;
	}

	/**
	 * create a TimeSemanticTag
	 * 
	 * @param long from
	 * @param long duration
	 * @return TimeSemanticTag semanticTag
	 */
	public TimeSemanticTag createYTTimeSemanticTag(long from, long duration) {
		TimeSemanticTag semanticTag = null;
		try {
			semanticTag = knowledgeBase.createTimeSemanticTag(from, duration);

		} catch (SharkKBException e) {
			e.printStackTrace();
		}
		return semanticTag;
	}

	/**
	 * create a SpatialSemanticTag
	 * 
	 * @param String name
	 * @param String[] sis
	 * @param SharkGeometry geom
	 * @return SpatialSemanticTag semanticTag
	 */
	public SpatialSemanticTag createYTSpatialSemanticTag(String name, String[] sis, SharkGeometry geom) {
		SpatialSemanticTag semanticTag = null;
		try {
			semanticTag = knowledgeBase.createSpatialSemanticTag(name, sis, geom);

		} catch (SharkKBException e) {
			e.printStackTrace();
		}
		return semanticTag;
	}

	/**
	 * create ContextCoordinates
	 * 
	 * @param SemanticTag topic
	 * @param PeerSemanticTag originator
	 * @param PeerSemanticTag peer
	 * @param PeerSemanticTag remotepeer
	 * @param TimeSemanticTag time
	 * @param TimeSemanticTag location
	 * @return ContextCoordinates cc
	 */
	public ContextCoordinates createContextCoordinates(SemanticTag topic, PeerSemanticTag originator,
			PeerSemanticTag peer, PeerSemanticTag remotepeer, TimeSemanticTag time, SpatialSemanticTag location) {
		ContextCoordinates cc = null;
		try {
			cc = knowledgeBase.createContextCoordinates(topic, originator, peer, remotepeer, time, location, this.direction);
		} catch (SharkKBException e) {
			e.printStackTrace();
		}
		return cc;
	}

	/**
	 * Create ContextCoordinates
	 * 
	 * @param ContextCoordinates cc
	 * @return ContextPoint cp
	 */
	public ContextPoint createContextPoint(ContextCoordinates cc) {
		ContextPoint cp = null;
		try {
			cp = knowledgeBase.createContextPoint(cc);
		} catch (SharkKBException e) {
			e.printStackTrace();
		}
		return cp;
	}

	/**
	 * Set the direction
	 * 
	 * @param int direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * Get the direction
	 * 
	 * @return int direction
	 */
	public int getDirection() {
		return this.direction;
	}

}
