package runforfun.data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.Environment;
import android.util.Log;


public class Utils {
	private static String tag = "RunForFun";
	
	public static StringBuilder readHttpData(String uri) {
		HttpClient client = new DefaultHttpClient();
		StringBuilder strBuilder = new StringBuilder();
		try {
			HttpResponse response = client.execute(new HttpGet(uri));
			int status = response.getStatusLine().getStatusCode();
			if(status == 200) {			
				InputStream in = response.getEntity().getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				String line;
				while((line=reader.readLine())!=null) {
					strBuilder.append(line);
				}
			}
			else {
				Log.e(tag, "Failed to download file via HTTP.");
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e(tag, "Failed to download file via HTTP.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e(tag, "Failed to download file via HTTP.");
		}
		Log.i(tag, String.valueOf(strBuilder.capacity()));
		
		return strBuilder;
	}
	
	public static void writeToExternalCard(String fileName, String data) {
		
		File file = new File(Environment.getExternalStorageDirectory(), fileName);
		
		try {
			FileOutputStream os = new FileOutputStream(file);
			os.write(data.getBytes());
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
