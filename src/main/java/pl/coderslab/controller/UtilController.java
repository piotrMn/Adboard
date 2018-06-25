package pl.coderslab.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.Role;
import pl.coderslab.entity.Ad;
import pl.coderslab.entity.User;
import pl.coderslab.service.MyService;

@Controller
@RequestMapping("/util")
public class UtilController {
	
	@Autowired
	MyService myService;
	
	@RequestMapping("/addusers")
	@ResponseBody
	public String addUser() {
		User user1 = new User();
		user1.setUsername("Jan Nowak");
		user1.setEmail("jan_nowakk@wp.pl");
		user1.setPhone("+48 547689221");
		user1.setPassword("test123");
		user1.setEnabled(1);
		myService.saveUserWithRole(user1, Role.ROLE_EMPLOYEE);
		
		User user2 = new User();
		user2.setUsername("Ewa Mazur");
		user2.setEmail("ewa.mazur72@gmail.com");
		user2.setPhone("+48 607589231");
		user2.setPassword("test123");
		user2.setEnabled(1);
		myService.saveUserWithRole(user2, Role.ROLE_EMPLOYEE);
		
		User user3 = new User();
		user3.setUsername("Emil Karski");
		user3.setEmail("emil.karski@gmail.com");
		user3.setPhone("+48 721584621");
		user3.setPassword("test123");
		user3.setEnabled(1);
		myService.saveUserWithRole(user3, Role.ROLE_EMPLOYEE);
		
		User user4 = new User();
		user4.setUsername("Anna Marciniak");
		user4.setEmail("a.marciniak@gmail.com");
		user4.setPhone("+48 524561444");
		user4.setPassword("test123");
		user4.setEnabled(1);
		myService.saveUserWithRole(user4, Role.ROLE_EMPLOYEE);
		
		return "users added";
	}
	
	@RequestMapping("/addads")
	@ResponseBody
	public String addAd() {
		Ad ad1 = new Ad();
		ad1.setTitle("Sprzedam gitarę akustyczną");
		ad1.setDescription("Gitara akustyczna firmy Cort w bardzo dobrym stanie. Kupiona w 2014 roku. Dodatkowo pokrowiec. Cena: 350 zł.");
		ad1.setLocation("Opole");
		ad1.setExpiryTimestamp(Timestamp.valueOf(LocalDateTime.now().plusDays(30)));
		User thisUser = myService.getUserById(1L);
		thisUser.getAds().add(ad1);
		ad1.setUser(thisUser);
		myService.saveAd(ad1);
		
		Ad ad2 = new Ad();
		ad2.setTitle("Sprzedam rower miejski");
		ad2.setDescription("Sprzedam rower miejski firmy Nexus - damski. Rozmiar ramy 18 cali. Kolor jasnozielony. Stan ogólny dobry. Cena 800 zł.");
		ad2.setLocation("Gliwice");
		ad2.setExpiryTimestamp(Timestamp.valueOf(LocalDateTime.now().plusDays(20)));
		User thisUser2 = myService.getUserById(2L);
		thisUser2.getAds().add(ad2);
		ad2.setUser(thisUser2);
		myService.saveAd(ad2);
		
		Ad ad3 = new Ad();
		ad3.setTitle("Kupię działkę ogrodową");
		ad3.setDescription("Kupię działkę ogrodową w obrębie Katowic i okolic. Maksymalna cena 15 000 zł");
		ad3.setLocation("Katowice - Panewniki");
		ad3.setExpiryTimestamp(Timestamp.valueOf(LocalDateTime.now().plusDays(25)));
		User thisUser3 = myService.getUserById(3L);
		thisUser3.getAds().add(ad3);
		ad3.setUser(thisUser3);
		myService.saveAd(ad3);
		
		Ad ad4 = new Ad();
		ad4.setTitle("Sprzedam laptop asus 15\\\" 8 GB RAM 4x2.50 GHz 750 GB SSD");
		ad4.setDescription("Bardzo szybki biznesowy laptop marki Asus nadający się zarówna o prac biznesowych jaki i gier. Ogromna nadwyżka mocy sprawia że nigdy się nie zacina. Laptop w 100% sprawny. Sprzedawany z oryginalnym świeżo przeinstalowanym windowsem. W zestawie z ładowarką, pudełkiem i dokumentami.");
		ad4.setLocation("Katowice");
		ad4.setExpiryTimestamp(Timestamp.valueOf(LocalDateTime.now().plusDays(35)));
		User thisUser4 = myService.getUserById(4L);
		thisUser4.getAds().add(ad4);
		ad4.setUser(thisUser4);
		myService.saveAd(ad4);
		
		Ad ad5 = new Ad();
		ad5.setTitle("Sprzedam monitor Dell 22\"");
		ad5.setDescription("Sprzedam 22 calowy monitor marki Dell. Rozdzielczość 1920x1080, matryca IPS zapewnia duże kąty widzenia.  Reguluje się w bardzo dużym zakresie (wysokość góra-dół, obrót względem podstawy, pochylenie). Cena 350 zł");
		ad5.setLocation("Bytom");
		ad5.setExpiryTimestamp(Timestamp.valueOf(LocalDateTime.now().plusDays(25)));
		User thisUser5 = myService.getUserById(4L);
		thisUser5.getAds().add(ad5);
		ad5.setUser(thisUser5);
		myService.saveAd(ad5);
		
		return "ads added";
	}
	

}
