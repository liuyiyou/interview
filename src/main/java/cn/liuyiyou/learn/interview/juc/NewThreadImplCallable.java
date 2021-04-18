package cn.liuyiyou.learn.interview.juc;

import java.util.concurrent.Callable;

/**
 * @author: liuyiyou.cn
 * @date: 2021/4/17
 * @version: V1.0
 */
public class NewThreadImplCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "NewThreadImplCallable";
    }
}
