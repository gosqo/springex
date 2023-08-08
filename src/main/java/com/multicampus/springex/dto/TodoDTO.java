package com.multicampus.springex.dto;

import lombok.*;

import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor // 모든 속성에 대한 아규먼트 처리
@NoArgsConstructor // Default 생성자 처리.
public class TodoDTO {

    private Long tno;
    private String title;
    private LocalDate dueDate;
    private String writer; // 새로 추가 됨.
    private boolean finished;

}
