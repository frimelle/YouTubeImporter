import net.sharkfw.knowledgeBase.inmemory.InMemoSharkKB;
import api.YouTubeAPI;
import api.YouTubeChannel;
import api.YouTubePlaylist;


public class ExampleUsecases {
   
    /**
     *
     * @param String channelName
     * @param String apiKey
     * @return String sharkKB
     */
    public InMemoSharkKB importVideosFromChannel(String channelName, String apiKey ) {
        YouTubeAPI api = new YouTubeAPI(apiKey);
        YouTubeKnowledgeBase ytkb = new YouTubeKnowledgeBase();
        YouTubeChannel channel = null;
        YouTubePlaylist playlist = null;
        SharkImporter si = new SharkImporter(ytkb);
        try {
            channel = api.getChannelByName(channelName);
            si.importChannel(channel);
            playlist = api.getPlaylistById(channel.getUploadedVideosPlaylistId());
            si.importPlaylist(playlist);
            for (String videoId: playlist.getVideoIds()) {
                si.importVideo(api.getVideoById(videoId));
            }       
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return ytkb.getSharkKB();
    }
}