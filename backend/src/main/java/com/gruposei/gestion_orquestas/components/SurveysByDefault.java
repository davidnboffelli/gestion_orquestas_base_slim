package com.gruposei.gestion_orquestas.components;

import com.gruposei.gestion_orquestas.model.*;
import com.gruposei.gestion_orquestas.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Order(4)
public class SurveysByDefault implements CommandLineRunner {

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private SurveyQuestionService surveyQuestionService;

    @Autowired
    private SurveyQuestionTypeService surveyQuestionTypeService;

    @Autowired
    private SurveyQuestionOptionService surveyQuestionOptionService;

    @Autowired
    private SurveyQuestionOptionAnswerService surveyQuestionOptionAnswerService;

    @Autowired
    private SurveyQuestionAnswerService surveyQuestionAnswerService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {

        Survey survey = new Survey();
        survey.setTitle("Encuesta de conformidad con las empanadas de Anajuana");
        survey.setRole(roleService.findById(3L).get());
        survey.setPublicDate(new Date(System.currentTimeMillis()));
        surveyService.create(survey);

        SurveyQuestionType surveyQuestionType1 = new SurveyQuestionType();
        surveyQuestionType1.setName("Opción única");
        surveyQuestionType1.setEnabled(true);
        surveyQuestionTypeService.create(surveyQuestionType1);

        SurveyQuestionType surveyQuestionType2 = new SurveyQuestionType();
        surveyQuestionType2.setName("Opción múltiple");
        surveyQuestionType2.setEnabled(true);
        surveyQuestionTypeService.create(surveyQuestionType2);

        SurveyQuestionType surveyQuestionType3 = new SurveyQuestionType();
        surveyQuestionType3.setName("Texto");
        surveyQuestionType3.setEnabled(true);
        surveyQuestionTypeService.create(surveyQuestionType3);

        SurveyQuestion surveyQuestion1 = new SurveyQuestion();
        surveyQuestion1.setSurvey(survey);
        surveyQuestion1.setSurveyQuestionType(surveyQuestionType2);
        surveyQuestion1.setTitle("Marque cuáles fueron sus empanadas favoritas");
        surveyQuestionService.create(surveyQuestion1);

        SurveyQuestion surveyQuestion2 = new SurveyQuestion();
        surveyQuestion2.setSurvey(survey);
        surveyQuestion2.setSurveyQuestionType(surveyQuestionType1);
        surveyQuestion2.setTitle("¿Le recomendaría Anajuana a un amigo?");
        surveyQuestionService.create(surveyQuestion2);

        SurveyQuestion surveyQuestion3 = new SurveyQuestion();
        surveyQuestion3.setSurvey(survey);
        surveyQuestion3.setSurveyQuestionType(surveyQuestionType3);
        surveyQuestion3.setTitle("Describa brevemente su experiencia");
        surveyQuestionService.create(surveyQuestion3);

        SurveyQuestionOption surveyQuestionOption1 = new SurveyQuestionOption();
        surveyQuestionOption1.setSurveyQuestion(surveyQuestion1);
        surveyQuestionOption1.setOption("Jamón y queso");
        surveyQuestionOptionService.create(surveyQuestionOption1);

        SurveyQuestionOption surveyQuestionOption2 = new SurveyQuestionOption();
        surveyQuestionOption2.setSurveyQuestion(surveyQuestion1);
        surveyQuestionOption2.setOption("Carne cortada a cuchillo");
        surveyQuestionOptionService.create(surveyQuestionOption2);

        SurveyQuestionOption surveyQuestionOption3 = new SurveyQuestionOption();
        surveyQuestionOption3.setSurveyQuestion(surveyQuestion1);
        surveyQuestionOption3.setOption("Caprese");
        surveyQuestionOptionService.create(surveyQuestionOption3);

        SurveyQuestionOption surveyQuestionOption4 = new SurveyQuestionOption();
        surveyQuestionOption4.setSurveyQuestion(surveyQuestion1);
        surveyQuestionOption4.setOption("Cuatro quesos");
        surveyQuestionOptionService.create(surveyQuestionOption4);

        SurveyQuestionOption surveyQuestionOption5 = new SurveyQuestionOption();
        surveyQuestionOption5.setSurveyQuestion(surveyQuestion1);
        surveyQuestionOption5.setOption("Verdura");
        surveyQuestionOptionService.create(surveyQuestionOption5);

        SurveyQuestionOption surveyQuestionOption6 = new SurveyQuestionOption();
        surveyQuestionOption6.setSurveyQuestion(surveyQuestion2);
        surveyQuestionOption6.setOption("No");
        surveyQuestionOptionService.create(surveyQuestionOption6);

        SurveyQuestionOption surveyQuestionOption7 = new SurveyQuestionOption();
        surveyQuestionOption7.setSurveyQuestion(surveyQuestion2);
        surveyQuestionOption7.setOption("Quizás");
        surveyQuestionOptionService.create(surveyQuestionOption7);

        SurveyQuestionOption surveyQuestionOption8 = new SurveyQuestionOption();
        surveyQuestionOption8.setSurveyQuestion(surveyQuestion2);
        surveyQuestionOption8.setOption("Es probable");
        surveyQuestionOptionService.create(surveyQuestionOption8);

        SurveyQuestionOption surveyQuestionOption9 = new SurveyQuestionOption();
        surveyQuestionOption9.setSurveyQuestion(surveyQuestion2);
        surveyQuestionOption9.setOption("Sí");
        surveyQuestionOptionService.create(surveyQuestionOption9);

        SurveyQuestionOptionAnswer surveyQuestionOptionAnswer1 = new SurveyQuestionOptionAnswer();
        surveyQuestionOptionAnswer1.setSurveyQuestionOption(surveyQuestionOption2);
        surveyQuestionOptionAnswer1.setUser(userService.findByUsername("david").get());
        surveyQuestionOptionAnswerService.create(surveyQuestionOptionAnswer1);

        SurveyQuestionOptionAnswer surveyQuestionOptionAnswer2 = new SurveyQuestionOptionAnswer();
        surveyQuestionOptionAnswer2.setSurveyQuestionOption(surveyQuestionOption4);
        surveyQuestionOptionAnswer2.setUser(userService.findByUsername("david").get());
        surveyQuestionOptionAnswerService.create(surveyQuestionOptionAnswer2);

        SurveyQuestionOptionAnswer surveyQuestionOptionAnswer3 = new SurveyQuestionOptionAnswer();
        surveyQuestionOptionAnswer3.setSurveyQuestionOption(surveyQuestionOption9);
        surveyQuestionOptionAnswer3.setUser(userService.findByUsername("david").get());
        surveyQuestionOptionAnswerService.create(surveyQuestionOptionAnswer3);

        SurveyQuestionOptionAnswer surveyQuestionOptionAnswer4 = new SurveyQuestionOptionAnswer();
        surveyQuestionOptionAnswer4.setSurveyQuestionOption(surveyQuestionOption5);
        surveyQuestionOptionAnswer4.setUser(userService.findByUsername("guest").get());
        surveyQuestionOptionAnswerService.create(surveyQuestionOptionAnswer4);

        SurveyQuestionOptionAnswer surveyQuestionOptionAnswer5 = new SurveyQuestionOptionAnswer();
        surveyQuestionOptionAnswer5.setSurveyQuestionOption(surveyQuestionOption6);
        surveyQuestionOptionAnswer5.setUser(userService.findByUsername("guest").get());
        surveyQuestionOptionAnswerService.create(surveyQuestionOptionAnswer5);

        SurveyQuestionAnswer surveyQuestionAnswer1 = new SurveyQuestionAnswer();
        surveyQuestionAnswer1.setSurveyQuestion(surveyQuestion3);
        surveyQuestionAnswer1.setUser(userService.findByUsername("guest").get());
        surveyQuestionAnswer1.setAnswer("Una cagada");
        surveyQuestionAnswerService.create(surveyQuestionAnswer1);

        SurveyQuestionAnswer surveyQuestionAnswer2 = new SurveyQuestionAnswer();
        surveyQuestionAnswer2.setSurveyQuestion(surveyQuestion3);
        surveyQuestionAnswer2.setUser(userService.findByUsername("david").get());
        surveyQuestionAnswer2.setAnswer("Las mejores empanadas de Rosario");
        surveyQuestionAnswerService.create(surveyQuestionAnswer2);
    }
}
