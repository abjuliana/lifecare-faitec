package br.fai.lds.backendspringlds.restcontrollers.configuration;

import br.fai.lds.domain.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class UserRestController {

    private final UserBackendAppConfiguration userBackendAppConfiguration = new UserBackendAppConfiguration();


    @GetMapping("/all")
    public List<UserModel> getUsers(){
        List<UserModel> userModel = userBackendAppConfiguration.findUserUseCase().find();

        return userModel;

    }

    @PostMapping("/create")
    public int create(@RequestBody final UserModel userModel){

        int id = userBackendAppConfiguration.createUserUseCase()
                .create(userModel);

        return id;
    }

}
