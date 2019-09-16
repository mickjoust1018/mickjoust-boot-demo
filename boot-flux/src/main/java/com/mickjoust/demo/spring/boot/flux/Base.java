package com.hjf.boot.demo.flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

/**
 * name: com.hjf.boot.demo.flux.ReactorBase
 * author: mickjoust
 * date: 2018/3/12
 **/
public class Base {

    public static void main(String[] args) {

        //可以指定序列中包含的全部元素。创建出来的 Flux 序列在发布这些元素之后会自动结束。
        Flux.just("Hello", "World").subscribe(System.out::println);
        //fromArray()，fromIterable()和 fromStream()：可以从一个数组、Iterable 对象或 Stream 对象中创建 Flux 对象。
        Flux.fromArray(new Integer[] {1, 2, 3}).subscribe(System.out::println);
        //创建一个不包含任何元素，只发布结束消息的序列。
        Flux.empty().subscribe(System.out::println);
        //创建包含从 start 起始的 count 个数量的 Integer 对象的序列。
        Flux.range(1, 10).subscribe(System.out::println);
        Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::println);
//        Flux.intervalMillis(1000).subscribe(System.out::println);

        Flux.generate(sink -> {
            sink.next("Hello");
            sink.complete();
        }).subscribe(System.out::println);


        //generate()方法
        final Random random = new Random();
        Flux.generate(ArrayList::new, (list, sink) -> {
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if (list.size() == 10) {
                sink.complete();
            }
            return list;
        }).subscribe(System.out::println);

        //Create()方法
        Flux.create(sink -> {
            for (int i = 0; i < 10; i++) {
                sink.next(i);
            }
            sink.complete();
        }).subscribe(System.out::println);

        //创建MONO
        Mono.just("test hjf").subscribe(System.out::println);
        Mono.empty().subscribe(System.out::println);
        Mono.error(new Throwable()).subscribe(System.out::println);
        Mono.never().subscribe(System.out::println);

        //fromCallable()、fromCompletionStage()、fromFuture()、fromRunnable()和 fromSupplier()：分别从 Callable、CompletionStage、CompletableFuture、Runnable 和 Supplier 中创建 Mono。
        Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);

        //justOrEmpty(Optional<? extends T> data)和 justOrEmpty(T data)：从一个 Optional 对象或可能为 null 的对象中创建 Mono。只有 Optional 对象中包含值或对象不为 null 时，Mono 序列才产生对应的元素。
        Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);

        //delay(Duration duration)和 delayMillis(long duration)：创建一个 Mono 序列，在指定的延迟时间之后，产生数字 0 作为唯一值。
        Mono.delay(Duration.ofSeconds(10)).subscribe(System.out::println);

        //ignoreElements(Publisher<T> source)：创建一个 Mono 序列，忽略作为源的 Publisher 中的所有元素，只产生结束消息。
        Mono.ignoreElements(null).subscribe(System.out::println);

        //还可以通过 create()方法来使用 MonoSink 来创建 Mono。
        Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);

        //buffer 相关操作符的使用示例
        Flux.range(1, 100).buffer(20).subscribe(System.out::println);
//        Flux.intervalMillis(100).bufferMillis(1001).take(2).toStream().forEach(System.out::println);
        Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);
        Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);

        //filter 操作符使用示例
        Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);

        //window 操作符使用示例
        Flux.range(1, 100).window(20).subscribe(System.out::println);
//        Flux.intervalMillis(100).windowMillis(1001).take(2).toStream().forEach(System.out::println);

        // zipWith 操作符使用示例
        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"))
                .subscribe(System.out::println);
        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2))
                .subscribe(System.out::println);

        // take 系列操作符使用示例
        Flux.range(1, 1000).take(10).subscribe(System.out::println);
        Flux.range(1, 1000).takeLast(10).subscribe(System.out::println);
        Flux.range(1, 1000).takeWhile(i -> i < 10).subscribe(System.out::println);
        Flux.range(1, 1000).takeUntil(i -> i == 10).subscribe(System.out::println);

        //reduce 和 reduceWith 操作符使用示例
        Flux.range(1, 100).reduce((x, y) -> x + y).subscribe(System.out::println);
        Flux.range(1, 100).reduceWith(() -> 100, (x, y) -> x + y).subscribe(System.out::println);

        //merge 和 mergeSequential 操作符使用示例
//        Flux.merge(Flux.intervalMillis(0, 100).take(5), Flux.intervalMillis(50, 100).take(5))
//                .toStream()
//                .forEach(System.out::println);
//        Flux.mergeSequential(Flux.intervalMillis(0, 100).take(5), Flux.intervalMillis(50, 100).take(5))
//                .toStream()
//                .forEach(System.out::println);

        // flatMap 操作符使用示例
