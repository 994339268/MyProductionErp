package org.erp.myproductionsrc.domain.authority;

public class SysUser {
    private String id;

    private String username;

    private String password;

    private String salt;

    private String lockstate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {

        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getLockstate() {
        return lockstate;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", lockstate='" + lockstate + '\'' +
                '}';
    }

    public void setLockstate(String lockstate) {
        this.lockstate = lockstate;
    }
}
