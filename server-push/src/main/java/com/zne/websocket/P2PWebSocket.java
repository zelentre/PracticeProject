package com.zne.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author ZNE
 * @since 2022/11/7
 */
@Component
@ServerEndpoint(value = "/p2p")
public class P2PWebSocket {
    private static Logger log = LoggerFactory.getLogger(P2PWebSocket.class);
    private static Session[] sessionContainer = new Session[2];

    /**
     * A、B与服务器建立连接
     */
    @OnOpen
    public void onOpen(Session session) {
        if (sessionContainer[0] == null && sessionContainer[1] == null) {
            sessionContainer[0] = session;
            log.info("A用户已接入");
        } else if (sessionContainer[0] != null && sessionContainer[1] == null) {
            sessionContainer[1] = session;
            log.info("B用户已接入");
            log.info("A与B用户准备就绪");
        } else {
            // do nothing
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void close(Session session) {
        for (int i = 0; i < sessionContainer.length; i++) {
            if (session == sessionContainer[i]) {
                sessionContainer[i] = null;
                log.info((i == 0 ? "A" : "B") + "用户已退出");
            }
        }
    }

    /**
     * 得到另一个Session对象
     */
    private Session getOtherSession(Session session) {
        for (int i = 0; i < sessionContainer.length; i++) {
            if (session == sessionContainer[i]) {
                return sessionContainer[(i == 0 ? 1 : 0)];
            }
        }
        return null;
    }

    /**
     * 向另一个会话发送消息
     */
    @OnMessage
    public void sendMessage(String message, Session session) throws IOException {
        Session otherSession = this.getOtherSession(session);
        otherSession.getBasicRemote().sendText(message);
    }

    /**
     * 异常处理
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("会话出现异常：{}", error);
    }

}
