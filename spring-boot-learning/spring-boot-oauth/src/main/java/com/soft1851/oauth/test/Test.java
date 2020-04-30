package com.soft1851.oauth.test;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class Test {
    public static void main(String[] args) throws Exception {
        test1();
        //test2();
    }

    private static void test2() throws NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException, IOException {
        URL reqURL = new URL("http://localhost:8080/");
        //创建SSLContext对象，并使用我们指定的信任管理器初始化
        TrustManager[] tm = {new MyX509TrustManager()};
        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
        sslContext.init(null, tm, new java.security.SecureRandom());
        //从上述SSLContext对象中得到SSLSocketFactory对象
        SSLSocketFactory ssf = sslContext.getSocketFactory();

        //创建HttpsURLConnection对象，并设置其SSLSocketFactory对象
        HttpsURLConnection httpsConn = (HttpsURLConnection) reqURL.openConnection();
        httpsConn.setSSLSocketFactory(ssf);
        //向服务端发送数据
        httpsConn.setDoOutput(true);
        httpsConn.setRequestMethod("POST");
        OutputStreamWriter out = new OutputStreamWriter(httpsConn.getOutputStream(), "utf-8");
        out.write("java");
        out.flush();
        out.close();

        //读取响应内容
        InputStreamReader in = new InputStreamReader(httpsConn.getInputStream());
        int respInt = in.read();
        while (respInt != -1) {
            System.out.print((char) respInt);
            respInt = in.read();
        }
    }

    private static void test1() throws IOException {
        URL reqURL = new URL("http://localhost:8080/");
        HttpsURLConnection httpsConn = (HttpsURLConnection) reqURL.openConnection();

        //向服务端发送数据
        httpsConn.setDoOutput(true);
        httpsConn.setRequestMethod("POST");
        OutputStreamWriter out = new OutputStreamWriter(httpsConn.getOutputStream(), "utf-8");
        out.write("java");
        out.flush();
        out.close();

        //读取响应内容
        InputStreamReader in = new InputStreamReader(httpsConn.getInputStream());
        int respInt = in.read();
        while (respInt != -1) {
            System.out.print((char) respInt);
            respInt = in.read();
        }
    }
}
