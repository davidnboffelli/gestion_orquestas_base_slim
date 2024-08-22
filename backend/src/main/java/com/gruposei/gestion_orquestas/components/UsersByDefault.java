package com.gruposei.gestion_orquestas.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.gruposei.gestion_orquestas.model.Role;
import com.gruposei.gestion_orquestas.model.User;
import com.gruposei.gestion_orquestas.service.ClothScaleService;
import com.gruposei.gestion_orquestas.service.ClothService;
import com.gruposei.gestion_orquestas.service.ClothTypeService;
import com.gruposei.gestion_orquestas.service.MeetingMinuteService;
import com.gruposei.gestion_orquestas.service.RoleService;
import com.gruposei.gestion_orquestas.service.UserClothService;
import com.gruposei.gestion_orquestas.service.UserService;

@Component
@Order(1)
public class UsersByDefault implements CommandLineRunner{

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ClothService clothService;

    @Autowired
    private UserClothService userClothService;

    @Autowired
    private MeetingMinuteService meetingMinuteService;

    @Autowired
    private ClothTypeService clothTypeService;

    @Autowired
    private ClothScaleService clothScaleService;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User();
        user1.setUsername("david");
        user1.setPassword(bCryptPasswordEncoder.encode("123"));
        user1.setName("David");
        user1.setLastname("Boffelli");
        user1.setEmail("davidboffelli@yahoo.com");
        user1.setAddress("Por acá");
//        user.setEnabled(true);
        userService.create(user1);

        User user4 = new User();
        user4.setUsername("damian");
        user4.setPassword(bCryptPasswordEncoder.encode("123"));
        user4.setName("Damian");
        user4.setLastname("Ciancio");
        user4.setEmail("damianciancio7@gmail.com");
        user4.setAddress("Riobamba y Paraguay");
//        user.setEnabled(true);
        userService.create(user4);

        User user2 = new User();
        user2.setUsername("guest");
        user2.setPassword(bCryptPasswordEncoder.encode("123"));
        user2.setName("Guest");
        user2.setLastname("Invitado");
        user2.setEmail("guest@yahoo.com");
        user2.setAddress("En tu mente");
//        user.setEnabled(true);
        userService.create(user2);

        User user3 = new User();
        user3.setId(1L);
        user3.setUsername("admin");
        user3.setPassword(bCryptPasswordEncoder.encode("admin"));
        user3.setName("Admin");
        user3.setLastname("Admin");
        user3.setEmail("gruposei@yahoo.com");
        user3.setAddress("Donde vendan empanadas piolas");
//        user.setEnabled(true);

        Role role1 = new Role();
        role1.setId(1L);
        role1.setName("Administradores de Sistema");
        role1.setEnabled(true);
        roleService.create(role1);

        Role role2 = new Role();
        role2.setId(2L);
        role2.setName("Integrante de la Orquesta");
        role2.setEnabled(true);
        roleService.create(role2);

        Role role3 = new Role();
        role3.setId(3L);
        role3.setName("Visitante");
        role3.setEnabled(false);
        roleService.create(role3);

        user3.addRole(role1);
        userService.create(user3);

