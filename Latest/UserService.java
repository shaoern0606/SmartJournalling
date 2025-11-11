package Latest;

public class UserService {
   
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Return messages instead of boolean so UI knows what happened.
    public String signup(String email, String password) {
        if (userRepository.findByEmail(email) != null) {
            return "EMAIL_EXISTS";
        }

        User newUser = new User(email, password);
        userRepository.save(newUser);
        return "SUCCESS";
    }

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return "NO_EMAIL";
        }
        if (!user.getPassword().equals(password)) {
            return "WRONG_PASSWORD";
        }
        return "SUCCESS";
    }

}
