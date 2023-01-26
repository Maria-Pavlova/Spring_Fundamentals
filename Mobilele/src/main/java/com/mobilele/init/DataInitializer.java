package com.mobilele.init;

import com.mobilele.models.entities.*;
import com.mobilele.models.enums.Role;
import com.mobilele.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

import static com.mobilele.models.enums.Category.CAR;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final UserRoleRepository roleRepository;
    private final ModelRepository modelRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(BrandRepository brandRepository, OfferRepository offerRepository,
                           UserRepository userRepository, UserRoleRepository roleRepository,
                           ModelRepository modelRepository, PasswordEncoder passwordEncoder) {
        this.brandRepository = brandRepository;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelRepository = modelRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //todo



//    private static final List<Offer> SAMPLE_OFFERS = List.of(
//            new Offer(1L, CAR, new ArrayList<Model>(SAMPLE_BRANDS.get("BMW")).get(5), 2016, 30000, Engine.DIESEL,
//                    Transmission.AUTOMATIC, "all extras", 75000D, "/uploads/2018_BMW_630i_GT_M_Sport_Automatic_2.0_Front.jpg",
//                    SAMPLE_USERS.get(1), 1L)
//    );


    @Override
    public void run(String... args) throws Exception {
//TODO


        if (userRepository.count() == 0) {
            initUsers();
        }
        if (brandRepository.count() == 0) {
            initBrands();
        }
//        if (modelRepository.count() == 0){
//            initModels();
//        }
   }
//
//    private void initModels() {
//      //  modelRepository.saveAll(
//        Set<Model> models = Set.of(
//                new Model("Agila", CAR, 2000, 2007, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Opel_Agila_A_1.2_Njoy.JPG/300px-Opel_Agila_A_1.2_Njoy.JPG"),
//                new Model("Adam", CAR, 2013, 2019, "https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Opel_Adam_1.4_Slam_%E2%80%93_Frontansicht%2C_15._Januar_2014%2C_D%C3%BCsseldorf.jpg/1600px-Opel_Adam_1.4_Slam_%E2%80%93_Frontansicht%2C_15._Januar_2014%2C_D%C3%BCsseldorf.jpg"),
//                new Model("Karl", CAR, 2015, 2019, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Opel_KARL_%281%29.jpg/300px-Opel_KARL_%281%29.jpg"),
//                new Model("Chevette", CAR, 1980, 1982, "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Vauxhall_Chevette_4_door_notchback_Trumpington.jpg/300px-Vauxhall_Chevette_4_door_notchback_Trumpington.jpg"),
//                new Model("Corsa A", CAR, 1982, 1993, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/Opel_Corsa_A_front_20080131.jpg/300px-Opel_Corsa_A_front_20080131.jpg"),
//                new Model("Corsa B", CAR, 1993, 2000, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Opel_Corsa_front_20080417.jpg/300px-Opel_Corsa_front_20080417.jpg"),
//                new Model("Tigra A", CAR, 1994, 2000, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Opel_Tigra_front_20071212.jpg/300px-Opel_Tigra_front_20071212.jpg"),
//                new Model("Corsa C", CAR, 2000, 2006, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/Opel_Corsa_C_1.2_Elegance_front_20100912.jpg/300px-Opel_Corsa_C_1.2_Elegance_front_20100912.jpg"),
//                new Model("Tigra TwinTop B", CAR, 2004, 2009, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/OPEL-VAUX-TIGRA-B.jpg/300px-OPEL-VAUX-TIGRA-B.jpg"),
//                new Model("Corsa D", CAR, 2006, 2014, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/Opel_Corsa_Satellite_%28D%2C_Facelift%29_%E2%80%93_Frontansicht%2C_2._April_2011%2C_D%C3%BCsseldorf.jpg/300px-Opel_Corsa_Satellite_%28D%2C_Facelift%29_%E2%80%93_Frontansicht%2C_2._April_2011%2C_D%C3%BCsseldorf.jpg"),
//                new Model("Corsa E", CAR, 2014, 2019, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Opel_Corsa_1.3_CDTI_ecoFLEX_Innovation_%28E%29_%E2%80%93_Frontansicht%2C_24._Dezember_2015%2C_Ratingen.jpg/300px-Opel_Corsa_1.3_CDTI_ecoFLEX_Innovation_%28E%29_%E2%80%93_Frontansicht%2C_24._Dezember_2015%2C_Ratingen.jpg"),
//                new Model("Corse F", CAR, 2019, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/Opel_Corsa-e_at_IAA_2019_IMG_0738.jpg/300px-Opel_Corsa-e_at_IAA_2019_IMG_0738.jpg"),
//                new Model("Olympia", CAR, 1947, 1953, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Opel_Olympia.jpg/300px-Opel_Olympia.jpg"),
//                new Model("Kadett A", CAR, 1962, 1965, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Opel_Kadett_A.jpg/300px-Opel_Kadett_A.jpg"));
//
//            models.forEach(model -> model.setBrand(brandRepository.findById()));
//    }
//
        private void initBrands () {
            Brand brandBMW = new Brand();
            brandBMW.setName("BMW");
//        brandBMW.setModels(Set.of( new Model("M1", CAR, 1978, 1981, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/BMW_M1%2C_front_right_%28Brooklyn%29.jpg/560px-BMW_M1%2C_front_right_%28Brooklyn%29.jpg"),
//                    new Model("M2", CAR, 2016, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/2017_BMW_M2_Automatic_3.0_Front.jpg/560px-2017_BMW_M2_Automatic_3.0_Front.jpg"),
//                    new Model("M3", CAR, 2008, 2012, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/2018_BMW_M3_3.0.jpg/560px-2018_BMW_M3_3.0.jpg"),
//                    new Model("M4", CAR, 2014, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/2015_BMW_M4_%28F82%29_coupe_%2824220553394%29.jpg/560px-2015_BMW_M4_%28F82%29_coupe_%2824220553394%29.jpg"),
//                    new Model("M5", CAR, 1984, 1988, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/BMW%2C_Techno_Classica_2018%2C_Essen_%28IMG_8995%29.jpg/560px-BMW%2C_Techno_Classica_2018%2C_Essen_%28IMG_8995%29.jpg"),
//                    new Model("M6", CAR, 1990,2004, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/2017-03-07_Geneva_Motor_Show_0996.JPG/560px-2017-03-07_Geneva_Motor_Show_0996.JPG"),
//                    new Model("X1", CAR, 2009, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/2018_BMW_X1_sDrive18i_xLine_1.5_Front.jpg/560px-2018_BMW_X1_sDrive18i_xLine_1.5_Front.jpg"),
//                    new Model("X2", CAR, 2017, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/2018_BMW_X2_xDrive20D_M_Sport_X_Automatic_2.0.jpg/560px-2018_BMW_X2_xDrive20D_M_Sport_X_Automatic_2.0.jpg"),
//                    new Model("X3", CAR, 2003, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/2018_BMW_X3_xDrive20d_SE_Automatic_2.0_Front.jpg/560px-2018_BMW_X3_xDrive20d_SE_Automatic_2.0_Front.jpg"),
//                    new Model("X4", CAR, 2014, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/2018_BMW_X4_xDrive20d_M_Sport_Automatic_2.0_Front.jpg/560px-2018_BMW_X4_xDrive20d_M_Sport_Automatic_2.0_Front.jpg"),
//                    new Model("X5", CAR, 1999, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/2019_BMW_X5_M50d_Automatic_3.0.jpg/560px-2019_BMW_X5_M50d_Automatic_3.0.jpg"),
//                    new Model("X6", CAR, 2007, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/2020_BMW_X6_xDrive30d_M_Sport_Automatic_3.0.jpg/560px-2020_BMW_X6_xDrive30d_M_Sport_Automatic_3.0.jpg"),
//                    new Model("X7", CAR, 2018, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/2019_BMW_X7_xDrive40i_in_white%2C_front_left.jpg/560px-2019_BMW_X7_xDrive40i_in_white%2C_front_left.jpg")));
//
            Brand brandOpel = new Brand();
            brandOpel.setName("Opel");
//        brandOpel.setModels( Set.of(
//                new Model("Agila", CAR, 2000, 2007, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Opel_Agila_A_1.2_Njoy.JPG/300px-Opel_Agila_A_1.2_Njoy.JPG"),
//                new Model("Adam", CAR, 2013, 2019, "https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Opel_Adam_1.4_Slam_%E2%80%93_Frontansicht%2C_15._Januar_2014%2C_D%C3%BCsseldorf.jpg/1600px-Opel_Adam_1.4_Slam_%E2%80%93_Frontansicht%2C_15._Januar_2014%2C_D%C3%BCsseldorf.jpg"),
//                new Model("Karl", CAR,2015, 2019, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Opel_KARL_%281%29.jpg/300px-Opel_KARL_%281%29.jpg"),
//                new Model("Chevette", CAR, 1980,1982, "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Vauxhall_Chevette_4_door_notchback_Trumpington.jpg/300px-Vauxhall_Chevette_4_door_notchback_Trumpington.jpg"),
//                new Model("Corsa A", CAR, 1982,1993,"https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/Opel_Corsa_A_front_20080131.jpg/300px-Opel_Corsa_A_front_20080131.jpg"),
//                new Model("Corsa B", CAR, 1993, 2000, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Opel_Corsa_front_20080417.jpg/300px-Opel_Corsa_front_20080417.jpg"),
//                new Model("Tigra A", CAR, 1994,2000, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Opel_Tigra_front_20071212.jpg/300px-Opel_Tigra_front_20071212.jpg"),
//                new Model("Corsa C", CAR, 2000, 2006, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/Opel_Corsa_C_1.2_Elegance_front_20100912.jpg/300px-Opel_Corsa_C_1.2_Elegance_front_20100912.jpg"),
//                new Model("Tigra TwinTop B", CAR, 2004, 2009, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/OPEL-VAUX-TIGRA-B.jpg/300px-OPEL-VAUX-TIGRA-B.jpg"),
//                new Model("Corsa D", CAR, 2006, 2014, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/Opel_Corsa_Satellite_%28D%2C_Facelift%29_%E2%80%93_Frontansicht%2C_2._April_2011%2C_D%C3%BCsseldorf.jpg/300px-Opel_Corsa_Satellite_%28D%2C_Facelift%29_%E2%80%93_Frontansicht%2C_2._April_2011%2C_D%C3%BCsseldorf.jpg"),
//                new Model("Corsa E", CAR, 2014, 2019, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Opel_Corsa_1.3_CDTI_ecoFLEX_Innovation_%28E%29_%E2%80%93_Frontansicht%2C_24._Dezember_2015%2C_Ratingen.jpg/300px-Opel_Corsa_1.3_CDTI_ecoFLEX_Innovation_%28E%29_%E2%80%93_Frontansicht%2C_24._Dezember_2015%2C_Ratingen.jpg"),
//                new Model("Corse F", CAR, 2019, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/Opel_Corsa-e_at_IAA_2019_IMG_0738.jpg/300px-Opel_Corsa-e_at_IAA_2019_IMG_0738.jpg"),
//                new Model("Olympia", CAR, 1947, 1953, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Opel_Olympia.jpg/300px-Opel_Olympia.jpg"),
//                new Model("Kadett A", CAR, 1962, 1965,"https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Opel_Kadett_A.jpg/300px-Opel_Kadett_A.jpg")));
//
            brandRepository.saveAll(List.of(brandBMW, brandOpel));

        }

        private void initUsers () {

            UserRole adminRole = new UserRole().setRole(Role.ADMIN);
            UserRole userRole = new UserRole().setRole(Role.USER);
            roleRepository.saveAll(List.of(adminRole, userRole));

            User admin = new User();
            admin.setFirstName("George")
                    .setLastName("Georgiev")
                    .setUsername("admin@abv")
                    .setPassword(passwordEncoder.encode("admin"))
                    .setRoles(Set.of(adminRole, userRole));

            User user = new User();
            user.setFirstName("Martin")
                    .setLastName("Hristov")
                    .setUsername("user@abv")
                    .setPassword(passwordEncoder.encode("user1"))
                    .setRoles(Set.of(userRole));

            userRepository.saveAll(List.of(admin, user));
        }

    }


