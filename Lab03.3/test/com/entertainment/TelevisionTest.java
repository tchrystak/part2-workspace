package com.entertainment;

import static org.junit.Assert.*;

import org.junit.Test;

public class TelevisionTest {

  @Test
  public void testSetVolume() {
    Television tv = new Television();
    tv.setVolume(100);
    assertEquals(100, tv.getVolume());
    tv.setVolume(0);
    assertEquals(0, tv.getVolume());
  }

//  @Test(expected = IllegalArgumentException.class)
//  public void testSetVolumeException() {
//    Television tv = new Television();
//    tv.setVolume(110);
//  }

  @Test
  public void testSetVolumeException() {
    try {
      Television tv = new Television();
      tv.setVolume(110);
      fail("Should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid volume: 110. Allowed range: [0, 100].", e.getMessage());
    }
  }

  @Test
    public void testChangeChannel () throws InvalidChannelException {
      Television tv = new Television();
      tv.changeChannel(12);
      assertEquals(12, tv.getCurrentChannel());
    }

  @Test
  public void testChangeChannelException() throws InvalidChannelException {
    try {
      Television tv = new Television();
      tv.changeChannel(0);
      fail("Should have thrown InvalidChannelException");
    } catch (InvalidChannelException e) {
      assertEquals("Invalid channel: 0. Allowed range: [1,999].", e.getMessage());
    }
  }

  @Test
  public void TestCompareTo() {
    Television tv2 = new Television("Sony");
    assertTrue(tv1.compareto(tv2) < 0);
    Television tv3 = new Television("LG");
    assertTrue(tv1.compareTo(tv3) > 0);
  }

  @Test
  public void testHashCode() {
    Television tv2 = new Television("Samsung", 0, DisplayType.OLED);
    assertEquals(tv1.hashCode(), tv2.hashCode());
    Television tv3 = new Television("Samsung", 1, DisplayType.OLED);
    assertEquals(tv.1.hashCode(), tv3.hashCode());
  }

  @Test
  public void testEquals() {
  }
}