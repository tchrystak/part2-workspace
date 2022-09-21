package com.javatunes.personnel;

import static org.junit.Assert.*;

import gov.irs.TaxPayer;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

public class SalariedEmployeeTest {

  private static final double SALARY = 100_000_000;
  private static final double TOLERANCE = 0.001;
  private static final double TAX = SALARY * TaxPayer.SALARIED_TAX_RATE;

  private SalariedEmployee employee;

  @Before
  public void setUp() {
    employee = new SalariedEmployee("LeBron James", new Date(100, 0,1), SALARY);
  }
  @Test
  public void testPay() {
    assertEquals(100000000.0, employee.pay(), TOLERANCE);
  }

  @Test
  public void testPayTaxes() {
    assertEquals(TAX, employee.payTaxes(), TOLERANCE);
  }
}