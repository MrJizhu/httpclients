import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jizhu on 2019/2/27.
 */
public class SimpleClient {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient= HttpClients.createDefault();
        try {
            HttpGet httpGet=new HttpGet("https://www.baidu.com/");
            CloseableHttpResponse response1=httpClient.execute(httpGet);
            try {
                System.out.println(response1.getStatusLine());
                HttpEntity entity1=response1.getEntity();
                EntityUtils.consume(entity1);
            }finally {
                response1.close();
            }

            HttpPost httpPost=new HttpPost("http://httpbin.org/post");
            List<NameValuePair> nvps=new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("username","vip"));
            nvps.add(new BasicNameValuePair("password","secret"));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            CloseableHttpResponse response2=httpClient.execute(httpPost);
            try {
                System.out.println(response2.getStatusLine());
                HttpEntity entity2=response2.getEntity();
                EntityUtils.consume(entity2);
            }finally {
                response2.close();
            }

        }finally {
            httpClient.close();
        }

    }



}
