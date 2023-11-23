package com.nxp.ourteam.test;

import javax.smartcardio.*;
import static com.nxp.ourteam.test.ISO7816.*;

class TestSomeCard {
    private CardChannel channel;
    public void test() throws CardException {
        channel.transmit(new CommandAPDU(CLA_NORMAL, INS_SELECT, 0, 0));
    }
}

