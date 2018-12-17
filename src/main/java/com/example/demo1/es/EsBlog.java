package com.example.demo1.es;/**
 * Created by Administrator on 2018/12/14.
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 *@author xuziheng
 *@date 2018/12/14
 *@since 1.0
 */
@Document(indexName="blog",type="blog")
public class EsBlog implements Serializable{
	@Id
	private String id;
	private String title;
	private String summary;
	private String content;
	//JPA规范要求
	protected EsBlog(){

	}

	public EsBlog(String title, String summary, String content) {
		this.title = title;
		this.summary = summary;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "EsBlog{" +
				"id='" + id + '\'' +
				", title='" + title + '\'' +
				", summary='" + summary + '\'' +
				", content='" + content + '\'' +
				'}';
	}
}