        user4.addRole(role3);
        userService.create(user4);

//        ClothType clothType1 = new ClothType();
//        clothType1.setName("Pantalón");
//        clothTypeService.create(clothType1);
//
//        ClothType clothType2 = new ClothType();
//        clothType2.setName("Remera");
//        clothTypeService.create(clothType2);
//
//        ClothType clothType3 = new ClothType();
//        clothType3.setName("Zapato");
//        clothTypeService.create(clothType3);
//
//        ClothScale clothScale1 = new ClothScale();
//        clothScale1.setClothType(clothType1);
//        clothScale1.setSize("36");
//        clothScaleService.create(clothScale1);
//
//        ClothScale clothScale2 = new ClothScale();
//        clothScale2.setClothType(clothType1);
//        clothScale2.setSize("38");
//        clothScaleService.create(clothScale2);
//
//        ClothScale clothScale3 = new ClothScale();
//        clothScale3.setClothType(clothType1);
//        clothScale3.setSize("40");
//        clothScaleService.create(clothScale3);
//
//        ClothScale clothScale4 = new ClothScale();
//        clothScale4.setClothType(clothType1);
//        clothScale4.setSize("S");
//        clothScaleService.create(clothScale4);
//
//        ClothScale clothScale5 = new ClothScale();
//        clothScale5.setClothType(clothType1);
//        clothScale5.setSize("M");
//        clothScaleService.create(clothScale5);
//
//        ClothScale clothScale6 = new ClothScale();
//        clothScale6.setClothType(clothType1);
//        clothScale6.setSize("L");
//        clothScaleService.create(clothScale6);
//
//        ClothScale clothScale7 = new ClothScale();
//        clothScale7.setClothType(clothType1);
//        clothScale7.setSize("36");
//        clothScaleService.create(clothScale7);
//
//        ClothScale clothScale8 = new ClothScale();
//        clothScale8.setClothType(clothType1);
//        clothScale8.setSize("38");
//        clothScaleService.create(clothScale8);
//
//        ClothScale clothScale9 = new ClothScale();
//        clothScale9.setClothType(clothType1);
//        clothScale9.setSize("40");
//        clothScaleService.create(clothScale9);
//
//        Cloth cloth1 = new Cloth();
//        cloth1.setDescription("Remera que usan los miembros de la orquesta durante los shows");
//        cloth1.setClothType(clothType2);
//        clothService.create(cloth1);
//
//        Cloth cloth2 = new Cloth();
//        cloth2.setDescription("Remera para los fans");
//        cloth1.setClothType(clothType2);
//        clothService.create(cloth2);
//
//        Cloth cloth3 = new Cloth();
//        cloth3.setDescription("Pantalón que usan los miembros de la orquesta durante los shows");
//        cloth1.setClothType(clothType1);
//        clothService.create(cloth3);
//
//        Cloth cloth4 = new Cloth();
//        cloth3.setDescription("Zapatos que usan los miembros de la orquesta durante los shows");
//        cloth1.setClothType(clothType3);
//        clothService.create(cloth4);
//
//        UserCloth userCloth1 = new UserCloth();
//        userCloth1.setUser(userService.findByUsername("david").get());
//        userCloth1.setCloth(cloth1);
//        userCloth1.setClothScale(clothScale6);
//        userClothService.create(userCloth1);
//
//        UserCloth userCloth2 = new UserCloth();
//        userCloth2.setUser(userService.findByUsername("david").get());
//        userCloth2.setCloth(cloth3);
//        userCloth2.setClothScale(clothScale2);
//        userClothService.create(userCloth2);
//
//        UserCloth userCloth3 = new UserCloth();
//        userCloth3.setUser(userService.findByUsername("guest").get());
//        userCloth3.setCloth(cloth2);
//        userCloth3.setClothScale(clothScale5);
//        userClothService.create(userCloth3);
//
//        MeetingMinute meetingMinute1 = new MeetingMinute();
//        meetingMinute1.setText("Aquí iría una minuta acerca de la última reunión de la orquesta, pero no tuve suficiente inspiración, por lo que solo escribo esto");
//        meetingMinute1.setAuthor("David");
//        meetingMinute1.setDate(new Date(System.currentTimeMillis()));
//        meetingMinute1.addUsers(user1);
//        meetingMinute1.addUsers(user2);
//        meetingMinute1.addUsers(user3);
//        meetingMinuteService.create(meetingMinute1);
//
//        MeetingMinute meetingMinute2 = new MeetingMinute();
//        meetingMinute2.setText("Nueva reunión donde se definieron cosas importante y se debió tomar nota");
//        meetingMinute2.setAuthor("Alguien");
//        meetingMinute2.setDate(new Date(System.currentTimeMillis()));
//        meetingMinute2.addUsers(user1);
//        meetingMinuteService.create(meetingMinute2);
    }
}