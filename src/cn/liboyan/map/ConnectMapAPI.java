package cn.liboyan.map;

import java.io.*;
import java.net.*;

public class ConnectMapAPI {
    public static String connectAPI(String targetUrl, String comm) {
        String rec_string = "";
        URL url = null;
        HttpURLConnection urlconn = null;
        OutputStream out = null;
        BufferedReader reader = null;
        try {
            url = new URL(targetUrl);
            urlconn = (HttpURLConnection) url.openConnection();
            urlconn.setReadTimeout(1000 * 30);
            urlconn.setRequestMethod("POST");
            urlconn.setDoInput(true);
            urlconn.setDoOutput(true);
            out = urlconn.getOutputStream();
            out.write(comm.getBytes("UTF-8"));
            out.flush();
            out.close();
            reader = new BufferedReader(new InputStreamReader(urlconn.getInputStream(),"UTF-8"));
            StringBuffer buffer = new StringBuffer();
            int ch;
            while ((ch = reader.read()) > -1)
                buffer.append((char)ch);
            rec_string = buffer.toString();
        } catch (Exception e) {
            return "";
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (urlconn != null) {
                    urlconn.disconnect();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
            }
        }
        return rec_string;
    }
    public static String getResponse(String serverUrl) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(serverUrl);
            URLConnection conn = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            String line;
            while((line = in.readLine()) != null){
                result.append(line);
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
    public static void mapRun(String url) {

    }
}
