
import net.sharkfw.knowledgeBase.ContextCoordinates;
import net.sharkfw.knowledgeBase.ContextPoint;
import net.sharkfw.knowledgeBase.Information;
import net.sharkfw.knowledgeBase.PeerSemanticTag;
import net.sharkfw.knowledgeBase.SemanticTag;
import net.sharkfw.knowledgeBase.SpatialSemanticTag;
import net.sharkfw.knowledgeBase.TimeSemanticTag;
import net.sharkfw.knowledgeBase.geom.SharkGeometry;
import net.sharkfw.knowledgeBase.geom.inmemory.InMemoSharkGeometry;

public class SharkImporter {
	
	private PeerSemanticTag originatorVid;
	private PeerSemanticTag peerVid;
	private PeerSemanticTag remotePeerVid;
	private SemanticTag topicVid;
	private TimeSemanticTag timeVid;
	private SpatialSemanticTag locationVid;
	private ContextCoordinates coco;
	private ContextPoint copo;
	
	YouTubeKnowledgeBase ytkb = new YouTubeKnowledgeBase();
	YouTubeAPI api = new YouTubeAPI("AIzaSyBZBT-ij4JblHC_HS5gv7tiJoLpwHlWjY8");	
	

	public void importVideo(String vid){
		
		try {
			//take videoID from console
			YouTubeVideo video = api.getVideoById(vid);//would be great if URL
			YouTubeVideo.Snippet s = new YouTubeVideo.Snippet();	
			
			originatorVid = 	ytkb.createYTPeerSemanticTag(video.getChannelId(), "URL", null);
			peerVid = 			ytkb.createYTPeerSemanticTag(video.getChannelId(), "URL", null);
			remotePeerVid = 	ytkb.createYTPeerSemanticTag(video.getChannelId(), "URL", null);
			topicVid = 			ytkb.createYTSemanticTag(video.getDescription(), "URL");
			timeVid = 			ytkb.createYTTimeSemanticTag(s.getPublishedAt(), 0);
			if (video.getLocation() != null){
				locationVid =	ytkb.createYTSpatialSemanticTag(video.getLocation().getLongitude(), video.getLocation().getLatitude());
			}else{
				locationVid = null;
			}		
			//not done
			coco = ytkb.createContextCoordinates(topicVid, originatorVid, peerVid, remotePeerVid, timeVid, locationVid);			
			copo = ytkb.createContextPoint(coco);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void printTags(){
		
		System.out.println(coco);
		System.out.println("HERE!"+locationVid);
		
//		System.out.println("Originator: " + originatorVid);
//		System.out.println("Peer: " + peerVid);
//		System.out.println("Remote Peer: " + remotePeerVid);
//		System.out.println("Topic: " + topicVid);
		//System.out.println("Time: " + timeVid);
		//System.out.println("Loacation: " + locationVid);
		
	}
	

	
}
