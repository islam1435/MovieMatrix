public class UserService {
    public boolean register(String username, String password, String email) {
        for (User user : DataStorage.users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        User user = new User(username, password, email);
        DataStorage.users.add(user);
        return true;
    }

    public User login(String username, String password) {
        for (User user : DataStorage.users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
