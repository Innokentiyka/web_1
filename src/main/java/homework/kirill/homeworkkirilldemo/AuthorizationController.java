package homework.kirill.homeworkkirilldemo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AuthorizationController {

    private final AuthorizationService authorizationService;

    public AuthorizationController( AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }



    @GetMapping(path = "/authorization")
    public String plus(@RequestParam("login") String login, @RequestParam("password") String password ,@RequestParam("confirmPassword") String confirmPassword){
        try {
            return authorizationService.authorization(login,password,confirmPassword);
        }catch (WrongLoginException e){
            e.printStackTrace();
            return "Ошибка в логине";
        }catch (WrongPasswordException e){
            e.printStackTrace();
            return "Ошибка в пароле";
        }
    }






}
