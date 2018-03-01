package com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.description;

import java.util.List;

public class FullMethodicsDto extends MethodicsDescriptionDto {
    private List<QuestionsWithKeyIdDto> questionsWithKeyList;

    private List<MethodicsKeyDto> methodicsKeyDtoList;

    public List<QuestionsWithKeyIdDto> getQuestionsWithKeyList() {
        return questionsWithKeyList;
    }

    public void setQuestionsWithKeyList(List<QuestionsWithKeyIdDto> questionsWithKeyList) {
        this.questionsWithKeyList = questionsWithKeyList;
    }

    public List<MethodicsKeyDto> getMethodicsKeyDtoList() {
        return methodicsKeyDtoList;
    }

    public void setMethodicsKeyDtoList(List<MethodicsKeyDto> methodicsKeyDtoList) {
        this.methodicsKeyDtoList = methodicsKeyDtoList;
    }
}
