package com.multicampus.springex.mapper;

import com.multicampus.springex.domain.TodoVO;
import com.multicampus.springex.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper {

    String getTime();

    // TodoVO 를 파라미터로 입력 받는 insert() 구현
    void insert(TodoVO todoVO);

    // 가장 최근에 등륵된 글 순서대로 tbl_todo 테이블의 모든 todoList_selectAll 작업
    List<TodoVO> selectAll();

    TodoVO selectOne(Long tno);

    void delete(Long tno);

    void update(TodoVO todoVO);

    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);

}
