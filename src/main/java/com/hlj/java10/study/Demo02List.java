package com.hlj.java10.study;

import com.hlj.java10.study.Demo02ListPack.Domo02Entry;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Desc:
 * @Author HealerJean
 * @Date 2018/10/9  下午5:31.
 */
public class Demo02List {

    @Test
    public void of(){
        var listOf  = List.of(new Domo02Entry(1L,"healerjean"),new Domo02Entry(1L,"张宇晋") );
        listOf.stream().forEach(System.out::println);
    }
}