//        Flux.just(5, 10)
//                .flatMap(x -> Flux.intervalMillis(x * 10, 100).take(x))
//                .toStream()
//                .forEach(System.out::println);

        // concatMap 操作符使用示例
//        Flux.just(5, 10)
//                .concatMap(x -> Flux.intervalMillis(x * 10, 100).take(x))
//                .toStream()
//                .forEach(System.out::println);

        //combineLatest 操作符使用示例
//        Flux.combineLatest(
//                Arrays::toString,
//                Flux.intervalMillis(100).take(5),
//                Flux.intervalMillis(50, 100).take(5)
//        ).toStream().forEach(System.out::println);

        //通过 subscribe()方法处理正常和错误消息
        Flux.just(1, 2)
                .concatWith(Mono.error(new IllegalStateException()))
                .subscribe(System.out::println, System.err::println);

        //出现错误时返回默认值
        Flux.just(1, 2)
                .concatWith(Mono.error(new IllegalStateException()))
                .onErrorReturn(0)
                .subscribe(System.out::println);

        //出现错误时使用另外的流
        Flux.just(1, 2)
                .concatWith(Mono.error(new IllegalStateException()))
//                .switchOnError(Mono.just(0))
                .subscribe(System.out::println);

        //出现错误时根据异常类型来选择流
//        Flux.just(1, 2)
//                .concatWith(Mono.error(new IllegalArgumentException()))
////                .onErrorResumeWith(e -> {
//                    if (e instanceof IllegalStateException) {
//                        return Mono.just(0);
//                    } else if (e instanceof IllegalArgumentException) {
//                        return Mono.just(-1);
//                    }
//                    return Mono.empty();
//                })
//                .subscribe(System.out::println);

        //使用 retry 操作符进行重试
        Flux.just(1, 2)
                .concatWith(Mono.error(new IllegalStateException()))
                .retry(1)
                .subscribe(System.out::println);

        //使用调度器切换操作符执行方式
        Flux.create(sink -> {
            sink.next(Thread.currentThread().getName());
            sink.complete();
        })
                .publishOn(Schedulers.single())
                .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
                .publishOn(Schedulers.elastic())
                .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
                .subscribeOn(Schedulers.parallel())
                .toStream()
                .forEach(System.out::println);

        //使用 StepVerifier 验证流中的元素
//        StepVerifier.create(Flux.just("a", "b"))
//                .expectNext("a")
//                .expectNext("b")
//                .verifyComplete();
        //操作测试时间
//        StepVerifier.withVirtualTime(() -> Flux.interval(Duration.ofHours(4), Duration.ofDays(1)).take(2))
//                .expectSubscription()
//                .expectNoEvent(Duration.ofHours(4))
//                .expectNext(0L)
//                .thenAwait(Duration.ofDays(1))
//                .expectNext(1L)
//                .verifyComplete();


        //使用 TestPublisher 创建测试所用的流
//        final TestPublisher<String> testPublisher = TestPublisher.create();
//        testPublisher.next("a");
//        testPublisher.next("b");
//        testPublisher.complete();
//        StepVerifier.create(testPublisher)
//                .expectNext("a")
//                .expectNext("b")
//                .expectComplete();

        //启用调试模式
//        Hooks.onOperator(providedHook -> providedHook.operatorStacktrace());

        //使用 checkpoint 操作符
        Flux.just(1, 0).map(x -> 1 / x).checkpoint("test").subscribe(System.out::println);

        //使用 log 操作符记录事件
        Flux.range(1, 2).log("Range").subscribe(System.out::println);

        //在实际的运行时，所产生的输出如代码清单 27 所示。

//        log 操作符所产生的日志
//        13:07:56.735 [main] DEBUG reactor.util.Loggers$LoggerFactory - Using Slf4j logging framework
//        13:07:56.751 [main] INFO Range - | onSubscribe([Synchronous Fuseable] FluxRange.RangeSubscription)
//        13:07:56.753 [main] INFO Range - | request(unbounded)
//        13:07:56.754 [main] INFO Range - | onNext(1)
//        13:07:56.754 [main] INFO Range - | onNext(2)
//        13:07:56.754 [main] INFO Range - | onComplete()

          //热序列
//        final Flux<Long> source = Flux.intervalMillis(1000)
//                .take(10)
//                .publish()
//                .autoConnect();
//        source.subscribe();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        source.toStream().forEach(System.out::println);

    }
}
