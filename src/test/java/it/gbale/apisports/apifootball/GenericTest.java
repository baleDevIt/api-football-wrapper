package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.core.ApiResponse;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("SameParameterValue")
public abstract class GenericTest<T> {

    private final String mListIsNull = "Response List of League is null";
    private final String mListEmptyElement = "Response List do not have element";
    @SuppressWarnings("FieldCanBeLocal")
    private final String mListNotEmptyElement = "Expected empty list element, but it is not so!";
    @SuppressWarnings("FieldCanBeLocal")
    private final String mRespObjIsNull = "Response is null";
    @SuppressWarnings("FieldCanBeLocal")
    private final String mHaveMorePage = "The request is not inclusive of all elements. There are probably other pages. Have more ";

    void testListObjSuccess(List<T> tList, Class<T> tClass){
        assertNotNull(tList, mListIsNull);
        assertNotEquals(tList.size(), 0, mListEmptyElement);
        tList.forEach(element -> assertInstanceOf(tClass, element));
    }

    void testEmptyListObj(List<T> tList, Class<T> tClass){
        assertNotNull(tList, mListIsNull);
        assertEquals(tList.size(), 0, mListNotEmptyElement);
        tList.forEach(element -> assertInstanceOf(tClass, element));
    }

    void testResponseObjSuccess(ApiResponse<T> response, Class<T> tClass){
        assertNotNull(response, mRespObjIsNull);
        assertEquals(response.getErrors().size(),0);
        assertNotEquals(response.getResponse().size(), 0, mListEmptyElement);
        assertEquals(response.getResults(), response.getResponse().size(), mHaveMorePage + (response.getPaging().getTotal() - response.getPaging().getCurrent()));
        response.getResponse().forEach(element -> assertInstanceOf(tClass, element));
    }
}
