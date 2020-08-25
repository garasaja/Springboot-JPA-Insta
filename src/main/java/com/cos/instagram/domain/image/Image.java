package com.cos.instagram.domain.image;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.cos.instagram.domain.tag.Tag;
import com.cos.instagram.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String location;
	private String caption;
	private String imageUrl;
	
	// Image를 select하면 한명의 User가 딸려옴
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId") // 컬럼명
	private User user; // 타입은 User오브젝트의 pk타입
	
	//Image를 select하면 여러개의 Tag가 딸려옴
		@OneToMany(mappedBy = "image",fetch = FetchType.LAZY) //fk주인을 정하는 함수 mappedBy = 연관관계 주인의 변수명을 적는다.         이미지테이블에는 tag가 들어갈수 없다. 여러개를 list로 생성하면 원자성 위반이므로 
		@JsonIgnoreProperties({"image"})
		private List<Tag> tags;		 // LAZY는 getter 호출시 나옴
	
	@CreationTimestamp
	private Timestamp createDate;
	
}
