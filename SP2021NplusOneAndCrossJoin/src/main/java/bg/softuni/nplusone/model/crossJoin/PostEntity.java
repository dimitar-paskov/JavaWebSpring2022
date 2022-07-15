/**
 * @author dimitar
 *
 */
package bg.softuni.nplusone.model.crossJoin;

import java.util.HashSet;
import java.util.Set;

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
	private Set<CommentEntity> comments= new HashSet<>();
	
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "post_id")
	private Set<TagEntity> tags= new HashSet<>();


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


	public Set<CommentEntity> getComments() {
		return comments;
	}


	public void setComments(Set<CommentEntity> comments) {
		this.comments = comments;
	}


	public Set<TagEntity> getTags() {
		return tags;
	}


	public void setTags(Set<TagEntity> tags) {
		this.tags = tags;
	}
	
	
	

}
