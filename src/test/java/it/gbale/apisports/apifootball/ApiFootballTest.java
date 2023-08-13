package it.gbale.apisports.apifootball;


import it.gbale.apisports.apifootball.ApiFootball;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApiFootballTest {

    @Test
    void classCreationWithoutTokenNotPossibile() {
        assertThrows(IllegalArgumentException.class, () -> {
            ApiFootball test = new ApiFootball(null, true);
        });
    }

    @Test
    void classCreationWithEmptyTokenNotPossibile() {
        assertThrows(IllegalArgumentException.class, () -> {
            ApiFootball test = new ApiFootball("", true);
        });
    }
}
