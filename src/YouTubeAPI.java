import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.apache.http.NameValuePair;


/**
 * Class responsible for handling YouTube API calls
 */
public class YouTubeAPI {
	
	/** 
	 * YouTube v3 API key used for making requests
	 */
	private String apiKey = null;
	
	/**
	 * Base URL for all requests
	 */
	private static final String API_URL = "www.googleapis.com/youtube/v3/";
	
	/**
	 * List of YouTube categories. Need to be fetched if necessary, as they may change over time
	 */
	private Collection<YouTubeCategory> youtubeCategories;
	
	/**
	 * Constructor requires YouTube v3 API key which can be requested at https://console.developers.google.com	
	 * @param apiKey
	 * @throws IllegalArgumentException
	 */
	public YouTubeAPI(String apiKey) throws IllegalArgumentException {
		if (apiKey.length() < 32) {
			throw new IllegalArgumentException("Please supply a YouTube API key. You may acquire one for free at at https://console.developers.google.com");
		}
		this.apiKey = apiKey;
	}

	/**
	 * 
	 * @param request The general request as outlined on https://developers.google.com/youtube/v3/docs/
	 * @param parameters The parameters related to the request. "part" parameters is required by all requests.
	 * @return URL The URL where we will get our JSON response
	 * @throws MalformedURLException
	 */
	private URL getRequestUrl(String request, List<NameValuePair> parameters) throws MalformedURLException {
		parameters.add(new BasicNameValuePair("key", this.apiKey));
		URIBuilder builder = new URIBuilder().setScheme("https").setHost(API_URL + request + "/").setParameters(parameters);
		return new URL(builder.toString());
	}
	
	/**
	 * Performing the request based on a given request URL
	 * @param url URL created by getRequestUrl()
	 * @return JsonElement - The JSON response sent by Google's YouTube v3 API
	 * @throws IOException
	 */
	private JsonElement getRequestResponse(URL url) throws IOException {		
		HttpsURLConnection request = (HttpsURLConnection) url.openConnection();
	    request.connect();
	    if (request.getResponseCode() != 200) {
	    	throw new IOException("Response code was not 200. Check your API key and / or its available quota. Affected query URL:\n " + url);
	    }
	    JsonParser jsonParser = new JsonParser();
	    JsonElement jsonElement = jsonParser.parse(new InputStreamReader((InputStream) request.getContent()));
	    return jsonElement;
	}
	
	/**
	 * Builds a request to receive a YouTube Channel by its given name
	 * @param name The Channel Name
	 * @return YouTubeChannel The object representing the Channel
	 * @throws Exception
	 */
	public YouTubeChannel getChannelByName(String name) throws Exception {
		YouTubeChannel channel = null;
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		
		parameters.add(new BasicNameValuePair("part", "contentDetails"));
		parameters.add(new BasicNameValuePair("forUsername", name));
		try {
			URL requestUrl = getRequestUrl("channels", parameters);
			JsonElement jsonResponse = getRequestResponse(requestUrl);
			JsonObject jsonObject = jsonResponse.getAsJsonObject();
			JsonElement channelElement = jsonObject.get("items");
			
			Gson gson = new Gson();
			
			//Working with a collection because the JSON is built to possibly give multiple results
			Collection<YouTubeChannel> channels = null;
			
			Type collectionType = new TypeToken<Collection<YouTubeChannel>>(){}.getType();
			channels = gson.fromJson(channelElement, collectionType);
			
			try {
				//Just grabbing "first" result, since the API only returns exact matches / one result in any case
				channel = channels.iterator().next();
				channel.setTitle(name); //Manually setting this value because it's not returned by the API
			} catch (NoSuchElementException e) {
				//No channel found
				channel = null;
			}
		} catch(Exception e) {
			throw e;
		}
		return channel;
	}
	
	/**
	 * Builds a request to receive a YouTube Playlist by its ID
	 * @param id The PlaylistId
	 * @return YouTubePlaylist Playlist object
	 * @throws Exception
	 */
	public YouTubePlaylist getPlaylistById(String id) throws Exception {
		YouTubePlaylist playlist = null;
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		
		parameters.add(new BasicNameValuePair("part", "snippet"));
		parameters.add(new BasicNameValuePair("id", id));
		try {
			URL requestUrl = getRequestUrl("playlists", parameters);
			JsonElement jsonResponse = getRequestResponse(requestUrl);
			JsonObject jsonObject = jsonResponse.getAsJsonObject();
			JsonElement playListItems = jsonObject.get("items");
			
			Gson gson = new Gson();
			
			//Working with a collection because the JSON is built to possibly give multiple results
			Collection<YouTubePlaylist> playlists = null;
			
			Type collectionType = new TypeToken<Collection<YouTubePlaylist>>(){}.getType();
			playlists = gson.fromJson(playListItems, collectionType);
			
			try {
				//Just grabbing "first" result, since the API only returns exact matches / one result in any case
				playlist = playlists.iterator().next();
			} catch (NoSuchElementException e) {
				//No channel found
				playlist = null;
			}
			

		} catch(Exception e) {
			throw e;
		}
		return playlist;
	}
	
