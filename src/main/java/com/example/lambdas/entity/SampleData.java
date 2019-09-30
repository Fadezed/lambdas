package com.example.lambdas.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * 描述:
 * 初始化数据
 *
 * @author zed
 * @since 2019-09-25 17:45
 */
public class SampleData {
    /**
     * 权志龙
     */
    public static final Artist G_DRAGON = new Artist("G DRAGON", "韩国");
    /**
     * TOP
     */
    public static final Artist T_O_P = new Artist("T O P", "韩国");
    /**
     * 东永裴
     */
    public static final Artist TAE_YANG = new Artist("Tae Yang", "韩国");
    /**
     * 李胜贤
     */
    public static final Artist SEUNG_Ri = new Artist("Seung Ri", "韩国");
    /**
     * 姜大声
     */
    public static final Artist DAE_SUNG = new Artist("Ringo Starr", "韩国");
    /**
     * BigBang成员
     */
    public static final List<Artist> membersOfTheBigBang = Arrays.asList(G_DRAGON, T_O_P,TAE_YANG, SEUNG_Ri, DAE_SUNG);
    /**
     * bigBang乐队
     */
    public static final Artist BIG_BANG_ARTIST = new Artist("Big Bang", membersOfTheBigBang, "韩国");
    /**
     * 专辑 MADE_SERIES
     */
    public static final Album MADE_SERIES = new Album("MADE_SERIES", asList(new Track("IF YOU ", 267), new Track("BANG BANG BANG", 442)), asList(G_DRAGON,T_O_P));
    /**
     * With_U
     */
    public static final Album WITH_U = new Album("With_U", Collections.singletonList(new Track("intro", 68)), Collections.singletonList(T_O_P));
    /**
     * BIG_BANG
     */
    public static final Album BIG_BANG = new Album("BIG_BANG", asList(new Track("Stay", 30), new Track("Follow Me", 30), new Track("short track 3", 30), new Track("short track 4", 30), new Track("short track 5", 30)), asList(G_DRAGON,SEUNG_Ri,DAE_SUNG));

    public static Stream<Album> albums = Stream.of(MADE_SERIES);
    /**
     * 专辑集合
     */
    public static List<Album> albumList = asList(MADE_SERIES,WITH_U,BIG_BANG);

    public static Stream<Artist> threeArtists() {
        return Stream.of(T_O_P, G_DRAGON, BIG_BANG_ARTIST);
    }

    public static List<Artist> getThreeArtists() {
        return Arrays.asList(T_O_P, G_DRAGON, BIG_BANG_ARTIST);
    }

}
