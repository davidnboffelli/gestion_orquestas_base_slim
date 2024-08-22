package com.gruposei.gestion_orquestas.service;

import com.google.gson.Gson;
import com.gruposei.gestion_orquestas.model.Cloth;
import com.gruposei.gestion_orquestas.model.MercadopagoResource;
import com.gruposei.gestion_orquestas.model.PaymentRequest;
import com.gruposei.gestion_orquestas.repositories.PaymentRequestRepository;
import com.gruposei.gestion_orquestas.responses.ApiRequestException;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.*;
//import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentRequestService {

    @Autowired
    private PaymentRequestRepository paymentRequestRepository;

    public MercadopagoResource generatePreference(){
        try{
            MercadoPago.SDK.setAccessToken("TEST-2338012267335051-121003-6aa56ef59f4244b1cd4c0ed4d1b1a5af-105584808");
            MercadoPago.SDK.setIntegratorId("2338012267335051");
            Preference preference = new Preference();
            // Appending the items
            Item item = new Item();
            item.setId("1234");
            item.setTitle("Apple iPhone 5S");
            item.setPictureUrl("https://i.blogs.es/3ade97/iphone-5-4/1366_2000.jpg");
            item.setQuantity(1);
            item.setDescription("Dispositivo móvil de Tienda e-commerce");
            item.setCurrencyId("PEN");
            item.setUnitPrice((float) 149.99);
            preference.appendItem(item);
            // Payer information
            Payer payer = new Payer();
            payer.setName("Lalo Landa")
                    .setEmail("test_user_290774@testuser.com")
                    .setIdentification(new Identification()
                            .setType("DNI")
                            .setNumber("223344445"))
                    .setPhone(new Phone()
                            .setAreaCode("52")
                            .setNumber("5549737300"))
                    .setAddress(new Address()
                            .setZipCode("03940")
                            .setStreetNumber(1602)
                            .setStreetName("Insurgentes Sur"));
            preference.setPayer(payer);
            // Back urls and notification url
//            preference.setBackUrls(
//                    new BackUrls()
//                            .setFailure("https://mp-marco.herokuapp.com/payment")
//                            .setPending("https://mp-marco.herokuapp.com/payment")
//                            .setSuccess("https://mp-marco.herokuapp.com/payment")
//            );
            preference.setNotificationUrl("https://mp-marco.herokuapp.com/api/payments/notifications");
            preference.setExternalReference("manriqueacham@gmail.com");
            // Payment Methods
            PaymentMethods paymentMethods = new PaymentMethods();
            paymentMethods.setExcludedPaymentMethods("diners");
            paymentMethods.setExcludedPaymentTypes("atm");
//            paymentMethods.setInstallments(6);
            preference.setPaymentMethods(paymentMethods);
            preference.setAutoReturn(Preference.AutoReturn.approved);
            // Saving and returning
            preference = preference.save();

            // Resource (DTO)
            MercadopagoResource resource = new MercadopagoResource();
//            resource.setId(preference.getId());
            resource.setInitPoint(preference.getInitPoint());
            resource.setSandboxInitPoint(preference.getSandboxInitPoint());
//            resource.setItems(preference.getItems());
            resource.setExternalReference(preference.getExternalReference());
            return resource;

        } catch (MPException exception){
            throw  new ApiRequestException("002");
        }
    }

    public List<PaymentRequest> getAll(){

        return paymentRequestRepository.findAll();
    }

    public void delete(PaymentRequest p){

        paymentRequestRepository.delete(p);
    }

    public Optional<PaymentRequest> findById(Long id){

        return paymentRequestRepository.findById(id);
    }

    public Optional<PaymentRequest> findByExternalReference(String er){

        return paymentRequestRepository.findByExternalReference(er);
    }

    public boolean existsByExternalReference(String er){

        return paymentRequestRepository.existsByExternalReference(er);
    }

    public PaymentRequest create(PaymentRequest p){

        if(p.getId() == null){

            p = paymentRequestRepository.save(p);
            p.setExternalReference(p.getId().toString() + p.getShow().getId().toString() + p.getQuantity() + p.getUser().getUsername());
        }

        return paymentRequestRepository.save(p);
    }
}
