package com.entertainment;

import static org.junit.Assert.*;

import org.junit.Test;

public class TelevisionTest {

  private final Television tv1 = new Television("Sony", 50, DisplayType.LED);

  @Test
  public void testSetVolume() {
    int volume = (Television.MIN_VOLUME + Television.MAX_VOLUME) / 2;
    tv1.setVolume(volume);
    assertEquals(volume, tv1.getVolume());
  }

//  @Test(expected = IllegalArgumentException.class)
//  public void testSetVolumeException() {
//    Television tv = new Television();
//    tv.setVolume(110);
//  }

  @Test (expected = IllegalArgumentException.class)
  public void testSetVolumeIllegalArgumentException() {
      tv1.setVolume(Television.MIN_VOLUME - 1);
    }
//    try {
//      Television tv = new Television();
//      tv.setVolume(110);
//      fail("Should have thrown IllegalArgumentException");
//    } catch (IllegalArgumentException e) {
//      assertEquals("Invalid volume: 110. Allowed range: [0, 100].", e.getMessage());
//    }
// }

  @Test
    public void testChangeChannel () throws InvalidChannelException {
      int channel = (Television.MIN_CHANNEL + Television.MAX_CHANNEL) / 2;
    tv1.changeChannel(channel);
    assertEquals(channel, tv1.getCurrentChannel());
//      Television tv = new Television();
//      tv.changeChannel(12);
//      assertEquals(12, tv.getCurrentChannel());
    }

  @Test
  public void testChangeChannelException() throws InvalidChannelException {
    try {
      Television tv1 = new Television();
      tv1.changeChannel(0);
      fail("Should have thrown InvalidChannelException");
    } catch (InvalidChannelException e) {
      assertEquals("Invalid channel: 0. Allowed range: [1,999].", e.getMessage());
    }
  }

  @Test
  public void TestCompareTo() {
    Television tv2 = new Television("Vizio");
    assertTrue(tv1.compareTo(tv2) < 0);
    Television tv3 = new Television("LG");
    assertTrue(tv1.compareTo(tv3) > 0);
  }

  @Test
  public void testHashCode() {
    Television tv2 = new Television("Samsung", 0, DisplayType.OLED);
    assertEquals(tv1.hashCode(), tv2.hashCode());
    Television tv3 = new Television("Samsung", 1, DisplayType.OLED);
    assertEquals(tv1.hashCode(), tv3.hashCode());
  }

  @Test
  public void testEquals() {
    Television tv2 = new Television("Samsung", 0, DisplayType.OLED);
    assertEquals(tv1, tv2);
    Television tv3 = new Television("Samsung", 0, DisplayType.LCD);
    assertNotEquals(tv1, tv3);
  }
}