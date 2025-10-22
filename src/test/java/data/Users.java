package data;

import lombok.Getter;

import config.ConfigurationManager;

/**
 * Имена юзеров использую сразу здесь без чтения из конфига, тк это не чувствительная информация, а при необходимости
 * можно имя поменять здесь и использовать в любом месте проекта через геттер
 *
 * Пароль считываю из конфига. Он в открытом виде не сможет лежать в репозитории и уже в properties
 * файле по хорошему должен шифроваться
 */


@Getter
public enum Users {
    STANDART_USER("standard_user", ConfigurationManager.config().password()),
    LOCKED_OUT_USER("locked_out_user", ConfigurationManager.config().password()),
    PROBLEM_USER("problem_user", ConfigurationManager.config().password()),
    PERFORMANCE_GLITCH_USER("performance_glitch_user", ConfigurationManager.config().password()),
    ERROR_USER("error_user", ConfigurationManager.config().password()),
    VISUAL_USER("visual_user", ConfigurationManager.config().password()),
    WRONG_USER("wrong", ConfigurationManager.config().passwordWrong());

    private final String LOGIN;
    private final String PASSWORD;

    Users(String login, String password) {
        this.LOGIN = login;
        this.PASSWORD = password;
    }
}
