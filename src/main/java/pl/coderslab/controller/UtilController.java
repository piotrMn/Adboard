package pl.coderslab.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.Role;
import pl.coderslab.entity.Ad;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.User;
import pl.coderslab.service.GenericService;
import pl.coderslab.service.SpecificService;

@Controller
@RequestMapping("/util")
public class UtilController {

	@Autowired
	SpecificService specificService;

	@Autowired
	GenericService<User> userService;

	@Autowired
	GenericService<Ad> adService;

	@Autowired
	GenericService<Category> categoryService;
	
	@RequestMapping("/addusers")
	@ResponseBody
	public String addUser() {
//		User user1 = new User();
//		user1.setFullname("Jan Nowak");
//		user1.setUsername("jnowak");
//		user1.setEmail("jan_nowakk@wp.pl");
//		user1.setPhone("+48 547689221");
//		user1.setPassword("test123");
//		user1.setEnabled(1);
//		specificService.saveUserWithRole(user1, Role.ROLE_USER);
//
//		User user2 = new User();
//		user2.setFullname("Ewa Mazur");
//		user2.setUsername("emazur");
//		user2.setEmail("ewa.mazur72@gmail.com");
//		user2.setPhone("+48 607589231");
//		user2.setPassword("test123");
//		user2.setEnabled(1);
//		specificService.saveUserWithRole(user2, Role.ROLE_USER);
//
//		User user3 = new User();
//		user3.setFullname("Emil Karski");
//		user3.setUsername("ekarski");
//		user3.setEmail("emil.karski@gmail.com");
//		user3.setPhone("+48 721584621");
//		user3.setPassword("test123");
//		user3.setEnabled(1);
//		specificService.saveUserWithRole(user3, Role.ROLE_USER);
//
//		User user4 = new User();
//		user4.setFullname("Anna Korcz");
//		user4.setUsername("annakorcz");
//		user4.setEmail("amma.korcz75k@gmail.com");
//		user4.setPhone("+48 524561444");
//		user4.setPassword("test123");
//		user4.setEnabled(1);
//		specificService.saveUserWithRole(user4, Role.ROLE_USER);
//
//		User user5 = new User();
//		user5.setFullname("Jerzy Wilk");
//		user5.setUsername("admin");
//		user5.setEmail("jerzywilk@gmail.com");
//		user5.setPhone("+48 771458226");
//		user5.setPassword("admin");
//		user5.setEnabled(1);
//		specificService.saveUserWithRole(user5, Role.ROLE_ADMIN);
		
		User user6 = new User();
		user6.setFullname("Marcin Miller");
		user6.setUsername("miller");
		user6.setEmail("mmiller@gmail.com");
		user6.setPhone("671428229");
		user6.setPassword("{bcrypt}" + BCrypt.hashpw("Test1234", BCrypt.gensalt()));
		user6.setEnabled(1);
		specificService.saveUserWithRoles(user6, new Role[] {Role.ROLE_USER, Role.ROLE_ADMIN});
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
		User thisUser = userService.getEntityById(User.class, 1L);
		ad1.setUser(thisUser);
		adService.saveEntity(ad1);

		Ad ad2 = new Ad();
		ad2.setTitle("Sprzedam rower miejski");
		ad2.setDescription(
				"Sprzedam rower miejski firmy Nexus - damski. Rozmiar ramy 18 cali. Kolor jasnozielony, w bardzo dobrym stanie, lekkie zarysowania. Cena 800 PLN.");
		ad2.setLocation("Gliwice");
		ad2.setExpiryTimestamp(Timestamp.valueOf(LocalDateTime.now().plusDays(20)));
		User thisUser2 = userService.getEntityById(User.class, 2L);
		ad2.setUser(thisUser2);
		adService.saveEntity(ad2);

		Ad ad3 = new Ad();
		ad3.setTitle("Oddam szczeniaka");
		ad3.setDescription(
				"Oddam w dobre rece do domu z ogrodem. Jest to pies rasy terrier, przyjazny i samodzielny. Urodzony 2 kwietnia br.");
		ad3.setLocation("Katowice - Panewniki");
		ad3.setExpiryTimestamp(Timestamp.valueOf(LocalDateTime.now().plusDays(25)));
		User thisUser3 = userService.getEntityById(User.class, 3L);
		ad3.setUser(thisUser3);
		adService.saveEntity(ad3);

		Ad ad4 = new Ad();
		ad4.setTitle("Sprzedam laptop asus 15\\\" 8 GB RAM 4x2.50 GHz 750 GB SSD");
		ad4.setDescription(
				"Bardzo szybki biznesowy laptop marki Asus dobry do prac biznesowych jaki i gier. Ogromna dwyżka mocy sprawia ze nigdy sie nie zacina. Laptop w 100% sprawny. Sprzedawany z oryginalnym przeinstalowanym windowsem. W zestawie ladowarka, pudelko i dokumenty.");
		ad4.setLocation("Katowice");
		ad4.setExpiryTimestamp(Timestamp.valueOf(LocalDateTime.now().plusDays(35)));
		User thisUser4 = userService.getEntityById(User.class, 4L);
		ad4.setUser(thisUser4);
		adService.saveEntity(ad4);

		Ad ad5 = new Ad();
		ad5.setTitle("Sprzedam monitor Dell 22\"");
		ad5.setDescription(
				"Sprzedam 22 calowy monitor marki Dell. 1920x1080 pikseli, matryca IPS zapewnia znaczny obszar widzenia.  Regulowany w bardzo duzym zakresie (w pionie, pochylenie). Cena 350 PLN");
		ad5.setLocation("Bytom");
		ad5.setExpiryTimestamp(Timestamp.valueOf(LocalDateTime.now().plusDays(25)));
		User thisUser5 = userService.getEntityById(User.class, 4L);
		ad5.setUser(thisUser5);
		adService.saveEntity(ad5);

		return "ads added";
	}

	@RequestMapping("/addcategories")
	@ResponseBody
	public String addCategories() {
		Category cat1 = new Category();
		cat1.setName("Komputery");
		cat1.setDescription("Komputery stacjonarne, laptopy, monitory, osprzet, etc.");
		categoryService.saveEntity(cat1);

		Category cat2 = new Category();
		cat2.setName("Rowery");
		cat2.setDescription("Rowery miejskie, sportowe, osprzet, akcesoria, etc.");
		categoryService.saveEntity(cat2);

		return "categories added";
	}
	
	@RequestMapping("/clear")
	@ResponseBody
	public String clearSession() {
		SecurityContextHolder.clearContext();
		return "session cleared";
		
	}

}
