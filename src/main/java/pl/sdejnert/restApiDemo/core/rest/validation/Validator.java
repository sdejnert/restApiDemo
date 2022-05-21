package pl.sdejnert.restApiDemo.core.rest.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class Validator {

    public List<String> validateLogin(final String login) {
        final List<String> errors = new ArrayList<>();
        verifyLoginLength(errors, login);
        verifyLoginCharacters(errors, login);
        return errors;
    }

    private void verifyLoginLength(final List<String> errors, final String login) {
        if (login.length() > 400) {
            errors.add("Login is too long.");
        }
    }

    private void verifyLoginCharacters(final List<String> errors, final String login) {
        String regex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(login).matches()) {
            errors.add("Incorrect data - use only A-Z a-z 0-9");
        }
    }
}
