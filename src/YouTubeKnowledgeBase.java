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
 * @author Lucie-Aimée Kaffee, Charlie Kritschmar, Tim F. Eulitz
 * @version 1.0
 */

public class YouTubeKnowledgeBase {
	
	public String YTKnowledgeBase() {
		return "Context Points";
	}
	private SharkKB knowledgeBase;
	// Direction
    final int direction = SharkCS.DIRECTION_OUT;
	 
	 /**
	  * create a SemanticTag
	  * @param name
	  * @param si
	  * @param address
	  * @return semanticTag
	  */
	 private SemanticTag createYTSemanticTag(String name, String si) {
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
	  * @param name
	  * @param si
	  * @param address
	  * @return semanticTag
	  */
	 private PeerSemanticTag createYTPeerSemanticTag(String name, String si, String address) {
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
	  * @param name
	  * @param si
	  * @param address
	  * @return semanticTag
	  */
	 private TimeSemanticTag createYTTimeSemanticTag(long from, long duration) {
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
	  * @param name
	  * @param si
	  * @param address
	  * @return semanticTag
	  */
	 private SpatialSemanticTag createYTSpatialSemanticTag(String name, String[] sis, SharkGeometry geom) {
	        SpatialSemanticTag semanticTag = null;
	        try {
	            semanticTag = knowledgeBase.createSpatialSemanticTag(name, sis, geom);
	            
	        } catch (SharkKBException e) {
	            e.printStackTrace();
	        }
	        return semanticTag;
	 }
	
}
