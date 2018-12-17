package com.example.demo1.es;/**
 * Created by Administrator on 2018/12/14.
 */

import com.example.demo1.es.Repository.EsBlogRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *@author xuziheng
 *@date 2018/12/14
 *@since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {
	@Autowired
	private EsBlogRepository esBlogRepository;
	@Before
	public void initRepositoryData(){
		//清楚所有数据
		esBlogRepository.deleteAll();
		esBlogRepository.save(new EsBlog("12","12","12"));
		esBlogRepository.save(new EsBlog("2","2","2"));
	}
	@Test
	public void testfindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(){
		Pageable pageable = new PageRequest(0,20);
		String title = "2";
		String summary="1";
		String content="1";
		Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining
				(title,summary,content,pageable);
		page.getContent().forEach(esBlog -> System.out.println(esBlog.toString()) );
		assertThat(page.getTotalElements()).isEqualTo(1);


	}
}
