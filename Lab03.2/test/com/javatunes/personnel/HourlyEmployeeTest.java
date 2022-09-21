package com.javatunes.personnel;

import static org.junit.Assert.*;

import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

public class HourlyEmployeeTest {

  private HourlyEmployee emp;

  @Before
  public void setUp() {
  emp = new HourlyEmployee("Trey Chrystak", new Date(120, 2, 15 ), 25.0, 40.0);
  }

  @Test
  public void testPay() {
    assertEquals(1000, emp.pay(), 0.001);
  }

  @Test
  public void testPayTaxes() {
    assertEquals(250, emp.payTaxes(),0.001);
  }
}