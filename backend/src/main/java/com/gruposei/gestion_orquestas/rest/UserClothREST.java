package com.gruposei.gestion_orquestas.rest;

import com.gruposei.gestion_orquestas.model.Song;
import com.gruposei.gestion_orquestas.model.UserCloth;
import com.gruposei.gestion_orquestas.model.UserClothKey;
import com.gruposei.gestion_orquestas.responses.ApiRequestException;
import com.gruposei.gestion_orquestas.responses.ResponseHandler;
import com.gruposei.gestion_orquestas.service.UserClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users_clothes")
public class UserClothREST {

    @Autowired
    private UserClothService userClothService;

    @Autowired
    private ResponseHandler responseHandler;

    @PostMapping
    private ResponseEntity<Object> save(@RequestBody UserCloth p){

        try{

            UserCloth temporal = userClothService.create(p);
            return responseHandler.generateResponse("000",temporal);
        }
        catch(Exception e){

            throw  new ApiRequestException("002");
        }
    }

    @GetMapping
    private ResponseEntity<Object> getAll(){

        try{

            List<UserCloth> cloths = userClothService.getAll();
            return responseHandler.generateResponse("000",cloths);
        }
        catch(Exception e){

            throw new ApiRequestException("002");
        }
    }

    @DeleteMapping(params = {"user_id","cloth_id"})
    public ResponseEntity<Object> deleteById(@RequestParam("user_id") Long user_id,@RequestParam("cloth_id") Long cloth_id) {
        UserClothKey userClothKey = new UserClothKey();
        userClothKey.setUserId(user_id);
        userClothKey.setClothId(cloth_id);

        Optional<UserCloth> cloth= userClothService.findById(userClothKey);

        if(!cloth.isPresent()){

            throw new ApiRequestException("005");
        }

        try {
            userClothService.deleteById(userClothKey);
            return responseHandler.generateResponse("000",cloth);
        }
        catch (Exception e){

            throw  new ApiRequestException("002");
        }
    }

    @RequestMapping(params = {"user_id","cloth_id"})
    public ResponseEntity<Object> getById(@RequestParam("user_id") Long user_id,@RequestParam("cloth_id") Long cloth_id) {
        UserClothKey userClothKey = new UserClothKey();
        userClothKey.setUserId(user_id);
        userClothKey.setClothId(cloth_id);

        Optional<UserCloth> cloth= userClothService.findById(userClothKey);

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
