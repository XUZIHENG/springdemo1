package com.example.demo1.es.Repository;/**
 * Created by Administrator on 2018/12/14.
 */

import com.example.demo1.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 *@author xuziheng
 *@date 2018/12/14
 *@since 1.0
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,String>{
	Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);
}
