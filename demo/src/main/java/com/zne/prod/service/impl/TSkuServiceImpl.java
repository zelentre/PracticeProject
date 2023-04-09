package com.zne.prod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zne.prod.entity.TSku;
import com.zne.prod.mapper.TSkuMapper;
import com.zne.prod.service.TSkuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ZNE
 * @since 2023-04-09
 */
@Service
public class TSkuServiceImpl extends ServiceImpl<TSkuMapper, TSku> implements TSkuService {

    @Override
    public List<TSku> getSkuList(Long prodId) {
        List<TSku> list = this.lambdaQuery().eq(TSku::getProdId, prodId).list();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
