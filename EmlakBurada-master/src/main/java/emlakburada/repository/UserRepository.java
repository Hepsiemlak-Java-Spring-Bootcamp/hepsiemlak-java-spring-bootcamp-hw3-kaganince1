package emlakburada.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import emlakburada.model.Advert;
import emlakburada.model.RealEstate;
import emlakburada.model.User;

@Repository
public class UserRepository {
	private static List<User> userList = new ArrayList<>();
	
	private static List<Advert> advertList = new ArrayList<>();

	static {
		advertList.add(prepareIlan(38164780, "Sahibinden Acil Satılık"));
		advertList.add(prepareIlan(38164781, "Dosta GİDERRR ACİLLL!!!"));
		advertList.add(prepareIlan(38164782, "Metroya Koşarak 5 dk"));
		advertList.add(prepareIlan(38164783, "Öğrenciye ve Bekar uygun"));
	}
	
	private static Set<Advert> advertSet = new HashSet<>(advertList);

	static {
		userList.add(prepareUser(1L, "Bireysel", "Kağan", "kagan@gmail.co", advertSet));
		userList.add(prepareUser(2L, "Bireysel", "Ali", "ali@gmail.co", advertSet));
		userList.add(prepareUser(3L, "Bireysel", "Veli", "veli@gmail.co", advertSet));
		userList.add(prepareUser(4L, "Kurumsal", "Can", "can@gmail.co", advertSet));
	}

	private static User prepareUser(Long id, String tip, String name, String mail, Set<Advert> advertList) {
		User user = new User(id, tip, name, mail);
		user.setFavoriIlanlar(advertList);
		return user;
	}
	
	private static Advert prepareIlan(int advertNo, String baslik) {
		Advert advert = new Advert();
		advert.setAdvertNo(advertNo);
		advert.setBaslik(baslik);
		advert.setGayrimenkul(makeGayrimenkul());
		advert.setAktifMi(true);
		advert.setResimList(makeResimList());
		return advert;
	}
	
	private static String[] makeResimList() {
		String[] resimList = new String[5];
		resimList[0] = "https://hecdnw01.hemlak.com/ds01/4/4/9/0/2/3/8/3/81d2e088-a551-485d-b2e9-664cc9200cdc.jpg";
		resimList[1] = "https://hecdnw01.hemlak.com/ds01/4/4/9/0/2/3/8/3/81d2e088-a551-485d-b2e9-664cc9200cdc.jpg";
		return resimList;
	}

	private static RealEstate makeGayrimenkul() {
		return new RealEstate();
	}
	
	public List<User> getAllUser() {
		return userList;
	}
	
	public User findUserById(Long id) {
		return userList.stream().filter(user -> user.getId() == id).findAny().orElse(new User());
	}
	
	public Set<Advert> getFavouriteAdvertsOfUser(Long id) {
		Set<Advert> advertSetTemp = new HashSet<>();
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getId().equals(id)) {
				advertSetTemp = userList.get(i).getFavoriIlanlar();
			}
		}
		return advertSetTemp;
	}
	
	public User saveUser(User user) {
		userList.add(user);
		return user;
	}
}
