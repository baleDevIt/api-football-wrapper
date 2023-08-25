package it.gbale.apisports.apifootball;


import it.gbale.apisports.apifootball.model.exception.ApiError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApiFootballTest {

    @Test
    void classCreationWithoutTokenNotPossibile() {
        assertThrows(ApiError.class, () -> new ApiFootball(null, true));
    }

    @Test
    void classCreationWithEmptyTokenNotPossibile() {
        assertThrows(ApiError.class, () -> new ApiFootball("", true));
    }
}
