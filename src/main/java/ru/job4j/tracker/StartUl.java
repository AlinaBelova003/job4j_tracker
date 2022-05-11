package ru.job4j.tracker;

import java.util.List;

public class StartUl {
    private final Output out;

    public StartUl(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
         for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index));
        }
    }

    public static void main(String[]args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output), new ShowItems(output),
                new ReplaceAction(output), new DeleteAction(output),
                new FindIdAction(output), new FindNameAction(output), new Exit(output)
        };
        new StartUl(output).init(input, tracker, List.of(actions));
    }
}
