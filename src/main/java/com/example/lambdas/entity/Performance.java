package com.example.lambdas.entity;

import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

/**
 * 描述:
 * 演出
 *
 * @author zed
 * @since 2019-09-25 17:23
 */
public interface Performance {
    /**
     * 返回演出名称
     * @return str
     */
    String getName();

    /**
     * 获取表演团队
     * @return Stream
     */
    Stream<Artist> getMusicians();

    /**
     * 获取所有成员
     * @return Stream
     */
    default Stream<Artist> getAllMusicians(){
        return getMusicians().flatMap(artist -> concat(Stream.of(artist), artist.getMembers()));
    }


}
