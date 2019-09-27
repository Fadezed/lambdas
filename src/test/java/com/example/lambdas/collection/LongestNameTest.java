package com.example.lambdas.collection;

import com.example.lambdas.entity.Artist;
import com.example.lambdas.entity.SampleData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestNameTest {

    @Test
    public void findsLongestNameByReduce() {
        Artist artist = CollectionDemo.getLongestNameByReduce(SampleData.getThreeArtists());
        assertEquals(SampleData.G_DRAGON, artist);
    }

    @Test
    public void findsLongestNameByCollecting() {
        Artist artist = CollectionDemo.getLongestNameByCollecting(SampleData.getThreeArtists());
        assertEquals(SampleData.G_DRAGON, artist);
    }
    @Test
    public void findsLongestNameByMax() {
        Artist artist = CollectionDemo.getLongestNameByMax(SampleData.getThreeArtists());
        assertEquals(SampleData.G_DRAGON, artist);
    }

}
