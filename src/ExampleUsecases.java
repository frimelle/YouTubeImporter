import net.sharkfw.system.L;
import api.YouTubeAPI;
import api.YouTubeChannel;
import api.YouTubePlaylist;

public class ExampleUsecases {
    
    private static YouTubeAPI api;
    private static YouTubeKnowledgeBase ytkb;
    
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            throw new IllegalArgumentException("Please provide an API key in the parameters.");
        }
        
        api = new YouTubeAPI(args[0]);
        ytkb = new YouTubeKnowledgeBase();
        
        importVideosFromChannel("UCNNEMxGKV1LsKZRt4vaIbvw");
    }

    /**
     *
     * @param String channelName
     * @param String apiKey
     * @return String sharkKB
     */
    public static void importVideosFromChannel(String channelName) {
        
        YouTubeChannel channel = null;
        YouTubePlaylist playlist = null;
        SharkImporter si = new SharkImporter(ytkb);
        try {
            channel = api.getChannelById(channelName);
            System.out.println(L.cp2String(si.importChannel(channel)));
            playlist = api.getPlaylistById(channel.getUploadedVideosPlaylistId());
            System.out.println(L.cp2String(si.importPlaylist(playlist)));
            String videoId = playlist.getVideoIds().iterator().next();
            //Just grabbing first video from play list to but normally this would be an iteration
            System.out.println(L.cp2String(si.importVideo(api.getVideoById(videoId))));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}