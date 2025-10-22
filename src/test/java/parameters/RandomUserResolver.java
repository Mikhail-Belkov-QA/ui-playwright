package parameters;

import models.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.Random;

public class RandomUserResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.isAnnotated(RandomUser.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Class<?> type = parameterContext.getParameter().getType();
        if (User.class.equals(type)) {
            Random random = new Random();
            User user = new User();
            user.setName("TestUser " + Math.abs(random.nextInt()));
            user.setLastName("TestJob " + Math.abs(random.nextInt()));
            user.setZipCode("1" + Math.abs(random.nextInt()));
            return user;
        }

        throw new ParameterResolutionException("No random generator implemented for " + type);
    }
}
