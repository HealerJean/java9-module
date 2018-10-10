package com.hlj.java10.study.Demo02ListPack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Desc:
 * @Author HealerJean
 * @Date 2018/10/9  下午5:36.
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class Domo02Entry {

    private Long id ;

    private String name ;

}
