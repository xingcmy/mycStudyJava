package tools;

import java.io.IOException;
import java.net.HttpURLConnection;

public interface HttpClient {
    interface post {
        /**
         * 启用post
         *
         * @param servlet
         * @return
         */
        HttpURLConnection http(String servlet);

        /**
         * 向服务端发送username和password
         *
         * @param username
         * @param password
         * @return
         *
         */
        String httpLogin(String username, String password) throws IOException;

    }


    }
