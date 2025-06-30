package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * {@code UrlEntity} は、ユーザーがアップロードした画像のURL情報を保存するエンティティクラス
 * <p>
 * このクラスは {@code urls} テーブルと対応しており、
 * 各ユーザー（{@code UserEntity}）に一意に紐づく画像URLを管理する。
 * </p>
 * <ul>
 *   <li>1ユーザーに対して1つのURL（1対1）</li>
 *   <li>画像URLは最大500文字</li>
 * </ul>
 */
@Entity
@Table(name = "urls")
public class UrlEntity {
	
	 /**
     * URLの一意な識別子（主キー）。
     * <br>データベース上では {@code url_id} カラムにマッピングされ、自動採番される。
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENT
	@Column(name = "url_id", nullable = false)
	private Integer id;
	
	/**
     * 対象のユーザー（外部キー）。
     * <br>{@code user_id} カラムにマッピングされ、{@code UserEntity} と1対1で関連付けられる。
     * <br>ユニーク制約により、1ユーザーにつき1URLの関係が保証される。
     */
	@OneToOne
	@JoinColumn(name = "user_id", nullable = false, unique = true)
	private UserEntity user;
	
	/**
     * 保存された画像のURL文字列。
     * <br>{@code image_url} カラムに対応し、最大500文字まで格納可能。
     */
	@Column(name = "image_url", nullable = false, length = 500)
	private String imageUrl;
	
	 /**
     * デフォルトコンストラクタ（JPAによる使用のために必要）。
     */
	public UrlEntity() {
	}
	

    /**
     * コンストラクタ：ユーザーと画像URLを指定して初期化する。
     *
     * @param user      関連付けるユーザーエンティティ
     * @param imageUrl  登録する画像URL
     */
	public UrlEntity(UserEntity user,String imageUrl) {
			this.user = user;
			this.imageUrl = imageUrl;
	}
	
	/**
     * URLのID（主キー）を取得する。
     *
     * @return URLの一意なID
     */
	public Integer getId() {
		return id;
	}

    /**
     * 関連付けられたユーザーを取得する。
     *
     * @return ユーザーエンティティ
     */
	public UserEntity getUser() {
		return user;
	}
	
	 /**
     * 関連付けるユーザーを設定する。
     *
     * @param user ユーザーエンティティ
     */
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	 /**
     * 登録されている画像URLを取得する。
     *
     * @return 画像のURL文字列
     */
	public String getImageUrl() {
		return imageUrl;
	}
	
	/**
     * 画像URLを設定する。
     *
     * @param imageUrl 設定する画像URL
     */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
