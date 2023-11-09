package kr.inhatc.mockito.mockitodemo.business;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SomeBusinessImplStubTest {
    @Test
    void findTheGreatestFromAllDataTest(){
        DataServiceStub1 dataServiceStub = new DataServiceStub1();
        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceStub);
        int result = business.findTheGreatestFromAllData();
        assertEquals(13, result);
    }

    @Test
    void findTheGreatestFromAllDataTest2(){
        DataServiceStub2 dataServiceStub = new DataServiceStub2();
        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceStub);
        int result = business.findTheGreatestFromAllData();
        assertEquals(33, result);
    }
}

// 스텁 만들기1
class DataServiceStub1 implements DataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] {10, 2, 13};
    }
}

// 스텁 만들기2
class DataServiceStub2 implements DataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] {33};
    }
}