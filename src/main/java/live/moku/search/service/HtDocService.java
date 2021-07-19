package live.moku.search.service;

import live.moku.search.models.HtDocDto;
import org.springframework.data.elasticsearch.core.SearchHits;

import java.util.List;

public interface HtDocService {
    List<HtDocDto> findHtDocByMessage(String searchWord);
}
