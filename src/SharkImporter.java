import java.util.ArrayList;
import java.util.Collection;

import api.YouTubeChannel;
import api.YouTubePlaylist;
import api.YouTubeVideo;
import net.sharkfw.knowledgeBase.ContextPoint;

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
		return new SharkVideo().importVideo(video, ytkb);
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
			contextPointCollection.add(new SharkVideo().importVideo(video, ytkb));
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
		return new SharkChannel().importChannel(channel, ytkb);
	}
	
	/**
	 * Get and store information from API Playlist calls in Shark Knowledgebase 
	 */
	public ContextPoint importPlaylist(YouTubePlaylist playlist){
		if (playlist == null) {
			throw new NullPointerException("Playlist is null.");
		}
		return new SharkPlaylist().importPlaylist(playlist, ytkb);
	}
}
