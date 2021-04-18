package cn.liuyiyou.learn.interview.controller.juc;

import cn.liuyiyou.learn.interview.juc.NewThreadExtendsThread;
import cn.liuyiyou.learn.interview.juc.NewThreadImplCallable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2021/4/17
 * @version: V1.0
 */
@Api(tags = "线程创建方式")
@Slf4j
@RestController
public class ThreadController {

    @ApiOperation("继承Thread")
    @GetMapping("/extendsThread")
    public Boolean extendsThread() {
        new NewThreadExtendsThread().start();
        return true;
    }

    @ApiOperation("实现Runnable接口")
    @GetMapping("/implRunnable")
    public Boolean implRunnable() {
        Runnable runnable = () -> log.info("实现Runnable接口");
        Thread thread = new Thread(runnable);
        thread.start();
        return true;
    }

    @ApiOperation("Executors.callable")
    @GetMapping("/excutors")
    public String excutors() throws Exception {
        final Callable<String> excutors = Executors.callable(() -> log.info(" 通过继承线程创建"), "excutors");
        return excutors.call();
    }

    @ApiOperation("实现Callable接口")
    @GetMapping("/implCallable")
    public String implCallable() throws ExecutionException, InterruptedException {
        FutureTask<String> ft = new FutureTask<>(new NewThreadImplCallable());
        new Thread(ft).start();
        return ft.get();
    }

}
