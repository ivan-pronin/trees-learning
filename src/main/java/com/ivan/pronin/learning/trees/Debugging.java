package com.ivan.pronin.learning.trees;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Ivan Pronin
 * @since 27.08.2025
 */
public class Debugging {

    public static void main(String[] args) {
        System.out.println("hello!");
        var cl = new Debugging().new MyClass();
        var st1 = new StaticClass();
        st1.name = "static 1";
        var st2 = new StaticClass();
        st2.name = "static 2";
        System.out.println(st1);
        System.out.println(st2);

        List<Photo> photos = List.of(
          new Photo("p1",true),
          new Photo("p2",true),
          new Photo("img1",false),
          new Photo("img2",false),
          new Photo("img3",false)
        );

        Map<String, List<Photo>> albums = new HashMap<>();
        final Map<String, List<Photo>> collect = photos.stream()
            .collect(Collectors.groupingBy(ph -> ph.isFav ? "favourite" : "other"));
        System.out.println(collect);
    }

    private class MyClass {

        String name;

    }

    private record Photo(String name, boolean isFav) {

    }

    private static class StaticClass {

        String name;

    }

}
