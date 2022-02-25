package pl.comarch.szkolenia.rest.clinet;

public class UserDTO {
    private int id;
    private String login;
    private String password;
    private String address;

    public UserDTO(int id, String login, String password, String address) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.address = address;
    }

    public UserDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
