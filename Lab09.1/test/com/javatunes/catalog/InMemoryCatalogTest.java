package com.javatunes.catalog;

import static org.junit.Assert.*;

import org.junit.Test;

public class InMemoryCatalogTest {

  @Test
  public void findById_exists() {
    MusicItem found = new InMemoryCatalog().findById(14L);
    assertEquals("So", found.getTitle());
    assertEquals("Peter Gabriel", found.getArtist());
  }

  @Test
  public void findById_nonExistence() {
    MusicItem found = new InMemoryCatalog().findById(Long.MAX_VALUE);
    assertNull(found);
  }
}