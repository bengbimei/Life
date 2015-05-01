package utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;


/**
 * 
 * @author Administrator
 *
 */
public class HttpUtil {
	

	/**
	 * ����ͼƬ:LruCache+DiskLruCache
	 * @param context
	 * @param url
	 */
	


	/**
	 * ��������ͼƬ
	 * @param path
	 * @return
	 * path:http://localhost:8080/android_server/images/pic1.jpg
	 */

	
	/**
	 * ��������JSON�б�
	 * @param path
	 * @return
	 */
	public static String getJsonFromNet(String path){
		HttpClient httpClient = new DefaultHttpClient();
		try {
			HttpGet httpGet= new HttpGet(path);
			HttpResponse response=httpClient.execute(httpGet);
			if(response.getStatusLine().getStatusCode()==200)
				return EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			httpClient.getConnectionManager().shutdown();
		}
		return null;
	}
	public static String postJsonFromNet(String path) throws ClientProtocolException, IOException{
		HttpClient client=new DefaultHttpClient();
		
		HttpPost httpPost = new HttpPost(path);
		
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("pageindex", "1"));
		params.add(new BasicNameValuePair("pagesize", "10"));
		
		//�����������
		httpPost.setEntity(new UrlEncodedFormEntity(params));
		
		
		HttpResponse response = client.execute(httpPost);
		
		if(response.getStatusLine().getStatusCode()==200){//����ɹ�
			return EntityUtils.toString(response.getEntity());
		}
		return null;

		
		
	}
	public static byte[] postImageFromNet(String path) throws ClientProtocolException, IOException{
		HttpClient client=new DefaultHttpClient();
		
		HttpPost httpPost = new HttpPost(path);
		
		List<NameValuePair> params=new ArrayList<NameValuePair>();
	
		
		//�����������
		httpPost.setEntity(new UrlEncodedFormEntity(params));
		
		
		HttpResponse response = client.execute(httpPost);
		
		if(response.getStatusLine().getStatusCode()==200){//����ɹ�
			return EntityUtils.toByteArray(response.getEntity());
		}
		return null;

		
		
	}
	
}
