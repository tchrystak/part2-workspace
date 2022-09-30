/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class MessagePrinterClient {

  public static void main(String[] args) {
    MessagePrinter printer = new MessagePrinter("Hello");
    printer.start();

    MessagePrinter printer2 = new MessagePrinter("Goodbye");
    printer2.start();
    // TODO: create two instances of your thread subclass and start them up
  }
}