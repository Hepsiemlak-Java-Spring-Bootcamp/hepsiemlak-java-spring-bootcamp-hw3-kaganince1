package emlakburada.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakburada.dto.UserRequest;
import emlakburada.dto.response.AdvertResponse;
import emlakburada.dto.response.UserResponse;
import emlakburada.model.Advert;
import emlakburada.model.User;
import emlakburada.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	private static Long userId = 4L;

	public List<UserResponse> getAllUser() {
		List<UserResponse> userResponseList = new ArrayList<>();
		for(User user : userRepository.getAllUser()) {
			userResponseList.add(converToUserResponse(user));
		}
		return userResponseList;
	}
	
	public UserResponse getUserById(Long id) {
		User user = userRepository.findUserById(id);
		return converToUserResponse(user);
	}
	
	public UserResponse saveUser(UserRequest userRequest) {
		User user = userRepository.saveUser(convertToUser(userRequest));
		return converToUserResponse(user);
	}
	
	public Set<AdvertResponse> getFavouriteAdvertsOfUser(Long id) {
		Set<AdvertResponse> advertResponseSet = new HashSet<>();
		for(Advert advert : userRepository.getFavouriteAdvertsOfUser(id)) {
			advertResponseSet.add(convertToAdvertResponse(advert));
		}
		return advertResponseSet;
	}

	private User convertToUser(UserRequest userRequest) {
		User user = new User();
		userId++;
		user.setId(userId);
		user.setKullaniciTipi(userRequest.getKullaniciTipi());
		user.setIsim(userRequest.getIsim());
		user.setEmail(userRequest.getEmail());
		return user;
	}
	
	private AdvertResponse convertToAdvertResponse(Advert savedAdvert) {
		AdvertResponse response = new AdvertResponse();
		response.setBaslik(savedAdvert.getBaslik());
		response.setFiyat(savedAdvert.getFiyat());
		response.setAdvertNo(savedAdvert.getAdvertNo());
		return response;
	}

	private UserResponse converToUserResponse(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setId(user.getId());
		userResponse.setKullaniciTipi(user.getKullaniciTipi());
		userResponse.setIsim(user.getIsim());
		userResponse.setEmail(user.getEmail());
		userResponse.setFavoriIlanlar(user.getFavoriIlanlar());
		return userResponse;
	}
}
