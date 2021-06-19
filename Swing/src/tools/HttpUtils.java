package tools;

import cmd.StructureSystem;
import cmd.TypeSystem;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.*;

public class HttpUtils implements HttpClient.post {

    private String str_url="http://127.0.0.1:8080/";
    @Override
    public HttpURLConnection http(String servlet) {
        try {
            URL url = new URL(str_url+servlet);
            URLConnection rulConnection = url.openConnection();
            HttpURLConnection httpUrlConnection = (HttpURLConnection) rulConnection;

            httpUrlConnection.setDoOutput(true);

            httpUrlConnection.setDoInput(true);

            httpUrlConnection.setUseCaches(false);

            httpUrlConnection.setRequestProperty("", "");

//            httpUrlConnection.setRequestProperty("accept", "*/*");
//            httpUrlConnection.setRequestProperty("connection", "Keep-Alive");

            httpUrlConnection.setRequestMethod("POST");

            return httpUrlConnection;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String httpLogin(String username, String password) throws IOException, JSONException {
        HttpURLConnection httpUrlConnection= http("login");

        OutputStream outputStream = httpUrlConnection.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put(StructureSystem.TYPE, TypeSystem.LOGIN);
        jsonObject.put(StructureSystem.USERNAME,username);
        jsonObject.put(StructureSystem.PASSWORD,password);
//        out.writeBytes(jsonObject.toString());
//        out.flush();
        System.out.println(jsonObject.toString());
        objectOutputStream.writeObject(jsonObject.toString());
        objectOutputStream.flush();
        objectOutputStream.close();


        InputStreamReader read = new InputStreamReader(
                httpUrlConnection.getInputStream());
        BufferedReader reader = new BufferedReader(read);
        String line = "";
        while ((line = reader.readLine()) != null) {

            return  line;

        }
        return null;
    }
}
