/**
 * @author dimitar
 *
 */
package bg.softuni.nplusone.model.crossJoin;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class PostEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String post;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "post_id")
	private List<CommentEntity> comments= new LinkedList<>();
	
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "post_id")
	private List<TagEntity> tags= new LinkedList<>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPost() {
		return post;
	}


	public void setPost(String post) {
		this.post = post;
	}


	public List<CommentEntity> getComments() {
		return comments;
	}


	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}


	public List<TagEntity> getTags() {
		return tags;
	}


	public void setTags(List<TagEntity> tags) {
		this.tags = tags;
	}
	
	
	

}
