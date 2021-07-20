package live.moku.search.service;

import live.moku.search.models.HtDocDto;
import live.moku.search.repository.HtDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HtDocServiceImpl implements HtDocService {

    @Autowired
    private HtDocRepository htDocRepository;

    @Override
    public List<HtDocDto> findHtDocByMessage(String searchWord) {
        SearchHits<HtDocDto> result =  htDocRepository.findByMessage(searchWord);
        List<HtDocDto> list = result.map(r -> new HtDocDto(r.getId(), r.getContent().getPath(),
                r.getHighlightField("message").get(0))).stream().distinct().collect(Collectors.toList());
        return list;
    }
}
