package com.zne.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author ZNE
 * @since 2022/11/6
 */
@CrossOrigin
@RestController
public class SseEmitterController {

    @RequestMapping(value = "/sse")
    public void getStreamDataImprove(HttpServletResponse response) throws IOException, InterruptedException {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        String s = "";
        while (true) {
            s = "data: " + new Date() + "\n\n";
            PrintWriter pw = response.getWriter();
            TimeUnit.SECONDS.sleep(1L);
            pw.write(s);
            pw.flush();
        }
    }

    @RequestMapping(value = "/sse-retry")
    public void getStreamDataImprove1(HttpServletResponse response) throws IOException {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        // 浏览器默认的是，如果服务器端三秒内没有发送任何信息，则开始重连。服务器端可以用retry头信息，指定通信的最大间隔时间。
        String s = "retry: 2000\n";
        s += "data: " + new Date() + "\n\n";
        PrintWriter pw = response.getWriter();
        pw.write(s);
        pw.flush();
    }
}
