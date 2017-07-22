package cl.inicia.dictionary.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Role")
@Table(name = "Role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roleId")
	private int roleId;

	@Column(name = "roleName", nullable = false)
	private String roleName;

	/* Un usuario tiene muchas palabras */
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public Role() {

	}

	public Role(User user, String roleName) {
		this.user = user;
		this.roleName = roleName;
	}

	public Role(String roleName) {
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRolName(String roleName) {
		this.roleName = roleName;
	}

}
