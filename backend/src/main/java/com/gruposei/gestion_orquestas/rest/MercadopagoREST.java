package com.gruposei.gestion_orquestas.rest;

import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gruposei.gestion_orquestas.model.MercadopagoNotification;
import com.gruposei.gestion_orquestas.model.MercadopagoResource;
import com.gruposei.gestion_orquestas.model.PaymentRequest;
import com.gruposei.gestion_orquestas.model.Show;
import com.gruposei.gestion_orquestas.model.Ticket;
import com.gruposei.gestion_orquestas.model.User;
import com.gruposei.gestion_orquestas.responses.ApiRequestException;
import com.gruposei.gestion_orquestas.responses.ResponseHandler;
import com.gruposei.gestion_orquestas.service.MercadopagoBackurlsService;
import com.gruposei.gestion_orquestas.service.MercadopagoNotificationService;
import com.gruposei.gestion_orquestas.service.PaymentRequestService;
import com.gruposei.gestion_orquestas.service.ShowService;
import com.gruposei.gestion_orquestas.service.TicketService;
import com.gruposei.gestion_orquestas.service.UserService;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;

//@CrossOrigin(origins = "**")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("/api/mercadopago")
public class MercadopagoREST {

    @Autowired
    private ResponseHandler responseHandler;

    @Autowired
    private ShowService showService;

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentRequestService paymentRequestService;

    @Autowired
    private MercadopagoNotificationService mercadopagoNotificationService;

    @Autowired
    private MercadopagoBackurlsService mercadopagoBackurlsService;

    @Autowired
    private TicketService ticketService;

    @PostMapping
    private ResponseEntity<Object> save(@RequestBody JsonNode p) throws JsonProcessingException, MPException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(String.valueOf(p));
        Long show_id = mapper.convertValue(rootNode.get("show_id"), Long.class);
        int quantity = mapper.convertValue(rootNode.get("quantity"), Integer.class);
        Long user_id = mapper.convertValue(rootNode.get("user_id"), Long.class);

        Optional<Show> show = showService.findById(show_id);
        Optional<User> user = userService.findById(user_id);

        if(!show.isPresent()){

            throw new ApiRequestException("008");
        }

        if(!user.isPresent()){

            throw new ApiRequestException("007");
        }

        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setShow(show.get());
        paymentRequest.setQuantity(quantity);
        paymentRequest.setUser(user.get());
        paymentRequest = paymentRequestService.create(paymentRequest);
        String externalReference = user.get().getUsername() + quantity + show.get().getName() + paymentRequest.getId();
        paymentRequest.setExternalReference(externalReference);
        paymentRequest = paymentRequestService.create(paymentRequest);

        MercadoPago.SDK.setAccessToken("TEST-2338012267335051-121003-6aa56ef59f4244b1cd4c0ed4d1b1a5af-105584808");
        MercadoPago.SDK.setIntegratorId("2338012267335051");
        Preference preference = new Preference();
        preference.setExternalReference(externalReference);
        Item item = new Item()
                .setId("1234")
                .setTitle("Entrada " + show.get().getName())
                .setPictureUrl("https://i.blogs.es/3ade97/iphone-5-4/1366_2000.jpg")
                .setQuantity(quantity)
                .setDescription("Lugar: " + show.get().getPlace())
                .setUnitPrice((float) show.get().getPrice());
        preference.setBackUrls(
                new BackUrls()
                    //    .setFailure("https://localhost:8080/payment/buy/failed")
//                        .setPending("http://7edc-190-2-106-33.ngrok.io/#/")
                    //    .setSuccess("https://localhost:8080/payment/buy/success")
        );
        preference.appendItem(item);
        preference = preference.save();

        paymentRequest.setPreferenceID(preference.getId());
        paymentRequestService.create(paymentRequest);

        MercadopagoResource mercadopagoResource = new MercadopagoResource();
        mercadopagoResource.setPreferenceID(preference.getId());
        mercadopagoResource.setExternalReference(preference.getExternalReference());
        mercadopagoResource.setInitPoint(preference.getInitPoint());
        mercadopagoResource.setSandboxInitPoint(preference.getSandboxInitPoint());
        System.out.println("SandboxInitPoint: " + preference.getSandboxInitPoint());
        return responseHandler.generateResponse("000", mercadopagoResource);
    }

    @PostMapping("/notifications")
    private ResponseEntity<Object> pagado(@RequestBody JsonNode jsonNode) throws MPException, JSONException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        JSONObject p;
        p=new JSONObject(mapper.writeValueAsString(jsonNode));

        String id = (p.isNull("id") ? null : p.getString("id"));
        String action = (p.isNull("action") ? null : p.getString("action"));
        String api_version = (p.isNull("api_version") ? null : p.getString("api_version"));
        String application_id = (p.isNull("application_id") ? null : p.getString("application_id"));
        String date_created = (p.isNull("date_created") ? null : p.getString("date_created"));
        String live_mode = (p.isNull("live_mode") ? null : p.getString("live_mode"));
        String type = (p.isNull("type") ? null : p.getString("type"));
        String user_id = (p.isNull("user_id") ? null : p.getString("user_id"));
        String version = (p.isNull("version") ? null : p.getString("version"));
        String data_id = (p.getJSONObject("data").isNull("id") ? null : p.getJSONObject("data").getString("id"));

        MercadopagoNotification mercadopagoNotification = new MercadopagoNotification();
        mercadopagoNotification.setId(id);
        mercadopagoNotification.setAction(action);
        mercadopagoNotification.setApi_version(api_version);
        mercadopagoNotification.setApplication_id(application_id);
        mercadopagoNotification.setDate_created(date_created);
        mercadopagoNotification.setLive_mode(live_mode);
        mercadopagoNotification.setType(type);
        mercadopagoNotification.setUser_id(user_id);
        mercadopagoNotification.setVersion(version);
        mercadopagoNotification.setData(data_id);
        mercadopagoNotificationService.create(mercadopagoNotification);

        if(!action.equalsIgnoreCase("payment.created")){

            return responseHandler.generateResponse("000","No es aviso de pago generado.");
        }

        String externalReferenceId = Payment.findById(data_id).getExternalReference();
        Optional<PaymentRequest> pr = paymentRequestService.findByExternalReference(externalReferenceId);

        if (!pr.isPresent()) {
            return responseHandler.generateResponse("000","Solicitud de pago no registrada.");
        }

        if (pr.get().isPaid()){
            return responseHandler.generateResponse("000","Pago ya realizado con anterioridad.");
        }

        try{
            pr.get().setPaid(true);
            paymentRequestService.create(pr.get());

            List<Ticket> tickets = ticketService.create(pr.get().getUser(),pr.get().getShow(),pr.get().getQuantity());

            return responseHandler.generateResponse("000",tickets);
        }
        catch(Exception e){

            return responseHandler.generateResponse("000","Error generando tickets.");
        }
    }
}