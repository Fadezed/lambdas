package com.example.lambdas.entity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;

/**
 * 描述:
 * 专辑
 *
 * @author zed
 * @since 2019-09-25 17:29
 */
public final class Album implements Performance{
    /**
     * 专辑名称
     */
    private String name;
    /**
     * 曲目集合
     */
    private List<Track> tracks;
    /**
     * 专辑作者集合
     */
    private List<Artist> musicians;


    public Album(String name, List<Track> tracks, List<Artist> musicians) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(tracks);
        Objects.requireNonNull(musicians);
        this.name = name;
        this.tracks = tracks;
        this.musicians = musicians;
    }

    /**
     * 获取曲目集合流
     * @return Stream
     */
    public Stream<Track> getTracks() {
        return tracks.stream();
    }

    /**
     * 获取曲目集合
     * @return list
     */
    public List<Track> getTrackList() {
        return unmodifiableList(tracks);
    }

    /**
     * 获取作者集合
     * @return list
     */
    public List<Artist> getMusicianList() {
        return unmodifiableList(musicians);
    }
    /**
     * 获取主唱
     * @return Artist
     */
    public Artist getMainMusician() {
        return musicians.get(0);
    }


    @Override
    public String getName() {
        return name;
    }

    /**
     * 获取作者集合流
     * @return Stream
     */
    @Override
    public Stream<Artist> getMusicians() {
        return musicians.stream();
    }



}
