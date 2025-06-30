package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * ユーザー情報を表すエンティティクラスで、DBのusersテーブルに対応している。
 */

@Entity
@Table(name = "users")
public class UserEntity {
	/**
	 * ユーザーID（主キー、自動生成）
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	/**
	 * ユーザー名（最大10文字、null不可、一意制約あり）
	 */
	@Column(length = 10, nullable = false, unique = true)
	private String userName;

	/**
	 * パスワード（最大10文字、null不可）
	 */
	@Column(length = 10, nullable = false)
	private String password;

	/**
	 * プロフィール（最大200文字）
	 */
	@Column(length = 200)
	private String profile;

	/**
	 * 指定されたユーザー名、パスワード、プロフィールで UserEntity のインスタンスを生成する。
	 *
	 * @param userName ユーザー名
	 * @param password パスワード
	 * @param profile  プロフィール
	 */
	public UserEntity(String userName, String password, String profile) {
		this.userName = userName;
		this.password = password;
		this.profile = profile;
	}

	/**
	 * デフォルトコンストラクタ（JPAが使用する）
	 */
	public UserEntity() {
	}

	// Getter & Setter

	/**
	 * ユーザーIDを取得する。
	 * 
	 * @return userId
	 */

	public int getUserId() {
		return userId;
	}

	/**
	 * ユーザーIDを設定する。
	 * 
	 * @param userId
	 */

	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * ユーザーネームを取得する。
	 * 
	 * @return userName
	 */

	public String getUserName() {
		return userName;
	}

	/**
	 * ユーザーネームを設定する。
	 * 
	 * @param userName
	 */

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * パスワードを取得する。
	 * 
	 * @return password
	 */

	public String getPassword() {
		return password;
	}

	/**
	 * パスワードを設定する。
	 * 
	 * @param password
	 */

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * プロフィールを取得する。
	 * 
	 * @return profile
	 */

	public String getProfile() {
		return profile;
	}

	/**
	 * プロフィールを設定する。
	 * 
	 * @param profile
	 */

	public void setProfile(String profile) {
		this.profile = profile;
	}

	/**
	 * オブジェクトの文字列表現を返す（パスワードは出力しない）。
	 *
	 * @return UserEntity の文字列表現（userId, userName, profile のみ表示）
	 */
	@Override
	public String toString() {
		return "UserEntity{" + "userId=" + userId + ", userName='" + userName + '\'' + ", profile='" + profile + '\''
				+ '}';
	}

}
