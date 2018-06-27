package pl.coderslab.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.Role;
import pl.coderslab.entity.Ad;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.User;
import pl.coderslab.service.GeneralService;
import pl.coderslab.service.SpecificService;

@Controller
@RequestMapping("/util")
public class UtilController {

	@Autowired
	SpecificService specificService;

	@Autowired
	GeneralService<User> generalServiceUser;

	@Autowired
	GeneralService<Ad> generalServiceAd;

	@Autowired
	GeneralService<Category> generalServiceCategory;

	@RequestMapping("/addusers")
	@ResponseBody
	public String addUser() {
		User user1 = new User();
		user1.setFullname("Jan Nowak");
		user1.setUsername("jnowak");
		user1.setEmail("jan_nowakk@wp.pl");
		user1.setPhone("+48 547689221");
		user1.setPassword("test123");
		user1.setEnabled(1);
		specificService.saveUserWithRole(user1, Role.ROLE_USER);

		User user2 = new User();
		user2.setFullname("Ewa Mazur");
		user2.setUsername("emazur");
		user2.setEmail("ewa.mazur72@gmail.com");
		user2.setPhone("+48 607589231");
		user2.setPassword("test123");
		user2.setEnabled(1);
		specificService.saveUserWithRole(user2, Role.ROLE_USER);

		User user3 = new User();
		user2.setFullname("Emil Karski");
		user3.setUsername("ekarski");
		user3.setEmail("emil.karski@gmail.com");
		user3.setPhone("+48 721584621");
		user3.setPassword("test123");
		user3.setEnabled(1);
		specificService.saveUserWithRole(user3, Role.ROLE_USER);

		User user4 = new User();
		user4.setFullname("Anna Korcz");
		user4.setUsername("annakorcz");
		user4.setEmail("amma.korcz75k@gmail.com");
		user4.setPhone("+48 524561444");
		user4.setPassword("test123");
		user4.setEnabled(1);
		specificService.saveUserWithRole(user4, Role.ROLE_USER);

		User user5 = new User();
		user5.setFullname("Jerzy Wilk");
		user5.setUsername("admin");
		user5.setEmail("jerzywilk@gmail.com");
		user5.setPhone("+48 771458226");
		user5.setPassword("admin");
		user5.setEnabled(1);
		specificService.saveUserWithRole(user5, Role.ROLE_ADMIN);

		return "users added";
	}

	@RequestMapping("/addads")
	@ResponseBody
	public String addAd() {
		Ad ad1 = new Ad();
		ad1.setTitle("Sprzedam gitarę akustyczną");
		ad1.setDescription(
				"Gitara akustyczna firmy Cort w bardzo dobrym stanie. Kupiona w 2014 roku. Dodatkowo pokrowiec. Cena: 350 PLN.");
		ad1.setLocation("Opole");
		ad1.setExpiryTimestamp(Timestamp.valueOf(LocalDateTime.now().plusDays(30)));
		User thisUser = specificService.getUserById(1L);
		thisUser.getAds().add(ad1);
		ad1.setUser(thisUser);
		specificService.saveAd(ad1);

		Ad ad2 = new Ad();
		ad2.setTitle("Sprzedam rower miejski");
		ad2.setDescription(
				"Sprzedam rower miejski firmy Nexus - damski. Rozmiar ramy 18 cali. Kolor jasnozielony, w bardzo dobrym stanie, lekkie zarysowania. Cena 800 PLN.");
		ad2.setLocation("Gliwice");
		ad2.setExpiryTimestamp(Timestamp.valueOf(LocalDateTime.now().plusDays(20)));
		User thisUser2 = specificService.getUserById(2L);
		thisUser2.getAds().add(ad2);
		ad2.setUser(thisUser2);
		specificService.saveAd(ad2);

		Ad ad3 = new Ad();
		ad3.setTitle("Oddam szczeniaka");
		ad3.setDescription(
				"Oddam w dobre rece do domu z ogrodem. Jest to pies rasy terrier, przyjazny i samodzielny. Urodzony 2 kwietnia br.");
		ad3.setLocation("Katowice - Panewniki");
		ad3.setExpiryTimestamp(Timestamp.valueOf(LocalDateTime.now().plusDays(25)));
		User thisUser3 = specificService.getUserById(3L);
		thisUser3.getAds().add(ad3);
		ad3.setUser(thisUser3);
		specificService.saveAd(ad3);

		Ad ad4 = new Ad();
		ad4.setTitle("Sprzedam laptop asus 15\\\" 8 GB RAM 4x2.50 GHz 750 GB SSD");
		ad4.setDescription(
				"Bardzo szybki biznesowy laptop marki Asus dobry do prac biznesowych jaki i gier. Ogromna dwyżka mocy sprawia ze nigdy sie nie zacina. Laptop w 100% sprawny. Sprzedawany z oryginalnym przeinstalowanym windowsem. W zestawie ladowarka, pudelko i dokumenty.");
		ad4.setLocation("Katowice");
		ad4.setExpiryTimestamp(Timestamp.valueOf(LocalDateTime.now().plusDays(35)));
		User thisUser4 = specificService.getUserById(4L);
		thisUser4.getAds().add(ad4);
		ad4.setUser(thisUser4);
		specificService.saveAd(ad4);

		Ad ad5 = new Ad();
		ad5.setTitle("Sprzedam monitor Dell 22\"");
		ad5.setDescription(
				"Sprzedam 22 calowy monitor marki Dell. 1920x1080 pikseli, matryca IPS zapewnia znaczny obszar widzenia.  Regulowany w bardzo duzym zakresie (w pionie, pochylenie). Cena 350 PLN");
		ad5.setLocation("Bytom");
		ad5.setExpiryTimestamp(Timestamp.valueOf(LocalDateTime.now().plusDays(25)));
		User thisUser5 = specificService.getUserById(4L);
		thisUser5.getAds().add(ad5);
		ad5.setUser(thisUser5);
		specificService.saveAd(ad5);

		return "ads added";
	}

	@RequestMapping("/addcategories")
	@ResponseBody
	public String addCategories() {
		Category cat1 = new Category();
		cat1.setName("Komputery");
		cat1.setDescription("Komputery stacjonarne, laptopy, monitory, osprzet, etc.");
		specificService.saveCategory(cat1);

		Category cat2 = new Category();
		cat2.setName("Rowery");
		cat2.setDescription("Rowery miejskie, sportowe, osprzet, akcesoria, etc.");
		specificService.saveCategory(cat2);

		return "categories added";
	}

}
