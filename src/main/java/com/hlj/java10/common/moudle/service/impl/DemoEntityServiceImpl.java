package com.hlj.java10.common.moudle.service.impl;

import com.hlj.java10.common.entity.repository.DemoEntityRepository;
import com.hlj.java10.common.moudle.service.DemoEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Desc:
 * @Author HealerJean
 * @Date 2018/9/17  下午2:39.
 */
@Service
@Slf4j
public class DemoEntityServiceImpl implements DemoEntityService {

    @Resource
    DemoEntityRepository demoEntityRepository ;



}
