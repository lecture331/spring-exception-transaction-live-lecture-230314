package com.example.springexceptiontransactionlivelecture230314.test;


import com.example.springexceptiontransactionlivelecture230314.entity.User;
import com.example.springexceptiontransactionlivelecture230314.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TestChildService {
    private final UserRepository userRepository;

    @Transactional
    public void testRequiredChild() throws RuntimeException {
        User user2 = new User("robbie2", "1234", "required2");
        userRepository.save(user2);
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testRequiredNewChild() {
        User user2 = new User("robbie2", "1234", "requiredNew2");
        userRepository.save(user2);
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void testMandatoryChild() {
        User user2 = new User("robbie2", "1234", "mandatory2");
        userRepository.save(user2);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void testNeverChild() {
        User user2 = new User("robbie2", "1234", "never2");
        userRepository.save(user2);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void testNestedChild() {
        User user2 = new User("robbie2", "1234", "nested2");
        userRepository.save(user2);
        throw new RuntimeException();
    }
}
