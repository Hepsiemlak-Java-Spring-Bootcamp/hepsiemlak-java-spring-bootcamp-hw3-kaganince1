package emlakburada.dto.response;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import emlakburada.model.Advert;
import emlakburada.model.Message;
import lombok.Data;

@Data
public class UserResponse {
	private Long id;
	private String kullaniciTipi; // bireysel & kurumsal & yeniTip
	private String isim;
	private String email;
	private String fotograf;
	private String biyografi;
	private Set<Advert> favoriIlanlar = new HashSet<>();
	private List<Advert> yayinladigiIlanlar = new ArrayList<>();
	private List<Message> mesajKutusu;
}
