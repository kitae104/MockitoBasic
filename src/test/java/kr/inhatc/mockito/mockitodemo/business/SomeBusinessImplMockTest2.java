package kr.inhatc.mockito.mockitodemo.business;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)  // @Mock, @InjectMocks 어노테이션을 사용하기 위해 필요 --> @SpringBootTest 어노테이션에 포함되어 있음
class SomeBusinessImplMockTest2 {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl business;

    @Test
    void findTheGreatestFromAllDataTest(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {10, 22, 13});  // mock에 대한 행동 지정
        int result = business.findTheGreatestFromAllData();
        assertEquals(22, result);
    }

    @Test
    void findTheGreatestFromOneDataTest(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {33});  // mock에 대한 행동 지정
        assertEquals(33, business.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromEmptyDataTest(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});  // mock에 대한 행동 지정
        assertEquals(Integer.MIN_VALUE, business.findTheGreatestFromAllData());
    }
}

