package stock;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class StockForLINEController {
	
	
	@Autowired
	private StockForLINEServices stockForLINEServices;
	
	@GetMapping(value="/Stock/{stockNum}")
	@ResponseBody
	public String getStockDetails(@PathVariable("stockNum") String stockNum){
		return stockForLINEServices.getStockDetails(stockNum);
	}
	
	@PostMapping(value="/Stock")
	@ResponseBody
	public void getStockDeatils(@RequestHeader HttpHeaders headers,@RequestBody String reqbody){
		JSONObject requestBody = new JSONObject(reqbody);
		System.out.println("表頭___"+headers);
//		System.out.println("內容__"+reqbody.toString());
		System.out.println("測試__"+new JSONObject(reqbody));
		stockForLINEServices.replyToLINE(requestBody);
	}
	
}
