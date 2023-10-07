package br.fai.lds.backend.usecases.user;

import br.fai.lds.backend.usecases.port.UserRepository;
import br.fai.lds.domain.UserModel;

public class CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public int create(final UserModel userToBeCreated) {

        if (userToBeCreated == null) {
            return -1;
        }

        if (userToBeCreated.getName().isEmpty()
                || userToBeCreated.getBirthData().isEmpty()
                || userToBeCreated.getCpf().isEmpty()
                || userToBeCreated.getPhoneNumber().isEmpty()
                || userToBeCreated.getAddress().isEmpty()
                || userToBeCreated.getEmail().isEmpty()
                || userToBeCreated.getPassword().isEmpty()
                || userToBeCreated.getType().isEmpty()){
            return -1;
        }

        if (userToBeCreated.getPassword().length() < 4) {
            return -1;
        }

        //final String encodedPassword = passwordEncoder.encode(userToBeCreated.getPassword());

        //userToBeCreated.setPassword(encodedPassword);

        final int userId = userRepository.create(userToBeCreated);

        if (userId < 0) {
            return -1;
        }

        return userId;

    }
}
