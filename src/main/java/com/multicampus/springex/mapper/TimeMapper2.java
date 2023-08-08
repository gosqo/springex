package com.multicampus.springex.mapper;

import org.apache.ibatis.annotations.Select;

// 데이터베이스의 현재 시각을 문자열로 받아와서 처리.
// 쿼리를 객체처럼 처리.
// 값 자체를 문자열로 넘기기 때문에 ;(세미콜론) 기입하지 않음.
public interface TimeMapper2 {

    String getNow();

}
