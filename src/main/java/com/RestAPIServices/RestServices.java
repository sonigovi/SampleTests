package com.RestAPIServices;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

//    import utils.APIPropertyFileReader;
//  import utils.GenerateXLReport;
//import utils.ParaMethodAPI;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.LogStatus;

public class RestServices {
    public static String pageUrl;
    public static SSLContext sslcontext;
    public static HttpPost httpPost;
    public static HttpGet httpGet;
    public static HttpDelete httpDelete;
    public static HttpClient client;
    public static HttpResponse httpResponse;
    // GenerateXLReport objXLreport = new GenerateXLReport();
    // public static APIPropertyFileReader prop = new APIPropertyFileReader();
    public static String Environment;

    @SuppressWarnings("deprecation")
    @BeforeMethod
    public static void main() throws NoSuchAlgorithmException, KeyManagementException {
        sslcontext = SSLContext.getInstance("TLSv1.2");
        sslcontext.init(null, null, null);
        try {
            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslcontext,
                    SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER); // Socket
            client = HttpClients.custom().setSSLSocketFactory(socketFactory).build();

        } catch (Exception e) {
            System.err.println("HttpsURLConnection Failed");
            e.printStackTrace();
        }
        pageUrl = "https://uat-api.mgmresorts.com";
        System.out.println("QA");

    }

    @org.testng.annotations.Test
    public void login() {
        try {
            httpPost = new HttpPost(pageUrl + "/auth/login");

            String auth = "MFASA217@mgmqa.com" + ":" + "Password123";
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("ISO-8859-1")));
            String authHeader = "Basic " + new String(encodedAuth);

            httpPost.setHeader("x-api-key", "IYivXm1po0awMVnneesIiagESE07fbWV91L0hmPw");
            httpPost.setHeader("x-api-version", "1");
            httpPost.setHeader("Content-Type", "application/json; charset=utf-8");

            httpPost.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

            httpResponse = client.execute(httpPost);

            String sessionID = httpResponse.getFirstHeader("Set-Cookie").getValue();
            sessionID = sessionID.substring(0).split(";")[0];
            System.out.println(sessionID);

            StatusLine statusLine = httpResponse.getStatusLine();
            System.out.println(statusLine);
            Assert.assertTrue(statusLine.getStatusCode() == HttpStatus.SC_OK);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            httpResponse.getEntity().writeTo(outputStream);
            String responseString = outputStream.toString();
            System.out.println(responseString);

        } catch (Exception | AssertionError e) {

            Assert.fail(e.getMessage());
        }

    }
}
