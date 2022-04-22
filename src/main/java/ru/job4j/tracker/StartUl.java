package ru.job4j.tracker;

public class StartUl {
    private final Output out;

    public StartUl(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        String[] menu = {
                "Add new Item", "Show new items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
         for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[]args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output), new AllItemAction(output),
                new EditAction(output), new DeleteAction(output),
                new FindIdAction(output), new FindNameAction(output), new Exit()
        };
        new StartUl(output).init(input, tracker, actions);
    }
}
