package com.gruposei.gestion_orquestas.rest;

import com.gruposei.gestion_orquestas.model.SurveyQuestionOptionAnswer;
import com.gruposei.gestion_orquestas.model.SurveyQuestionOptionAnswerKey;
import com.gruposei.gestion_orquestas.responses.ApiRequestException;
import com.gruposei.gestion_orquestas.responses.ResponseHandler;
import com.gruposei.gestion_orquestas.service.SurveyQuestionOptionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sq_options/answers")
public class SurveyQuestionOptionAnswerREST {

    @Autowired
    private SurveyQuestionOptionAnswerService surveyQuestionOptionAnswerService;

    @Autowired
    private ResponseHandler responseHandler;

    @PostMapping
    private ResponseEntity<Object> save(@RequestBody SurveyQuestionOptionAnswer p){

        try{

            SurveyQuestionOptionAnswer temporal = surveyQuestionOptionAnswerService.create(p);
            return responseHandler.generateResponse("000",temporal);
        }
        catch(Exception e){

            throw  new ApiRequestException("002");
        }
    }

    @GetMapping
    private ResponseEntity<Object> getAll(){

        try{

            List<SurveyQuestionOptionAnswer> cloths = surveyQuestionOptionAnswerService.getAll();
            return responseHandler.generateResponse("000",cloths);
        }
        catch(Exception e){

            throw new ApiRequestException("002");
        }
    }

    @DeleteMapping(params = {"user_id","option_id"})
    public ResponseEntity<Object> deleteById(@RequestParam("user_id") Long user_id,@RequestParam("option_id") Long option_id) {
        SurveyQuestionOptionAnswerKey sqoaKey = new SurveyQuestionOptionAnswerKey();
        sqoaKey.setUserId(user_id);
        sqoaKey.setOptionId(option_id);
        Optional<SurveyQuestionOptionAnswer> cloth= surveyQuestionOptionAnswerService.findById(sqoaKey);

        if(!cloth.isPresent()){

            throw new ApiRequestException("005");
        }

        try {
            surveyQuestionOptionAnswerService.deleteById(sqoaKey);
            return responseHandler.generateResponse("000",cloth);
        }
        catch (Exception e){

            throw  new ApiRequestException("002");
        }
    }

    @RequestMapping(params = {"user_id","option_id"})
    public ResponseEntity<Object> getById(@RequestParam("user_id") Long user_id,@RequestParam("option_id") Long option_id) {
        SurveyQuestionOptionAnswerKey sqoaKey = new SurveyQuestionOptionAnswerKey();
        sqoaKey.setUserId(user_id);
        sqoaKey.setOptionId(option_id);
        Optional<SurveyQuestionOptionAnswer> cloth= surveyQuestionOptionAnswerService.findById(sqoaKey);

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
