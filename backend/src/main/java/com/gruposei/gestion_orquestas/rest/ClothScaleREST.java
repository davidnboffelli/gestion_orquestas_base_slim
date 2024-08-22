package com.gruposei.gestion_orquestas.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gruposei.gestion_orquestas.model.ClothScale;
import com.gruposei.gestion_orquestas.model.ClothType;
import com.gruposei.gestion_orquestas.responses.ApiRequestException;
import com.gruposei.gestion_orquestas.responses.ResponseHandler;
import com.gruposei.gestion_orquestas.service.ClothScaleService;
import com.gruposei.gestion_orquestas.service.ClothTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/clothe_scales")
public class ClothScaleREST {

    @Autowired
    private ClothScaleService clothScaleService;

    @Autowired
    private ClothTypeService clothTypeService;

    @Autowired
    private ResponseHandler responseHandler;

//    @PostMapping
//    private ResponseEntity<Object> save(@RequestBody ClothScale p){
//
//        try{
//
//            ClothScale temporal = clothScaleService.create(p);
//            return responseHandler.generateResponse("000",temporal);
//        }
//        catch(Exception e){
//
//            throw  new ApiRequestException("002");
//        }
//    }

    @PostMapping
    private ResponseEntity<Object> save(@RequestBody JsonNode p) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(String.valueOf(p));
        List<String> x = mapper.convertValue(rootNode.get("size"), ArrayList.class);
        Long y = mapper.convertValue(rootNode.get("clothType").get("id"), Long.class);
        Optional<ClothType> clothType = clothTypeService.findById(y);

        List<ClothScale> scales = new ArrayList<ClothScale>();
        try{
            for (String s:x) {
                if(!clothScaleService.existBySize(s)){

                    ClothScale temporal = clothScaleService.create_manual(clothType.get(),s);
                    scales.add(temporal);
                }
            }
            return responseHandler.generateResponse("000",scales);
        }
        catch(Exception e){

            throw  new ApiRequestException("002");
        }
    }

    @GetMapping
    private ResponseEntity<Object> getAll(){

        try{

            List<ClothScale> cloths = clothScaleService.getAll();
            return responseHandler.generateResponse("000",cloths);
        }
        catch(Exception e){

            throw new ApiRequestException("002");
        }
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<Object> deleteById(@RequestParam("id") Long id) {

        Optional<ClothScale> cloth= clothScaleService.findById(id);

        if(!cloth.isPresent()){

            throw new ApiRequestException("005");
        }

        try {
            clothScaleService.deleteById(id);
            return responseHandler.generateResponse("000",cloth);
        }
        catch (Exception e){

            throw  new ApiRequestException("002");
        }
    }

    @RequestMapping(params = "id")
    public ResponseEntity<Object> getById(@RequestParam("id") Long id) {

        Optional<ClothScale> cloth= clothScaleService.findById(id);

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
