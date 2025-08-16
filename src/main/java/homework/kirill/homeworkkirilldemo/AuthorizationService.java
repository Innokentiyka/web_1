package homework.kirill.homeworkkirilldemo;


import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class AuthorizationService {

    public static String authorization (String login, String password, String confirmPassword){

        String[] person = new String[] {login,password,confirmPassword};

        Pattern pattern = Pattern.compile("^[0-9]*[a-zA-Z]*[_]*(?=\\S+$).{8,}$");
        Pattern pattern1 = Pattern.compile("[а-яёА-ЯЁ]+");

        for (int i = 0; i < person.length-1; i++) {
            Matcher matcher = pattern.matcher(person[i]);
            Matcher matcher1 = pattern1.matcher(person[i]);
            if(!matcher.find() && matcher1.find() || person[i].length() > 20 || person[i].equals("")){
                if (i == 0){
                    throw new WrongLoginException();
                }else {
                    throw new WrongPasswordException();
                }
            }
        }
        if (!password.equals(confirmPassword)){
            throw new WrongPasswordException();
        }
        return "Все ок";
    }
}
