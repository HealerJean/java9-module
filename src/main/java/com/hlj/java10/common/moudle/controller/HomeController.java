package com.hlj.java10.common.moudle.controller;


import com.hlj.java10.common.data.ResponseBean;
import com.hlj.java10.common.entity.DemoEntity;
import com.hlj.java10.common.entity.repository.DemoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @Description
 * @Author HealerJean
 * @Date 2018/3/22  上午10:22.
 */
@Controller
public class HomeController {



    @Autowired
    private DemoEntityRepository demoEntityRepository;


    //http://localhost:8080/insert?name=HealerJean
    @GetMapping("insert")
    public @ResponseBody
    ResponseBean insert(DemoEntity demoEntity){
        try {
            return  ResponseBean.buildSuccess(demoEntityRepository.save(demoEntity));
        }catch (Exception e){
            return  ResponseBean.buildFailure(e.getMessage());
        }
    }


    @GetMapping("findById")
    @ResponseBody
    public ResponseBean  findById(Long id){
        try {
            return ResponseBean.buildSuccess(demoEntityRepository.findById(id).orElse(null));
        }catch (Exception e){
            return  ResponseBean.buildFailure(e.getMessage());
        }
    }





}
