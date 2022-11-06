package com.zne;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @author ZNE
 * @see <a href="https://zhuanlan.zhihu.com/p/337000646">OkHttp使用总结</a>
 * @since 2022/10/24
 */
@SpringBootTest
public class OkHttpTest {

    /**
     * okhttp3测试
     */
    @Test
    void test1() throws IOException {
        String url = "http://127.0.0.1:8080/retry/show/1";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().get().url(url).build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }
}
