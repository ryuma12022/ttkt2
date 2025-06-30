package entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "message")
public class Message {

	@Id // 主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
	private Integer messageId;

	@ManyToOne // message : users = 多：一
	@JoinColumn(name = "user_id", nullable = true) // usersテーブルのuser_idを参照(マッピング)
	private UserEntity sendUser;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true) // usersテーブルのuser_idを参照
	private UserEntity recieveUser;

	@Column(nullable = false, length = 140)
	private String content;

	@Column(nullable = false)
	private LocalDateTime messageDate;

	// デフォルトコンストラクタ(必須らしい)
	public Message() {
	}

	// アクセサ(これもまあまあ必須らしい)
	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public UserEntity getSendUser() {
		return sendUser;
	}

	public void setSendUser(UserEntity sendUser) {
		this.sendUser = sendUser;
	}

	public UserEntity getRecieveUser() {
		return recieveUser;
	}

	public void setRecieveUser(UserEntity recieveUser) {
		this.recieveUser = recieveUser;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(LocalDateTime messageDate) {
		this.messageDate = messageDate;
	}

}
