package com.example.lambdas.stream;

import com.example.lambdas.entity.Album;
import com.example.lambdas.entity.Artist;
import com.example.lambdas.entity.SampleData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * 描述:
 * Stream流使用范例
 *
 * @author zed
 * @since 2019-09-25 18:17
 */
public class StreamSample {
    /**
     * 求流中所有数据之和
     * @param numbers stream流
     * @return sum
     */
    private static int addUp(Stream<Integer> numbers){
        return numbers.reduce(0, Integer::sum);
    }

    /**
     * 返回艺术家姓名和国籍
     * @param list list
     * @return list
     */
    private static List<String> getNameAndOrigins(List<Artist> list){
        return list.stream()
                .flatMap(artist -> Stream.of(artist.getName(),artist.getNationality()))
                .collect(Collectors.toList());
    }

    /**
     * 返回最多包含三首歌曲的专辑列表
     * @param list 专辑列表
     * @return list
     */
    private static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> list){
        return list.stream().filter(album -> album.getTrackList().size()<=3).collect(Collectors.toList());
    }

    /**
     * 获取艺术家集合中的总成员
     * @param list list
     * @return count
     */
    private static int countBandMembersInternal(List<Artist> list){
        return list.stream()
                .map(artist -> artist.getMembers().count())
                .reduce(0L,Long::sum)
                .intValue();
    }

    /**
     * 计算一个字符串中小写字母的个数
     * @param str str
     * @return count
     */
    private static int countLowercaseLetters(String str){
        return (int)str.chars().filter(Character::isLowerCase).count();
    }

    /**
     * 在一个字符串列表找出包含最多小写字母的字符串，空列表返回Optional<String> 对象
     * @param list 字符串集合
     * @return Optional
     */
    private static Optional<String> mostLowercaseString(List<String> list){
        return list.stream().max(Comparator.comparing(StreamSample::countLowercaseLetters));
    }

    public static void main(String[] args) {
        System.out.println("求流中所有数据之和");
        List<Integer> list = asList(12,10,1);
        System.out.println(addUp(list.stream()));
        System.out.println("返回艺术家姓名和国籍");
        System.out.println(getNameAndOrigins(SampleData.getThreeArtists()));
        System.out.println("返回最多包含三首歌曲的专辑列表");
        getAlbumsWithAtMostThreeTracks(SampleData.albumList).forEach(album -> System.out.println(album.getName()));
        System.out.println("获取艺术家集合中的总成员");
        System.out.println(countBandMembersInternal(SampleData.getThreeArtists()));
        System.out.println("计算一个字符串中小写字母的个数");
        System.out.println(countLowercaseLetters("Hello,Word"));
        System.out.println("在一个字符串列表找出包含最多小写字母的字符串，空列表返回Optional<String> 对象");
        //相同大小
        System.out.println(mostLowercaseString(asList("Hello","worlds","simple")));

    }


    /**
     * 只用reduce 和lambda 表达式写出实现Stream 上的map操作 FilterUsingReduce
     * @param stream stream
     * @param predicate predicate
     * @param <I> i
     * @return list
     */
    public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
        List<I> initial = new ArrayList<>();
        return stream.reduce(initial,(List<I> acc,I x)->{
            //满足条件则复制集合元素
            if(predicate.test(x)){
                List<I> newAcc = new ArrayList<>(acc);
                newAcc.add(x);
                return newAcc;
            }else {
                return acc;
            }
        }, StreamSample::combineLists);
    }
    private static <I> List<I> combineLists(List<I> left, List<I> right) {
        // We are copying left to new list to avoid mutating it.
        List<I> newLeft = new ArrayList<>(left);
        newLeft.addAll(right);
        return newLeft;
    }
    /**
     * 只用reduce和lambda表达式写出实现Stream上的filter操作 MapUsingReduce
     * @param stream stream
     * @param mapper mapper
     * @param <I> i
     * @param <O> o
     * @return list
     */
    public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
        return stream.reduce(new ArrayList<>(), (acc, x) -> {
            // We are copying data from acc to new list instance. It is very inefficient,
            // but contract of Stream.reduce method requires that accumulator function does
            // not mutate its arguments.
            // Stream.collect method could be used to implement more efficient mutable reduction,
            // but this exercise asks to use reduce method.
            List<O> newAcc = new ArrayList<>(acc);
            newAcc.add(mapper.apply(x));
            return newAcc;
        }, (List<O> left, List<O> right) -> {
            // We are copying left to new list to avoid mutating it.
            List<O> newLeft = new ArrayList<>(left);
            newLeft.addAll(right);
            return newLeft;
        });
    }
}
