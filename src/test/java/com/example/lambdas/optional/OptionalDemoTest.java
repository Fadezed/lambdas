package com.example.lambdas.optional;

import com.example.lambdas.entity.Artist;
import com.example.lambdas.entity.SampleData;
import com.example.lambdas.usage.OptionalDemo;
import org.junit.Assert;
import org.junit.Test;


import java.util.Optional;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class OptionalDemoTest {

    private final OptionalDemo optionalExamples = new OptionalDemo(SampleData.getThreeArtists());

    @Test
    public void indexWithinRange() {
        Optional<Artist> artist = optionalExamples.getArtist(0);
        assertTrue(artist.isPresent());
    }

    @Test
    public void indexOutsideRange() {
        Optional<Artist> artist = optionalExamples.getArtist(4);
        assertFalse(artist.isPresent());
    }

    @Test
    public void nameIndexInsideRange() {
        String artist = optionalExamples.getArtistName(0);
        Assert.assertEquals("T O P", artist);
    }

    @Test
    public void nameIndexOutsideRange() {
        String artist = optionalExamples.getArtistName(4);
        assertEquals("unknown", artist);
    }

}
