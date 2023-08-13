package it.gbale.apisports.apifootball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestFactoryTest {

    @Test
    void classCreationWithoutTokenNotPossibile() {
        assertThrows(IllegalArgumentException.class, () -> {
            RequestFactory test = new RequestFactory(null, true);
        });
    }

    @Test
    void classCreationWithEmptyTokenNotPossibile() {
        assertThrows(IllegalArgumentException.class, () -> {
            ApiFootball test = new ApiFootball("", true);
        });
    }

    @Test
    void makeRequestWithout() {
        assertThrows(IllegalArgumentException.class, () -> {
            ApiFootball test = new ApiFootball("", true);
        });
    }


}