	/**
	 * Builds a request to receive a YouTube Playlist by its ID
	 * @param id The PlaylistId
	 * @return Collection<YouTubeVideo> Collection of YouTubeVideos returned by playlist
	 * @throws Exception
	 */
	protected Collection<YouTubeVideo> getPlayListItems(String id) throws Exception {
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		Collection<YouTubeVideo> playlistItems = null;
		parameters.add(new BasicNameValuePair("part", "contentDetails"));
		parameters.add(new BasicNameValuePair("maxResults", "50")); //50 = max videos returned per result "page", default is only 5
		parameters.add(new BasicNameValuePair("playlistId", id));
		try {
			URL requestUrl = getRequestUrl("playlistItems", parameters);
			JsonElement jsonResponse = getRequestResponse(requestUrl);
			JsonObject jsonObject = jsonResponse.getAsJsonObject();
			JsonElement playListItems = jsonObject.get("items");
			
			Gson gson = new Gson();
			
			Collection<YouTubeVideo> playlistItemsPage = null;
			
			Type collectionType = new TypeToken<Collection<YouTubeVideo>>(){}.getType();
			playlistItems = gson.fromJson(playListItems, collectionType);
			
			playlistItemsPage = this.getPlayListItems(id);
		} catch(Exception e) {
			throw e;
		}
		return playlistItems;
	}
	
	/**
	 * Builds a request to receive a YouTube Video by its ID
	 * @param id The Video ID
	 * @return YouTubeVideo The object representing the video data
	 * @throws Exception
	 */
	protected YouTubeVideo getVideoById(String id) throws Exception {
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		YouTubeVideo video = null;
		parameters.add(new BasicNameValuePair("part", "snippet,recordingDetails"));
		parameters.add(new BasicNameValuePair("id", id));
		try {
			URL requestUrl = getRequestUrl("videos", parameters);
			JsonElement jsonResponse = getRequestResponse(requestUrl);
			JsonObject jsonObject = jsonResponse.getAsJsonObject();
			JsonElement playListItems = jsonObject.get("items");
			
			Gson gson = new Gson();
			
			Collection<YouTubeVideo> videos = null;
			
			Type collectionType = new TypeToken<Collection<YouTubeVideo>>(){}.getType();
			videos = gson.fromJson(playListItems, collectionType);
			try {
				//Just grabbing "first" result, since the API only returns exact matches / one result in any case
				video = videos.iterator().next();
			} catch (NoSuchElementException e) {
				//No channel found
				video = null;
			}
			
		} catch(Exception e) {
			throw e;
		}
		return video;
	}
	
	/**
	 * Builds a request to fetch all YouTube categories
	 * @return Collection<YouTubeCategory List of all YouTube categories
	 * @throws Exception
	 */
	protected void queryCategories() throws Exception {
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair("part", "snippet"));
		parameters.add(new BasicNameValuePair("regionCode", "DE"));
		try {
			URL requestUrl = getRequestUrl("videoCategories", parameters);
			JsonElement jsonResponse = getRequestResponse(requestUrl);
			JsonObject jsonObject = jsonResponse.getAsJsonObject();
			JsonElement playListItems = jsonObject.get("items");
			
			Gson gson = new Gson();		
			
			Type collectionType = new TypeToken<Collection<YouTubeCategory>>(){}.getType();
			this.youtubeCategories = gson.fromJson(playListItems, collectionType);
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * Builds a request to fetch all YouTube categories
	 * @return Collection<YouTubeCategory List of all YouTube categories
	 * @throws Exception
	 */
	protected YouTubeCategory getCategoryById(String id) throws Exception {
		//Only fetch categories from API if the current API instance has not fetched them yet
		if (this.youtubeCategories == null) {
			this.queryCategories();
		}
		
		for (YouTubeCategory category : this.youtubeCategories) {
			if (category.getId().equals(id)) {
				return category;
			}
		}		
		return null;
	}
	
	
	
}
