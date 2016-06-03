package runforfun.data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	public static Boolean debug = true;

	public static StringBuilder readHttpData(String uri) {
		StringBuilder strBuilder = new StringBuilder();
		BufferedReader reader = null;

		try {
			if(!debug) {
				HttpClient client = new DefaultHttpClient();
				HttpResponse response = client.execute(new HttpGet(uri));
				int status = response.getStatusLine().getStatusCode();
				if(status == 200) {
					InputStream in = response.getEntity().getContent();
					reader = new BufferedReader(new InputStreamReader(in));
				}
				else {
					Log.e(tag, "Failed to download file via HTTP.");
				}
			}
			else{
				File file = new File(Environment.getExternalStorageDirectory(), "debug.txt");
				FileInputStream in = new FileInputStream(file);
				reader = new BufferedReader(new InputStreamReader(in));
			}

			String line;
			while((line=reader.readLine())!=null) {
				strBuilder.append(line);
			}

			reader.close();
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e(tag, "Failed to download file via HTTP.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e(tag, "Failed to download file via HTTP.");
		}
		
		if(!debug) {
			Utils.writeToExternalCard("debug.txt", strBuilder.toString());
		}
			
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
