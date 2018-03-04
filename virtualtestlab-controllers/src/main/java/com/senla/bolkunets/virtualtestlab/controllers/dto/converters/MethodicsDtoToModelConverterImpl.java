package com.senla.bolkunets.virtualtestlab.controllers.dto.converters;

import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.description.FullMethodicsDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.description.MethodicsKeyDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.description.QuestionsDto;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.MethodicsKey;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Question;

import java.util.*;

public class MethodicsDtoToModelConverterImpl implements MethodicsDtoToModelConverter {


    public Methodics convertNewMethodics(FullMethodicsDto methodicsDto) {

        Methodics methodics = new Methodics();

        HashMap<Integer, Question> questionMap = new HashMap<>();

        List<QuestionsDto> questionsDtos = methodicsDto.getQuestionsDtos();
        questionsDtos.forEach(x -> questionMap.put(x.getNumber(), convert(x)));

        List<MethodicsKey> methodicsKeys = new ArrayList<>();

        List<MethodicsKeyDto> methodicsKeyDtos = methodicsDto.getMethodicsKeyDtoList();

        for (MethodicsKeyDto methodicsKeyDto : methodicsKeyDtos) {

            MethodicsKey methodicsKey = convert(methodicsKeyDto);

            List<Integer> numbersQuestions = methodicsKeyDto.getNumbersQuestions();

            for (Integer numberQuestion : numbersQuestions) {

                Question question = questionMap.get(numberQuestion);
                if (question != null) {
                    question.setMethodicsKey(methodicsKey);
                }

            }

            methodicsKeys.add(methodicsKey);


        }

        methodics.setDescription(methodicsDto.getDescription());
        methodics.setLeftValueBorder(methodicsDto.getLeftValueBorder());
        methodics.setRightValueBorder(methodicsDto.getRightValueBorder());
        methodics.setName(methodicsDto.getName());
        Set<Question> questions = new HashSet<>(questionMap.values());
        methodics.setQuestions(questions);
        methodics.setKeys(methodicsKeys);
        return methodics;
    }

    private MethodicsKey convert(MethodicsKeyDto methodicsKeyDto) {

        MethodicsKey methodicsKey = new MethodicsKey();
        methodicsKey.setNameScale(methodicsKeyDto.getNameScale());

        return methodicsKey;

    }


    private Question convert(QuestionsDto questionsDto) {
        Question question = new Question();

        Integer number = questionsDto.getNumber();
        String text = questionsDto.getText();

        question.setNumber(number);
        question.setText(text);

        return question;

    }
}
