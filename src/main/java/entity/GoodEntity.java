package entity;

import jakarta.persistence.*;

/**
 * 「うすいね（Good）」情報を表すエンティティクラス。
 * データベースの"Good"テーブルに対応し、ユーザーの「うすいね」操作を管理する。
 */
@Entity
@Table(name = "Good")
public class GoodEntity {

	/**
	 * うすいねの一意識別ID。
	 * 主キーであり、データベースで自動採番される。
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "good_id" , nullable = false)
	private int goodId ;

	/**
	 * うすいねを付けたユーザー情報。
	 * UserEntityとの多対一関係を表し、外部キー"user_id"で紐づく。
	 * ユーザー削除時に紐づくうすいねも自動削除される（CASCADE設定）。
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id" , referencedColumnName ="user_id" , nullable = false , foreignKey = @ForeignKey(name = "fk_users_user_id"))
	private UserEntity userEntity;
	
	/**
	 * うすいね対象の投稿情報。
	 * PostEntityとの多対一関係を表し、外部キー"post_id"で紐づく。
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "post_id" , referencedColumnName = "post_id" , nullable = false)
	private PostEntity postEntity;
	
	/**
	 * うすいねの状態フラグ。
	 * 0: うすいねなし, 1: うすいねあり を表す。
	 */
	@ManyToOne
	@Column(name = "good_flg" , nullable = false)
	private int goodFlg;
	
	
	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getGoodFlg() {
		return goodFlg;
	}

	public void setGoodFlg(int goodFlg) {
		this.goodFlg = goodFlg;
	}
}
