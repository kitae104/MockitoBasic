package kr.inhatc.mockito.mockitodemo.list;

import org.junit.jupiter.api.Test;

import java.util.List;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ListTest {
    @Test
    void simpleTest() {
        List listMock = mock(List.class);
        // listMock.size() ==> 3
        when(listMock.size()).thenReturn(3);
        assertEquals(3, listMock.size());
    }

    @Test
    void multipleReturnsTest() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(1).thenReturn(2).thenReturn(3);
        assertEquals(1, listMock.size());
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    void specificParametersTest() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("inhatc");
        assertEquals("inhatc", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }

    @Test
    void genericParametersTest() {
        List listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("inhatc");
        assertEquals("inhatc", listMock.get(0));
        assertEquals("inhatc", listMock.get(1));
    }
}