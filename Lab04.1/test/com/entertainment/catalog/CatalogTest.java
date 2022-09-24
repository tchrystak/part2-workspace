/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.Map;
import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {
  
  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */
  @Test
  public void testFindByBrandNoMatches() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  @Test
  public void testFindByBrandWithMatches() {
    Collection<Television> tvs = Catalog.findByBrand("Sony");
    assertNotNull(tvs);
    assertFalse(tvs.isEmpty());
    assertEquals(7, tvs.size());
  }

  @Test
  public void testFindByBrandsNoBrands() {
    Map<String, Collection<Television>> tvMap = Catalog.findByBrands();
    assertNotNull(tvMap);
    assertTrue(tvMap.isEmpty());
    //fail("test not yet implemented");
  }

  @Test
  public void testFindByBrandsSomeBrands() {
//    fail("test not yet implemented");
    Map<String,Collection<Television>> tvs = Catalog.findByBrands("Sony", "RCA", "Samsung");
    assertNotNull(tvs);
    assertFalse(tvs.isEmpty());
    assertEquals(3, tvs.size());
    assertEquals(7, tvs.get("Sony").size());
    assertEquals(9, tvs.get("RCA").size());
    assertEquals(0, tvs.get("Samsung").size());
    // TODO: 9/22/2022 Add more info 
  }

}