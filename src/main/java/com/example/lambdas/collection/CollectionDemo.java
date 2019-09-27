package com.example.lambdas.collection;

import com.example.lambdas.entity.Artist;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * 描述:
 * 集合类和收集器
 *
 * @author zed
 * @since 2019-09-27 10:34
 */
public class CollectionDemo {

    private static Comparator<Artist> byNameLength = Comparator.comparing(artist -> artist.getName().length());

    /**
     * 使用reduce找出集合中姓名最长的艺术家
     * @param list list
     * @return artist
     */
    public static Artist getLongestNameByReduce(List<Artist> list){
        return list.stream()
                .reduce((acc,artist)-> (byNameLength.compare(acc,artist) >= 0)?acc:artist)
                .orElseThrow(RuntimeException::new);
    }

    /**
     * 使用collect
     * @param list list
     * @return artist
     */
    public static Artist getLongestNameByCollecting(List<Artist> list){
        return list.stream()
                .collect(Collectors.maxBy(byNameLength))
                .orElseThrow(RuntimeException::new);
    }

    /**
     * 使用stream max
     * @param list list
     * @return artist
     */
    public static Artist getLongestNameByMax(List<Artist> list){
        return list.stream().max(byNameLength)
                .orElseThrow(RuntimeException::new);
    }

    /**
     * 计算集合中每个元素出现的次数
     * @param names names
     * @return map
     */
    public static Map<String, Long> getCount(Stream<String> names){

        return names.collect(groupingBy(name -> name,counting()));
    }
}

