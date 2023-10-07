package br.fai.lds.backend.implementation.repository.repository.connection;

import br.fai.lds.backend.usecases.port.UserRepository;
import br.fai.lds.domain.UserModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeUserDao implements UserRepository {

    private final Map<Integer, UserModel> database;

    public FakeUserDao(Map<Integer, UserModel> database){
        this.database = new HashMap<>();
        populateData();
    }

    @Override
    public UserModel findById(int id) {
        return database.get(id);
    }

    @Override
    public List<UserModel> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public List<UserModel> findByCriteria(Map<String, String> criteria) {
        return null;
    }

    @Override
    public boolean update(UserModel userModel) {

        database.put(userModel.getId(), userModel);

        return true;
    }

    @Override
    public boolean deleteById(int id) {
        UserModel removedUser = database.remove(id);
        return removedUser == null ? false : true;
    }

    @Override
    public int create(UserModel userModel) {

        userModel.setId(generateNextId());
        database.put(userModel.getId(), userModel);

        return userModel.getId();
    }

}
