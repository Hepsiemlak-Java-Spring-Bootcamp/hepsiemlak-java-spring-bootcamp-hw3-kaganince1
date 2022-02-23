package emlakburada.dto.response;

import java.util.Date;

import emlakburada.model.User;
import lombok.Data;

@Data
public class MessageResponse {
	private Long id;
	private String baslik;
	private String icerigi;
	private Date gonderilenTarih;
	private Date okunduguTarihi;
	private boolean gorulduMu;
	private User gonderici;
	private User alici;
}
