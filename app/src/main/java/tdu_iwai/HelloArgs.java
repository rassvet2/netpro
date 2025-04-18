package tdu_iwai;

import java.util.stream.Stream;

import com.google.common.collect.Streams;

public class HelloArgs {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Streams.mapWithIndex(Stream.of(args), (arg, i) -> "args[" + i + "] = " + arg)
            .forEach(System.out::println);
    }
}
