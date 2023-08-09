package com.multicampus.springex.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor // 모든 속성에 대한 아규먼트 처리
@NoArgsConstructor // Default 생성자 처리.
public class TodoDTO {

    private Long tno;

    // NULL, 빈 문자열을 걸러내는 검증.
    @NotEmpty
    private String title;

    //현재 보다 미래인가 를 검증.
    @Future
    private LocalDate dueDate;

    @NotEmpty
    private String writer; // 새로 추가 됨.
    private boolean finished;

}
