---
title: Java9_模块化
date: 2018-10-12 03:33:00
tags: 
- Java
category: 
- Java
description: Java9_模块化
---
<!-- image url 
https://raw.githubusercontent.com/HealerJean123/HealerJean123.github.io/master/blogImages
　　首行缩进
<font color="red">  </font>
-->

## 前言

![WX20181009-175940@2x](https://raw.githubusercontent.com/HealerJean123/HealerJean123.github.io/master/blogImages/WX20181009-175940@2x.png)





## 1、必须是java文件夹下面才可以创建`module-info.java`，添加两个maven。module项目。分别为one和two

![WX20181009-181918](https://raw.githubusercontent.com/HealerJean123/HealerJean123.github.io/master/blogImages/WX20181009-181918.png)



```java

module one {
}

```


```java

module two {
}

```

## 2、设置模块的依赖和权限

### 2.1、设置modulej级别为9（我的idea初始为5）
![WX20181009-191640](https://raw.githubusercontent.com/HealerJean123/HealerJean123.github.io/master/blogImages/WX20181009-191640.png)


### 2.2、one中创建两个包和方法

![WX20181009-191823](https://raw.githubusercontent.com/HealerJean123/HealerJean123.github.io/master/blogImages/WX20181009-191823.png)


```java
package com.hlj.java9.can;


public static class UtilCan {

    public void can(){
        System.out.println("can");
    }
}



```


```java
package com.hlj.java9.cannot;


public static class UtilCanNot {

    public void canNot(){
        System.out.println("canNot");
    }
}


```


### 2.3、one中`module-info.java`


```java

module one {
//导出可用包
     exports  com.hlj.java9.can;
}

```


### 2.4、two中进行引入，如果发现为红报错，则，alt+enter进行one包的引入


```java
module two {
     requires one;
}

```

### 2.5、two中开始使用


```java
package com.hlj.java9.use;


import com.hlj.java9.can.UtilCan;
//import com.hlj.java9.cannot.UtilCanNot; //导入了，但是报错

public class Use {

    public static void main(String[] args) {
        UtilCan.can();
//        UtilCanNot.canNot(); 可以导入，但是编译不成功
    }
}


```

## 3、模块化中的服务（Service接口）
<br/>
### 3.1、创建接口和实现类

#### 3.1.1、接口

```java
package com.hlj.java9.api;

public interface MyServiceInter {

    void method();

}


```

#### 3.1.2、实现类


```java
package com.hlj.java9.api.impl;

import com.hlj.java9.api.MyServiceInter;


public class MyServiceInterImpl  implements MyServiceInter {

    @Override
    public void method() {
        System.out.println("接口实现类");
    }
    
    public static  void staticImpl(){
    System.out.println("接口实现类中自己定义的静态方法");
}

}


```

#### 3.1.3、第二个实现类


```java
package com.hlj.java9.api.impl;

import com.hlj.java9.api.MyServiceInter;


public class MyServiceInterImplTwo implements MyServiceInter {

    @Override
    public void method() {

        System.out.println("第二个接口实现类");
    }
}


```

### 3.2、one module-info.java 服务开始提供

```java

import com.hlj.java9.api.MyServiceInter;
import com.hlj.java9.api.impl.MyServiceInterImpl;
import com.hlj.java9.api.impl.MyServiceInterImplTwo;

module one {

   //导出可用包
     exports  com.hlj.java9.can;

     //对外提供的接口服务 ,下面指定的接口以及提供服务的impl，如果有多个实现类，用用逗号隔开    
     exports  com.hlj.java9.api;
     provides MyServiceInter  with MyServiceInterImpl, MyServiceInterImplTwo;
}


```

### 3.3、two模块开始调用

#### 3.3.1、two module-info.java


```java
import com.hlj.java9.api.MyServiceInter;

module two {
     requires one;

     //使用接口的名称 ，上面已经导入了one模块了
     uses MyServiceInter  ;
}

```

#### 3.3.2、开始测试使用<font color="red"> 下面中的注释掉的解答下export必须是第一层才能够导出 </font>


```java

package com.hlj.java9.Consumer;

import com.hlj.java9.api.MyServiceInter;
//import com.hlj.java9.api.impl.MyServiceInterImpl;

import java.util.ServiceLoader;

/**
 * @Desc:
 * @Author HealerJean
 * @Date 2018/10/10  上午10:23.
 */
public class ConsumerUse {
    public static void main(String[] args) {

        //专门用来提供服务的类
        ServiceLoader<MyServiceInter> loader = ServiceLoader.load(MyServiceInter.class);
        //所有的实现类
        for(MyServiceInter service:loader){
            service.method();
        }

//        MyServiceInterImpl.staticImpl(); ont中export必须是第一层包，不可以套多层

    }
}


```


[代码下载]()




<font color="red"> 感兴趣的，欢迎添加博主微信， </font>哈，博主很乐意和各路好友交流，如果满意，请打赏博主任意金额，感兴趣的在微信转账的时候，备备注您的微信或者其他联系方式。添加博主微信哦。
请下方留言吧。可与博主自由讨论哦

|支付包 | 微信|微信公众号|
|:-------:|:-------:|:------:|
|![支付宝](https://raw.githubusercontent.com/HealerJean123/HealerJean123.github.io/master/assets/img/tctip/alpay.jpg) | ![微信](https://raw.githubusercontent.com/HealerJean123/HealerJean123.github.io/master/assets/img/tctip/weixin.jpg)|![微信公众号](https://raw.githubusercontent.com/HealerJean123/HealerJean123.github.io/master/assets/img/my/qrcode_for_gh_a23c07a2da9e_258.jpg)|



