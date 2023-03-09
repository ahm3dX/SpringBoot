package esprit.DevUp.FoRest.Service.GestionRestaurant;

import esprit.DevUp.FoRest.Entity.*;
import esprit.DevUp.FoRest.Entity.Restaurant.OffreRestaurant;
import esprit.DevUp.FoRest.Entity.Restaurant.Restaurant;
import esprit.DevUp.FoRest.Entity.Restaurant.accessRestaurant;
import esprit.DevUp.FoRest.Repository.GestionRestaurant.AccessRestaurantRepository;
import esprit.DevUp.FoRest.Repository.GestionRestaurant.OffreRestaurantRepository;
import esprit.DevUp.FoRest.Repository.GestionRestaurant.RestaurantRepository;
import esprit.DevUp.FoRest.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.net.http.*;


@Service
@Slf4j
public class ServiceAccessRestaurant implements IServiceAccessRestaurant {
    @Autowired
    AccessRestaurantRepository accessRestaurantRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    OffreRestaurantRepository offreRestaurantRepository;


    @Override
    @Transactional
    public accessRestaurant addaccessRestaurant(accessRestaurant u, Integer iduser, Integer idoffre) {
        User user= userRepository.findById(iduser).get();
        u.setUser(user);
        OffreRestaurant offreRestaurant=offreRestaurantRepository.findById(idoffre).get();
        u.setOffreRestaurant(offreRestaurant);
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, offreRestaurant.getNbrDays());
        Date futureDate = calendar.getTime();
        u.setDateEnd(futureDate);
        u.setDateStart(currentDate);
        Restaurant restaurant= restaurantRepository.findById(offreRestaurant.getRestaurant().getIdRestaurant()).get();
        restaurant.setNbrmaximal(restaurant.getNbrmaximal()-1);
        restaurantRepository.save(restaurant);
        return accessRestaurantRepository.save(u);
    }
    @Scheduled(cron = "0 0 23 * * MON-FRI")
    public void accessIsOver() {
        Date currentDate = new Date();
        List<accessRestaurant> accessRestaurants = accessRestaurantRepository.findAll();
        for (accessRestaurant accessRestaurant : accessRestaurants) {
            if (accessRestaurant.getDateEnd().compareTo(currentDate) < 0) {
                log.info("User {} your subscription of {} has expired", accessRestaurant.getUser().getFirstname(), accessRestaurant.getOffreRestaurant().getNameOffre());
                accessRestaurantRepository.deleteById(accessRestaurant.getId_access_restaurant());
                OffreRestaurant offreRestaurant= offreRestaurantRepository.findById(accessRestaurant.getOffreRestaurant().getIdOffreRestaurant()).get();
                Restaurant restaurant= restaurantRepository.findById(offreRestaurant.getRestaurant().getIdRestaurant()).get();
                restaurant.setNbrmaximal(restaurant.getNbrmaximal()+1);
                restaurantRepository.save(restaurant);

            }
        }
    }

    @Override
    public accessRestaurant updateaccessRestaurant(accessRestaurant u) {
        return accessRestaurantRepository.save(u);
    }


    @Override
    public void removeaccessRestaurant(Integer idaccessRestaurant) {
        accessRestaurantRepository.deleteById(idaccessRestaurant);
    }
    @Override
    public List<accessRestaurant> retrieveAllaccess() {
        return accessRestaurantRepository.findAll();
    }

    @Override
    public accessRestaurant OneAccessRestaurant(Integer idaccessRestaurant) {
        return accessRestaurantRepository.findById(idaccessRestaurant).orElse(null);
    }

    @Override
    public List<accessRestaurant> retrieveAllAccessbyRestaurant(Integer idRestaurant) {
        return accessRestaurantRepository.findByRestaurantId(idRestaurant);
    }
   /* @Override
    public byte[] accessRestaurant(Integer restid) throws IOException, InterruptedException{
        accessRestaurant product = accessRestaurantRepository.findById(restid).get();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://yakpdf.p.rapidapi.com/pdf"))
                .header("content-type", "application/json")
                .header("X-RapidAPI-Host", "yakpdf.p.rapidapi.com")
                .header("X-RapidAPI-Key", "b648c42070msh2f1e24111397e42p1155f4jsn864d7705eee5")
                .method("accessRestaurant", HttpRequest.BodyPublishers.ofString("{\r\n    \"pdf\": {\r\n        \"format\": \"A4\",\r\n        \"printBackground\": true,\r\n        \"scale\": 1\r\n    },\r\n    \"source\": {\r\n        \"html\": \"<!DOCTYPE html><html lang=\\\"en\\\"><head><meta charset=\\\"UTF-8\\\"><meta name=\\\"viewport\\\" content=\\\"width=device-width, initial-scale=1.0\\\"></head><body><div style=\\\"width:800px; height:600px; padding:20px; text-align:center; border: 10px solid #DB7093\\\"><div style=\\\"width:750px; height:550px; padding:20px; text-align:center; border: 5px solid #FFC0CB\\\"><span style=\\\"font-size:50px; font-weight:bold\\\">Certificate of Completion</span><br><br><span style=\\\"font-size:25px\\\"><i>This is to certify that</i></span><br><br><span style=\\\"font-size:30px\\\"><b>"+product.getPayment()+"</b></span><br/><br/><span style=\\\"font-size:25px\\\"><i>has completed the course</i></span> <br/><br/><span style=\\\"font-size:30px\\\"> "+product.getId_access_restaurant()+"</span> <br/><br/><br/><br/><br/><br/><span style=\\\"font-size:25px\\\"><i>For "+product.getOffreRestaurant().getNameOffre()+"hours length</i></span><br><span style=\\\"font-size:25px;float:left\\\">Aquired on : "+product.getDateEnd()+"</span><div style=\\\"float:right\\\"><img src=\\\""+product.getUser().getUserName()+"\\\"></div></div></div></body></html>\"\r\n    },\r\n    \"wait\": {\r\n        \"for\": \"navigation\",\r\n        \"timeout\": 250,\r\n        \"waitUntil\": \"load\"\r\n    }\r\n}")).build();
        HttpResponse<byte[]> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofByteArray());
        byte[] res = response.body();
        return res;
    }*/

    @Override
    public byte[] accessrestaurant(Integer idaccess) throws IOException, InterruptedException{
        accessRestaurant access = accessRestaurantRepository.findById(idaccess).get();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://yakpdf.p.rapidapi.com/pdf"))
                .header("content-type", "application/json")
                .header("X-RapidAPI-Host", "yakpdf.p.rapidapi.com")
                .header("X-RapidAPI-Key", "b648c42070msh2f1e24111397e42p1155f4jsn864d7705eee5")
                .method("POST", HttpRequest.BodyPublishers.ofString("{\r\n    \"pdf\": {\r\n" +
                        "        \"format\": \"A4\",\r\n        \"printBackground\": true,\r\n     " +
                        "   \"scale\": 1\r\n    },\r\n    \"source\": {\r\n    " +
                        "    \"html\": \"<!DOCTYPE html><html lang=\\\"en\\\"><head><meta charset=\\\"UTF-8\\\">" +
                        "<meta name=\\\"viewport\\\" content=\\\"width=device-width, initial-scale=1.0\\\">" +
                        "</head><body><div style=\\\"width:800px; height:600px; padding:20px; text-align:center;" +
                        " border: 10px solid #DB7093\\\"><div style=\\\"width:750px; height:550px; padding:20px;" +
                        " text-align:center; border: 5px solid #FFC0CB\\\"><span style=\\\"font-size:50px;" +
                        " font-weight:bold\\\">Subscription of Forest </span><br><br><span style=\\\"font-size:25px\\\">" +
                        "<i>this improve that Mr(s)  </i></span><br><br><span style=\\\"font-size:30px\\\">" +
                        "<b>"+access.getUser().getUserName()+"</b></span><br/><br/><span style=\\\"font-size:25px\\\">" +
                        "<i>can join the Restaurant : </i></span> <br/><br/><span style=\\\"font-size:30px\\\">" +
                        " "+access.getOffreRestaurant().getRestaurant().getNameRestaurant()+"</span> <br/><br/><br/><br/><br/><br/>" +
                        "<span style=\\\"font-size:25px\\\"><i>From  "+access.getDateStart()+"</i>" +
                        "</span><br><span style=\\\"font-size:25px;float:left\\\">Until :" +
                        " "+access.getDateEnd()+"</span><div style=\\\"float:right\\\">" +
                        "<img src=\\\""+access.getOffreRestaurant().getNameOffre()+"\\\"></div></div></div></body></html>\"\r\n    },\r\n" +
                        "    \"wait\": {\r\n        \"for\": \"navigation\",\r\n        \"timeout\": 250,\r\n   " +
                        "     \"waitUntil\": \"load\"\r\n    }\r\n}"))
                .build();
        HttpResponse<byte[]> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofByteArray());
        byte[] res = response.body();
        return res;
    }


}

