package com.example.lambdas.entity;

import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 描述:
 * 创作音乐的个人或者团队
 *
 * @author zed
 * @since 2019-09-25 17:24
 */
public final class Artist {
    /**
     * 名称
     */
    private String name;
    /**
     * 成员
     */
    private List<Artist> members;
    /**
     * 籍贯
     */
    private String nationality;

    /**
     * 只有名称和国籍
     * @param name name
     * @param nationality nationality
     */
    public Artist(String name, String nationality) {
        this(name, Collections.emptyList(), nationality);
    }
    public Artist(String name, List<Artist> members, String nationality) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(members);
        Objects.requireNonNull(nationality);
        this.name = name;
        this.members = members;
        this.nationality = nationality;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * 成员流
     * @return Stream
     */
    public Stream<Artist> getMembers() {
        return members.stream();
    }
    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * 是否独唱
     * @return b
     */
    public boolean isSolo() {
        return members.isEmpty();
    }

    /**
     * 来源是否一致
     * @param nationality nationality
     * @return b
     */
    public boolean isFrom(String nationality) {
        return this.nationality.equals(nationality);
    }

    @Override
    public String toString() {
        return getName();
    }

    /**
     * 复制 成员
     * @return artist
     */
    public Artist copy() {
        List<Artist> members = getMembers().map(Artist::copy).collect(toList());
        return new Artist(name, members, nationality);
    }
}
