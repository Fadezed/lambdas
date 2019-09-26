package com.example.lambdas.entity;


/**
 * 描述:
 * 曲目
 *
 * @author zed
 * @since 2019-09-25 17:29
 */
public class Track {
    /**
     * 曲目名称
     */
    private final String name;
    /**
     * 曲目长度
     */
    private final int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }
    /**
     * @return 曲目名称
     */
    public String getName() {
        return name;
    }

    /**
     * @return 曲目长度
     */
    public int getLength() {
        return length;
    }
    /**
     * 复制曲目
     * @return Track
     */
    public Track copy() {
        return new Track(name, length);
    }
}
