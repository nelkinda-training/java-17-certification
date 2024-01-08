package com.nelkinda.training.java.modules.app;

import com.nelkinda.training.java.modules.hello.Hello;

import javax.smartcardio.*;

public class Main {
    public static void main(final String... args) throws Throwable {
        Hello.hello();
        final TerminalFactory terminalFactory = TerminalFactory.getDefault();
        for (final CardTerminal terminal : terminalFactory.terminals().list()) {
            System.out.println(terminal.getName());
        }
    }
}
