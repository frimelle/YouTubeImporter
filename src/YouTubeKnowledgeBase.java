import net.sharkfw.knowledgeBase.ContextCoordinates;
import net.sharkfw.knowledgeBase.ContextPoint;
import net.sharkfw.knowledgeBase.Information;
import net.sharkfw.knowledgeBase.PeerSemanticTag;
import net.sharkfw.knowledgeBase.SemanticTag;
import net.sharkfw.knowledgeBase.SharkCS;
import net.sharkfw.knowledgeBase.SharkKBException;
import net.sharkfw.knowledgeBase.SpatialSemanticTag;
import net.sharkfw.knowledgeBase.TimeSemanticTag;
import net.sharkfw.knowledgeBase.geom.SharkGeometry;
import net.sharkfw.knowledgeBase.geom.inmemory.InMemoSharkGeometry;
import net.sharkfw.knowledgeBase.inmemory.InMemoSharkKB;

/**
 * Class to add information to the Shark knowledge base
 * 
 * @version 1.0
 */

public class YouTubeKnowledgeBase {

    private InMemoSharkKB sharkKB = new InMemoSharkKB();
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
        SemanticTag semanticTag = InMemoSharkKB.createInMemoSemanticTag(name, si);
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
        PeerSemanticTag semanticTag = InMemoSharkKB.createInMemoPeerSemanticTag(name, si, address);
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
        TimeSemanticTag semanticTag = InMemoSharkKB.createInMemoTimeSemanticTag(from, duration);
        return semanticTag;
    }

    /**
     * create a SpatialSemanticTag from longitude and latitude
     * 
     * @param double longi
     * @param double lati
     * @return SpatialSemanticTag semanticTag
     */
    public SpatialSemanticTag createYTSpatialSemanticTag(double longi, double lati) {
        String wkt = "POINT(" + longi + " " + lati + ")";
        SharkGeometry geom = null;
        try {
            geom = InMemoSharkGeometry.createGeomByWKT(wkt);
        } catch (SharkKBException e) {
            e.printStackTrace();
        }
        SpatialSemanticTag semanticTag = InMemoSharkKB.createInMemoSpatialSemanticTag(geom);
        return semanticTag;
    }

    /**
     * create an Information for videoId
     * 
     * @param String vidId
     * @param String contentType
     * @return Information info
     */
    public Information createInfo(String vidId, String contentType) {
        Information info = InMemoSharkKB.createInMemoInformation();
        info.setContent(vidId);
        try {
            info.setName(vidId);
        } catch (SharkKBException e) {
            e.printStackTrace();
        }
        info.setContentType(contentType);
        return info;
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
    public ContextCoordinates createContextCoordinates(SemanticTag topic, PeerSemanticTag originator, PeerSemanticTag peer, PeerSemanticTag remotepeer, TimeSemanticTag time, SpatialSemanticTag location) {
        ContextCoordinates cc = null;
        try {
            cc = sharkKB.createContextCoordinates(topic, originator, peer, remotepeer, time, location, this.direction);
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
            cp = sharkKB.createContextPoint(cc);
        } catch (SharkKBException e) {
            e.printStackTrace();
        }
        return cp;
    }

    /**
     *
     * @return InMemoSharkKB sharkKB
     */
    public InMemoSharkKB getSharkKB() {
        return this.sharkKB;
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
