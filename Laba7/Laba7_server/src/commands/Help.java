package commands;

import network.Server;
import util.ComandInterface;

/**
 * display a list of commands
 */
public class Help implements ComandInterface {
    private final static String name = "help";

    /**
     * executes the command
     */
    public static String execute() {
        String answer;
        History.archive.add(name);
        String s;
        s = "help : выводит справку по доступным командам\n" +
                "info : выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : выводит в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавляет новый элемент в коллекцию\n" +
                "update id {element} : обновляет значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удаляет элемент из коллекции по его id\n" +
                "clear : очищает коллекцию\n" +
                "save : сохраняет коллекцию в файл\n" +
                "execute_script file_name : считывает и исполняет скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершает программу (без сохранения в файл)\n" +
                "add_if_min {element} : добавляет новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n" +
                "remove_lower {element} : удаляет из коллекции все элементы, меньшие, чем заданный\n" +
                "history : выводит последние 5 команд (без их аргументов)\n" +
                "min_by_weapon_type : выводит любой объект из коллекции, значение поля weaponType которого является минимальным\n" +
                "group_counting_by_impact_speed : сгрупировывает элементы коллекции по значению поля impactSpeed, вывести количество элементов в каждой группе\n" +
                "count_greater_than_mood mood : выводит количество элементов, значение поля mood которых больше заданного";
        answer = s;
        return answer;
    }
}
