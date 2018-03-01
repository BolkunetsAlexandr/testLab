package com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result;

import java.util.List;

public class PassingFactDto {

    private Integer methodicsId;

    private List<AnswerQuestionDto> list;

    public Integer getMethodicsId() {
        return methodicsId;
    }

    public void setMethodicsId(Integer methodicsId) {
        this.methodicsId = methodicsId;
    }

    public List<AnswerQuestionDto> getList() {
        return list;
    }

    public void setList(List<AnswerQuestionDto> list) {
        this.list = list;
    }
}
