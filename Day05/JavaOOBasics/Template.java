class ResponseAPDU {
    private final byte[] rawResponse;
    public ResponseAPDU(final byte[] rawResponse) {
        if (rawResponse.length < 2)
            throw new IllegalArgumentException("Expecting at least two response bytes");
        this.rawResponse = rawResponse;
    }
    public byte[] getBytes() {
        return rawResponse;
    }
}

class CommandAPDU {
    private final byte[] command;
    public CommandAPDU(final byte[] command) {
        if (comand.length < 4)
            throw new IllegalArgumentException("Expecting at least four command bytes");
        this.command = command;
    }
    public byte[] getBytes() {
        return command;
    }
}

abstract class TerminalFactory {
    public abstract CardTerminal cardTerminal();
}

class PCSCTerminalFactory extends TerminalFactory {
    public CardTerminal cardTerminal() {
        return new PCSCCardTerminal();
    }
}

abstract class CardTerminal {
    public abstract byte[] transmit(byte[] command);

    public ResponseAPDU transmit(final CommandAPDU command) {
        return new ResponseAPDU(transmit(command.getBytes()));
    }
}

class PCSCCardTerminal extends CardTerminal {
    @Override
    public byte[] transmit(byte[] command) {
        return new byte[0];
    }
}

class AndroidNFCCardTerminal extends CardTerminal {
    @Override
    public byte[] transmit(byte[] command) {
        return new byte[0];
    }
}

class Main {
    public static void main(final String... args) {
        TerminalFactory terminalFactory = new PCSCTerminalFactory();
        CardTerminal terminal = terminalFactory.cardTerminal();
        runTestsWithCard(terminal);
    }
    public static void runTestsWithCard(CardTerminal cardTerminal) {
        byte[] response = cardTerminal.transmit(new byte[] { 0x00, (byte) 0xA4, 0x00, 0x00 }); // SELECT MF
    }
}
