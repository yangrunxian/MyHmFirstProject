package com.example.httplibrary;

import com.example.httplibrary.exception.CreateErrorException;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.net.NetHandle;
import ohos.net.NetManager;
import ohos.net.NetStatusCallback;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpConnection {
    private static final HiLogLabel TAG = new HiLogLabel(1, 1, HttpConnection.class.getSimpleName());
    private NetManager netManager;
    private NetHandle netHandle;

    public HttpConnection() throws Exception {
        super();
        netManager = NetManager.getInstance(null);
        if (!netManager.hasDefaultNet()) {
            throw new CreateErrorException();
        }
        netHandle = netManager.getDefaultNet();
    }

    public void get(NetStatusCallback callback) {
        if (callback != null) {
            netManager.addDefaultNetStatusCallback(callback);
        }
        HttpURLConnection connection = null;
        try {
            String urlString = "EXAMPLE_URL"; // 开发者根据实际情况自定义EXAMPLE_URL
            URL url = new URL(urlString);

            URLConnection urlConnection = netHandle.openConnection(url,
                    java.net.Proxy.NO_PROXY);
            if (urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
            }
            connection.setRequestMethod("GET");
            connection.connect();
            // 之后可进行url的其他操作
        } catch (IOException e) {
            HiLog.error(TAG, "exception happened.");
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
    public void post(List<Map<String, String>> param, NetStatusCallback callback) {
        if (callback != null) {
            netManager.addDefaultNetStatusCallback(callback);
        }
        String json = "12312312";
        HttpURLConnection connection = null;
        try {
            String urlString = "EXAMPLE_URL"; // 开发者根据实际情况自定义EXAMPLE_URL
            URL url = new URL(urlString);

            URLConnection urlConnection = netHandle.openConnection(url,
                    java.net.Proxy.NO_PROXY);
            if (urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
            }
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("Charset", "UTF-8");
            connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
            connection.setRequestProperty("accept","application/json");
            if (json.isEmpty()) {
                byte[] writebytes = json.getBytes();
                connection.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
                OutputStream outwritestream = connection.getOutputStream();
                outwritestream.write(json.getBytes());
                outwritestream.flush();
                outwritestream.close();
                connection.getResponseCode();
            }

            connection.connect();
            // 之后可进行url的其他操作
        } catch (IOException e) {
            HiLog.error(TAG, "exception happened.");
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
