package org.komparator.mediator.ws.it;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;


/**
 * Test suite
 */
public class PingIT extends BaseIT {

    @Test
    public void pingEmptyTest() {
       assertNotNull(mediatorClient.ping("test"));
    }

}
