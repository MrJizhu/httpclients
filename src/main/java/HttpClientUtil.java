import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Map;

/**
 * Created by jizhu on 2019/2/27.
 */
public class HttpClientUtil {

    /**
     *  请求编码
     */
    private static final String DEFAULT_CHARSET="UTF-8";

    public static String httpPostWithJSON(String url, Map<String,?> param) throws IOException {
        CloseableHttpClient client= HttpClients.createDefault();
        try {
            if (url==null||url.trim().length()==0){
                throw new Exception("URL is null");
            }
            HttpPost httpPost=new HttpPost(url);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
        return null;
    }

}
