package emlakburada.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import emlakburada.client.request.BannerRequest;
import emlakburada.client.response.BannerResponse;

@FeignClient(value = "banner-client", url = "http://localhost:8081")
public interface BannerFeignClient {
	@PostMapping(value = "/banners")
	public ResponseEntity<BannerResponse> saveBanner(@RequestBody BannerRequest bannerRequest);
}
