import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
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
	 * Constructor requires YouTube v3 API key which can be requested at https://console.developers.google.com	
	 * @param apiKey
	 * @throws IllegalArgumentException
	 */
	public YouTubeAPI(String apiKey) throws IllegalArgumentException {
		if (apiKey.length() < 32) {
			throw new IllegalArgumentException("Please supply a YouTube API key.");
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
	    	throw new IOException("Response code was not 200");
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
			
			//Just grabbing "first" result, since the API only returns exact matches / one result in any case
			channel = channels.iterator().next();
			
		} catch(Exception e) {
			throw e;
		}
		return channel;
	}
	
}
