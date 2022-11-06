package com.zne.pipeline;

import com.foldright.auto.pipeline.AutoPipeline;
import com.zne.model.Receipt;

/**
 * 责任链
 *
 * @author ZNE
 * @see <a href="https://mp.weixin.qq.com/s?__biz=MzIzOTU0NTQ0MA==&mid=2247510173&idx=1&sn=12c7a610644c9312cf2e3400c7a1a73a&chksm=e92a9592de5d1c84d95f8550c1f02f2fcfffa773166f09757d63bcea2015d1233ed0610a95b7&scene=132#wechat_redirect">一个注解搞定责任链</a>
 * @since 2022/10/8
 */
@AutoPipeline
public interface IReceiptHandleChain {

    /**
     * 责任链处理
     *
     * @param receipt receipt
     */
    void handleReceipt(Receipt receipt);

}
