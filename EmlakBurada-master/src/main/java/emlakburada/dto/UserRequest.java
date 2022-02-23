package emlakburada.dto;

import lombok.Data;

@Data
public class UserRequest {
	private String kullaniciTipi;
	private String isim;
	private String email;
}
