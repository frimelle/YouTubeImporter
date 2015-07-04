import net.sharkfw.knowledgeBase.*;
import net.sharkfw.knowledgeBase.inmemory.InMemoSharkKB;

public class Importer {

	//we're gonna need this somewhere
	//InMemoSharkKB kb = new InMemoSharkKB();
	//ContextPoint kbCP = kb.createContextPoint(cc);
	private YoutubeData youtubeData;
	
	
	
	private void YoutubeImporter (SharkKB knowledgebase){
		youtubeData = new YoutubeData();
	}
	
	public void getInformation (SharkKB knowledgebase) {

		youtubeData.getChannel();
		youtubeData.getVideo();
		
	}
	
}
