package com.gruposei.gestion_orquestas.rest;

import com.gruposei.gestion_orquestas.model.SurveyQuestionAnswer;
import com.gruposei.gestion_orquestas.model.SurveyQuestionAnswerKey;
import com.gruposei.gestion_orquestas.responses.ApiRequestException;
import com.gruposei.gestion_orquestas.responses.ResponseHandler;
import com.gruposei.gestion_orquestas.service.SurveyQuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/surveys_questions/answers")
public class SurveyQuestionAnswerREST {

    @Autowired
    private SurveyQuestionAnswerService surveyQuestionAnswerService;

    @Autowired
    private ResponseHandler responseHandler;

    @PostMapping
    private ResponseEntity<Object> save(@RequestBody SurveyQuestionAnswer p){

        try{

            SurveyQuestionAnswer temporal = surveyQuestionAnswerService.create(p);
            return responseHandler.generateResponse("000",temporal);
        }
        catch(Exception e){

            throw  new ApiRequestException("002");
        }
    }

    @GetMapping
    private ResponseEntity<Object> getAll(){

        try{

            List<SurveyQuestionAnswer> cloths = surveyQuestionAnswerService.getAll();
            return responseHandler.generateResponse("000",cloths);
        }
        catch(Exception e){

            throw new ApiRequestException("002");
        }
    }

    @DeleteMapping(params = {"user_id","question_id"})
    public ResponseEntity<Object> deleteById(@RequestParam("user_id") Long user_id,@RequestParam("question_id") Long question_id) {
        SurveyQuestionAnswerKey sqaKey = new SurveyQuestionAnswerKey();
        sqaKey.setQuestionId(question_id);
        sqaKey.setUserId(user_id);
        Optional<SurveyQuestionAnswer> cloth= surveyQuestionAnswerService.findById(sqaKey);

        if(!cloth.isPresent()){

            throw new ApiRequestException("005");
        }

        try {
            surveyQuestionAnswerService.deleteById(sqaKey);
            return responseHandler.generateResponse("000",cloth);
        }
        catch (Exception e){

            throw  new ApiRequestException("002");
        }
    }

    @RequestMapping(params = {"user_id","question_id"})
    public ResponseEntity<Object> getById(@RequestParam("user_id") Long user_id,@RequestParam("question_id") Long question_id) {
        SurveyQuestionAnswerKey sqaKey = new SurveyQuestionAnswerKey();
        sqaKey.setQuestionId(question_id);
        sqaKey.setUserId(user_id);
        Optional<SurveyQuestionAnswer> cloth= surveyQuestionAnswerService.findById(sqaKey);

        if(!cloth.isPresent()){

            throw new ApiRequestException("005");
        }
        try {

            return responseHandler.generateResponse("000",cloth);
        }
        catch (Exception e){

            throw  new ApiRequestException("002");
        }
    }
}
