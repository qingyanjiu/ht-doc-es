package live.moku.search;

import live.moku.search.models.HtDocDto;
import live.moku.search.service.HtDocService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.SearchHits;

import java.util.List;

@SpringBootTest
class SearchApplicationTests {

	@Autowired
	private HtDocService htDocService;

	@Test
	void testFindByMessage() {
		List<HtDocDto> result =  htDocService.findHtDocByMessage("polyline");
		result.forEach(System.out::println);
	}

}
