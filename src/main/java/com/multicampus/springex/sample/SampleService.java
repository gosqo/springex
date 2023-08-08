package com.multicampus.springex.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@ToString
@Service
@RequiredArgsConstructor
public class SampleService {

    @Qualifier("normal")
    // '느슨한 결합'
    // 객체와 객체의 의존관계의 실제 객체를 몰라도 주입이 가능하게 하는 방식
    private final SampleDAO sampleDAO;

    // Field Injection
//    @Autowired
//    private SampleDAO sampleDAO;
}
