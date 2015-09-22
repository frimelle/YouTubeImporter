# YouTubeImporter

Submodule for Shark (SharedKnowledge)

The YouTubeImporter is an extension to the SharedKnowledge (Shark) Framework. It's possible to import Videos, Channels and Playlist from YouTube in the semantic database of Shark.
We decided to not build a pure importer except for our the ExampleUsage. The idea is, that it's possible to build a huge net of videos, channels and playlist. So it's possible to

It's necessary to get an API key for the requests to the YouTube api.

# YouTube in Shark

We decided to have three possible context points, that are interconnected: the Video, the Playlist and the Channel. Following is the description how those are transformed into ContextPoints and imported into a Shark knowledgebase. Fitting the Sharkstructure to what we get from Youtube happens in the YouTubeKnowledgeBase. There the context coordinates are written into a shark knowledge base that is passed to the YouTubeKnowledgebase. Due to having to convert the parameter from YouTube three times, we decided we wanted to do the calculating in a different place. In the SharkImporter, the semantic tags can be filled with YouTube videos, channels and playlists. This is also where the mapping of the results from the YouTube api gets fitted with the structure of Shark.

## Video in Shark

This is the description of the YouTube Video in the semantic structure of Shark.
The adress and si are all set to the video Url.

### Originator
The Originator is set to be the video id. The main idea is in this case to have one of the PeerSemanticTags set to be the video id.

### Peer and RemotePeer
There are no users but only channels in YouTube so that's the creator and/or uploader of the video. Therefore the peer is a link to the creater/uploader by beeing filled with the channelid
Same for the remote peer. We decided it made most sense to fill them both with the creater/uploader of the video.

### Topic
The topic is set to be the video description- those are just plain text saying something about the video, which is interessting to get the whole overview over a video but of course semantically not as interesting as the id for example.

### Time
The time when the video was published in YouTube.

### Location
That's the location, YouTube returns for the video, set by the user where the video was recorded. This is often left empty and would result in the location being set to null.

### ContextCoordinates and ContextPoint
From those Tags a contextCoordinates is created and transformed to a contextPoint. Thereby we have the video created as a ContextPoint in a knowledgeBase and can work with it there.

## Playlist in Shark

There are three different kinds of Playlist: the playlist from favourited Videos, from uploaded Videos and liked Videos of a certain channel (which is basically the same as a user in this case). We handle all those playlists the same. Playlists are mainly there to create a link between Videos and Channels beside the direct link they already have. It's an important part espacially when building a bigger semantic net of playlists, their videos and the channels connected to both.

### Originator
