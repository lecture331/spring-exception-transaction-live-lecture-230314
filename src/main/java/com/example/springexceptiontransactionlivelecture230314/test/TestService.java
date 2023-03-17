package com.example.springexceptiontransactionlivelecture230314.test;

import com.example.springexceptiontransactionlivelecture230314.entity.User;
import com.example.springexceptiontransactionlivelecture230314.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TestService {
    private final UserRepository userRepository;
    private final TestChildService testChildService;

    @Transactional
    public void testRequired() throws RuntimeException {
        try {

            User user1 = new User("robbie1", "1234", "required1");
            userRepository.save(user1);

            testChildService.testRequiredChild();

            User user3 = new User("robbie3", "1234", "required3");
            userRepository.save(user3);

        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
    }

    @Transactional
    public void testRequiredNew() {
        try {

            User user1 = new User("robbie1", "1234", "requiredNew1");
            userRepository.save(user1);

            testChildService.testRequiredNewChild();

            User user3 = new User("robbie3", "1234", "requiredNew3");
            userRepository.save(user3);

        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
    }


    public void testMandatory() {
        User user1 = new User("robbie1", "1234", "mandatory1");
        userRepository.save(user1);

        testChildService.testMandatoryChild();

        User user3 = new User("robbie3", "1234", "mandatory3");
        userRepository.save(user3);
    }

    @Transactional
    public void testNever() {
        User user1 = new User("robbie1", "1234", "never1");
        userRepository.save(user1);

        testChildService.testNeverChild();

        User user3 = new User("robbie3", "1234", "never3");
        userRepository.save(user3);
    }

    @Transactional
    public void testNested() {
        try {

            User user1 = new User("robbie1", "1234", "nested1");
            userRepository.save(user1);

            testChildService.testNestedChild();

            User user3 = new User("robbie3", "1234", "nested3");
            userRepository.save(user3);

        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
    }
}
