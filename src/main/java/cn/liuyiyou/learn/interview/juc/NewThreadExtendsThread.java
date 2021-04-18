package cn.liuyiyou.learn.interview.juc;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 线程创建方式
 *
 * @author: liuyiyou.cn
 * @date: 2021/4/17
 * @version: V1.0
 */
@ApiOperation("线程创建方式: 继承Thread")
@Slf4j
public class NewThreadExtendsThread extends Thread {

    @Override
    public void run() {
        log.info("通过继承线程创建");
    }
}
