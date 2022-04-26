package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User i : users) {
            if (login.equals(i.getUsername())) {
                user = i;
                break;
            }
            if (user == null) {
                throw new UserNotFoundException("Пользователя не найдено.");
            }
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() == false && user.getUsername().length() < 3) {
            throw new UserInvalidException("Пользователь не валидный");
        }
        return false;

    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}

