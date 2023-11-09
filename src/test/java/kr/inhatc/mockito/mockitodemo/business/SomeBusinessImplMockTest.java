package kr.inhatc.mockito.mockitodemo.business;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class SomeBusinessImplMockTest {
    @Test
    void findTheGreatestFromAllDataTest(){
        DataService dataServiceMock = mock(DataService.class);                      // mock 생성
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {10, 2, 13});  // mock에 대한 행동 지정
        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceMock);
        int result = business.findTheGreatestFromAllData();
        assertEquals(13, result);
    }

    @Test
    void findTheGreatestFromOneDataTest(){
        DataService dataServiceMock = mock(DataService.class);                      // mock 생성
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {33});         // mock에 대한 행동 지정
        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceMock);
        assertEquals(33, business.findTheGreatestFromAllData());
    }
}

