package emlakburada.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

	private Long id;
	private String baslik;
	private String icerigi;
	private Date gonderilenTarih;
	private Date okunduguTarihi;
	private boolean gorulduMu;
	private User gonderici;
	private User alici;

	public Message(Long id, String baslik) {
		super();
		this.id = id;
		this.baslik = baslik;
	}

}
