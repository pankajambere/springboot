package com.springboot.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

//@RestController
//@RequestMapping("/feed")
//@EnableAutoConfiguration
public class DataFeeder {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataFeeder.class);

    @PostConstruct
    public void init(){
        LOGGER.info("DataFeeder API activated");
    }

    /*@GetMapping("/")
    public Mono<String> index(){
        return Mono.just("Index content");
    }

    @GetMapping("/greetings")
    public String greetings(){
        return "Hello World!";
    }

    @GetMapping("/greet/{name}")
    public Mono<String> greet(@PathVariable String name){

        LOGGER.info("Greeting {}", name);

        return Mono.just(String.format("Hello %s", name));
    }

    @GetMapping("/random")
    public Flux<String> randomNumbers(){
//        return Flux.fromIterable(Arrays.asList("a","b","c","d","e","f","g"));
        Flux<String> helloPauseWorld =
                Mono.just("Hello")
                        .concatWith(Mono.just("world").delaySubscription(Duration.ofMillis(10000)));

        LOGGER.info("Returning flux...");
        return helloPauseWorld;

    }*/
}
