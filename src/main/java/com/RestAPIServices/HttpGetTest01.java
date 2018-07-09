package com.RestAPIServices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;

public class HttpGetTest01 {
    public static HttpClient client;

    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws ClientProtocolException, IOException, NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
        SSLContextBuilder builder = new SSLContextBuilder();
        builder.loadTrustMaterial(null, new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                return true;
            }
        });

        SSLConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(builder.build(),
                SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

        client = HttpClients.custom().setSSLSocketFactory(sslSF).build();

        HttpGet request = new HttpGet("https://auroraws-pp.mgmresorts.local/tpws/customer/search?request=%7B%22key%22:%7B%22mlifeNo%22:75754334%7D%7D");

        // HttpGet request = new HttpGet("https://auroraws-pp.mgmresorts.local/tpws/customer/search?request={\"key\":{\"mlifeNo\":{75754334}}}");
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
        client.getConnectionManager().shutdown();
    }
}