# YouTubeImporter

Submodule for Shark (SharedKnowledge)

The YouTubeImporter is an extension to the SharedKnowledge (Shark) Framework. It is possible to import Videos, Channels and Playlist from YouTube in the semantic database of Shark.
We decided to not build a pure importer except for the ExampleUsage class. The idea is, that it is possible to build a huge net of videos, channels and playlist. 

It is necessary to get an API key for the requests to the YouTube API.

# YouTube in Shark

We decided to have three possible context points, which are interconnected: the Video, the Playlist and the Channel. Following is the description how these are transformed into ContextPoints and imported into a Shark knowledgebase. Matching the Shark structure to what we get from YouTube happens in the YouTubeKnowledgeBase. There, the context coordinates are written into a shark knowledge base that is passed to the YouTubeKnowledgebase. Due to having to convert the parameter from YouTube three times, we decided that we wanted to do the calculating in a different place. In the SharkImporter, the semantic tags can be filled with YouTube videos, channels and playlists. This is also where the mapping of the results from the YouTube API get fitted with the structure of Shark.
Even though there are three different context points, they are comparable in their structure.

## Common Structure

### Originator
The originator is always the ID of the channel, the context point belongs to or is created by.

### Peer
The peer is the unique identifier of the context point taken from the ID they have in YouTube.

### Remote Peer
The remote peer is, in our case the same as the peer.

### Topic
The topic is the description of the video, playlist or channel in YouTube.

### Time
The time is the time it was published in YouTube

### Location
If there is a location returned by the YouTube API it goes in here. The YouTubeKnowledgeBase will take longitude and latitude as provided by the YouTube API and transform it to WKT to pass it into the SpatialSemanticTag.

### ContextCoordinates and ContextPoint
Context coordinates and context points are very important to the structure of shark and combine the previously named and created semantic Tags. Informations can be added to context coordinates, which in this case was not necessary for all the cases.

## Video in Shark

This is the description of the YouTube Video in the semantic structure of Shark.

![Video Diagram](https://github.com/frimelle/YouTubeImporter/blob/master/VideoDiagram.PNG "VideoDiagram")

The SI is set to the video URL and the address is set to the videoId so the video becomes identifiable and searchable in a context space.

### Originator
There are no users but only channels in YouTube so that is the creator and/or uploader of the video. Therefore the originator is the channelId.

### Peer
If the video comes from a playlist, the peer will be the playlistId. Otherwise it is equal to the originator.

### RemotePeer
The remote peer is equal to the peer.

### Topic
The topic is a String from YouTubeCategory() which returns a category that has been associated with the video.

### Time
The time when the video was published on YouTube.

### Location
That is the location, YouTube returns for the video, set by the user where the video was recorded. This is often left empty and would result in the location being set to null.

### ContextCoordinates and ContextPoint
From those Tags a contextCoordinates is created and transformed to a contextPoint. Thereby we have the video created as a ContextPoint in the knowledgeBase where it can be worked with further.

## Playlist in Shark

There are three different kinds of Playlist: the playlist from favorited Videos, from uploaded Videos and liked Videos of a certain channel (which is basically the same as a user in this case). We handle all those playlists the same. Playlists are mainly there to create a link between Videos and Channels beside the direct link they already have. It is an important part espacially when building a bigger semantic net of playlists.

Again the SI is the playlists URL and the address is the playlist ID.

### Originator
The originator is the channel ID of the person who created this playlist. Depending on the creation of the playlist object passed to the function, this might be a playlist of the users favorited, liked or uploaded videos.

### Peer
The peer is equal to the originator.

### Remote Peer
The remote peer is equal to the peer.

### Topic
The topic is the title of the playlist for uniformity reasons and lack of category options that could be assigned.

### Time
The time the playlist was published on YouTube.

### Location
The location of playlists is always set to null since there are no location informations for playlists.

### Information
For every video that is part of the playlist, an Information with its ID will be created. Since the information is just filled with a string of the video ID, its content type is set to 'text/plain'.

### ContextCoordinates and ContextPoint
The informations are added to the context point after it is created from the context coordinates, which are assembled by the semantic tags mentioned before.

## Channel in Shark

The channel is very important to the structure of our model. It connects it to the social idea of shark by having an identifiable user ID and also connects it to the "outside world" in the way that it enables interaction with other google plus ids(so long as provided).

### Originator
We originally made the originator with the google plus ID but not every channel necessarily has such an ID associated with it and soon google will make it possible to decouple the google plus account from the youtube account so we coudn't guarantee the ID to be not null. Our only other option was to use the channel ID which is not the best solution but for now that is what we got.

### Peer
The peer is equal to the originator.

### Remote Peer
The remote peer is equal to the peer.

### Topic
The topic is the channel's title for uniformity reasons and lack of category settings.

### Time
The time is the timestamp at which the channel was created on YouTube.

### Location
Channels can have a country code associated with them which we used to create a hashmap of approximate longitute and latitude values for the country's epicenter which can then be assigned to the respective country code.

### ContextCoordinates and ContextPoint
The context point of a channel is created from its context coordinates.

### Information
Since the google plus ID is of great value we want to add it to our context point if supplied. This is done in an information which is then added to our context point.

# Example Usecase
This class is an example of how to set up a bigger net of videos, channels and playlists.
In the case of the function *importVideosFromChannel* a channelId is passed together with an API key. The function will create a shark knowledge base and fill it with the channel and the playlist of the channel's uploaded videos and the videos in that playlist. This will, for an active channel on YouTube, pretty quickly produce a lot of context points, especially for the context points of videos.
This way it would be possible to recursivly get all connected videos, channels and playlists of channel and their connected videos, channels etc. if wished to set up a huge network representing a part of the relations in YouTube of channels and their videos to each other. 
