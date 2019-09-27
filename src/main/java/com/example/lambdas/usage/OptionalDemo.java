package com.example.lambdas.usage;

import com.example.lambdas.entity.Artist;

import java.util.List;
import java.util.Optional;

/**
 * 描述:
 * OptionalDemo
 *
 * @author zed
 * @since 2019-09-26 14:28
 */
public class OptionalDemo {
    /**
     * 艺术家集合
     */
    private List<Artist> artists;

    public OptionalDemo(List<Artist> artists) {
        this.artists = artists;
    }

    /**
     * 获取艺术家
     * @param index 索引下标
     * @return optional
     */
    public Optional<Artist> getArtist(int index){
        if (index < 0 || index >= artists.size()){
            return Optional.empty();
        }
        return Optional.of(artists.get(index));
    }

    /**
     * 获取艺术家名称 orElse 预备值防止空指针 orElseGet 则返回Supplier get
     * @param index 索引下标
     * @return str
     */
    public String getArtistName(int index){
        Optional<Artist> artist = getArtist(index);
        return artist.map(Artist::getName).orElse("unknown");
    }


}
